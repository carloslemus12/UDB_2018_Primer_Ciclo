/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.modelo;

import java.sql.ResultSet;
import mojica.alexander.mvc.Conexion;
import mojica.alexander.pojo.Usuario;

/**
 *
 * @author MekakuZero
 */
public class UsuarioModelo extends Conexion {
    public Usuario usuario;

    public UsuarioModelo(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean login(){
        String consulta = "SELECT * FROM usuario WHERE username = ? and password = ? and id_tipo_usuario = 2 LIMIT 1";
        
        this.conectar();
        
        this.crearQuery(consulta);
        
        this.agregarParametro(1, this.usuario.getUsername());
        this.agregarParametro(2, this.usuario.getPassword());
        
        ResultSet rs = this.getResultSet();
        
        boolean existe = false;
        
        try{
            if (rs.next()){
                existe = true;
                usuario.setId(rs.getInt("id"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
            }
        } catch(Exception error){}
        
        this.desconectar();
        
        return existe;
    }
    
    // /////////////////////////////////////////////////////////////////////////
    @Override
    public boolean guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
