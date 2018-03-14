using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for UsuarioModelo
/// </summary>
public class UsuarioModelo
{
    private db_roaming_guatemalaEntities ctx;

    public UsuarioModelo()
    {
        this.ctx = new db_roaming_guatemalaEntities();
    }

    public Object obtenerTodosLosUsuarios() {
        return (from c in ctx.cliente
                where c.estado.Equals("t")
                select new {
                    Id = c.idcliente,
                    Codigo = c.codigo_cliente,
                    NombreCompleto = c.nombres + " " + c.apellidos,
                    Telefono = c.numero_telefono,
                    Dui = c.dui,
                    Tipo = c.tipo_clientes.nombre_tipo
                }).ToArray();
    }

    public cliente obtenerCliente(int id)
    {
        //Buscando por la llave primaria
        return ctx.cliente.Find(id);
    }

    public bool eliminar(int id)
    {
        try
        {
            cliente c = ctx.cliente.Find(id);

            if (c == null)
                throw new System.ArgumentException("El cliente no existe", "error");

            ctx.cliente.Remove(c);
            ctx.SaveChanges();
            return true;
        }
        catch (Exception)
        {
            return false;
        }
    }

    public bool modificar(cliente cliente)
    {
        try
        {
            //Obteniendo el tipo de cliente a modificar
            cliente obj = ctx.cliente.Find(cliente.idcliente);

            if (obj == null)
                throw new System.ArgumentException("El cliente no existe", "error");

            //Actualizando el valor del objeto
            ctx.Entry(obj).CurrentValues.SetValues(cliente);
            ctx.SaveChanges();
            return true;
        }
        catch (Exception)
        {
            return false;
        }
    }

    public bool insertar(cliente cliente)
    {
        try
        {
            ctx.cliente.Add(cliente);
            ctx.SaveChanges();
            return true;
        }
        catch (Exception)
        {
            return false;
        }
    }
}