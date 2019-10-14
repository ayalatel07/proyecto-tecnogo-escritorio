package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import vista.AcercaDe;
import vista.Articulos;
import vista.Clientes;
import vista.CorteCaja;
import vista.Factura;
import vista.Interfaz;
import vista.Login;
import vista.Pedidos;
import vista.Proveedores;
import vista.Reportes;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */



public class InterfazControl implements ActionListener{
    
    Interfaz interfaz;
    Login login;
    
    
 /**
 Esta clase es la clase de control de la vista Interfaz en la cual se captan 
 * las acciones efectuadas en los elementos menu del frame.
 * @deprecated 
 * @param interfaz recive eventos de la vista interfaz
 */


    
    public InterfazControl(Interfaz interfaz) {
        this.interfaz = interfaz;
       
        
        this.interfaz.jMenu1.addActionListener(this);
        this.interfaz.jMenu2.addActionListener(this);
        this.interfaz.jMenu6.addActionListener(this);
        this.interfaz.jMenu7.addActionListener(this);
        this.interfaz.jMenuItem1.addActionListener(this);
        this.interfaz.jMenuItem10.addActionListener(this);
        this.interfaz.jMenuItem11.addActionListener(this);
        this.interfaz.jMenuItem2.addActionListener(this);
        this.interfaz.jMenuItem3.addActionListener(this);
        this.interfaz.jMenuItem4.addActionListener(this);
        this.interfaz.jMenuItem5.addActionListener(this);
        this.interfaz.jMenuItem6.addActionListener(this);
        this.interfaz.jMenuItem7.addActionListener(this);
        this.interfaz.jMenuItem8.addActionListener(this);  
    }
    
    /**
     * Metodo sobreescrito que capta los eventos efectuados en los componentes
     * mediante la clase ActionPerformed
     *
     * @param a ActionEvento ingresado al meotodo desde el componente de la
     * vista
     */

    @Override
    public void actionPerformed(ActionEvent a) {
        
        if (a.getSource().getClass().toString().equals("class javax.swing.JMenuItem")) {

            JMenuItem opcion = (JMenuItem) a.getSource();
        if (opcion.equals(interfaz.jMenuItem1)) {// cerrar secion
               System.exit(0);
        }
        if (opcion.equals(interfaz.jMenuItem2)) {//Cerrar Sesion
               Interfaz vInterfaz=new Interfaz();
               Login acs = new Login();
                acs.show(true);
                vInterfaz.dispose();
                interfaz.hide();
        }
        if(opcion.equals(interfaz.jMenuItem3)){//Clientes vista
            Clientes obj = new Clientes();
            clientesControl control = new clientesControl(obj);
            obj.setVisible(true);
        }
        if(opcion.equals(interfaz.jMenuItem4)){ //pedidos vista
            Pedidos obj = new Pedidos();
            pedidosControl pcontrol=new pedidosControl(obj);
            obj.setVisible(true);
        }
        if(opcion.equals(interfaz.jMenuItem5)){
            AcercaDe control=new AcercaDe(); //Acerca de vista
            control.setVisible(true);
        }
        if(opcion.equals(interfaz.jMenuItem6)){  //proveedores vista
            Proveedores obj = new Proveedores();
            proveedoresControl control=new proveedoresControl(obj);
            obj.setVisible(true);
        }
        if(opcion.equals(interfaz.jMenuItem7)){  //factura vista
            Factura obj = new Factura();
            facturaControl control=new facturaControl(obj);
            obj.setVisible(true);
        }
        if(opcion.equals(interfaz.jMenuItem8)){ //articulos vista
            Articulos obj = new Articulos();
            articulosControl control = new articulosControl(obj);
            obj.setVisible(true);
        }
        if(opcion.equals(interfaz.jMenuItem10)){  //reportes vista
            
            Reportes rep = new Reportes();
            reportesControl obj=new reportesControl(rep);
            rep.setVisible(true);
        }
        if(opcion.equals(interfaz.jMenuItem11)){  //corte de caja vista
            CorteCaja objeto = new CorteCaja();
            corteCajaControl    control = new   corteCajaControl(objeto);
            objeto.setVisible(true);   
        }
            
            
            
        }
            
            
        
    }//fin de metodo override
    
}//fin de clase InterfazControl
