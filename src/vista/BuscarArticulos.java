package vista;

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

public final class BuscarArticulos extends javax.swing.JFrame {
DefaultTableModel model = new DefaultTableModel();
static ResultSet res;

/**
 * Esta clase es la vista que nos permite buscar articulos para generar venta 
 * en vista venta
 * @deprecated 
 */

    public BuscarArticulos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Lista De Articulos");
        CargarArticulo();
        cargarIcono();
        if(modelo.Conexion.usuario.equals("vanessa")){
        JBT_REGISTRAR.setEnabled(false);
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
    public void CargarArticulo() {
        DefaultTableModel modelo = (DefaultTableModel) JT_TablaBuscarProducto.getModel();
        modelo.setRowCount(0);
        res = Conexion.Consulta("select * From articulo");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getInt(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getInt(5));
                v.add(res.getFloat(6));
                modelo.addRow(v);
                JT_TablaBuscarProducto.setModel(modelo);
            }
        } catch (SQLException e) {
        }
    }
    
    /**
     * metodo que nos ayuda seleccionar articulo de la tabla  Articulos
     * @deprecated 
     */

    private void Selecionaarticulo(){
        DefaultTableModel modelo = (DefaultTableModel) Factura.jtableDetalle.getModel();
        int row=JT_TablaBuscarProducto.getSelectedRow(); //parametro de busqueda en la tabla
        String id=JT_TablaBuscarProducto.getValueAt(row, 0).toString();
        String id2=JT_TablaBuscarProducto.getValueAt(row, 1).toString();
        String nom=JT_TablaBuscarProducto.getValueAt(row, 2).toString();
        String mar=JT_TablaBuscarProducto.getValueAt(row, 3).toString();
        String can="1";
        String pre=JT_TablaBuscarProducto.getValueAt(row, 5).toString();
        int i=0; 
        i=i+1;
        Object[]  dato=new Object[6];
        dato[0]=id;
        dato[1]=id2;
        dato[2]=nom;
        dato[3]=mar;
        dato[4]=can;
        dato[5]=pre;
        modelo.addRow(dato);
        Factura.jtableDetalle.setModel(modelo);
        Factura.jtableDetalle.editCellAt(row, 4);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_TablaBuscarProducto = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        JBT_REGISTRAR = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buscartodo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        jMenuItem2.setText("Seleccionar Articulo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE ARTICULOS");

        JT_TablaBuscarProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_articulo", "id_proveedores", "nom_articulo", "marca_articulo", "cantidad", "precio_articulo "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JT_TablaBuscarProducto.setComponentPopupMenu(jPopupMenu2);
        jScrollPane1.setViewportView(JT_TablaBuscarProducto);
        if (JT_TablaBuscarProducto.getColumnModel().getColumnCount() > 0) {
            JT_TablaBuscarProducto.getColumnModel().getColumn(0).setResizable(false);
            JT_TablaBuscarProducto.getColumnModel().getColumn(1).setResizable(false);
            JT_TablaBuscarProducto.getColumnModel().getColumn(2).setResizable(false);
            JT_TablaBuscarProducto.getColumnModel().getColumn(3).setResizable(false);
            JT_TablaBuscarProducto.getColumnModel().getColumn(4).setResizable(false);
            JT_TablaBuscarProducto.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        JBT_REGISTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_PDF_16px.png"))); // NOI18N
        JBT_REGISTRAR.setText("VER REPORTE");
        JBT_REGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_REGISTRARActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Si el articulo no se encuetra en esta tabla, favor de pedir registrarlo por un encargado o administrador.");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BUSCAR");

        buscartodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscartodoKeyPressed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBT_REGISTRAR)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBT_REGISTRAR)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBT_REGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_REGISTRARActionPerformed
       
        //codigo para generar reporte del contenido 
        
        Connection miConexion = Conexion.getConexion();
        try {
           // String ubicacion = System.getProperty("user.dir") + "\\src\\Reportes\\report1.jasper";
             String ubicacion = "C:\\Users\\ayala\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto5b\\proyecto goMarket\\src\\Reportes\\report1_1.jasper";
            JasperReport jb = (JasperReport) JRLoader.loadObject(ubicacion);
            JasperPrint print = JasperFillManager.fillReport(jb, null, miConexion);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte De Articulos");
            view.setVisible(true);

            miConexion.close();

        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_JBT_REGISTRARActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Selecionaarticulo();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed
        String[] titulos = {"id_articulo", "id_proveedores", "nom_articulo", "marca_articulo", "cantidad", "precio_articulo"};
        String[] registros = new String[50];

            String sql = "SELECT * FROM articulo WHERE id_articulo LIKE '%" + buscartodo.getText() + "%' "
                    + "OR nom_articulo LIKE '%" + buscartodo.getText() + "%'"
                    + "OR marca_articulo LIKE '%" + buscartodo.getText() + "%'"
                    + "OR cantidad LIKE '%" + buscartodo.getText() + "%'"
                    + "OR precio_articulo LIKE '%" + buscartodo.getText() + "%'" 
                    + "OR id_proveedores LIKE '%" + buscartodo.getText() + "%'";
            model = new DefaultTableModel(null, titulos);
            Conexion cc = new Conexion();
            Connection conect = cc.getConexion();
            try {
                Statement st = (Statement) conect.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    registros[0] = rs.getString("id_articulo");
                    registros[1] = rs.getString("id_proveedores");
                    registros[2] = rs.getString("nom_articulo");
                    registros[3] = rs.getString("marca_articulo");
                    registros[4] = rs.getString("cantidad");
                    registros[5] = rs.getString("precio_articulo");
                    model.addRow(registros);
                }
                JT_TablaBuscarProducto.setModel(model);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }//GEN-LAST:event_buscartodoKeyPressed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.setState(BuscarArticulos.ICONIFIED);
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
            java.util.logging.Logger.getLogger(BuscarArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BuscarArticulos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton JBT_REGISTRAR;
    public static javax.swing.JTable JT_TablaBuscarProducto;
    public javax.swing.JTextField buscartodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
