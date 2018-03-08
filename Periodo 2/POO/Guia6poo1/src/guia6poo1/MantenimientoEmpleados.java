/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia6poo1;

import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sv.edu.udb.util.CheckPassword;

/**
 *
 * @author MekakuZero
 */
public class MantenimientoEmpleados extends javax.swing.JInternalFrame {

    ResultSet empleados;
    ResultSet llenarcombo;
    public static int bandera;
    Conexion con;
    /**
     * Creates new form MantenimientoEmpleados
     */
    public MantenimientoEmpleados() {
        initComponents();
        try{
            con = new Conexion();
            iniciarValores();
        } catch (Exception ex){}
    }
    
    public void iniciarValores() throws SQLException{
        Conexion con2 = new Conexion();
        con2.setRs("select * from tipo_usuario");
        this.cbTipoUsuario.removeAllItems();
        llenarcombo = con2.getRs();
        while(llenarcombo.next()){
            this.cbTipoUsuario.addItem(llenarcombo.getString(2));
        }
        con2.cerrarConexion();
        
        con.setRs("select * from usuarios where usuario like '%" + txtUsernameFiltro.getText() + "%'");
        System.out.println("select * from usuarios where usuario like '%" + txtUsernameFiltro.getText() + "%'");
        empleados = (ResultSet)con.getRs();
        
        int count = 0;
        
        while(empleados.next())
            count++;
        
        lblCantidad.setText("Cantidad de usuarios: " + count);
        
        if (count > 0) {
            empleados.beforeFirst();
            empleados.next();

            llenarTxt();
            
            this.btnAtras.setEnabled(false);
            this.btnSiguiente.setEnabled(true);
        } else {
            limpiarTxt();
            
            this.btnAtras.setEnabled(false);
            this.btnSiguiente.setEnabled(false);
            
            JOptionPane.showMessageDialog(this, "Error no hay usuarios con esos datos", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void anterior() throws SQLException{
        if (!empleados.isBeforeFirst()) {
            btnSiguiente.setEnabled(true);
            empleados.previous();
            llenarTxt();
        } else {
            JOptionPane.showMessageDialog(this, "Ya no existen elementos ha recorer");
            empleados.next();
            btnAtras.setEnabled(false);
        }
    }
    
    public void llenarTxt() throws SQLException{
        this.txtIndice.setText("" + empleados.getInt(1));
        this.txtNombre.setText(empleados.getString(2));
        this.txtApellido.setText(empleados.getString(3));
        this.txtEdad.setText("" + empleados.getInt(4));
        this.txtUsername.setText(empleados.getString(5));
        this.txtPass.setText(empleados.getString(6));
        this.cbTipoUsuario.setSelectedIndex(empleados.getInt(7));
    }
    
    public void siguiente() throws SQLException{
        if (!empleados.isAfterLast()) {
            btnAtras.setEnabled(true);
            empleados.next();
            llenarTxt();
        } else {
            JOptionPane.showMessageDialog(this, "Ya no existen elementos ha recorer");
            empleados.previous();
            btnSiguiente.setEnabled(false);
        }
    }
    
    public void limpiarTxt(){
        if(txtIndice.isEnabled())
            this.txtIndice.setText("");
        
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtUsername.setText("");
        this.txtPass.setText("");
        this.txtEdad.setText("");
        this.cbTipoUsuario.setSelectedIndex(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        txtIndice = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        txtPass = new javax.swing.JPasswordField();
        txtUsernameFiltro = new javax.swing.JTextField();
        lblUsernameFiltro = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setEnabled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnModificar.setText("Seleccionar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSiguiente)
                    .addComponent(btnAtras)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion de los empleados"));

        lblID.setText("Indice:");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblEdad.setText("Edad:");

        lblUsername.setText("Nombre de usuario:");

        lblPass.setText("Clave del usuario:");

        lblTipoUsuario.setText("Tipo de usuario:");

        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "empleado" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTipoUsuario)
                    .addComponent(lblPass)
                    .addComponent(lblUsername)
                    .addComponent(lblEdad)
                    .addComponent(lblApellido)
                    .addComponent(lblNombre)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIndice)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtEdad)
                    .addComponent(txtUsername)
                    .addComponent(cbTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoUsuario)
                    .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtUsernameFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameFiltroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameFiltroKeyTyped(evt);
            }
        });

        lblUsernameFiltro.setText("Nombre de usuario: ");

        lblCantidad.setText("Cantidad de usuarios: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsernameFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsernameFiltro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantidad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsernameFiltro)
                    .addComponent(txtUsernameFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        try{
            anterior();
        } catch(Exception e){
            try{
                anterior();
            } catch (Exception ex){
                Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        try{
            siguiente();
        } catch(Exception e){
            try{
                siguiente();
            } catch (Exception ex){
                Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarTxt();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(btnIngresar.getText().equals("Ingresar")){
                
                btnIngresar.setText("Guardar");
                
                btnAtras.setEnabled(false);
                btnSiguiente.setEnabled(false);
                btnModificar.setEnabled(false);
                btnLimpiar.setEnabled(true);
                
                limpiarTxt();
            }
            else{
                Conexion con2=new Conexion();
                CheckPassword verificar= new CheckPassword();
                char passArray[] = txtPass.getPassword();

                if(verificar.verificarPassword(passArray)){
                    String password = new String(txtPass.getPassword());
                    con2.setQuery("Insert into usuarios values("+this.txtIndice.getText() + ",\"" + this.txtNombre.getText() + "\",\"" +
                    txtApellido.getText() + "\"," +Integer.parseInt(txtEdad.getText()) +
                    ",\"" +this.txtUsername.getText()  +  "\",\""+
                    password +
                    "\"," + this.cbTipoUsuario.getSelectedIndex() + ")");
                    con2.cerrarConexion();
                    btnIngresar.setText("Ingresar");
                    JOptionPane.showMessageDialog(this, "Usuario Ingresado Exitosamente");
                    limpiarTxt();
                    con2.cerrarConexion();
                    iniciarValores();
                
                    btnModificar.setEnabled(true);
                    btnLimpiar.setEnabled(false);
                }
                else{
                    JOptionPane.showMessageDialog(this, "El passwor Contiene Caracteres Invalidos");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEdadKeyTyped

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        try{
            bandera = 0;
            con.cerrarConexion();
            this.dispose();
        } catch(Exception ex){
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            if (!txtIndice.getText().trim().equals("")) {
                if(btnModificar.getText().equals("Seleccionar")){
                    btnModificar.setText("Modificar");

                    btnAtras.setEnabled(false);
                    btnSiguiente.setEnabled(false);
                    btnIngresar.setEnabled(false);

                    btnEliminar.setEnabled(true);

                    txtIndice.setEnabled(false);

                    llenarTxt();

                    btnLimpiar.setEnabled(true);
                }
                else{
                    Conexion con2=new Conexion();

                    CheckPassword verificar= new CheckPassword();
                    char passArray[] = txtPass.getPassword();

                    if(verificar.verificarPassword(passArray)){

                        String id = this.txtIndice.getText();
                        String nombre = this.txtNombre.getText();
                        String apellido = this.txtApellido.getText();
                        String edad = this.txtEdad.getText();
                        String username = this.txtUsername.getText();
                        String pass = new String(this.txtPass.getPassword());
                        String tipo = "" +this.cbTipoUsuario.getSelectedIndex();

                        con2.setQuery("UPDATE usuarios SET " 
                                + "nombre = '" + nombre + "'"
                                + ",apellido = '" + apellido + "'"
                                + ",edad = " + edad
                                + ",usuario = '" + username + "'"
                                + ",password = '" + pass + "'"
                                + ",id_tipo_usuario = " + tipo
                                + " WHERE id = " + id);


                        con2.cerrarConexion();

                        JOptionPane.showMessageDialog(this, "Usuario modificado Exitosamente");

                        limpiarTxt();
                        iniciarValores();

                        btnModificar.setText("Seleccionar");
                        btnIngresar.setEnabled(true);
                        txtIndice.setEnabled(true);
                        btnLimpiar.setEnabled(false);

                        btnEliminar.setEnabled(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "El passwor Contiene Caracteres Invalidos");
                    }                            
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error no se puede modificar el usuario", "Error inesperado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try{
            String id = this.txtIndice.getText();
            Conexion con2 = new Conexion();
            con2.setQuery("DELETE FROM usuarios WHERE id = " + id);
            con2.cerrarConexion();
            JOptionPane.showMessageDialog(this, "Usuario Eliminado Exitosamente");        
            limpiarTxt();
            iniciarValores();
            btnModificar.setText("Seleccionar");
            btnIngresar.setEnabled(true);
            txtIndice.setEnabled(true);
            btnLimpiar.setEnabled(false);
            btnEliminar.setEnabled(false);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtUsernameFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameFiltroKeyReleased
        // TODO add your handling code here:
        try{
            iniciarValores();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_txtUsernameFiltroKeyReleased

    private void txtUsernameFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameFiltroKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtUsernameFiltroKeyPressed

    private void txtUsernameFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameFiltroKeyTyped
        // TODO add your handling code here:
        if (!Character.isLetterOrDigit(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtUsernameFiltroKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbTipoUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsernameFiltro;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIndice;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameFiltro;
    // End of variables declaration//GEN-END:variables
}