

package controlador;

import modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import vista.Interfaz;

import vista.Login;
import static vista.Login.usuario2;


/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class loginControl implements ActionListener{
    
    Login login;
    
    /**
     * metodo constructor de clase login
     * @param login nos envia parametro evento de la vista login
     */
    

    public loginControl(Login login) {
        this.login = login;
       
        
        
        /////////////LOGIN///////////////////////
        
        this.login.jButton17.addActionListener(this);
        this.login.contraseña2.addActionListener(this);
        
        
        /////////////////INTERFAZ////////////////////
        
       
        
      
    }//fin de action lisstener
    
    
    /**
     * Metodo sobreescrito que capta los eventos efectuados en los componentes mediante 
     * la clase ActionPerformed 
     * @param ae  ActionEvento ingresado al meotodo desde el componente 
     * de la vista 
     */


    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        ////////////////BOTONES///////////////////////////////////////////////////
        
         if (ae.getSource().getClass().toString().equals("class javax.swing.JButton")) {
            JButton boton = (JButton) ae.getSource();

            //   Hoja1 activa = (Hoja1) editor.jDesktopPaneEditorPrincipal.getSelectedFrame();
            if (boton.equals(login.jButton17)) {
                
                //lineas de validacion de campos
                
                 if (String.valueOf(usuario2.getText()).compareTo("") == 0 && String.valueOf(login.contraseña2.getPassword()).compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "INGRESE SU USUARIO Y CONTRASEÑA", "Advertencia", JOptionPane.WARNING_MESSAGE);
            usuario2.requestFocus();
        } else {
            if (String.valueOf(usuario2.getText()).compareTo(usuario2.getText()) == 0 && String.valueOf(login.contraseña2.getPassword()).compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE SU CONTRASEÑA", "Advertencia", JOptionPane.WARNING_MESSAGE);
                login.contraseña2.requestFocus();
            } else {
                if (String.valueOf(usuario2.getText()).compareTo("") == 0 && String.valueOf(login.contraseña2.getPassword()).compareTo(login.contraseña2.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE SU USUARIO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    usuario2.requestFocus();
                } else {
                  //contador = new Timer(30, new Login.claseTimer());
                    Conexion.setcuenta(usuario2.getText(), login.contraseña2.getText());
                    Conexion.getConexion();
                    if (Conexion.getstatus()) {
                       // contador.start();
                        if (Conexion.getstatus()){
                           
                           Interfaz vInterfaz = new Interfaz();
                           InterfazControl contInterfaz=new  InterfazControl(vInterfaz);
                           vInterfaz.setVisible(true);
                           // obj.setVisible(true);
                            login.setVisible(false);
                            //vInterfaz.dispose();

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTAS", "Error", JOptionPane.ERROR_MESSAGE);
                        usuario2.setText("");
                        login.contraseña2.setText("");
                        usuario2.requestFocus();
                    }
                }
            }
        }
             
            }
                
            }/////////////////FIN DE BOTONES/////////////////////////////////
         
         
         //////////////////JMENUITEM////////////////////////////////////////
         
          
       
    }//fin de metodo oveerride
    
}//fin de clase login control
