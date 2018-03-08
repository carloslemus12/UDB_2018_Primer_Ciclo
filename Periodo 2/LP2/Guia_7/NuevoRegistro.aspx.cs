using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class NuevoRegistro : System.Web.UI.Page
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
            this.nuevaConexion.desconectar();
        }
    }

    protected void btn_Guardar_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            this.nuevaConexion = new ConexionDesconectada();
            this.nuevaConexion.copiarBaseDatos();
            object[] datosActualizados = new object[7] { this.ProductName.Text, this.SupplierID.SelectedValue, this.CategoryID.SelectedValue, this.QuantityPerUnit.Text, this.UnitPrice.Text, this.UnitsInStock.Text, this.UnitsOnOrder.Text };
            int filasActualizadas = this.nuevaConexion.agregarProducto(datosActualizados);

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
}