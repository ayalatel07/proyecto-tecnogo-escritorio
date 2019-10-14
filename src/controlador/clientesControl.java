
package controlador;

import modelo.Procedimientos;
import modelo.Conexion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Clientes;
import static vista.Clientes.jTable1;
import vista.ClientesNuevo;
import vista.Interfaz;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class clientesControl implements ActionListener{
    Clientes clientes;
    private final int limite  = 10;
    ClientesNuevo obj2 = new ClientesNuevo();
    static ResultSet res;
    
    
    /**
     * Metodo mediante el cual captamos un evento de la clase action listener 
     * de la vista clientes
     * @param clientes mediante esta variable se recive el dato de la accion 
     * de la vista
     */

 
    public clientesControl(Clientes clientes){
        this.clientes=clientes;
        this.clientes.jMenuItem1.addActionListener(this);//Regresar
        this.clientes.jMenuItem2.addActionListener(this);//Nuevo
        this.clientes.jMenuItem3.addActionListener(this);//Editar
        this.clientes.jMenuItem6.addActionListener(this);//Guardar
        this.clientes.jMenuItem4.addActionListener(this);//Eliminar
        this.clientes.jMenuItem5.addActionListener(this);//Buscar
    }
    
    /**
     * metodo que nos genera una consulta a la base de datos y nos llena la 
     * tabla de la vista corte de caja
     * @deprecated 
     */
    
    public void CorteDeCaja(){
       DefaultTableModel modelo=(DefaultTableModel)jTable1.getModel();
       modelo.setRowCount(0);
       res = Conexion.Consulta("select fec,SUM(tot) as TOTAL_DE_VENTA from factura where nfac=nfac group by fec");
       try {
                while(res.next()){
                    Vector v=new Vector();
                    v.add(res.getString(1));
                    v.add("$" + res.getFloat(2) + "0");
                    modelo.addRow(v);
                    jTable1.setModel(modelo);
                }
       } catch (SQLException e){  
       }
    }
    
    
    /**
     * metodo sobreescrito para activar acciones conforme se capturan eventos 
     * del parametro del metodo
     * @param ae evento captado de la vista clientes
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().getClass().toString().equals("class javax.swing.JMenuItem")) {
            JMenuItem opcion = (JMenuItem) ae.getSource();
        
        if(opcion.equals(clientes.jMenuItem1)){
            clientes.dispose();
        }
         if(opcion.equals(clientes.jMenuItem2)){  //despliega la viata cliente nuevo
             ClientesNuevo obj = new ClientesNuevo();
             clientesNuevoControl control=new clientesNuevoControl(obj);
            obj.setVisible(true);
        }
         if(opcion.equals(clientes.jMenuItem3)){
                clientes.jTextField1.setEnabled(true);
                clientes.jTextField2.setEnabled(true);
                clientes.jTextField3.setEnabled(true);
                clientes.jTextField4.setEnabled(true);
        }
         if(opcion.equals(clientes.jMenuItem6)){
                        try {
                      PreparedStatement pps = Conexion.getConexion().prepareStatement("update clientes set nombre_cliente='" + 
                              clientes.jTextField1.getText() + "',apellidos='" + 
                              clientes.jTextField2.getText() + "',telefono='" + 
                              clientes.jTextField3.getText() + "',correo='" + 
                              clientes.jTextField4.getText() + "' WHERE id_cliente='" + 
                              clientes.jTextField5.getText() + "'");
                      pps.executeUpdate();
                      JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                      clientes.jTextField1.setText("");
                      clientes.jTextField2.setText("");
                      clientes.jTextField3.setText("");
                      clientes.jTextField4.setText("");
                      clientes.jTextField5.setText("");
                      clientes.jTextField1.setEnabled(false);
                      clientes.jTextField2.setEnabled(false);
                      clientes.jTextField3.setEnabled(false);
                      clientes.jTextField4.setEnabled(false);
                      obj2.CargarClientes();
                  } catch (SQLException ex) {
                      Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                  }
         }
         if(opcion.equals(clientes.jMenuItem4)){ //metodo para eliminacino de fila en tabla 
                            int fila = jTable1.getSelectedRow();
                    if (fila == -1) 
                        {
                            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        } 
                    else 
                        {
                            int row = jTable1.getSelectedRow();

                            int opc = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                            if (opc == JOptionPane.YES_OPTION) {
                                try {
                                    Procedimientos.EliminarCliente(Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
                                    obj2.CargarClientes();
                                } catch (SQLException e) {
                                }
                            }
                        }
         }
         if(opcion.equals(clientes.jMenuItem5)){//codigo para generar busqueda de cliente en base de datos
                        if (clientes.jTextField5.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Ingrese Correctamente sus datos", "Error", JOptionPane.ERROR_MESSAGE);
                     clientes.jTextField5.setText("");
                     clientes.jTextField5.requestFocus();
                 } else {
                     String b;
                     try {
                         Procedimientos.BuscarCliente(Integer.parseInt(clientes.jTextField5.getText()));
                         b = clientes.jTextField5.getText();
                         clientes.jTextField1.setText("");
                         clientes.jTextField2.setText("");
                         clientes.jTextField3.setText("");
                         clientes.jTextField4.setText("");
                         clientes.jTextField5.setText("");
                         clientes.jTextField1.requestFocus();
                         clientes.jTextField2.requestFocus();
                         clientes.jTextField3.requestFocus();
                         clientes.jTextField4.requestFocus();
                         clientes.jTextField5.requestFocus();
                         res = Conexion.Consulta("select * From clientes");
                         while (res.next()) {
                             if (res.getString(1).equals(b)) {
                                 JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
                                 clientes.jTextField5.setText(res.getString(1));
                                 clientes.jTextField1.setText(res.getString(2));
                                 clientes.jTextField2.setText(res.getString(3));
                                 clientes.jTextField3.setText(res.getString(4));
                                 clientes.jTextField4.setText(res.getString(5));
                             }
                         }
                         JOptionPane.showMessageDialog(null, "DATOS NO ENCONTRADOS");
                     } catch (NumberFormatException | SQLException | HeadlessException ex) {
                     }
                 }
         }
         
        
    }
    }//fin de metodo sobreescrito
    
    
}//fin de clase clientes control
