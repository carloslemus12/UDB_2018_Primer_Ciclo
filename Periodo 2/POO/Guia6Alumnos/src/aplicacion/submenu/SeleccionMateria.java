/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.submenu;

import java.util.Map;
import mojica.alexander.consulta.Conexion;
import mojica.alexander.consulta.Query;
import mojica.alexander.utilidades.*;

/**
 *
 * @author MekakuZero
 */
public class SeleccionMateria extends javax.swing.JInternalFrame {

    String id;
    String nombre;
    String descripcion;
    ListaMateria lista;
    
    /**
     * Creates new form NuevaMateria
     */
    public SeleccionMateria(Map<String, Object> fila, ListaMateria lista) {
        initComponents();
        
        this.id = fila.get("Codigo").toString();
        this.nombre = fila.get("Nombre").toString();
        this.descripcion = fila.get("Descripcion").toString();
        this.lista = lista;
        
        Limipiar();
        
        bandera = true;
    }

    static private boolean bandera = false;
    
    public static boolean Bandera(){
        return bandera;
    }
    
    @Override
    public void dispose() {
        // do your work here
        super.dispose();
        bandera = false;
    }
    
    public void Limipiar(){
        this.txtId.setText(this.id);
        this.txtNombre.setText(this.nombre);
        this.txtDescripcion.setText(this.descripcion);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modificar materia");

        lblId.setText("Codigo materia:");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Textbox_KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        lblNombre.setText("Nombre de la materia:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Textbox_KeyTyped(evt);
            }
        });

        lblDescripcion.setText("Descripcion de la materia:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblId)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId)
                            .addComponent(txtNombre))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar)
                        .addComponent(btnEliminar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.Limipiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_txtIdKeyTyped

    private void Textbox_KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Textbox_KeyTyped
        // TODO add your handling code here:
        if (!Character.isLetterOrDigit(evt.getKeyChar()) && evt.getKeyChar()!= ' ')
            evt.consume();
    }//GEN-LAST:event_Textbox_KeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (Validacion.ComprobarDatosTextBox(new javax.swing.JTextField[]{ this.txtId, this.txtNombre}) && !this.txtDescripcion.getText().trim().equals("")) {
            Conexion conexion;
            
            // Mientras no se haya oriducido ningun error
            if ((conexion = Conexion.establecerConexion()) != null) {
                
                Query update = conexion.crearQuery("materia");
                update.agregarCampoValor("Cod_materia", Integer.valueOf(this.txtId.getText().trim()));
                update.agregarCampoValor("Nombre", this.txtNombre.getText().trim());
                update.agregarCampoValor("Descripcion", this.txtDescripcion.getText().trim());
                
                update.where("Cod_materia", Integer.valueOf(this.id));
                
                if (update.update()> 0) {
                    Mensaje.Informacion("La materia ha sido modificada con exito", this.getTitle());
                    lista.obtenerMaterias();
                    this.dispose();
                } else
                    Mensaje.Error("No se ha podido modificar la materia", this.getTitle());
                
                conexion.cerrarConexion();
            } else
                Mensaje.Error("No se ha podido establecer la conexion", this.getTitle());
        } else
            Mensaje.Error("Todos los campos son obligatorios", this.getTitle());
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Conexion conexion;

        // Mientras no se haya oriducido ningun error
        if ((conexion = Conexion.establecerConexion()) != null) {
            Query delete = conexion.crearQuery("materia");
            delete.where("Cod_materia", Integer.valueOf(this.id));
            
            if (delete.delete() > 0) {
                    Mensaje.Informacion("La materia ha sido eliminada con exito", this.getTitle());
                    lista.obtenerMaterias();
                    this.dispose();
                } else
                    Mensaje.Error("No se ha podido eliminar la materia", this.getTitle());
            
            conexion.cerrarConexion();
        } else
            Mensaje.Error("No se ha podido establecer la conexion", this.getTitle());
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
