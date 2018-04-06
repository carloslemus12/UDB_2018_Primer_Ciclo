/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_catedra_2.usuarios;

import java.util.List;
import mojica.lemus.utilitades.Mensaje;
import mojica.lemus.utilitades.Validacion;

/**
 *
 * @author MekakuZero
 */
public class jfrm_Nuevo_Usuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrm_Nuevo_Usuario
     */
    public jfrm_Nuevo_Usuario() {
        initComponents();
        this.btn_elminar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_opciones = new javax.swing.JPanel();
        btn_accion = new javax.swing.JButton();
        btn_elminar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        pnl_datos = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        lbl_confirmar_password = new javax.swing.JLabel();
        lbl_tipo_usuario = new javax.swing.JLabel();
        cmb_tipo_usuario = new javax.swing.JComboBox();
        jpf_password = new javax.swing.JPasswordField();
        jpf_confirmar_password = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo usuario");
        setDoubleBuffered(true);

        pnl_opciones.setBackground(new java.awt.Color(235, 47, 6));
        pnl_opciones.setMaximumSize(new java.awt.Dimension(300, 50));
        pnl_opciones.setMinimumSize(new java.awt.Dimension(300, 50));
        pnl_opciones.setPreferredSize(new java.awt.Dimension(300, 40));

        btn_accion.setText("Guardar");
        btn_accion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accionActionPerformed(evt);
            }
        });
        pnl_opciones.add(btn_accion);

        btn_elminar.setText("Eliminar");
        pnl_opciones.add(btn_elminar);

        btn_limpiar.setText("Limpiar");
        pnl_opciones.add(btn_limpiar);

        getContentPane().add(pnl_opciones, java.awt.BorderLayout.PAGE_END);

        lbl_username.setText("Nombre de usuario:");

        lbl_password.setText("Clave de usuario:");

        lbl_confirmar_password.setText("Confirmar clave de usuario:");

        lbl_tipo_usuario.setText("Tipo de usuario:");

        javax.swing.GroupLayout pnl_datosLayout = new javax.swing.GroupLayout(pnl_datos);
        pnl_datos.setLayout(pnl_datosLayout);
        pnl_datosLayout.setHorizontalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_datosLayout.createSequentialGroup()
                        .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_username)
                            .addComponent(txt_username)
                            .addComponent(lbl_password)
                            .addComponent(lbl_confirmar_password)
                            .addComponent(lbl_tipo_usuario)
                            .addComponent(cmb_tipo_usuario, 0, 289, Short.MAX_VALUE)
                            .addComponent(jpf_password))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jpf_confirmar_password))
                .addContainerGap())
        );
        pnl_datosLayout.setVerticalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_confirmar_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpf_confirmar_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_tipo_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_datos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_accionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accionActionPerformed
        // TODO add your handling code here:
        Validacion validacion = new Validacion();
        
        // Añadimos los controles a comprobar
        validacion.addTextBox(this.txt_username, "nombre de usuario").addTextBox(this.jpf_password, "contraseña").addTextBox(this.jpf_confirmar_password, "confirmar contraseña");
        
        // Establecemos los campos a los cuales se haran ñas validacones
        validacion.validarNoVacios(new String[]{"nombre de usuario","contraseña", "confirmar contraseña"}).validarSoloTexto(new String[]{"nombre de usuario"}).comprobarIgualdad("contraseña", "confirmar contraseña");
        
        // Posee errores
        if (validacion.validar()) {
            Mensaje.informacion(title, validacion.getTextFilter("nombre de usuario"));
        } else {
            validacion.msgError("Error en los campos del formulario");
        }
    }//GEN-LAST:event_btn_accionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accion;
    private javax.swing.JButton btn_elminar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox cmb_tipo_usuario;
    private javax.swing.JPasswordField jpf_confirmar_password;
    private javax.swing.JPasswordField jpf_password;
    private javax.swing.JLabel lbl_confirmar_password;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_tipo_usuario;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel pnl_datos;
    private javax.swing.JPanel pnl_opciones;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}