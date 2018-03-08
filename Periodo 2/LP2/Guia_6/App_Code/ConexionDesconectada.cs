using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;
using System.Web.UI.WebControls;

/// <summary>
/// Summary description for ConexionDesconectada
/// </summary>
public class ConexionDesconectada
{
    /*
     La clase se compone de un cosntructor el cual establece una conexion con la propia base de datos
     es por ello que usamos el string de conexion en el mismo constructor se establece el adaptador
     cuando queremos usar la clase tenemos que abrir y cerrar la conexion a la base esto con el motivo
     de poder actualizar los datos, pues aunque usemos una tabla segun veo actualizamos la propia base
     luego de haber realizado algun cambio, una cosa interesante es el hecho de usar el valor 0 en los combobox
     para que muestre la tabla completa es decir la opcion "Ver todo" otra opcion interesante es el uso del comand
     el cual es empleado para decidir que hacer con la informacion, en resumen es una clase que usa los dataset y
     que al mismo tiempo actualiza la base.
         */

    string coneccionString;
    SqlConnection conexionSQL;
    DataSet DataSetPrincipal;
    SqlDataAdapter DataAdapterEspecífico;

    public ConexionDesconectada()
    {
        //Configuramos la conexion y obtenemos la cadena de conexion desde el Web.config
        coneccionString = "Data Source=MEKAKUZERO-PC\\SQLEXPRESS;Initial Catalog=EmpresaPlazaLibre;Integrated Security=True";
        conexionSQL = new SqlConnection(coneccionString);
        DataSetPrincipal = new DataSet();
        conexionSQL.Open();
        //Inicializamos el adaptador específico que se utilizará en la gestión de registros de producto
        DataAdapterEspecífico = new SqlDataAdapter();
        DataAdapterEspecífico.SelectCommand = new SqlCommand("SELECT * FROM Products", conexionSQL);
    }

    public void conectar()
    {
        conexionSQL.Open();
    }

    public void desconectar()
    {
        conexionSQL.Close();
    }

    public void cargarTabla(String nombreTabla, String primaryKey)
    {
        nombreTabla = nombreTabla.Trim();
        //Si la tabla no existe en el contexto actual, procederemos a adicionarla
        if (DataSetPrincipal.Tables.IndexOf(nombreTabla) == -1)
        {
            //Configuramos un control dataAdaprte para que funcione como puente entre dataset y base de datos
            SqlDataAdapter dataAdapter = new SqlDataAdapter();
            dataAdapter.SelectCommand = new SqlCommand();
            dataAdapter.SelectCommand.CommandText = "SELECT * FROM " + nombreTabla;
            dataAdapter.SelectCommand.Connection = conexionSQL;
            dataAdapter.SelectCommand.CommandType = CommandType.Text;
            //Populamos el dataset con la tabla que acabamos de obtener
            dataAdapter.FillSchema(DataSetPrincipal, SchemaType.Source, nombreTabla);
            dataAdapter.Fill(DataSetPrincipal, nombreTabla);
            dataAdapter.SelectCommand.Dispose();
            dataAdapter.Dispose();
            //Obtenemos la tabla actual y establecemos el campo que se utilizará como llaveprimaria
            DataTable tablaActual;
            tablaActual = DataSetPrincipal.Tables[nombreTabla];
            DataColumn[] columnasPrincipales = new DataColumn[1];
            columnasPrincipales[0] = tablaActual.Columns[primaryKey];
            tablaActual.PrimaryKey = columnasPrincipales;
        }
    }

    public void copiarBaseDatos()
    {
        //Cargamos las tablas al dataset a traves del método cargarTabla
        cargarTabla("Categories", "CategoryID");
        cargarTabla("Suppliers", "SupplierID");
        cargarTabla("Products", "ProductID");
        
        //Establecemos la relacion de llaves foraneas entre las tablas, verifique la sintaxis de cada una de llas
        ForeignKeyConstraint fk1_cat_pro;
        fk1_cat_pro = new ForeignKeyConstraint(DataSetPrincipal.Tables["Categories"].Columns["CategoryID"], DataSetPrincipal.Tables["Products"].Columns["CategoryID"]);
        DataSetPrincipal.Tables["Products"].Constraints.Add(fk1_cat_pro);
        ForeignKeyConstraint fk1_sup_pro;
        fk1_sup_pro = new ForeignKeyConstraint(DataSetPrincipal.Tables["Suppliers"].Columns["SupplierID"], DataSetPrincipal.Tables["Products"].Columns["SupplierID"]); DataSetPrincipal.Tables["Products"].Constraints.Add(fk1_sup_pro);
    }

    public void llenarCombo(ref DropDownList comboBox, String nombreTabla, String campoValor, String campoTexto)
    {
        //Asociamos al control de combobox la fuente de datos desde donde obtendrá su información
        nombreTabla = nombreTabla.Trim();
        comboBox.DataSource = DataSetPrincipal;
        comboBox.DataMember = nombreTabla;
        comboBox.DataValueField = campoValor;
        comboBox.DataTextField = campoTexto;
        comboBox.DataBind();
    }

    public object[] getDataRow(int ProductID)
    {
        //Obtenemos un arreglo genérico con los datos de una fila en especifico a la que se le pasa como parametro
        //el ID a seleccionar desde la tabla
        object[] datosRetorno = new object[8];
        DataRow[] filaSeleccionada;
        filaSeleccionada =
        DataSetPrincipal.Tables["Products"].Select("ProductID=" + ProductID);
        if (filaSeleccionada.Length == 1)
        {
            datosRetorno[0] = filaSeleccionada[0]["ProductID"];
            datosRetorno[1] = filaSeleccionada[0]["ProductName"];
            datosRetorno[2] = filaSeleccionada[0]["SupplierID"];
            datosRetorno[3] = filaSeleccionada[0]["CategoryID"];
            datosRetorno[4] = filaSeleccionada[0]["QuantityPerUnit"];
            datosRetorno[5] = filaSeleccionada[0]["UnitPrice"];
            datosRetorno[6] = filaSeleccionada[0]["UnitsInStock"];
            datosRetorno[7] = filaSeleccionada[0]["UnitsOnOrder"];
        }
        return datosRetorno;
    }

    public void cargarProductosEnTabla(ref GridView grid, string categoria, string proveedor)
    {
        grid.Columns.Clear();
        //Cargamos un dataview ya que es el que nos permite hacer filtros sobre la tabla seleccionada
        DataView vistaFiltro = new DataView(DataSetPrincipal.Tables["Products"]);

        if (categoria != "0")
        {
            vistaFiltro.RowFilter = "CategoryID = " + categoria;
        }

        if (proveedor != "0")
        {
            vistaFiltro.RowFilter = "SupplierID = " + proveedor;
        }
        //Configuramos el gridView que es pasado por referencia para que su fuente de datos sea el dataview
        //configurado y populado anteriormente, ademas establecemos que el campo principal sea la columna de ProductID

        grid.DataSource = vistaFiltro;
        grid.DataBind();
        grid.AllowPaging = true;
        grid.DataKeyNames = new String[1] { "ProductID" };

        //Configuramos un boton de editar el cual será añadido al grid

        ButtonField columnaEditar = new ButtonField();
        columnaEditar.HeaderText = "Editar";
        columnaEditar.HeaderStyle.HorizontalAlign = HorizontalAlign.Center;
        columnaEditar.ButtonType = ButtonType.Button;
        columnaEditar.Text = "Editar";
        columnaEditar.CommandName = "Seleccionar";
        columnaEditar.ControlStyle.CssClass = "button special";
        grid.Columns.Add(columnaEditar);
        
        //Configuramos un boton de eliminar que será añadido al grid
        ButtonField columnaEliminar = new ButtonField();
        columnaEliminar.HeaderText = "Eliminar";
        columnaEliminar.HeaderStyle.HorizontalAlign = HorizontalAlign.Center;
        columnaEliminar.ButtonType = ButtonType.Button;
        columnaEliminar.Text = "Eliminar";
        columnaEliminar.CommandName = "Eliminar";
        columnaEliminar.ControlStyle.CssClass = "button special";
        grid.Columns.Add(columnaEliminar);
        
        //Recargamos el grid y seteamos los nombres de las columnas
        grid.DataBind();
        grid.HeaderStyle.HorizontalAlign = HorizontalAlign.Center;

        try
        {
            grid.HeaderRow.Cells[2].Text = "ID";
            grid.HeaderRow.Cells[3].Text = "Producto";
            grid.HeaderRow.Cells[4].Text = "Proveedor";
            grid.HeaderRow.Cells[5].Text = "Categoría";
            grid.HeaderRow.Cells[6].Text = "Cant/Unidad";
            grid.HeaderRow.Cells[7].Text = "Precio";
            grid.HeaderRow.Cells[8].Text = "Disponibles";
            grid.HeaderRow.Cells[9].Text = "Ordenadas";
        }
        catch (Exception) { }

        grid.PagerStyle.CssClass = "pager";
    }

    public int actualizarProducto(int ProductID, object[] datosActualizados)
    {
        DataRow fila2Update;
        DataTable tablaProductos;
        tablaProductos = DataSetPrincipal.Tables["Products"];
        try
        {
            fila2Update = tablaProductos.Rows.Find(ProductID);
            fila2Update["ProductName"] = datosActualizados[0].ToString();
            fila2Update["SupplierID"] = int.Parse(datosActualizados[1].ToString());
            fila2Update["CategoryID"] = int.Parse(datosActualizados[2].ToString());
            fila2Update["QuantityPerUnit"] = datosActualizados[3].ToString();
            fila2Update["UnitPrice"] = double.Parse(datosActualizados[4].ToString());
            fila2Update["UnitsInStock"] = int.Parse(datosActualizados[5].ToString());
            fila2Update["UnitsOnOrder"] = int.Parse(datosActualizados[6].ToString());
            if (DataSetPrincipal.HasChanges())
            {
                SqlCommandBuilder comando = new SqlCommandBuilder(DataAdapterEspecífico);
                int filasAfectadas = DataAdapterEspecífico.Update(DataSetPrincipal,
               "Products");
                DataSetPrincipal.AcceptChanges();
                return filasAfectadas;
            }
            return 0;
        }
        catch (Exception)
        {
            return 0;
        }
    }

    public int agregarProducto(object[] datosActualizados)
    {
        DataRow nuevaFilaProductos = DataSetPrincipal.Tables["Products"].NewRow();

        try
        {
            nuevaFilaProductos["ProductName"] = datosActualizados[0].ToString();
            nuevaFilaProductos["SupplierID"] = int.Parse(datosActualizados[1].ToString());
            nuevaFilaProductos["CategoryID"] = int.Parse(datosActualizados[2].ToString());
            nuevaFilaProductos["QuantityPerUnit"] = datosActualizados[3].ToString();
            nuevaFilaProductos["UnitPrice"] = double.Parse(datosActualizados[4].ToString());
            nuevaFilaProductos["UnitsInStock"] = int.Parse(datosActualizados[5].ToString());
            nuevaFilaProductos["UnitsOnOrder"] = int.Parse(datosActualizados[6].ToString());

            DataSetPrincipal.Tables["Products"].Rows.Add(nuevaFilaProductos);

            if (DataSetPrincipal.HasChanges())
            {
                SqlCommandBuilder comando = new SqlCommandBuilder(DataAdapterEspecífico);
                int filasAfectadas = DataAdapterEspecífico.Update(DataSetPrincipal,
               "Products");
                DataSetPrincipal.AcceptChanges();
                return filasAfectadas;
            }
            return 0;
        }
        catch (Exception)
        {
            return 0;
        }
    }

    public int eliminarProducto(int ProductID)
    {
        DataRow fila2Delete;
        DataTable tablaProductos;
        tablaProductos = DataSetPrincipal.Tables["Products"];
        try
        {
            fila2Delete = tablaProductos.Rows.Find(ProductID);
            fila2Delete.Delete();
            if (DataSetPrincipal.HasChanges())
            {
                SqlCommandBuilder comando = new SqlCommandBuilder(DataAdapterEspecífico);
                int filasAfectadas = DataAdapterEspecífico.Update(DataSetPrincipal,
               "Products");
                DataSetPrincipal.AcceptChanges();
                return filasAfectadas;
            }
            return 0;
        }
        catch
        {
            return 0;
        }
    }
}