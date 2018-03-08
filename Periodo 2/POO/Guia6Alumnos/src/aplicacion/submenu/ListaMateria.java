/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.submenu;

import java.sql.ResultSet;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import mojica.alexander.consulta.Conexion;
import mojica.alexander.consulta.Query;
import mojica.alexander.utilidades.Mensaje;
import mojica.alexander.utilidades.Modelo;

/**
 *
 * @author MekakuZero
 */
public class ListaMateria extends javax.swing.JInternalFrame {

    static private boolean bandera = false;
    
    SeleccionMateria actual;
    
    Modelo materias;
    JDesktopPane panel;
    /**
     * Creates new form ListaMateria
     */
    public ListaMateria(JDesktopPane panel) {
        initComponents();
        obtenerMaterias();
        this.panel = panel;
        bandera = true;
        actual = null;
    }

    public static boolean Bandera(){
        return bandera;
    }
    
    @Override
    public void dispose() {
        // do your work here
        super.dispose();
        bandera = false;
    }
    
    public void obtenerMaterias(){
        Conexion con;
        
        if ((con = Conexion.establecerConexion()) != null) {
            String filtroNombre = this.txtFiltroNombre.getText().trim();
            
            Query seleccion = con.crearQuery("materia");
            
            String[] columnas = { "Codigo", "Nombre", "Descripcion" };
            
            ResultSet rs = seleccion.agregarCampoInt("Cod_materia")
                    .agregarCampoString("Nombre")
                    .agregarCampoString("Descripcion")
                    .whereLike("Nombre", "%" + filtroNombre + "%")
                    .select();
            
            materias = new Modelo(null, columnas);
            
            try{
                while(rs.next()){
                    Object[] fila = { rs.getInt("Cod_materia"), rs.getString("Nombre"), rs.getString("Descripcion") };
                    materias.addRow(fila);
                }
            } catch(Exception ex) {
                System.out.println("Listado de materia: " + ex.getMessage());
            }
            
            this.tblMateria.setModel(materias);
            
            con.cerrarConexion();
        } else
            Mensaje.Error("No se ha podido establecer la conexion", this.title);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateria = new javax.swing.JTable();
        pnlFiltracio = new javax.swing.JPanel();
        lblFiltroNombre = new javax.swing.JLabel();
        txtFiltroNombre = new javax.swing.JTextField();
        btnRecargar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de materias");

        tblMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMateriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMateria);

        pnlFiltracio.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrado"));

        lblFiltroNombre.setText("Nombre de la materia:");

        txtFiltroNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroNombreKeyTyped(evt);
            }
        });

        btnRecargar.setText("Recargar");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltracioLayout = new javax.swing.GroupLayout(pnlFiltracio);
        pnlFiltracio.setLayout(pnlFiltracioLayout);
        pnlFiltracioLayout.setHorizontalGroup(
            pnlFiltracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltracioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFiltroNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFiltracioLayout.setVerticalGroup(
            pnlFiltracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltracioLayout.createSequentialGroup()
                .addGroup(pnlFiltracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltroNombre)
                    .addComponent(txtFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecargar))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(pnlFiltracio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltracio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        // TODO add your handling code here:
        this.obtenerMaterias();
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void txtFiltroNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNombreKeyTyped
        // TODO add your handling code here:
        if (!Character.isLetterOrDigit(evt.getKeyChar()) && evt.getKeyChar() != ' ')
            evt.consume();
        
    }//GEN-LAST:event_txtFiltroNombreKeyTyped

    private void txtFiltroNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNombreKeyReleased
        // TODO add your handling code here:
        this.obtenerMaterias();
    }//GEN-LAST:event_txtFiltroNombreKeyReleased

    private void tblMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMateriaMouseClicked
        // TODO add your handling code here:
        int fila = this.tblMateria.rowAtPoint(evt.getPoint());
        
        if (actual != null) {
            actual.dispose();
            actual = null;
        }
        
        SeleccionMateria sm = new SeleccionMateria(this.materias.getRow(fila), this);
        actual = sm;
        panel.add(sm);
        sm.show();
    }//GEN-LAST:event_tblMateriaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecargar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltroNombre;
    private javax.swing.JPanel pnlFiltracio;
    private javax.swing.JTable tblMateria;
    private javax.swing.JTextField txtFiltroNombre;
    // End of variables declaration//GEN-END:variables
}
