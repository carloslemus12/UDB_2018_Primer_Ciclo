using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class AgregarRegistroLINQ : System.Web.UI.Page
{
    ConexionDesconectada conexion;

    protected void Page_Load(object sender, EventArgs e)
    {
        conexion = new ConexionDesconectada();

        if (!IsPostBack)
        {
            conexion.copiarBaseDatos();
            this.conexion.llenarCombo(ref this.CategoryID, "Categories", "CategoryID", "CategoryName");
            this.conexion.llenarCombo(ref this.SupplierID, "Suppliers", "SupplierID", "CompanyName");
            conexion.desconectar();
        }
    }



    protected void btnAgregar_Click(object sender, EventArgs e)
    {
        PruebaLINQ linq = new PruebaLINQ();

        int filas = linq.agregarProducto(
                ProductName.Text,
                int.Parse(SupplierID.SelectedValue.ToString()),
                int.Parse(CategoryID.SelectedValue.ToString()),
                QuantityPerUnit.Text,
                Decimal.Parse(UnitPrice.Text.ToString()),
                short.Parse(UnitsInStock.Text.ToString()),
                short.Parse(UnitsOnOrder.Text.ToString())
            );

        if (filas != 0)
            Response.Redirect("Default.aspx");
        else
            ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "alert", "alert('Error al guardar los datos');", true);
    }
}