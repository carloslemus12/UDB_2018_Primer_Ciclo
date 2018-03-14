using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class TipoClientes : System.Web.UI.Page
{


    TipoClientesModel model = new TipoClientesModel();
    tipo_clientes tipo;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
			//Asignando valor al campo oculto
            hfOp.Value = "1";
            lblTitulo.Text = "Nuevo tipo de cliente";
            // Si hay un parametro id en la url
            if (Request.QueryString["id"] != null)
            {
				//Leyendo el parametro de la url
                int id = Int32.Parse(Request.QueryString["id"]);
                tipo = model.ObtenerTipoCliente(id);
                lblTitulo.Text = "Editando tipo de cliente";
                // Cargando los valores de los campos
                txtId.Text = tipo.idtipocliente.ToString();
                txtId.ReadOnly = true;
                txtTipo.Text = tipo.nombre_tipo;
                txtDescripcion.Text = tipo.Descripcion;
					// Cambiamos el campo oculto
                    hfOp.Value = "2";

                }

            }
        }
        

    

    protected void btnAceptar_Click(object sender, EventArgs e)
    {
        try
        {
            tipo = new tipo_clientes
            {
                idtipocliente = Int32.Parse(txtId.Text),
                nombre_tipo = txtTipo.Text,
                Descripcion = txtDescripcion.Text
            };


			//Si se desea insertar...
            if (hfOp.Value=="1")
            {
                if (model.InsertarTipoCliente(tipo) > 0)
                {
                    Session["msg"] = "Tipo de cliente agregado exitosamente";
                    Response.Redirect("Default.aspx");
                }
                else
                {
                    
                    lblError.Text = "Registro NO insertado";
                }
            }
            else
            {
                if (model.ModificarTipoCliente(tipo) > 0)
                {
                    Session["msg"] = "Tipo de cliente modificado exitosamente";
                    Response.Redirect("Default.aspx");
                }
                else
                {
                    lblError.Text = "Registro NO modificado";
                }
            }

                
        }
        catch (Exception)
        {

            lblError.Text = "Registro NO insertado";
        }
       



    }
}