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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MekakuZero
 */
public class Modelo extends DefaultTableModel {
    
    private List<Object[]> filas = new ArrayList<>();
    private Object[] columnas = null;
    
    public Modelo(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public Modelo(Vector columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public Modelo(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public Modelo(Vector data, Vector columnNames) {
        super(data, columnNames);
    }

    public Modelo(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        columnas = columnNames;
    }

    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData);
        filas.add(rowData);
    }

    public Map<String, Object> getRow(int fila){
        Map<String, Object> rows = new HashMap<>();
        
        Object[] celdas = this.filas.get(fila);
        
        for (int i = 0; i < columnas.length; i++) {
            rows.put(columnas[i].toString(), celdas[i]);
        }
        
        return rows;
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
