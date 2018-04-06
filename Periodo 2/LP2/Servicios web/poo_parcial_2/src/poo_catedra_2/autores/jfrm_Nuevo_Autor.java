/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_catedra_2.autores;

import mojica.lemus.utilitades.Mensaje;
import mojica.lemus.utilitades.Validacion;

/**
 *
 * @author MekakuZero
 */
public class jfrm_Nuevo_Autor extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrm_Nuevo_Autor
     */
    public jfrm_Nuevo_Autor() {
        initComponents();
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
        btn_guardar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_nombre_completo = new javax.swing.JLabel();
        txt_nombre_completo = new javax.swing.JTextField();
        lbl_seudonimo = new javax.swing.JLabel();
        txt_seudonimo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo autor");

        jPanel1.setBackground(new java.awt.Color(39, 60, 117));
        jPanel1.setMaximumSize(new java.awt.Dimension(394, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(394, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(394, 40));

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar);

        btn_limpiar.setText("Limpiar");
        jPanel1.add(btn_limpiar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        lbl_nombre_completo.setText("Nombre completo:");

        lbl_seudonimo.setText("Seudonimo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_seudonimo)
                    .addComponent(lbl_nombre_completo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre_completo)
                    .addComponent(txt_seudonimo, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre_completo)
                    .addComponent(txt_nombre_completo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_seudonimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_seudonimo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        Validacion validacion = new Validacion();
        
        validacion.addTextBox(this.txt_nombre_completo, "nombre completo").addTextBox(this.txt_seudonimo, "seudonimo");
        
        validacion.validarSoloTexto(new String[]{ "nombre completo", "seudonimo" });
        
        if (!Validacion.isEmpty(txt_seudonimo) || !Validacion.isEmpty(txt_nombre_completo)) {
            if (validacion.validar()) {
                
            } else
                validacion.msgError("Guardar autor");
        } else
            Mensaje.error("Guardar autor", "Error: uno de los campos debe de estar lleno");
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_nombre_completo;
    private javax.swing.JLabel lbl_seudonimo;
    private javax.swing.JTextField txt_nombre_completo;
    private javax.swing.JTextField txt_seudonimo;
    // End of variables declaration//GEN-END:variables
}
