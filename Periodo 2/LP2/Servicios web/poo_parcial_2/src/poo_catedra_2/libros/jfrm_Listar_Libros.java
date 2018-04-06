/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_catedra_2.libros;

import mojica.lemus.utilitades.Validacion;
import poo_catedra_2.usuarios.*;

/**
 *
 * @author MekakuZero
 */
public class jfrm_Listar_Libros extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrm_Listar_Usuarios
     */
    public jfrm_Listar_Libros() {
        initComponents();
        this.pnl_datos.setVisible(false);
        
        this.btn_eliminar.setOpaque(false);
        this.btn_eliminar.setContentAreaFilled(false);
        this.btn_eliminar.setBorderPainted(false);
        
        this.btn_modificar.setOpaque(false);
        this.btn_modificar.setContentAreaFilled(false);
        this.btn_modificar.setBorderPainted(false);
        
        this.btn_close.setOpaque(false);
        this.btn_close.setContentAreaFilled(false);
        this.btn_close.setBorderPainted(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnl_filtro = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        txt_filtrar_titulo = new javax.swing.JTextField();
        lbl_tipo_usuario = new javax.swing.JLabel();
        cmb_filtrar_autor = new javax.swing.JComboBox();
        pnl_tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnl_datos = new javax.swing.JPanel();
        pnl_opciones = new javax.swing.JPanel();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        pnl_info = new javax.swing.JPanel();
        lbl_nuevo_username = new javax.swing.JLabel();
        lbl_img = new javax.swing.JLabel();
        lbl_nuevo_username2 = new javax.swing.JLabel();
        pnl_separacion = new javax.swing.JPanel();
        txt_titulo = new javax.swing.JTextField();
        cmb_autor = new javax.swing.JComboBox();
        lbl_nuevo_username3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Libros");
        setToolTipText("");

        pnl_filtro.setBackground(new java.awt.Color(75, 101, 132));

        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Titulo de la obra:");
        lbl_username.setToolTipText("");
        pnl_filtro.add(lbl_username);

        txt_filtrar_titulo.setMaximumSize(new java.awt.Dimension(150, 20));
        txt_filtrar_titulo.setMinimumSize(new java.awt.Dimension(150, 20));
        txt_filtrar_titulo.setPreferredSize(new java.awt.Dimension(150, 20));
        pnl_filtro.add(txt_filtrar_titulo);

        lbl_tipo_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipo_usuario.setText("Autor:");
        lbl_tipo_usuario.setToolTipText("");
        pnl_filtro.add(lbl_tipo_usuario);

        cmb_filtrar_autor.setMinimumSize(new java.awt.Dimension(150, 20));
        cmb_filtrar_autor.setPreferredSize(new java.awt.Dimension(150, 20));
        pnl_filtro.add(cmb_filtrar_autor);

        getContentPane().add(pnl_filtro, java.awt.BorderLayout.PAGE_START);

        pnl_tabla.setBackground(new java.awt.Color(255, 255, 255));
        pnl_tabla.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        pnl_tabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnl_tabla, java.awt.BorderLayout.CENTER);

        pnl_datos.setBackground(new java.awt.Color(255, 255, 255));
        pnl_datos.setMaximumSize(new java.awt.Dimension(200, 332));
        pnl_datos.setMinimumSize(new java.awt.Dimension(200, 332));
        pnl_datos.setPreferredSize(new java.awt.Dimension(200, 332));
        pnl_datos.setLayout(new java.awt.BorderLayout());

        pnl_opciones.setBackground(new java.awt.Color(194, 54, 22));
        pnl_opciones.setMaximumSize(new java.awt.Dimension(100, 40));
        pnl_opciones.setMinimumSize(new java.awt.Dimension(100, 40));
        pnl_opciones.setPreferredSize(new java.awt.Dimension(100, 40));
        pnl_opciones.setLayout(new java.awt.GridBagLayout());

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo_catedra_2/img/update.png"))); // NOI18N
        btn_modificar.setToolTipText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        pnl_opciones.add(btn_modificar, new java.awt.GridBagConstraints());

        btn_eliminar.setBackground(new java.awt.Color(252, 92, 101));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo_catedra_2/img/delete.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        pnl_opciones.add(btn_eliminar, new java.awt.GridBagConstraints());

        pnl_datos.add(pnl_opciones, java.awt.BorderLayout.PAGE_END);

        pnl_info.setBackground(new java.awt.Color(255, 255, 255));
        pnl_info.setLayout(new java.awt.GridBagLayout());

        lbl_nuevo_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo_username.setText("Autor:");
        lbl_nuevo_username.setMaximumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username.setMinimumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username.setPreferredSize(new java.awt.Dimension(200, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        pnl_info.add(lbl_nuevo_username, gridBagConstraints);

        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo_catedra_2/img/camera.png"))); // NOI18N
        lbl_img.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnl_info.add(lbl_img, gridBagConstraints);

        lbl_nuevo_username2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo_username2.setText("Titulo de la obra:");
        lbl_nuevo_username2.setMaximumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username2.setMinimumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username2.setPreferredSize(new java.awt.Dimension(200, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        pnl_info.add(lbl_nuevo_username2, gridBagConstraints);

        pnl_separacion.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        pnl_info.add(pnl_separacion, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnl_info.add(txt_titulo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnl_info.add(cmb_autor, gridBagConstraints);

        lbl_nuevo_username3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo_username3.setText("Descripcion:");
        lbl_nuevo_username3.setMaximumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username3.setMinimumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username3.setPreferredSize(new java.awt.Dimension(200, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        pnl_info.add(lbl_nuevo_username3, gridBagConstraints);

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        txt_descripcion.setMaximumSize(new java.awt.Dimension(164, 94));
        txt_descripcion.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPane2.setViewportView(txt_descripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnl_info.add(jScrollPane2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(5, 5));
        jPanel3.setMinimumSize(new java.awt.Dimension(5, 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(5, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        pnl_info.add(jPanel3, gridBagConstraints);

        pnl_datos.add(pnl_info, java.awt.BorderLayout.CENTER);
        pnl_info.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_close.setBackground(new java.awt.Color(220, 221, 225));
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo_catedra_2/img/close.png"))); // NOI18N
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 143, Short.MAX_VALUE)
                .addComponent(btn_close))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_close)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnl_datos.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnl_datos, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.pnl_datos.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        this.pnl_datos.setVisible(false);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        Validacion validar = new Validacion();
        
        validar.addTextBox(this.txt_titulo, "titulo").addTextArea(this.txt_descripcion, "descripcion");
        
        validar.validarNoVacios(new String[]{ "titulo" }).validarSoloTexto(new String[]{ "titulo", "descripcion"});
        
        if (validar.validar()) {
            
        } else
            validar.msgError("Seleccionar libro");
    }//GEN-LAST:event_btn_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox cmb_autor;
    private javax.swing.JComboBox cmb_filtrar_autor;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_nuevo_username;
    private javax.swing.JLabel lbl_nuevo_username2;
    private javax.swing.JLabel lbl_nuevo_username3;
    private javax.swing.JLabel lbl_tipo_usuario;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel pnl_datos;
    private javax.swing.JPanel pnl_filtro;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_opciones;
    private javax.swing.JPanel pnl_separacion;
    private javax.swing.JPanel pnl_tabla;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_filtrar_titulo;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
