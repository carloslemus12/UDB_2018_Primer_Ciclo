using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    private ConexionDesconectada nuevaConexion;

    protected void Page_Load(object sender, EventArgs e)
    {
        this.nuevaConexion = new ConexionDesconectada();

        if (!IsPostBack)
        {
            this.nuevaConexion.copiarBaseDatos();
            this.nuevaConexion.llenarCombo(ref this.ddlCategorias, "Categories", "CategoryID", "CategoryName");
            this.nuevaConexion.llenarCombo(ref this.ddlProveedor, "Suppliers", "SupplierID", "CompanyName");
            this.ddlCategorias.Items.Insert(0, new ListItem("Ver Todos", "0"));
            this.ddlProveedor.Items.Insert(0, new ListItem("Ver Todos", "0"));
            this.nuevaConexion.cargarProductosEnTabla(ref this.GridView1, "0", "0");
            this.nuevaConexion.desconectar();
        }
    }

    protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
    {
        this.nuevaConexion = new ConexionDesconectada();
        this.nuevaConexion.copiarBaseDatos();
        this.GridView1.PageIndex = e.NewPageIndex;
        this.nuevaConexion.cargarProductosEnTabla(ref GridView1, this.ddlCategorias.SelectedValue, this.ddlProveedor.SelectedValue);
        this.nuevaConexion.desconectar();
    }

    protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
    {
        int index = Convert.ToInt32(e.CommandArgument);

        GridViewRow filaSeleccionada = this.GridView1.Rows[index];

        TableCell celdaIDProducto = filaSeleccionada.Cells[2];

        if (e.CommandName == "Seleccionar")
        {
            Response.Redirect("EditarRegistro.aspx?ProductoID="+celdaIDProducto.Text);
        }
        else if (e.CommandName == "Eliminar")
        {
            this.nuevaConexion = new ConexionDesconectada();
            this.nuevaConexion.copiarBaseDatos();
            if (this.nuevaConexion.eliminarProducto(int.Parse(celdaIDProducto.Text)) < 1)
            {
                ScriptManager.RegisterStartupScript(this.Page, this.Page.GetType(), "error_msg", "alert('Error al eliminar el producto');", true);
            }
            else
            {
                nuevaConexion.desconectar();
                Response.Redirect("Default.aspx");
            }
        }
    }

    protected void btnBuscar_Click(object sender, EventArgs e)
    {
        this.nuevaConexion = new ConexionDesconectada();
        this.nuevaConexion.copiarBaseDatos();
        this.nuevaConexion.cargarProductosEnTabla(ref GridView1, this.ddlCategorias.SelectedValue, this.ddlProveedor.SelectedValue);
        this.nuevaConexion.desconectar();
    }
}