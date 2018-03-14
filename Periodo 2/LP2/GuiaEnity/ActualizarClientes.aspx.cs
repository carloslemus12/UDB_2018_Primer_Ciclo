using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class ActualizarClientes : System.Web.UI.Page
{
    TipoClientesModel tipos = new TipoClientesModel();

    UsuarioModelo modelo = new UsuarioModelo();
    cliente cliente = new cliente();

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {

            this.ddlTipos.DataSource = tipos.ListarTipoClientes();
            this.ddlTipos.DataBind();

            //Asignando valor al campo oculto
            hfOp.Value = "1";
            lblTitulo.Text = "Nuevo cliente";

            // Si hay un parametro id en la url
            if (Request.QueryString["id"] != null)
            {
                //Leyendo el parametro de la url
                int id = Int32.Parse(Request.QueryString["id"]);

                cliente = modelo.obtenerCliente(id);
                lblTitulo.Text = "Editando tipo de cliente";

                // Cargando los valores de los campos
                txtId.Text = cliente.idcliente.ToString();

                txtId.ReadOnly = true;

                this.txtCodigo.Text = cliente.codigo_cliente;

                this.txtNombre.Text = cliente.nombres;

                this.txtApellido.Text = cliente.apellidos;

                this.ddlTipos.SelectedValue = cliente.idtipocliente.ToString();

                this.txtDui.Text = cliente.dui;

                this.txtNit.Text = cliente.nit;

                this.txtTelefono.Text = cliente.numero_telefono;

                this.ddlSexo.SelectedValue = cliente.sexo;

                this.ddlEstado.SelectedValue = cliente.estado;

                // Cambiamos el campo oculto
                hfOp.Value = "2";

            }

        }
    }

    protected void btnAceptar_Click(object sender, EventArgs e)
    {
        try
        {
            this.cliente = new cliente {
                idcliente = int.Parse(this.txtId.Text.Trim()),
                idtipocliente = int.Parse(this.ddlTipos.SelectedValue),
                codigo_cliente = this.txtCodigo.Text.Trim(),
                dui = this.txtDui.Text.Trim(),
                nit = this.txtNit.Text.Trim(),
                apellidos = this.txtApellido.Text.Trim(),
                nombres = this.txtNombre.Text.Trim(),
                sexo = ddlSexo.SelectedValue,
                numero_telefono = txtTelefono.Text.Trim(),
                estado = this.ddlEstado.SelectedValue,
            };

            if (hfOp.Value == "1")
            {
                if (modelo.insertar(this.cliente))
                {
                    Session["msg"] = "El cliente ha sido agregado exitosamente";
                    Response.Redirect("Clientes.aspx");
                }
                else
                {

                    lblError.Text = "Registro NO insertado";
                }
            }
            else
            {
                if (modelo.modificar(this.cliente))
                {
                    Session["msg"] = "El cliente ha sido modificado exitosamente";
                    Response.Redirect("Clientes.aspx");
                }
                else
                {
                    lblError.Text = "Registro NO modificado";
                }
            }

        }
        catch (Exception ex)
        {
            lblError.Text = "Registro NO insertado por el error: " + ex.Message;
        }
    }
}