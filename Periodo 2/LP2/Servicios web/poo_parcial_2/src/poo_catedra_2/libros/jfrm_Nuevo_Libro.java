/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_catedra_2.libros;

import mojica.lemus.utilitades.Validacion;

/**
 *
 * @author MekakuZero
 */
public class jfrm_Nuevo_Libro extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrm_Nuevo_Libro
     */
    public jfrm_Nuevo_Libro() {
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

        pnl_opciones = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        pnl_datos = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_picture = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        lbl_descripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo Libro");

        pnl_opciones.setBackground(new java.awt.Color(68, 189, 50));
        pnl_opciones.setMaximumSize(new java.awt.Dimension(100, 40));
        pnl_opciones.setMinimumSize(new java.awt.Dimension(100, 40));
        pnl_opciones.setPreferredSize(new java.awt.Dimension(100, 40));

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        pnl_opciones.add(btn_guardar);

        btn_limpiar.setText("Limpiar");
        pnl_opciones.add(btn_limpiar);

        getContentPane().add(pnl_opciones, java.awt.BorderLayout.PAGE_END);

        lbl_titulo.setText("Titulo:");

        lbl_picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo_catedra_2/img/camera.png"))); // NOI18N

        lbl_descripcion.setText("Descripcion");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        javax.swing.GroupLayout pnl_datosLayout = new javax.swing.GroupLayout(pnl_datos);
        pnl_datos.setLayout(pnl_datosLayout);
        pnl_datosLayout.setHorizontalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnl_datosLayout.createSequentialGroup()
                        .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_titulo)
                            .addComponent(lbl_descripcion)
                            .addComponent(txt_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(lbl_picture)))
                .addContainerGap())
        );
        pnl_datosLayout.setVerticalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_picture)
                    .addGroup(pnl_datosLayout.createSequentialGroup()
                        .addComponent(lbl_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_descripcion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(pnl_datos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        Validacion validar = new Validacion();
        
        validar.addTextBox(this.txt_titulo, "titulo").addTextArea(this.txt_descripcion, "descripcion");
        
        validar.validarNoVacios(new String[]{ "titulo" }).validarSoloTexto(new String[]{ "titulo", "descripcion"});
        
        if (validar.validar()) {
            
        } else
            validar.msgError("Guardar libro");
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_picture;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel pnl_datos;
    private javax.swing.JPanel pnl_opciones;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
