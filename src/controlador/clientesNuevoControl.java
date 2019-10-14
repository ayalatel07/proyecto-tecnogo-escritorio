/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Procedimientos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import vista.ClientesNuevo;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class clientesNuevoControl implements ActionListener {

    private final int limite = 10;
    static ResultSet res;
    int cont;
    ClientesNuevo clNuevo;

    /**
     * Esta clase es la clase de control de la vista Interfaz en la cual se
     * captan las acciones efectuadas en los elementos menu del frame.
     * @deprecated
     * @param clNuevo recive metodo valor de cliente
     */
    public clientesNuevoControl(ClientesNuevo clNuevo) {
        this.clNuevo = clNuevo;
        this.clNuevo.jButton1.addActionListener(this);
    }
    
    /**
     * Metodo sobreescrito que capta los eventos efectuados en los componentes mediante 
     * la clase ActionPerformed 
     * @param ae  ActionEvento ingresado al meotodo desde el componente 
     * de la vista 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {  //Lineas de validacion de campos nulos

        JButton boton = (JButton) ae.getSource();
        if (boton.equals(clNuevo.jButton1)) {
            if (clNuevo.jTextField1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL NOMBRE DEL CLIENTE", "Advertencia", JOptionPane.WARNING_MESSAGE);
                clNuevo.jTextField1.requestFocus();
            } else if (clNuevo.jTextField2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR LOS APELLIDOS DEL CLIENTE", "Advertencia", JOptionPane.WARNING_MESSAGE);
                clNuevo.jTextField2.requestFocus();
            } else if (clNuevo.jTextField3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL TELEFONO DEL CLIENTE", "Advertencia", JOptionPane.WARNING_MESSAGE);
                clNuevo.jTextField3.requestFocus();
            } else if (clNuevo.jTextField4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL CORREO DEL CLIENTE", "Advertencia", JOptionPane.WARNING_MESSAGE);
                clNuevo.jTextField4.requestFocus();
            } else {
                try {  //Linea que realiza consulta a la base de datos cliente
                    res = modelo.Conexion.Consulta("Select COUNT(nombre_cliente)from clientes where nombre_cliente='" + clNuevo.jTextField1.getText() + "'");
                    try {
                        while (res.next()) {
                            cont = res.getInt(1);
                        }
                    } catch (SQLException e) {
                    }
                    if (cont >= 1) {  //lineas de validacion de dato existente en base de datos
                        JOptionPane.showMessageDialog(null, "ESTE ELEMENTO YA EXISTE", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        clNuevo.jTextField1.setText("");
                        clNuevo.jTextField2.setText("");
                        clNuevo.jTextField3.setText("");
                        clNuevo.jTextField4.setText("");
                        clNuevo.jTextField5.setText("");
                        clNuevo.jTextField1.requestFocus();
                        clNuevo.jTextField2.requestFocus();
                        clNuevo.jTextField3.requestFocus();
                        clNuevo.jTextField4.requestFocus();
                        clNuevo.jTextField5.requestFocus();
                 
                    /**
                     * metodo para ingreesar datos a la tabla de clientes  en base de datos
                     */
                    } else {
                        Procedimientos.EntradaCliente(clNuevo.jTextField1.getText(), clNuevo.jTextField2.getText(), clNuevo.jTextField3.getText(), clNuevo.jTextField4.getText());
                        clNuevo.jTextField1.setText("");
                        clNuevo.jTextField2.setText("");
                        clNuevo.jTextField3.setText("");
                        clNuevo.jTextField4.setText("");
                        clNuevo.jTextField5.setText("");
                        clNuevo.jTextField1.requestFocus();
                        clNuevo.jTextField2.requestFocus();
                        clNuevo.jTextField3.requestFocus();
                        clNuevo.jTextField4.requestFocus();
                        clNuevo.jTextField5.requestFocus();
                        JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO GUARDADOS CORRECTAMENTE");
                        clNuevo.CargarClientes();
                        clNuevo.dispose();
                    }
                } catch (SQLException e) {
                }
            }
        }
    } //fin de metodo override

}//fin de clase cliente nuevo control
