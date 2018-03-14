using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    TipoClientesModel model = new TipoClientesModel();

   

    protected void Page_Load(object sender, EventArgs e)
    {

       
        if (!Page.IsPostBack)
        {

            GridView1.DataSource = model.ListarTipoClientes();
            GridView1.DataBind();



            if (Session["msg"] != null)
            {
                ScriptManager.RegisterClientScriptBlock(this.Page, this.GetType(),
           "alert", "mostrarMensaje('Success','"+ Session["msg"] + "');",
           true);
                Session["msg"] = null;
            }
        }

       


    }

    protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        try
        {
			//Leyendo el id del tipo seleccionado
            int id = Convert.ToInt32(e.Keys[0]);
            model.EliminarTipoCliente(id);
            Session["msg"] = "Tipo de cliente eliminado exitosamente";
            Response.Redirect("Default.aspx");
        }
        catch (Exception)
        {

            lblError.Text = "No se puede eliminar este tipo de cliente";
        }
        

    }

    protected void GridView1_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
    {
		// Leyendo el id del tipo seleccionado
        int id = Convert.ToInt32(GridView1.DataKeys[e.NewSelectedIndex].Value);
        Response.Redirect("TipoClientes.aspx?id=" + id);

    }
}