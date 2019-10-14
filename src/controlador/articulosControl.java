package controlador;

import modelo.Procedimientos;
import modelo.Conexion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import vista.Articulos;
import vista.ArticulosNuevo;
import vista.Interfaz;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */

public class articulosControl implements ActionListener{
ArticulosNuevo obj2 = new ArticulosNuevo();
static ResultSet res;
    Articulos articulos;
    
    
    /**
     * Metodo que nos permite captar los eventos de los elementos de la vista 
     * articulos 
     * @param articulos mediante este parametro enviamos la accion dek menu selecciondo
     */
    
    public articulosControl(Articulos articulos){
        this.articulos = articulos;
        this.articulos.jMenuItem1.addActionListener(this);
        this.articulos.jMenuItem2.addActionListener(this);
        this.articulos.jMenuItem3.addActionListener(this);
        this.articulos.jMenuItem4.addActionListener(this);
        this.articulos.jMenuItem5.addActionListener(this);
        this.articulos.jMenuItem6.addActionListener(this);
        this.articulos.jMenu1.addActionListener(this);
        this.articulos.jMenu2.addActionListener(this);
        this.articulos.jMenu3.addActionListener(this);
        this.articulos.jMenu4.addActionListener(this);
        
        
        
        
    }

    /**
     * Metodo sobreescrito que capta los eventos efectuados en los componentes mediante 
     * la clase ActionPerformed 
     * @param ae  ActionEvento ingresado al meotodo desde el componente 
     * de la vista 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().getClass().toString().equals("class javax.swing.JMenuItem")) {
            JMenuItem opcion = (JMenuItem) ae.getSource();
        
            
            if(opcion.equals(articulos.jMenuItem1)){  // articulos nuevo vista 
                ArticulosNuevo obj = new ArticulosNuevo();
                articulosNuevoControl control = new articulosNuevoControl(obj);
                obj.setVisible(true);
        }
        if(opcion.equals(articulos.jMenuItem2)){
                articulos.jTextField1.setEnabled(true);
                articulos.jTextField2.setEnabled(true);
                articulos.jTextField3.setEnabled(true);
                articulos.jTextField4.setEnabled(true);
                articulos.jTextField5.setEnabled(true);
        }
        if(opcion.equals(articulos.jMenuItem6)){  // codigo para modificar tabla proveedores
            try {
            PreparedStatement pps = Conexion.getConexion().prepareStatement("update articulo set id_proveedores='" + 
                    articulos.jTextField1.getText() + "',nom_articulo='" + 
                    articulos.jTextField2.getText() + "',marca_articulo='" + 
                    articulos.jTextField3.getText() + "',cantidad='" + 
                    articulos.jTextField4.getText() + "',precio_articulo='" + 
                    articulos.jTextField5.getText() + "' WHERE id_articulo='" + 
                    articulos.jTextField6.getText() + "'");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
            articulos.jTextField1.setText("");
            articulos.jTextField2.setText("");
            articulos.jTextField3.setText("");
            articulos.jTextField4.setText("");
            articulos.jTextField5.setText("");
            articulos.jTextField6.setText("");
            articulos.jTextField1.setEnabled(false);
            articulos.jTextField2.setEnabled(false);
            articulos.jTextField3.setEnabled(false);
            articulos.jTextField4.setEnabled(false);
            articulos.jTextField5.setEnabled(false);
            obj2.CargarArticulo();
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        if(opcion.equals(articulos.jMenuItem3)){
                    int fila = articulos.jTable1.getSelectedRow();
                if (fila == -1) 
                    {
                        JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    } 
                else 
                    {
                        int row = articulos.jTable1.getSelectedRow();
                        int opc = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (opc == JOptionPane.YES_OPTION) {
                            try {
                                Procedimientos.EliminarArticulo(Integer.parseInt(articulos.jTable1.getValueAt(row, 0).toString()));
                                obj2.CargarArticulo();
                            } catch (SQLException e) {
                            }
                        }
                    }
        }
        if(opcion.equals(articulos.jMenuItem5)){  //linea para validacion de campos de vista llenos
                        if (articulos.jTextField6.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "INGRESE SUS DATOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
                        articulos.jTextField6.setText("");
                        articulos.jTextField6.requestFocus();
                    } else {
                        try {  //consulta a base de datos tabla articulos
                            String b;
                            modelo.Procedimientos.BuscarArticulos(Integer.parseInt(articulos.jTextField6.getText()));
                            b = articulos.jTextField6.getText();
                            articulos.jTextField1.setText("");
                            articulos.jTextField2.setText("");
                            articulos.jTextField3.setText("");
                            articulos.jTextField4.setText("");
                            articulos.jTextField5.setText("");
                            articulos.jTextField6.setText("");
                            articulos.jTextField1.requestFocus();
                            articulos.jTextField2.requestFocus();
                            articulos.jTextField3.requestFocus();
                            articulos.jTextField4.requestFocus();
                            articulos.jTextField5.requestFocus();
                            articulos.jTextField6.requestFocus();
                            res = Conexion.Consulta("select * From articulo");
                            while (res.next()) {
                                if (res.getString(1).equals(b)) {
                                    JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
                                    articulos.jTextField6.setText(res.getString(1));
                                    articulos.jTextField1.setText(res.getString(2));
                                    articulos.jTextField2.setText(res.getString(3));
                                    articulos.jTextField3.setText(res.getString(4));
                                    articulos.jTextField4.setText(res.getString(5));
                                    articulos.jTextField5.setText(res.getString(6));
                                }
                            }
                            //JOptionPane.showMessageDialog(null, "DATOS NO ENCONTRADOS");
                        } catch (NumberFormatException | SQLException | HeadlessException ex) {
                        }
                    }
        }
        if(opcion.equals(articulos.jMenuItem4)){
            this.articulos.dispose();
        }
        
        }
       
        
        
    
    }//fin de sobreescritura
    
}//fin de clase articulosControl
