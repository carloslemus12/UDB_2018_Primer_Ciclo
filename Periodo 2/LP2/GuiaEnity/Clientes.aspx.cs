using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Clientes : System.Web.UI.Page
{
    UsuarioModelo cliente = new UsuarioModelo();

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            this.GridView1.DataSource = cliente.obtenerTodosLosUsuarios();
            this.GridView1.DataBind();

            if (Session["msg"] != null)
            {
                ScriptManager.RegisterClientScriptBlock(this.Page, this.GetType(), "alert", "mostrarMensaje('Success','" + Session["msg"] + "');",true);
                Session["msg"] = null;
            }
        }
    }

    protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        try
        {
            if (this.cliente.eliminar(Convert.ToInt32(e.Keys[0])))
            {
                Session["msg"] = "El cliente eliminado exitosamente";
                Response.Redirect("/Clientes.aspx");
            } else
                throw new System.ArgumentException("El cliente no existe", "error");

        }
        catch (Exception ex)
        {
            lblError.Text = "No se puede eliminar este tipo de cliente por el error: " + ex.Message;
        }
    }

    protected void GridView1_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
    {
        // Leyendo el id del tipo seleccionado
        int id = Convert.ToInt32(GridView1.DataKeys[e.NewSelectedIndex].Value);
        Response.Redirect("ActualizarClientes.aspx?id=" + id);
    }
}