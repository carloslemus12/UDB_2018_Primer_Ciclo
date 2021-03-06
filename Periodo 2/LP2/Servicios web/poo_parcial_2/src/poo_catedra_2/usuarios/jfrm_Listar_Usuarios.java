/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_catedra_2.usuarios;

import mojica.lemus.utilitades.Mensaje;
import mojica.lemus.utilitades.Validacion;

/**
 *
 * @author MekakuZero
 */
public class jfrm_Listar_Usuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrm_Listar_Usuarios
     */
    public jfrm_Listar_Usuarios() {
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
        txt_username = new javax.swing.JTextField();
        lbl_tipo_usuario = new javax.swing.JLabel();
        cmb_tipo_usuario = new javax.swing.JComboBox();
        pnl_tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnl_datos = new javax.swing.JPanel();
        pnl_opciones = new javax.swing.JPanel();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        pnl_info = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbl_nuevo_username = new javax.swing.JLabel();
        lbl_img = new javax.swing.JLabel();
        lbl_nuevo_username1 = new javax.swing.JLabel();
        lbl_nuevo_username2 = new javax.swing.JLabel();
        pnl_separacion = new javax.swing.JPanel();
        txt_nuevo_username = new javax.swing.JTextField();
        cmb_nuevo_tipo_usuario = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Usuarios");
        setToolTipText("");

        pnl_filtro.setBackground(new java.awt.Color(75, 101, 132));

        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Nombre de usuario:");
        lbl_username.setToolTipText("");
        pnl_filtro.add(lbl_username);

        txt_username.setMaximumSize(new java.awt.Dimension(150, 20));
        txt_username.setMinimumSize(new java.awt.Dimension(150, 20));
        txt_username.setPreferredSize(new java.awt.Dimension(150, 20));
        pnl_filtro.add(txt_username);

        lbl_tipo_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tipo_usuario.setText("Tipo de usuario");
        lbl_tipo_usuario.setToolTipText("");
        pnl_filtro.add(lbl_tipo_usuario);

        cmb_tipo_usuario.setMinimumSize(new java.awt.Dimension(150, 20));
        cmb_tipo_usuario.setPreferredSize(new java.awt.Dimension(150, 20));
        pnl_filtro.add(cmb_tipo_usuario);

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
        pnl_info.add(jLayeredPane1, new java.awt.GridBagConstraints());

        lbl_nuevo_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo_username.setText("Tipo de usuario:");
        lbl_nuevo_username.setMaximumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username.setMinimumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username.setPreferredSize(new java.awt.Dimension(200, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        pnl_info.add(lbl_nuevo_username, gridBagConstraints);

        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo_catedra_2/img/user.png"))); // NOI18N
        lbl_img.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        pnl_info.add(lbl_img, gridBagConstraints);

        lbl_nuevo_username1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo_username1.setText("Nombre de usuario:");
        lbl_nuevo_username1.setMaximumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username1.setMinimumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username1.setPreferredSize(new java.awt.Dimension(200, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        pnl_info.add(lbl_nuevo_username1, gridBagConstraints);

        lbl_nuevo_username2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nuevo_username2.setText("Nombre de usuario:");
        lbl_nuevo_username2.setMaximumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username2.setMinimumSize(new java.awt.Dimension(200, 14));
        lbl_nuevo_username2.setPreferredSize(new java.awt.Dimension(200, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        pnl_info.add(lbl_nuevo_username2, gridBagConstraints);

        pnl_separacion.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 3;
        pnl_info.add(pnl_separacion, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnl_info.add(txt_nuevo_username, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnl_info.add(cmb_nuevo_tipo_usuario, gridBagConstraints);
        pnl_info.add(jPanel1, new java.awt.GridBagConstraints());

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
        Validacion validacion = new Validacion();
        
        // Añadimos los controles a comprobar
        validacion.addTextBox(this.txt_nuevo_username, "nombre de usuario");
        
        // Establecemos los campos a los cuales se haran ñas validacones
        validacion.validarNoVacios(new String[]{"nombre de usuario"}).validarSoloTexto(new String[]{"nombre de usuario"});
        
        // Posee errores
        if (validacion.validar()) {
            Mensaje.informacion(title, validacion.getTextFilter("nombre de usuario"));
        } else {
            validacion.msgError("Error en los campos del formulario");
        }
    }//GEN-LAST:event_btn_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox cmb_nuevo_tipo_usuario;
    private javax.swing.JComboBox cmb_tipo_usuario;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_nuevo_username;
    private javax.swing.JLabel lbl_nuevo_username1;
    private javax.swing.JLabel lbl_nuevo_username2;
    private javax.swing.JLabel lbl_tipo_usuario;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel pnl_datos;
    private javax.swing.JPanel pnl_filtro;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_opciones;
    private javax.swing.JPanel pnl_separacion;
    private javax.swing.JPanel pnl_tabla;
    private javax.swing.JTextField txt_nuevo_username;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
