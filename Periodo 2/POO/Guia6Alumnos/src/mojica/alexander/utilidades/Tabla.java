/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.utilidades;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MekakuZero
 */
public class Tabla {
    private List<Map<String, String>> filas;
    private int pos = -1;
    
    public void InicializarPosicion(){
        pos = -1;
    }
    
    public boolean siguiente(){
        return filas != null && filas.size() > 0 && pos < filas.size();
    }
    
    public Tabla(ResultSet resultados) {
        filas = new ArrayList<>();
        pos = -1;
        
        int numFilas = 0;
        
        try{
            while(resultados.next()) numFilas++;
            
            if (numFilas > 0) {
                ResultSetMetaData datos = resultados.getMetaData();
                int numColumn = datos.getColumnCount();
                
                if (numColumn > 0) {
                    
                    resultados.beforeFirst();
                    int indice = 0;
                    while(resultados.next()){
                        Map<String, String> fila = new HashMap<>();
                        
                        fila.put("Indice", ""+indice);
                        
                        for (int i = 1; i <= numColumn; i++) {
                            fila.put(datos.getColumnName(i), resultados.getObject(i).toString());
                        }
                        
                        filas.add(fila);
                        indice++;
                    }
                }
            }
        } catch(Exception ex){ System.out.println("Modelo: " + ex.getMessage()); }
    }

    public Map<String,String> getRow(int row){
        if (row < this.filas.size())
            return this.filas.get(row);
        else
            return null;
    }
    
    public Fila getRow(){
        try{
            return new Fila(this.filas.get(pos));
        } catch(Exception ex){
            return null;
        }
    }
    
    public String getField(int row, String columna){
        if (row < this.filas.size()){
            Map<String, String> fila = this.filas.get(row);
            
            if (fila.containsKey(columna))
                return fila.get(columna);
            else
                return "none";
        } else
            return "none";
    }
    
    @Override
    public String toString() {
        return "Tabla(" + filas + ")";
    }
    
    public static class Fila{
        Map<String, String> campos;

        public Fila(Map<String, String> campos) {
            this.campos = campos;
        }

        @Override
        public String toString() {
            return "Hola";
        }
        
    }
}
