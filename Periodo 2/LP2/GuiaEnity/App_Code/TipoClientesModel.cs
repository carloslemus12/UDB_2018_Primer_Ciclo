using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Modelo para la tabla de TipoClientes
/// </summary>
public class TipoClientesModel
{

    private db_roaming_guatemalaEntities ctx;

    public TipoClientesModel()
    {
        ctx = new db_roaming_guatemalaEntities();
    }

    public int InsertarTipoCliente(tipo_clientes tipo)
    {
        try
        {
            ctx.tipo_clientes.Add(tipo);
            ctx.SaveChanges();
            return 1;
        }
        catch (Exception)
        {
            return 0; 
        }
    }

    public List<tipo_clientes> ListarTipoClientes()
    {
        return (from t in ctx.tipo_clientes select t).ToList();
    }

    public tipo_clientes ObtenerTipoCliente(int id)
    {
        //Buscando por la llave primaria
        return ctx.tipo_clientes.Find(id);
    }

    public int ModificarTipoCliente(tipo_clientes tipo)
    {
        try
        {
            //Obteniendo el tipo de cliente a modificar
            tipo_clientes obj = ctx.tipo_clientes.Find(tipo.idtipocliente);
            if (obj != null)
            {
                //Actualizando el valor del objeto
                ctx.Entry(obj).CurrentValues.SetValues(tipo);
                ctx.SaveChanges();
                return 1;
            }
            return 0;
        }
        catch (Exception)
        {
            return 0;
        }
    }


    public int EliminarTipoCliente(int id)
    {
        try
        {
            //Obtieniendo el tipo de cliente a modificar
            tipo_clientes obj = ctx.tipo_clientes.Find(id);
            // Si el objeto existe...
            if (obj != null)
            {
                ctx.tipo_clientes.Remove(obj);
                ctx.SaveChanges();
                return 1;
            }
            return 0;
        }
        catch (Exception)
        {
            return 0;
        }
    }

}