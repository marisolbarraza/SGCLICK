/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author Marisol
 */
public class ListarEmpleados extends javax.swing.JPanel {

    /**
     * Creates new form ListarEmpleados
     */
    public ListarEmpleados() {
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

        bgCuit = new javax.swing.JPanel();
        lbl_estado = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        lbl_busqueda = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox<>();
        btn_darBaja = new javax.swing.JButton();
        btn_nuevoEmpleado = new javax.swing.JButton();
        btn_editarEmpleado = new javax.swing.JButton();
        lbl_infoUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bgBienvenida1 = new javax.swing.JPanel();
        lbl_bienvenida1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgCuit.setBackground(new java.awt.Color(231, 197, 59));
        bgCuit.setForeground(new java.awt.Color(255, 255, 255));
        bgCuit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_estado.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lbl_estado.setText("Estado");
        bgCuit.add(lbl_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        txt_busqueda.setBorder(null);
        txt_busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_busquedaMouseClicked(evt);
            }
        });
        bgCuit.add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 390, 20));

        lbl_busqueda.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lbl_busqueda.setText("Legajo, Nombre o apellido");
        bgCuit.add(lbl_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bgCuit.add(cb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 100, -1));

        btn_darBaja.setBackground(new java.awt.Color(231, 197, 59));
        btn_darBaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_darBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconBaja.png"))); // NOI18N
        btn_darBaja.setText("Dar de baja");
        btn_darBaja.setBorder(null);
        bgCuit.add(btn_darBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 120, -1));

        btn_nuevoEmpleado.setBackground(new java.awt.Color(231, 197, 59));
        btn_nuevoEmpleado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_nuevoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconNuevo.png"))); // NOI18N
        btn_nuevoEmpleado.setText("Nuevo empleado");
        btn_nuevoEmpleado.setBorder(null);
        btn_nuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoEmpleadoActionPerformed(evt);
            }
        });
        bgCuit.add(btn_nuevoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 30));

        btn_editarEmpleado.setBackground(new java.awt.Color(231, 197, 59));
        btn_editarEmpleado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_editarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconEditar.png"))); // NOI18N
        btn_editarEmpleado.setText("Editar datos del empleado");
        btn_editarEmpleado.setBorder(null);
        btn_editarEmpleado.setBorderPainted(false);
        btn_editarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarEmpleadoActionPerformed(evt);
            }
        });
        bgCuit.add(btn_editarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 190, -1));

        add(bgCuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 830, 100));

        lbl_infoUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbl_infoUsuario.setText("Usuario: Nombre y apellido empleado - Rol: Administrador");
        add(lbl_infoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Legajo", "DNI", "Nombre y apellido", "Fecha de nacimieto", "Domicilio ", "Telefono", "Localidad", "Provincia", "Pais", "Email"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 810, 440));

        bgBienvenida1.setBackground(new java.awt.Color(0, 0, 0));
        bgBienvenida1.setForeground(new java.awt.Color(255, 255, 255));
        bgBienvenida1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bienvenida1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lbl_bienvenida1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bienvenida1.setText("Lista de empleados");
        bgBienvenida1.add(lbl_bienvenida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        add(bgBienvenida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 830, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_busquedaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busquedaMouseClicked

    private void btn_nuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevoEmpleadoActionPerformed

    private void btn_editarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarEmpleadoActionPerformed
       
    }//GEN-LAST:event_btn_editarEmpleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgBienvenida1;
    private javax.swing.JPanel bgCuit;
    public javax.swing.JButton btn_darBaja;
    public javax.swing.JButton btn_editarEmpleado;
    public javax.swing.JButton btn_nuevoEmpleado;
    public javax.swing.JComboBox<String> cb_estado;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_bienvenida1;
    private javax.swing.JLabel lbl_busqueda;
    private javax.swing.JLabel lbl_estado;
    public javax.swing.JLabel lbl_infoUsuario;
    public javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
