using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class EditarRegistro : System.Web.UI.Page
{
    private ConexionDesconectada nuevaConexion;

    protected void Page_Load(object sender, EventArgs e)
    {
        this.nuevaConexion = new ConexionDesconectada();

        if (!IsPostBack)
        {
            nuevaConexion.copiarBaseDatos();
            this.nuevaConexion.llenarCombo(ref this.CategoryID, "Categories", "CategoryID", "CategoryName");
            this.nuevaConexion.llenarCombo(ref this.SupplierID, "Suppliers", "SupplierID", "CompanyName");
            object[] datosRetornados = this.nuevaConexion.getDataRow(int.Parse(Request.QueryString["ProductoID"]));
            this.nuevaConexion.desconectar();

            if (datosRetornados != null)
            {
                this.ProductID.Value = datosRetornados[0].ToString();
                this.ProductName.Text = datosRetornados[1].ToString();
                this.SupplierID.SelectedValue = datosRetornados[2].ToString();
                this.CategoryID.SelectedValue = datosRetornados[3].ToString();
                this.QuantityPerUnit.Text = datosRetornados[4].ToString();
                this.UnitPrice.Text = datosRetornados[5].ToString();
                this.UnitsInStock.Text = datosRetornados[6].ToString();
                this.UnitsOnOrder.Text = datosRetornados[7].ToString();
            }
        }
    }

    protected void btnModificar_Click(object sender, EventArgs e)
    {
        this.nuevaConexion = new ConexionDesconectada();
        this.nuevaConexion.copiarBaseDatos();
        object[] datosActualizados = new object[7] { this.ProductName.Text, this.SupplierID.SelectedValue, this.CategoryID.SelectedValue, this.QuantityPerUnit.Text, this.UnitPrice.Text, this.UnitsInStock.Text, this.UnitsOnOrder.Text };
        int filasActualizadas = this.nuevaConexion.actualizarProducto(int.Parse(this.ProductID.Value.ToString()), datosActualizados);
        this.nuevaConexion.desconectar();
        if (filasActualizadas > 0)
        {
            Response.Redirect("Default.aspx");
        }
        else
        {
            ScriptManager.RegisterStartupScript(this.Page, this.Page.GetType(), "error_msg", "alert('Error al modificar el producto');", true);
        }
    }
}