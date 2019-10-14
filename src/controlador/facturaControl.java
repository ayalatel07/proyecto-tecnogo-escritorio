/**
 * Esta clase es la clase de control de la vista Interfaz en la cual se captan
 * las acciones efectuadas en los elementos menu del frame.
 *
 * @deprecated
 */
package controlador;

import modelo.Procedimientos;
import modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.BuscarArticulos;
import vista.BuscarCliente;
import vista.Factura;
import static vista.Factura.jTextField2;
import static vista.Factura.jTextField3;
import static vista.Factura.jTextField5;
import static vista.Factura.jTextField6;
import static vista.Factura.jTextField7;
import static vista.Factura.jtableDetalle;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class facturaControl implements ActionListener {

    Connection cn = Conexion.getConexion();
    PreparedStatement ps = null;
    private final int limite = 10;
    double suma = 0.0;
    double subtot = 0.0;
    double des = 0.0;
    double igv = 0.0;
    double total = 0.0;

    static int numfactura = 0;
    Factura factura;

    /**
     * este metodo se encarga de captar los eventos realizados en los menus de
     * la vista interfaz
     * @param factura recive valor de la vita factura
     */
    public facturaControl(Factura factura) {
        this.factura = factura;
        this.factura.jButton1.addActionListener(this);//Buscar Clientes
        this.factura.jButton2.addActionListener(this);//Buscar Articulos
        this.factura.jButton8.addActionListener(this);//Calculadora
        this.factura.jButton6.addActionListener(this);//alcular Total
        this.factura.jButton4.addActionListener(this);//Eliminar Articulo
        this.factura.jButton7.addActionListener(this);//Realizar Articulo
        this.factura.jButton3.addActionListener(this);//Salir

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

        if (boton.equals(factura.jButton1)) {//instancia para vista buscar cliente
            BuscarCliente obj = new BuscarCliente();
            buscarClienteControl control = new buscarClienteControl(obj);
            obj.setVisible(true);
        }
        if (boton.equals(factura.jButton2)) {//istancia para cista buscar articulo
            BuscarArticulos obj = new BuscarArticulos();
            buscarArticuloControl control = new buscarArticuloControl(obj);
            obj.setVisible(true);
        }
        if (boton.equals(factura.jButton8)) {//lineas para activar calculadora de windows
            try {
                Runtime rt = Runtime.getRuntime();
                Process p = rt.exec("calc");
                p.waitFor();
            } catch (IOException | InterruptedException ex) {
                System.out.println("ERROR AL EJECUTAR LA CALCULADORA DEL SISTEMA DE WINDOWS :" + ex);
            }
        }
        if (boton.equals(factura.jButton6)) {//lines para CalcularTotal
            for (int i = 0; i < jtableDetalle.getRowCount(); i++) {
                String precio = jtableDetalle.getValueAt(i, 5).toString();
                String cantidad = jtableDetalle.getValueAt(i, 4).toString();
                int c = Integer.parseInt(cantidad);
                double p = Double.parseDouble(precio);
                String stock = BuscarArticulos.JT_TablaBuscarProducto.getValueAt(i, 4).toString();
                String cant = jtableDetalle.getValueAt(i, 4).toString();
                if (Integer.parseInt(cant) > Integer.parseInt(stock)) {
                    JOptionPane.showMessageDialog(null, "NO HAY SUFICIENTES ARTICULOS EN EL STOCK", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                if (c >= 0) {
                    suma = c * p;
                    subtot += suma;
                    des = (subtot * 18) / 100;
                    total = subtot - des;
                    factura.jtf_subto.setText("$" + subtot);
                    factura.jtf_desc.setText("$" + des);
                    factura.jtf_total.setText(String.valueOf(total));
                }
            }
        }
        if (boton.equals(factura.jButton4)) {
            DefaultTableModel modelo = (DefaultTableModel) jtableDetalle.getModel();
            int fila_select = Factura.jtableDetalle.getSelectedRow();
            if (fila_select < 0) {
                JOptionPane.showMessageDialog(null, "Tabla Vacia O No Se Ha Seleccionado Un Elemento");
            } else {
                modelo.removeRow(fila_select);
                subtot = 0.0;
                des = 0.0;
                total = 0.0;
                factura.jtf_desc.setText("");
                factura.jtf_subto.setText("");
                factura.jtf_total.setText("");
            }
        }
        if (boton.equals(factura.jButton7)) {//Generar Factura

            //folio de factura
            numfactura++;

            String folio = Integer.toString(numfactura);

            factura.jTextField4.setText(folio);

            //lineas de validacion de campos nulos de factura
            if (factura.jTextField1.getText().isEmpty() || factura.jTextField4.getText().isEmpty() || factura.jtf_total.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "META BIEN SUS DATOS", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Procedimientos.EntradaFactura(factura.jTextField1.getText(), jTextField7.getText(), jTextField2.getText(), jTextField3.getText(), jTextField5.getText(), jTextField6.getText(), Float.parseFloat(factura.jtf_total.getText()));
                    factura.jTextField1.setText("");
                    factura.jTextField4.setText("");
                    subtot = 0.0;
                    des = 0.0;
                    total = 0.0;
                    factura.jtf_desc.setText("");
                    factura.jtf_subto.setText("");
                    factura.jtf_total.setText("");
                    factura.jTextField1.requestFocus();
                    factura.jTextField4.requestFocus();
                    JOptionPane.showMessageDialog(null, "LA VENTA SE REALIZO CORRECTAMENTE");
                    factura.limpiartabla();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (boton.equals(factura.jButton3)) {  // lineas para salir de aplicacion
            int dato = JOptionPane.showConfirmDialog(null, "¿ESTÁ SEGURO QUE DESEA SALIR?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (dato == JOptionPane.YES_OPTION) {
                factura.dispose();
            }
        }

    }//fin de metodo override

}//fin de clase facturaControl
