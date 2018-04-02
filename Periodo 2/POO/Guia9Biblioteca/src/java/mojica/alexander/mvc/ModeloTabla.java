/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.mvc;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MekakuZero
 */
public class ModeloTabla extends DefaultTableModel {
    
    // Modelos
    private List<Modelado> modelos;

    public ModeloTabla(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public ModeloTabla(Vector columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public ModeloTabla(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public ModeloTabla(Vector data, Vector columnNames) {
        super(data, columnNames);
    }

    public ModeloTabla(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    
    public ModeloTabla(List<Modelado> modelos, Object[] columnNames) {
        super(null, columnNames);
        this.modelos = modelos;
        
        for (Modelado modelado : modelos) 
            this.addRow(modelado.crearFilaModelo());
    }

    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData);
    }
    
    public Modelado obtenerFilaModelo(int fila){
        return this.modelos.get(fila);
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
