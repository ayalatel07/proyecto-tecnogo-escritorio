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
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import vista.Interfaz;
import vista.Pedidos;
import static vista.Pedidos.jTable1;
import vista.PedidosNuevo;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class pedidosControl implements ActionListener {

    Pedidos pedidos;
    PedidosNuevo obj2 = new PedidosNuevo();
    static ResultSet res;

    /**
     * Esta clase es la clase de control de la vista Interfaz en la cual se
     * captan las acciones efectuadas en los elementos menu del frame.
     *
     * @param pedidos metodo enviado de la vista pedidos
     */
    public pedidosControl(Pedidos pedidos) {
        this.pedidos = pedidos;
        this.pedidos.jMenuItem1.addActionListener(this);//Regresar
        this.pedidos.jMenuItem2.addActionListener(this);//Nuevo
        this.pedidos.jMenuItem3.addActionListener(this);//Editar
        this.pedidos.jMenuItem6.addActionListener(this);//Guardar
        this.pedidos.jMenuItem4.addActionListener(this);//Eliminar
        this.pedidos.jMenuItem5.addActionListener(this);//Ayuda
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

            JMenuItem boton = (JMenuItem) a.getSource();

            if (boton.equals(pedidos.jMenuItem1)) {//Regresar
                pedidos.dispose();
            }
            if (boton.equals(pedidos.jMenuItem2)) {//activacion de la vista pedidosNuevo
                PedidosNuevo obj = new PedidosNuevo();
                pedidosNuevosControl control = new pedidosNuevosControl(obj);
                obj.setVisible(true);
            }
            if (boton.equals(pedidos.jMenuItem3)) {
                pedidos.jTextField1.setEnabled(true);
                pedidos.jTextField2.setEnabled(true);
                pedidos.jTextField3.setEnabled(true);
                pedidos.jTextField4.setEnabled(true);
                pedidos.jTextField6.setEnabled(true);
                pedidos.jTextField5.setEnabled(true);
            }
            if (boton.equals(pedidos.jMenuItem6)) { //lineas para modificacion de la tabla pedidos
                try {
                    PreparedStatement pps = Conexion.getConexion().prepareStatement("update pedidos set id_proveedores='"
                            + pedidos.jTextField1.getText() + "',id_articulo='"
                            + pedidos.jTextField7.getText() + "',producto_pedidos='"
                            + pedidos.jTextField2.getText() + "',cant_de_pedidos='"
                            + pedidos.jTextField6.getText() + "',fecha_pedidos='"
                            + pedidos.jTextField3.getText() + "',fecha_entrega='"
                            + pedidos.jTextField4.getText() + "' WHERE id_pedidos='"
                            + pedidos.jTextField5.getText() + "'");
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                    pedidos.jTextField1.setText("");
                    pedidos.jTextField2.setText("");
                    pedidos.jTextField3.setText("");
                    pedidos.jTextField4.setText("");
                    pedidos.jTextField5.setText("");
                    pedidos.jTextField6.setText("");
                    pedidos.jTextField7.setText("");
                    pedidos.jTextField1.requestFocus();
                    pedidos.jTextField2.requestFocus();
                    pedidos.jTextField3.requestFocus();
                    pedidos.jTextField4.requestFocus();
                    pedidos.jTextField5.requestFocus();
                    pedidos.jTextField6.requestFocus();
                    pedidos.jTextField7.requestFocus();
                    obj2.CargarPedidos();
                } catch (SQLException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (boton.equals(pedidos.jMenuItem4)) {  //lineas de validacion de fila seleccionada en tabla
                int fila = jTable1.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    int row = jTable1.getSelectedRow();

                    int opc = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (opc == JOptionPane.YES_OPTION) {
                        try {

                            //lineas para la eliminacion e fila seleccionada en la vista
                            Procedimientos.EliminarPedidos(Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
                            obj2.CargarPedidos();
                        } catch (SQLException e) {
                        }
                    }
                }
            }
            if (boton.equals(pedidos.jMenuItem5)) {
                if (pedidos.jTextField5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "META BIEN SUS DATOS", "Error", JOptionPane.ERROR_MESSAGE);
                    pedidos.jTextField5.setText("");
                    pedidos.jTextField5.requestFocus();
                } else {
                    String b;
                    try {
                        Procedimientos.BuscarPedidos(Integer.parseInt(pedidos.jTextField5.getText()));
                        b = pedidos.jTextField5.getText();
                        pedidos.jTextField1.setText("");
                        pedidos.jTextField2.setText("");
                        pedidos.jTextField3.setText("");
                        pedidos.jTextField4.setText("");
                        pedidos.jTextField5.setText("");
                        pedidos.jTextField6.setText("");
                        pedidos.jTextField7.setText("");
                        pedidos.jTextField1.requestFocus();
                        pedidos.jTextField2.requestFocus();
                        pedidos.jTextField3.requestFocus();
                        pedidos.jTextField4.requestFocus();
                        pedidos.jTextField5.requestFocus();
                        pedidos.jTextField6.requestFocus();
                        pedidos.jTextField7.requestFocus();
                        res = Conexion.Consulta("select * From pedidos");
                        while (res.next()) {
                            if (res.getString(1).equals(b)) {
                                JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
                                pedidos.jTextField5.setText(res.getString(1));
                                pedidos.jTextField1.setText(res.getString(2));
                                pedidos.jTextField7.setText(res.getString(3));
                                pedidos.jTextField2.setText(res.getString(4));
                                pedidos.jTextField6.setText(res.getString(5));
                                pedidos.jTextField3.setText(res.getString(6));
                                pedidos.jTextField4.setText(res.getString(7));

                            }
                        }
                        JOptionPane.showMessageDialog(null, "DATOS NO ENCONTRADOS");
                    } catch (NumberFormatException | SQLException | HeadlessException ex) {
                    }
                }
            }
        }

    }//fin de metodo override

}//fin de clase pedidos control
