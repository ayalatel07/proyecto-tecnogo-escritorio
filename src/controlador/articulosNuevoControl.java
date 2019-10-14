package controlador;

import modelo.Procedimientos;
import modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Articulos;
import vista.ArticulosNuevo;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class articulosNuevoControl implements ActionListener{
    static ResultSet res;
    int cont;
    int contador = 0;
    ArticulosNuevo artNuevo;
    Articulos art;
    
    
    /**
 Esta clase es la clase de control de la vista Interfaz en la cual se captan 
 * las acciones efectuadas en los elementos menu del frame.
 * @deprecated 
 */
    
    articulosNuevoControl(ArticulosNuevo artNuevo){
        this.artNuevo = artNuevo;
        this.artNuevo.jButton1.addActionListener(this);
        //this.artNuevo.combo.addActionListener(this);
        this.artNuevo.jTextField1.addActionListener(this);
        this.artNuevo.jTextField2.addActionListener(this);
        this.artNuevo.jTextField3.addActionListener(this);
        this.artNuevo.jTextField4.addActionListener(this);
        this.artNuevo.jTextField6.addActionListener(this);
        this.artNuevo.jTextField7.addActionListener(this);
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
        if(boton.equals(artNuevo.jButton1)){
                    if (artNuevo.jTextField6.getText().isEmpty())  //lineas para validacion de campos nulos de la vista
            {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL ID LOS PROVEEDORES", "Advertencia", JOptionPane.WARNING_MESSAGE);
                artNuevo.jTextField6.requestFocus();
            }
        else if (artNuevo.jTextField1.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL NOMBRE DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                artNuevo.jTextField1.requestFocus();
            }        
        else if (artNuevo.jTextField2.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR LA MARCA DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                artNuevo.jTextField2.requestFocus();
            }
        else if (artNuevo.jTextField3.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR LA CANTIDAD DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                artNuevo.jTextField3.requestFocus();
            }
        else if (artNuevo.jTextField4.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL PRECIO DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                artNuevo.jTextField4.requestFocus();
            }
        else 
            {
                try 
                    {
                        res = modelo.Conexion.Consulta("Select COUNT(nom_articulo)from articulo where nom_articulo='" + artNuevo.jTextField1.getText() + "'");
                        try {
                            while (res.next()) {
                                cont = res.getInt(1);
                            }
                        } catch (SQLException e) {
                        }
                        if (cont >= 1) { //lineas de validacion de elemento existente en base de datos
                            JOptionPane.showMessageDialog(null, "ESTE ELEMENTO YA EXISTE", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            artNuevo.jTextField1.setText("");
                            artNuevo.jTextField2.setText("");
                            artNuevo.jTextField3.setText("");
                            artNuevo.jTextField4.setText("");
                            artNuevo.jTextField6.setText("");
                            artNuevo.jTextField7.setText("");
                            artNuevo.jTextField1.requestFocus();
                            artNuevo.jTextField2.requestFocus();
                            artNuevo.jTextField3.requestFocus();
                            artNuevo.jTextField4.requestFocus();
                            artNuevo.jTextField6.requestFocus();
                            artNuevo.jTextField7.requestFocus();
                        } else {
                            String b = "0";
                            String d = "0.0";
                            String c = ".";
                            if(artNuevo.jTextField3.getText().equals(String.valueOf(b))){
                                JOptionPane.showMessageDialog(null, "ESTE VALOR NO ES PERMITIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                JOptionPane.showMessageDialog(null, "INGRESE UN VALOR MAYOR A (0)", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                artNuevo.jTextField3.setText("");
                            }else if(artNuevo.jTextField4.getText().equals(String.valueOf(d)) || artNuevo.jTextField4.getText().equals(String.valueOf(b)) || artNuevo.jTextField4.getText().equals(String.valueOf(c))){
                                JOptionPane.showMessageDialog(null, "ESTE VALOR NO ES PERMITIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                JOptionPane.showMessageDialog(null, "INGRESE UN VALOR MAYOR A (0.0), (0) Y QUE NO SEA (.)", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                artNuevo.jTextField4.setText("");
                            }else{
                            Procedimientos.EntradaArticulo( Integer.parseInt(artNuevo.jTextField6.getText()), artNuevo.jTextField1.getText(), artNuevo.jTextField2.getText(), Integer.parseInt(artNuevo.jTextField3.getText()), Float.parseFloat(artNuevo.jTextField4.getText()));
                            artNuevo.jTextField1.setText("");
                            artNuevo.jTextField2.setText("");
                            artNuevo.jTextField3.setText("");
                            artNuevo.jTextField4.setText("");
                            artNuevo.jTextField6.setText("");
                            artNuevo.jTextField7.setText("");
                            artNuevo.jTextField1.requestFocus();
                            artNuevo.jTextField2.requestFocus();
                            artNuevo.jTextField3.requestFocus();
                            artNuevo.jTextField4.requestFocus();
                            artNuevo.jTextField6.requestFocus();
                            artNuevo.jTextField7.requestFocus();
                            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO GUARDADOS CORRECTAMENTE");
                            ArticulosNuevo arNuevo=new ArticulosNuevo();
                            arNuevo.CargarArticulo();
                            artNuevo.dispose();
                        }
                    }
                    } catch (SQLException e) 
                    {
                    }
        }
        } 
    }//fin de metodo sobreescrito
}// fin de clase articulosNuevoControl

