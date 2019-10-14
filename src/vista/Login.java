package vista;


import modelo.Conexion;
import controlador.InterfazControl;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */

public final class Login extends javax.swing.JFrame {
    
       

    static int a;

    static boolean bandera = false;
    static Timer contador;

   /**
 * Esta clase es la vista que nos permite controlar el acceso de usuario a la 
 * aplicacion 
 * @deprecated 
 */
    
    public Login() {
        initComponents();
        
     

        setLocationRelativeTo(null);
        setTitle("SEGURIDAD");
        cargarIcono();
        usuario2.requestFocus();
    }
    
     /**
     * este metodo nos permite precargar las imagenes de iconos a la vista
     * @deprecated 
     */

    public void cargarIcono() {
        java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/icons8_Login_24px.png"));
        setIconImage(icon);
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    /**
     * esta clase nos permite tener el control de la barra de inicio al momento 
     * de estar validando los datos de usuario y contraseña
     * @deprecated 
     */

    public class claseTimer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            a = JPB_BarraDeProgreso8.getValue();

            if (a < 100) {
                a++;
                JPB_BarraDeProgreso8.setValue(a);
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        JPB_BarraDeProgreso8 = new javax.swing.JProgressBar();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        usuario2 = new javax.swing.JTextField();
        contraseña2 = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        internet = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPB_BarraDeProgreso8.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        JPB_BarraDeProgreso8.setForeground(new java.awt.Color(0, 0, 0));
        JPB_BarraDeProgreso8.setToolTipText("");
        JPB_BarraDeProgreso8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JPB_BarraDeProgreso8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JPB_BarraDeProgreso8.setStringPainted(true);
        JPB_BarraDeProgreso8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JPB_BarraDeProgreso8StateChanged(evt);
            }
        });
        jPanel12.add(JPB_BarraDeProgreso8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 310, -1));

        jLabel14.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("USUARIO:");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 161, -1, -1));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PASSWORD:");
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 265, -1, -1));

        jButton17.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Shutdown_32px.png"))); // NOI18N
        jButton17.setText("INICIAR");
        jButton17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 380, 130, 43));

        usuario2.setBackground(new java.awt.Color(240, 240, 240));
        usuario2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        usuario2.setToolTipText("");
        usuario2.setBorder(null);
        usuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioKeyTyped(evt);
            }
        });
        jPanel12.add(usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 199, 250, 32));

        contraseña2.setBackground(new java.awt.Color(240, 240, 240));
        contraseña2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        contraseña2.setBorder(null);
        contraseña2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaActionPerformed(evt);
            }
        });
        contraseña2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraseñaKeyPressed(evt);
            }
        });
        jPanel12.add(contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 301, 250, 30));
        jPanel12.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 237, 286, 10));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Key_32px.png"))); // NOI18N
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 299, -1, -1));
        jPanel12.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 337, 286, 10));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_User_32px.png"))); // NOI18N
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 199, -1, -1));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Contacts_64px.png"))); // NOI18N
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 310, 100));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Close_Window_32px.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 30, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Minimize_Window_32px.png"))); // NOI18N
        jLabel20.setToolTipText("");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 30, -1));

        internet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Globe_32px.png"))); // NOI18N
        internet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        internet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                internetMouseClicked(evt);
            }
        });
        jPanel12.add(internet, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 490, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   //lineas de validacion de la informacion ingresada al formulario
    private void contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (String.valueOf(usuario2.getText()).compareTo("") == 0 && String.valueOf(contraseña2.getPassword()).compareTo("") == 0) {
                JOptionPane.showMessageDialog(this, "INGRESE SU USUARIO Y CONTRASEÑA", "Advertencia", JOptionPane.WARNING_MESSAGE);
                usuario2.requestFocus();
            } else {
                if (String.valueOf(usuario2.getText()).compareTo(usuario2.getText()) == 0 && String.valueOf(contraseña2.getPassword()).compareTo("") == 0) {
                    JOptionPane.showMessageDialog(this, "POR FAVOR INGRESE SU CONTRASEÑA", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    contraseña2.requestFocus();
                } else {
                    if (String.valueOf(usuario2.getText()).compareTo("") == 0 && String.valueOf(contraseña2.getPassword()).compareTo(contraseña2.getText()) == 0) {
                        JOptionPane.showMessageDialog(this, "POR FAVOR INGRESE SU USUARIO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        usuario2.requestFocus();
                    } else {
                        contador = new Timer(30, new claseTimer());
                        Conexion.setcuenta(usuario2.getText(), contraseña2.getText());
                        Conexion.getConexion();
                        if (Conexion.getstatus()) {
                            contador.start();
                        } else {
                            JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCORRECTAS", "Error", JOptionPane.ERROR_MESSAGE);
                            usuario2.setText("");
                            contraseña2.setText("");
                            usuario2.requestFocus();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_contraseñaKeyPressed

    private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaActionPerformed
        contraseña2.transferFocus();
    }//GEN-LAST:event_contraseñaActionPerformed

    private void usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyTyped
        char c = evt.getKeyChar();  //lineas de limitacion de tipo  de datos ingresados al campo de texto
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_usuarioKeyTyped

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        usuario2.transferFocus();
    }//GEN-LAST:event_usuarioActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void internetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_internetMouseClicked

    }//GEN-LAST:event_internetMouseClicked

    private void JPB_BarraDeProgreso8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JPB_BarraDeProgreso8StateChanged
       
        //barra de progreso en la vista login
        
        if (JPB_BarraDeProgreso8.getValue()==100){
            dispose();
            Interfaz a=new Interfaz();
            InterfazControl control =new InterfazControl(a);
          a.setVisible(true);
          this.dispose();
        }
    }//GEN-LAST:event_JPB_BarraDeProgreso8StateChanged

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar JPB_BarraDeProgreso8;
    public javax.swing.JPasswordField contraseña2;
    private javax.swing.JLabel internet;
    public javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    public static javax.swing.JTextField usuario2;
    // End of variables declaration//GEN-END:variables
}
