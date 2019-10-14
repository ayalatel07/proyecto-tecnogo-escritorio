
package controlador;


 /**
 Esta clase es la clase de control de la vista Interfaz en la cual se captan 
 * las acciones efectuadas en los elementos menu del frame.
 * @deprecated 
 */

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vista.CorteCaja;
/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class corteCajaControl implements ActionListener{
    CorteCaja corte;
    
   /**
    * metodo constructor de clase
    * @param corte parametro que resive metodo de la vista 
    */

    
    public corteCajaControl(CorteCaja corte){
        this.corte=corte;
        this.corte.jButton2.addActionListener(this);        
    }
    
    
    /**
     * Metodo sobreescrito que capta los eventos efectuados en los componentes mediante 
     * la clase ActionPerformed 
     * @param ae  ActionEvento ingresado al meotodo desde el componente 
     * de la vista 
     */

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        if(boton.equals(corte.jButton2)){
            corte.CorteDeCaja();
        }
    
    }//fin de metodo override
    
}//fin de clase corte de caja control
