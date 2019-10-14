package vista;

import modelo.Procedimientos;
import modelo.Conexion;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */

public class PedidosNuevo extends javax.swing.JFrame {
    Connection cn = Conexion.getConexion();
    PreparedStatement ps = null;
    static ResultSet res;
    int cont;
    int contador = 0;
    int contador2 = 0;
    
/**
 * Esta clase es la vista que nos permite buscar articulos para generar venta 
 * en vista venta
 * @deprecated 
 */
    
    public PedidosNuevo() {
        initComponents();
        jTextField6.setEditable(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("NUEVO");
        
        //lineas para precargar combobox
        this.combo.removeAllItems();
        this.combo.addItem("SELECCIONAR");
        this.combo1.removeAllItems();
        this.combo1.addItem("SELECCIONAR");
        try{
            String url = "jdbc:sqlserver://localhost:1433;databaseName=proyecto_goMarket";
            Connection cn = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("select * from proveedores");
            while(rs.next()){
                this.combo.addItem(rs.getString("nombre_proveedores"));
            }
            contador++;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            String url = "jdbc:sqlserver://localhost:1433;databaseName=proyecto_goMarket";
            Connection cn = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
            Statement Sent = cn.createStatement();
            ResultSet rs = Sent.executeQuery("select * from articulo");
            while(rs.next()){
                this.combo1.addItem(rs.getString("nom_articulo"));
            }
            contador2++;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * metodo que nos permite generar una precarga del combobox pedidos de la vista pedido nuevo
     * @deprecated 
     */

    public void CargarPedidos() {
        DefaultTableModel modelo = (DefaultTableModel) vista.Pedidos.jTable1.getModel();
        modelo.setRowCount(0);
        res = Conexion.Consulta("select * From pedidos");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getInt(2));
                v.add(res.getInt(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                modelo.addRow(v);
                vista.Pedidos.jTable1.setModel(modelo);
            }
        } catch (SQLException e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Save_16px.png"))); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("ID PROVEEDOR");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("PRODUCTO");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("CANTIDAD");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("FECHA DE PEDIDO");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("FECHA DE ENTREGA");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("ID PEDIDO");

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        combo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setText("ID ARTICULO");

        combo1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField5)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo, 0, 240, Short.MAX_VALUE)
                                    .addComponent(combo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jTextField1.transferFocus();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        jTextField2.transferFocus();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        jTextField3.transferFocus();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        jTextField4.transferFocus();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //if (jTextField6.getText().isEmpty())
          //  {
                //JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL ID DEL PEDIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                //jTextField6.requestFocus();
           // }
        //else 
        
        
        //lineas de validacion de los campo de texto
        if (jTextField1.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL ID DEL PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
                jTextField1.requestFocus();
            }
        else if (jTextField7.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL ID DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                jTextField7.requestFocus();
            }        
        else if (jTextField2.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NOMBRE DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                jTextField2.requestFocus();
            }
        else if (jTextField5.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA CANTIDAD DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                jTextField5.requestFocus();
            }
        else if (jTextField3.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA FECHA DEL PEDIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                jTextField3.requestFocus();
            }
        else if (jTextField4.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA FECHA DEL ENTREGA", "Advertencia", JOptionPane.WARNING_MESSAGE);
                jTextField4.requestFocus();
            }
        else {
                    String b = "0";
                    if(jTextField5.getText().equals(String.valueOf(b))){
                        JOptionPane.showMessageDialog(this, "ESTE VALOR NO ES PERMITIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(this, "INGRESE UN VALOR MAYOR A (0)", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        jTextField5.setText("");
                    }else{
                        try {
                            
                            //lineas pare hacer la modificacion en la base de datos 
                                                                                    
                            Procedimientos.EntradaPedidos( Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField7.getText()), jTextField2.getText(), jTextField5.getText(), jTextField3.getText(), jTextField4.getText());
                            String Update = "UPDATE articulo SET cantidad = cantidad + " + jTextField5.getText() + " WHERE id_articulo = '" + jTextField7.getText() + "'";
                            ps = cn.prepareStatement(Update);
                            ps.executeUpdate();
                            jTextField1.setText("");
                            jTextField2.setText("");
                            jTextField3.setText("");
                            jTextField4.setText("");
                            jTextField5.setText("");
                            jTextField6.setText("");
                            jTextField7.setText("");
                            jTextField1.requestFocus();
                            jTextField2.requestFocus();
                            jTextField3.requestFocus();
                            jTextField4.requestFocus();
                            jTextField5.requestFocus();
                            jTextField6.requestFocus();
                            jTextField7.requestFocus();
                            JOptionPane.showMessageDialog(this, "LOS DATOS HAN SIDO GUARDADOS CORRECTAMENTE");
                            CargarPedidos();
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(PedidosNuevo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
       
        
        //lineas de validacion de campos nulos de la vista al momento de guardar la informacion
        
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (jTextField6.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL ID DEL PEDIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jTextField6.requestFocus();
                }
            else if (jTextField1.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL ID DEL PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jTextField1.requestFocus();
                }
            else if (jTextField7.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL ID DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jTextField7.requestFocus();
                }        
            else if (jTextField2.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NOMBRE DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jTextField2.requestFocus();
                }
            else if (jTextField5.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA CANTIDAD DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jTextField5.requestFocus();
                }
            else if (jTextField3.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA FECHA DEL PEDIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jTextField3.requestFocus();
                }
            else if (jTextField4.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA FECHA DEL ENTREGA", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jTextField4.requestFocus();
                }
            else {
                        String b = "0";
                        if(jTextField5.getText().equals(String.valueOf(b))){
                            JOptionPane.showMessageDialog(this, "ESTE VALOR NO ES PERMITIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog(this, "INGRESE UN VALOR MAYOR A (0)", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            jTextField5.setText("");
                        }else{
                            try {
                                Procedimientos.EntradaPedidos( Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField7.getText()), jTextField2.getText(), jTextField5.getText(), jTextField3.getText(), jTextField4.getText());
                                String Update = "UPDATE articulo SET cantidad = cantidad + " + jTextField5.getText() + " WHERE id_articulo = '" + jTextField7.getText() + "'";
                                ps = cn.prepareStatement(Update);
                                ps.executeUpdate();
                                jTextField1.setText("");
                                jTextField2.setText("");
                                jTextField3.setText("");
                                jTextField4.setText("");
                                jTextField5.setText("");
                                jTextField6.setText("");
                                jTextField7.setText("");
                                jTextField1.requestFocus();
                                jTextField2.requestFocus();
                                jTextField3.requestFocus();
                                jTextField4.requestFocus();
                                jTextField5.requestFocus();
                                jTextField6.requestFocus();
                                jTextField7.requestFocus();
                                JOptionPane.showMessageDialog(this, "LOS DATOS HAN SIDO GUARDADOS CORRECTAMENTE");
                                CargarPedidos();
                                dispose();
                            } catch (SQLException ex) {
                                Logger.getLogger(PedidosNuevo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
            }
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c = evt.getKeyChar(); //validacion de tipo de dato en el campo de texto
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar(); //validacion de tipo de dato en el campo de texto
        if((c<'a'||c>'z')&&(c<'A'||c>'Z')&&(c<' '||c>' ')) evt.consume();
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        jTextField5.transferFocus();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char c = evt.getKeyChar(); //validacion de tipo de dato en el campo de texto
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char c = evt.getKeyChar(); //validacion de tipo de dato en el campo de texto
        if((c<'0'||c>'9')&&(c<'/'||c>'/')) evt.consume();
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char c = evt.getKeyChar();
        if((c<'0'||c>'9')&&(c<'/'||c>'/')) evt.consume();
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        jTextField6.transferFocus();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char c = evt.getKeyChar(); //validacion de tipo de dato en el campo de texto
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_jTextField6KeyTyped

    
    
    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
       //lineas para precargar el combo box de la viata pedido nuevo
        
        try{
            if(this.contador>0){
                String url = "jdbc:sqlserver://localhost:1433;databaseName=proyecto_goMarket";
                Connection cn = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
                Statement Sent = cn.createStatement();
                ResultSet rs1 = Sent.executeQuery("select * from proveedores where id_proveedores = '" + this.combo.getSelectedIndex() + "'");
                rs1.next();
                this.jTextField1.setText(String.valueOf(rs1.getInt("id_proveedores")));
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_comboActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
      //lineas de precarga del combobox articulo de la vista pedido nuevo
        
        try
            {
                if(this.contador2>0){
                    String url ="jdbc:sqlserver://localhost:1433;databaseName=proyecto_goMarket";
                    Connection cn = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
                    Statement Sent = cn.createStatement();
                    ResultSet rs1 = Sent.executeQuery("select * from articulo where id_articulo = '" + this.combo1.getSelectedIndex() + "'");
                    rs1.next();
                    this.jTextField7.setText(String.valueOf(rs1.getInt("id_articulo")));
                    this.jTextField2.setText(String.valueOf(rs1.getString("nom_articulo")));
                }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_combo1ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.setState(PedidosNuevo.ICONIFIED);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PedidosNuevo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox combo;
    public javax.swing.JComboBox combo1;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
