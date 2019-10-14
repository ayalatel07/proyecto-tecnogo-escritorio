package controlador;

import modelo.Procedimientos;
import modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.PedidosNuevo;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author auator
 */
public class pedidosNuevosControl implements ActionListener {

    Connection cn = Conexion.getConexion();
    PreparedStatement ps = null;
    static ResultSet res;
    int cont;
    int contador = 0;
    int contador2 = 0;
    PedidosNuevo pNuevo;

    /**
     * metodo constructor de clase
     *
     * @param pNuevo
     */
    pedidosNuevosControl(PedidosNuevo pNuevo) {
        this.pNuevo = pNuevo;
        // this.pNuevo.combo.addActionListener(this);
        //this.pNuevo.combo1.addActionListener(this);
        this.pNuevo.jButton1.addActionListener(this);
        this.pNuevo.jTextField1.addActionListener(this);
        this.pNuevo.jTextField2.addActionListener(this);
    }

    /**
     * metodo para cargar tabla de la vista pedidos
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

    /**
     * Metodo sobreescrito que capta los eventos efectuados en los componentes
     * mediante la clase ActionPerformed
     *
     * @param ae ActionEvento ingresado al meotodo desde el componente de la
     * vista
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();

        if (boton.equals(pNuevo.jButton1)) {
            if (pNuevo.jTextField6.getText().isEmpty())//lineas de validacion capos nulos
            {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL ID DEL PEDIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                pNuevo.jTextField6.requestFocus();
            } else if (pNuevo.jTextField1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL ID DEL PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
                pNuevo.jTextField1.requestFocus();
            } else if (pNuevo.jTextField7.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL ID DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                pNuevo.jTextField7.requestFocus();
            } else if (pNuevo.jTextField2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL NOMBRE DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                pNuevo.jTextField2.requestFocus();
            } else if (pNuevo.jTextField5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR LA CANTIDAD DEL ARTICULO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                pNuevo.jTextField5.requestFocus();
            } else if (pNuevo.jTextField3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR LA FECHA DEL PEDIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                pNuevo.jTextField3.requestFocus();
            } else if (pNuevo.jTextField4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR LA FECHA DEL ENTREGA", "Advertencia", JOptionPane.WARNING_MESSAGE);
                pNuevo.jTextField4.requestFocus();
            } else {
                String b = "0";
                if (pNuevo.jTextField5.getText().equals(String.valueOf(b))) {
                    JOptionPane.showMessageDialog(null, "ESTE VALOR NO ES PERMITIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "INGRESE UN VALOR MAYOR A (0)", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    pNuevo.jTextField5.setText("");
                } else {
                    try {
                        Procedimientos.EntradaPedidos(Integer.parseInt(pNuevo.jTextField1.getText()), Integer.parseInt(pNuevo.jTextField7.getText()), pNuevo.jTextField2.getText(), pNuevo.jTextField5.getText(), pNuevo.jTextField3.getText(), pNuevo.jTextField4.getText());
                        String Update = "UPDATE articulo SET cantidad = cantidad + " + pNuevo.jTextField5.getText() + " WHERE id_articulo = '" + pNuevo.jTextField7.getText() + "'";
                        ps = cn.prepareStatement(Update);
                        ps.executeUpdate();
                        pNuevo.jTextField1.setText("");
                        pNuevo.jTextField2.setText("");
                        pNuevo.jTextField3.setText("");
                        pNuevo.jTextField4.setText("");
                        pNuevo.jTextField5.setText("");
                        pNuevo.jTextField6.setText("");
                        pNuevo.jTextField7.setText("");
                        pNuevo.jTextField1.requestFocus();
                        pNuevo.jTextField2.requestFocus();
                        pNuevo.jTextField3.requestFocus();
                        pNuevo.jTextField4.requestFocus();
                        pNuevo.jTextField5.requestFocus();
                        pNuevo.jTextField6.requestFocus();
                        pNuevo.jTextField7.requestFocus();
                        JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO GUARDADOS CORRECTAMENTE");
                        CargarPedidos();
                        pNuevo.dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(PedidosNuevo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//fin de metodo override

}//fin de clase pedidosNuevosControl
