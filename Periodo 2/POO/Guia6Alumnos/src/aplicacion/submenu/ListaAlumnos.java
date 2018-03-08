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
public class ListaAlumnos extends javax.swing.JInternalFrame {

    
    
    
    
    Modelo alumnos;
    JDesktopPane panel;
    /**
     * Creates new form ListaMateria
     */
    public ListaAlumnos(JDesktopPane panel) {
        initComponents();
        obtenerAlumnos();
        this.panel = panel;
    }

    public void obtenerAlumnos(){
        Conexion con;
        
        if ((con = Conexion.establecerConexion()) != null) {
            String filtroNombre = this.txtFiltroNombreCompleto.getText().trim();
            
            Query seleccion = con.crearQuery("alumno");
            
            String[] columnas = { "Codigo", "Nombre", "Apellido" };
            
            ResultSet rs = seleccion
                    .whereConcatLike("Nombres", "Apellidos", "%" + filtroNombre + "%")
                    .select();
            
            alumnos = new Modelo(null, columnas);
            
            try{
                while(rs.next()){
                    Object[] fila = { rs.getInt("Cod_alumno"), rs.getString("Nombres"), rs.getString("Apellidos") };
                    alumnos.addRow(fila);
                }
            } catch(Exception ex) {
                System.out.println("Listado de alumnos: " + ex.getMessage());
            }
            
            this.tblAlumnos.setModel(alumnos);
            
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
        tblAlumnos = new javax.swing.JTable();
        pnlFiltracio = new javax.swing.JPanel();
        lblFiltroNombre = new javax.swing.JLabel();
        txtFiltroNombreCompleto = new javax.swing.JTextField();
        btnRecargar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de materias");

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        pnlFiltracio.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrado"));

        lblFiltroNombre.setText("Nombre completo del alumno:");

        txtFiltroNombreCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroNombreCompletoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroNombreCompletoKeyTyped(evt);
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
                .addComponent(txtFiltroNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFiltracioLayout.setVerticalGroup(
            pnlFiltracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltracioLayout.createSequentialGroup()
                .addGroup(pnlFiltracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltroNombre)
                    .addComponent(txtFiltroNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        this.obtenerAlumnos();
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void txtFiltroNombreCompletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNombreCompletoKeyTyped
        // TODO add your handling code here:
        if (!Character.isLetterOrDigit(evt.getKeyChar()) && evt.getKeyChar() != ' ')
            evt.consume();
        
    }//GEN-LAST:event_txtFiltroNombreCompletoKeyTyped

    private void txtFiltroNombreCompletoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNombreCompletoKeyReleased
        // TODO add your handling code here:
        this.obtenerAlumnos();
    }//GEN-LAST:event_txtFiltroNombreCompletoKeyReleased

    private void tblAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosMouseClicked
        // TODO add your handling code here:
        int fila = this.tblAlumnos.rowAtPoint(evt.getPoint());
        
        ModificarAlumno ma = new ModificarAlumno(this.alumnos.getRow(fila), this);
        panel.add(ma);
        ma.show();
        
        /*
        if (actual != null) {
            actual.dispose();
            actual = null;
        }
        
        SeleccionMateria sm = new SeleccionMateria(this.alumnos.getRow(fila), this);
        actual = sm;
        panel.add(sm);
        sm.show();
        */
    }//GEN-LAST:event_tblAlumnosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecargar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltroNombre;
    private javax.swing.JPanel pnlFiltracio;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtFiltroNombreCompleto;
    // End of variables declaration//GEN-END:variables
}
