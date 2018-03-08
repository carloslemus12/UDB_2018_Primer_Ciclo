using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class EditarRegistro : System.Web.UI.Page
{
    private ConexionDesconectada nuevaConexion;
    PruebaLINQ obj = new PruebaLINQ();

    protected void Page_Load(object sender, EventArgs e)
    {
        this.nuevaConexion = new ConexionDesconectada();

        if (!IsPostBack)
        {
            nuevaConexion.copiarBaseDatos();
            this.nuevaConexion.llenarCombo(ref this.CategoryID, "Categories", "CategoryID", "CategoryName");
            this.nuevaConexion.llenarCombo(ref this.SupplierID, "Suppliers", "SupplierID", "CompanyName");
            this.nuevaConexion.desconectar();

            int id = int.Parse(Request.QueryString["ProductoID"]);

            Product productos = obj.obtenerProductoPorID(id);

            if (productos != null)
            {
                this.ProductID.Value = productos.ProductID.ToString();
                this.ProductName.Text = productos.ProductName.ToString();
                this.SupplierID.SelectedValue = productos.SupplierID.ToString();
                this.CategoryID.SelectedValue = productos.CategoryID.ToString();
                this.QuantityPerUnit.Text = productos.QuantityPerUnit.ToString();
                this.UnitPrice.Text = productos.UnitPrice.ToString();
                this.UnitsInStock.Text = productos.UnitsInStock.ToString();
                this.UnitsOnOrder.Text = productos.UnitsInStock.ToString();
            }
        }
    }

    protected void btnModificar_Click(object sender, EventArgs e)
    {
        PruebaLINQ linq = new PruebaLINQ();

        bool estado = linq.actualizarProducto(
                int.Parse(ProductID.Value),
                ProductName.Text,
                int.Parse(SupplierID.SelectedValue.ToString()),
                int.Parse(CategoryID.SelectedValue.ToString()),
                QuantityPerUnit.Text,
                Decimal.Parse(UnitPrice.Text.ToString()),
                short.Parse(UnitsInStock.Text.ToString()),
                short.Parse(UnitsOnOrder.Text.ToString())
            );

        if (estado)
        {
            Response.Redirect("Default.aspx");
        }
        else
        {
            ScriptManager.RegisterStartupScript(this.Page, this.Page.GetType(), "error_msg", "alert('Error al modificar el producto');", true);
        }
    }
}