/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.consulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import static mojica.alexander.consulta.Consulta.INT;
import static mojica.alexander.consulta.Consulta.STRING;


/**
 *
 * @author MekakuZero
 */
public class Query extends Consulta {
    private Map<String, Pair<String, String>> campovalor;
    private List<Pair<Pair<String, String>, Pair<String, Object>>> where;
    
    private static final String LIKE = "like";
    private static final String EQUALS = "=";
    private static final String IN = "in";
    private static final String NOTIN = "in";
    
    public Query(Conexion conexion, String tabla) {
        super(conexion, tabla);
        this.campovalor = new HashMap<>();
        this.where = new ArrayList<>();
    }
    
    public Query agregarCampoString(String campo){
        if (!this.campovalor.containsKey(campo))
            this.campovalor.put(campo, new Pair<>(STRING, ""));
        
        return this;
    }
    
    public Query agregarCampoInt(String campo){
        if (!this.campovalor.containsKey(campo))
            this.campovalor.put(campo, new Pair<>(INT, ""));
        
        return this;
    }
    
    // Añadimos los campos con los campovalor
    public Query agregarCampoValor(String campo, String valor){
        this.campovalor.put(campo, new Pair<>(STRING, valor));
        return this;
    }
    
    public Query agregarCampoValor(String campo, int valor){
        this.campovalor.put(campo, new Pair<>(INT, ""+valor));
        return this;
    }

    public Query where(String campo, String valor){
        where.add(new Pair<>(new Pair<>(campo, STRING), new Pair<>(EQUALS, valor)));
        
        return this;
    }
    
    public Query where(String campo, int valor){
        where.add(new Pair<>(new Pair<>(campo, INT), new Pair<>(EQUALS, ""+valor)));
        
        return this;
    }
    
    public Query whereLike(String campo, String valor){
        where.add(new Pair<>(new Pair<>(campo, STRING), new Pair<>(LIKE, valor)));
        
        return this;
    }
    
    public Query whereNotIn(String campo, List<Integer> valor){
        where.add(new Pair<>(new Pair<>(campo, INT), new Pair<>(NOTIN, valor)));
        
        return this;
    }
    
    public Query whereConcatLike(String campo1, String campo2, String valor){
        where.add(new Pair<>(new Pair<>("CONCAT("+campo1+",' ',"+ campo2 + ")", STRING), new Pair<>(LIKE, valor)));
        
        return this;
    }
    
    public ResultSet select(){
        try{
            String consulta = "SELECT ";
 
            boolean primera = true;
            for(HashMap.Entry<String, Pair<String, String>> datos : this.campovalor.entrySet()){
                consulta += (primera)? datos.getKey() : ", " + datos.getKey();
                primera = false;
            }

            if (primera) consulta += "*";
            
            primera = true;
            
            consulta += " FROM " + tabla;
            
            for(Pair<Pair<String, String>, Pair<String, Object>> datos : where){
                String campo = datos.getKey().getKey();
                String operacion = datos.getValue().getKey();
                
                if (operacion.equals(NOTIN)) {
                    consulta += (primera)? " WHERE NOT " + campo + " IN " : " AND NOT " + campo + " IN ";
                    
                    List<Object> lista = (List<Object>)datos.getValue().getValue();
                    
                    consulta += "(";
                    boolean uso = false;
                    
                    for(Object obj : lista){
                        consulta += (!uso)? "?" : ",?";
                        
                        uso = true;
                    }
                    
                    consulta += ")";
                } else {
                    String sentencia = campo + " " + operacion + " ?";
                    consulta += (primera)? " WHERE " + sentencia : " AND " + sentencia;
                }
                
                primera = false;
            }
            
            PreparedStatement sentencia = super.conexion.crearPreparedStatement(consulta);
            
            int indice = 1;
            for(Pair<Pair<String, String>, Pair<String, Object>> datos : where){
                String campo = datos.getKey().getKey();
                String operacion = datos.getValue().getKey();
                String tipo = datos.getKey().getValue();
                
                if (operacion.equals(NOTIN)) {
                    if (tipo.equals(INT)) {
                        List<Integer> lista = (List<Integer>)datos.getValue().getValue();
                         
                        for(Integer ind : lista){
                            sentencia.setInt(indice, ind);

                            indice++;
                        }

                    }
                } else {
                    String valor = datos.getValue().getValue().toString();
                    if (tipo.equals(STRING))
                        sentencia.setString(indice, valor);
                    else if (tipo.equals(INT))
                        sentencia.setInt(indice, Integer.valueOf(valor));
                
                    indice++;
                }
            }
            
            System.out.println(consulta);
            
            return sentencia.executeQuery();
            
        } catch (Exception ex){
            System.out.println("Sentencia select: " + ex.getMessage());
            return null;
        }
    }

    public int delete(){
        try{
            String consulta = "DELETE FROM " + super.tabla;
 
            boolean primera = true;
            
            for(Pair<Pair<String, String>, Pair<String, Object>> datos : where){
                String campo = datos.getKey().getKey();
                String operacion = datos.getValue().getKey();
                
                String sentencia = campo + " " + operacion + " ?";
                
                consulta += (primera)? " WHERE " + sentencia : " AND " + sentencia;
                
                primera = false;
            }
            
            PreparedStatement sentencia = super.conexion.crearPreparedStatement(consulta);
            
            int indice = 1;
            for(Pair<Pair<String, String>, Pair<String, Object>> datos : where){
                String campo = datos.getKey().getKey();
                String valor = datos.getValue().getValue().toString();
                
                String tipo = datos.getKey().getValue();
                
                if (tipo.equals(STRING))
                    sentencia.setString(indice, valor);
                else if (tipo.equals(INT))
                    sentencia.setInt(indice, Integer.valueOf(valor));
                
                indice++;
            }
            
            System.out.println(consulta);
            
            return sentencia.executeUpdate();
            
        } catch (Exception ex){
            System.out.println("Sentencia delete: " + ex.getMessage());
            return 0;
        }
    }
    
    public int update(){
        try{
            String consulta = "UPDATE " + super.tabla + " SET ";
            
            boolean primera = true;
            
            for(HashMap.Entry<String, Pair<String, String>> datos : this.campovalor.entrySet()){
                consulta += (primera)? datos.getKey() + " = ?" : ", " + datos.getKey() + " = ?";
                primera = false;
            }
            
            primera = true;
            for(Pair<Pair<String, String>, Pair<String, Object>> datos : where){
                String campo = datos.getKey().getKey();
                String operacion = datos.getValue().getKey();
                
                String sentencia = campo + " " + operacion + " ?";
                
                consulta += (primera)? " WHERE " + sentencia : " AND " + sentencia;
                
                primera = false;
            }
            
            PreparedStatement sentencia = super.conexion.crearPreparedStatement(consulta);
            
            int indice = 1;
            for (HashMap.Entry<String, Pair<String, String>> info : this.campovalor.entrySet()) {
                String tipo = info.getValue().getKey();
                String val = info.getValue().getValue();
                
                if (tipo.equals(STRING))
                    sentencia.setString(indice, val);
                else if (tipo.equals(INT))
                    sentencia.setInt(indice, Integer.valueOf(val));
                
                indice++;
            }
            
            for(Pair<Pair<String, String>, Pair<String, Object>> datos : where){
                String campo = datos.getKey().getKey();
                String valor = datos.getValue().getValue().toString();
                
                String tipo = datos.getKey().getValue();
                
                if (tipo.equals(STRING))
                    sentencia.setString(indice, valor);
                else if (tipo.equals(INT))
                    sentencia.setInt(indice, Integer.valueOf(valor));
                
                indice++;
            }
            
            return sentencia.executeUpdate();
        } catch(Exception ex) {
            System.out.println("Instruccion update: " + ex.getMessage());
            return 0;
        }
    }
    
    public int insert() {
        try{
            // Creamos la sentencia
            String consulta = "INSERT " + super.tabla;
            String valor = "";

            boolean campos = false;
            for (HashMap.Entry<String, Pair<String, String>> info : this.campovalor.entrySet()) {
                String campo = info.getKey();
                
                if (campos) {
                    consulta += "," + campo;
                    valor += ",?";
                } else {
                    consulta += "(" + campo;
                    valor += "(?";
                }

                campos = true;
            }

            consulta += ") VALUES " + valor + ")";

            PreparedStatement sentencia = super.conexion.crearPreparedStatement(consulta);

            int indice = 1;
            for (HashMap.Entry<String, Pair<String, String>> info : this.campovalor.entrySet()) {
                String tipo = info.getValue().getKey();
                String val = info.getValue().getValue();
                
                if (tipo.equals(STRING))
                    sentencia.setString(indice, val);
                else if (tipo.equals(INT))
                    sentencia.setInt(indice, Integer.valueOf(val));
                
                indice++;
            }
            
            System.out.println(consulta);

            return sentencia.executeUpdate();
        } catch(Exception ex){
            System.out.println("Sentencia insert: " + ex.getMessage());
            return 0;
        }
    }
}
