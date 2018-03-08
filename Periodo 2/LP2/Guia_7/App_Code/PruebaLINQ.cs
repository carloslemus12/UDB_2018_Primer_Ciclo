using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for PruebaLINQ
/// </summary>
public class PruebaLINQ
{
    LinqDBDataContext dc = new LinqDBDataContext();

    public int agregarProducto(string nombreProducto, int proveedor, int categoria, string cantidadPorUnidad, decimal precio, short unidadesStock, short unidadesOrdenadas)
    {
        Product nuevoProducto = new Product();
        nuevoProducto.ProductName = nombreProducto;
        nuevoProducto.SupplierID = proveedor;
        nuevoProducto.CategoryID = categoria;
        nuevoProducto.QuantityPerUnit = cantidadPorUnidad;
        nuevoProducto.UnitPrice = precio;
        nuevoProducto.UnitsInStock = unidadesStock;
        nuevoProducto.UnitsOnOrder = unidadesOrdenadas;
        dc.Products.InsertOnSubmit(nuevoProducto);
        dc.SubmitChanges();
        return nuevoProducto.ProductID;
    }

    public Product obtenerProductoPorID(int ID)
    {
        var producto = from tableProduct in dc.Products
                       where tableProduct.ProductID == ID
                       select tableProduct;
        if (producto.Count() > 0)
            return producto.First();
        else
            return null;
    }

    public bool actualizarProducto(int ID, string nombreProducto, int proveedor, int categoria, string cantidadPorUnidad, decimal precio, short unidadesStock, short unidadesOrdenadas)
    {
        var queryActualiza = from registroActualiza 
                             in dc.Products
                             where registroActualiza.ProductID == ID
                             select registroActualiza;

        foreach (Product Producto in queryActualiza)
        {
            Producto.ProductName = nombreProducto;
            Producto.SupplierID = proveedor;
            Producto.CategoryID = categoria;
            Producto.QuantityPerUnit = cantidadPorUnidad;
            Producto.UnitPrice = precio;
            Producto.UnitsInStock = unidadesStock;
            Producto.UnitsOnOrder = unidadesOrdenadas;
        }
        try
        {
            dc.SubmitChanges();
            return true;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return false;
        }
    }
}