package vista;

import static vista.Clientes.res;
import modelo.Conexion;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */

public final class BuscarCliente extends javax.swing.JFrame {
DefaultTableModel model = new DefaultTableModel();


/**
 * Esta clase es la vista que nos permite buscar cliente para generar venta 
 * en vista venta
 * @deprecated 
 */
    public BuscarCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Lista De Clientes");
        CargarClientes();
        cargarIcono();
        if(modelo.Conexion.usuario.equals("vanessa")){
        jButton2.setEnabled(false);
        }
    }
    
    /**
     * este metodo nos permite precargar las imagenes de iconos a la vista
     * @deprecated 
     */

    public void cargarIcono() {
        java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/icons8_Search_24px.png"));
        setIconImage(icon);
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Metodo que nos permite cargar la tabla de articulos de la vista
     * @deprecated 
     */

    public void CargarClientes() {
        DefaultTableModel modelo = (DefaultTableModel) JT_TablaBuscarCliente.getModel();
        modelo.setRowCount(0);
        res = Conexion.Consulta("select * From clientes");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                modelo.addRow(v);
                JT_TablaBuscarCliente.setModel(modelo);
            }
        } catch (SQLException e) {
        }
    }
    
    /**
     * metodo que nos ayuda seleccionar articulo de la tabla  Articulos
     * @deprecated 
     */

    private void SelecionaCLiente() {
        int row = this.JT_TablaBuscarCliente.getSelectedRow();
        String id = this.JT_TablaBuscarCliente.getValueAt(row, 0).toString();
        String nom = this.JT_TablaBuscarCliente.getValueAt(row, 1).toString();
        String ape = this.JT_TablaBuscarCliente.getValueAt(row, 2).toString();
        String tel = this.JT_TablaBuscarCliente.getValueAt(row, 3).toString();
        String cor = this.JT_TablaBuscarCliente.getValueAt(row, 4).toString();
        Factura.jTextField7.setText(id);
        Factura.jTextField2.setText(nom);
        Factura.jTextField5.setText(tel);
        Factura.jTextField3.setText(ape);
        Factura.jTextField6.setText(cor);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_TablaBuscarCliente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buscartodo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        jMenuItem1.setText("Seleccionar Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_PDF_16px.png"))); // NOI18N
        jButton2.setText("VER REPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE CLIENTES");

        JT_TablaBuscarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_cliente", "nombre_cliente", "apellidos", "telefono", "correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JT_TablaBuscarCliente.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(JT_TablaBuscarCliente);
        if (JT_TablaBuscarCliente.getColumnModel().getColumnCount() > 0) {
            JT_TablaBuscarCliente.getColumnModel().getColumn(0).setResizable(false);
            JT_TablaBuscarCliente.getColumnModel().getColumn(1).setResizable(false);
            JT_TablaBuscarCliente.getColumnModel().getColumn(2).setResizable(false);
            JT_TablaBuscarCliente.getColumnModel().getColumn(3).setResizable(false);
            JT_TablaBuscarCliente.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Si el cliente no se encuetra en esta tabla, favor de pedir ser registrado por un encargado o administrador. ");

        buscartodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscartodoKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BUSCAR");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Close_Window_32px.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Minimize_Window_32px.png"))); // NOI18N
        jLabel20.setToolTipText("");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscartodo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        SelecionaCLiente();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection miConexion = Conexion.getConexion();  //lineas para generar reportes jasper
        try {
            String ubicacion = System.getProperty("user.dir") + "\\src\\Reportes\\report2_1.jasper";
           
            JasperReport jb = (JasperReport) JRLoader.loadObject(ubicacion);
            JasperPrint print = JasperFillManager.fillReport(jb, null, miConexion);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte De Clientes");
            view.setVisible(true);

            miConexion.close();

        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
       //codigo para generar busqueda de tabla clientes
        
        String[] titulos = {"id_cliente", "nombre_cliente", "apellidos", "telefono", "correo"};
        String[] registros = new String[50];

            String sql = "SELECT * FROM clientes WHERE id_cliente LIKE '%" + buscartodo.getText() + "%' "
                    + "OR nombre_cliente LIKE '%" + buscartodo.getText() + "%'"
                    + "OR apellidos LIKE '%" + buscartodo.getText() + "%'"
                    + "OR telefono LIKE '%" + buscartodo.getText() + "%'"
                    + "OR correo LIKE '%" + buscartodo.getText() + "%'";
            model = new DefaultTableModel(null, titulos);
            Conexion cc = new Conexion();
            Connection conect = cc.getConexion();
            try {
                Statement st = (Statement) conect.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    registros[0] = rs.getString("id_cliente");
                    registros[1] = rs.getString("nombre_cliente");
                    registros[2] = rs.getString("apellidos");
                    registros[3] = rs.getString("telefono");
                    registros[4] = rs.getString("correo");
                    model.addRow(registros);
                }
                JT_TablaBuscarCliente.setModel(model);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_buscartodoKeyPressed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.setState(BuscarCliente.ICONIFIED);
    }//GEN-LAST:event_jLabel20MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BuscarCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JT_TablaBuscarCliente;
    public static javax.swing.JTextField buscartodo;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
