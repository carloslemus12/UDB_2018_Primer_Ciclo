/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemus.alexander;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MekakuZero
 */
public class Categorias extends mojica.alexander.mvc.Conexion implements java.io.Serializable {

    private int id;
    private String categoria;
    
    // Obtenemos todos los objetos categorias
    public Categorias() {
        this.id = 0;
        this.categoria = "";
    }
    
    public Categorias(ResultSet info) {
        try {
            this.id = info.getInt("id");
            this.categoria = info.getString("categoria");
        } catch(Exception error) {}
    }
    
    public Categorias(int id) {
        this.id = id;
        this.categoria = "";
    }
    
    // Obtenemos la lista de categoria
    public static Categorias obtenerCategoria(int id){
        Categorias categoria = new Categorias();
        
        Categorias c = new Categorias();
        
        c.conectar();
        
        c.crearQuery("select * from categoria_libro where id = ?");
        
        c.agregarParametro(1, id);
        
        ResultSet informacion = c.getResultSet();
        
        try {
            if (informacion.next())
                categoria = new Categorias(informacion);
        } catch (Exception error) {}
        
        c.desconectar();
        
        return categoria;
    }
    
    // Obtenemos la lista de categoria
    public static List<Categorias> obtenerCategorias(){
        List<Categorias> categorias = new ArrayList<>();
        
        Categorias c = new Categorias();
        
        c.conectar();
        
        c.crearQuery("select * from categoria_libro");
        
        ResultSet informacion = c.getResultSet();
        
        try {
            while (informacion.next())
                categorias.add(new Categorias(informacion));
        } catch (Exception error) {}
        
        c.desconectar();
        
        return categorias;
    }
    
    @Override
    public boolean guardar() {
        this.conectar();
        
        this.crearQuery("INSERT INTO categoria_libro (id, categoria) VALUES (?, ?)");
        
        this.agregarParametro(1, id);
        this.agregarParametro(2, categoria);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public boolean eliminar() {
        this.conectar();
        
        this.crearQuery("DELETE FROM categoria_libro WHERE id = ?");
        
        this.agregarParametro(1, id);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    @Override
    public boolean actualizar() {
        this.conectar();
        
        this.crearQuery("UPDATE categoria_libro SET categoria = ? WHERE id = ?");
        
        this.agregarParametro(1, categoria);
        this.agregarParametro(2, id);
        
        boolean resultado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return (this.categoria != null)? this.categoria : "";
    }

    public void setCategoria(String categoria) {
        if (categoria.trim().equals(""))
            this.categoria = null;
        else
            this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "<option value='" + id + "'>" + categoria + "</option>";
    }
    
    public String toString(int id) {
        if(id == this.id)
            return "<option value='" + this.id + "' selected>" + this.categoria + "</option>";
        else
            return "<option value='" + this.id + "'>" + this.categoria + "</option>";
    }
    
}
