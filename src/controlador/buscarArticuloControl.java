/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.BuscarArticulos;
import vista.Factura;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class buscarArticuloControl implements ActionListener { //

    DefaultTableModel model = new DefaultTableModel();
    static ResultSet res;
    BuscarArticulos buscarArt;

    /**
     * metodo que permite captar los ecentos de la vista buscar articulo
     *
     * @param buscarArt dato que sera buscado en la base de datos
     */
    public buscarArticuloControl(BuscarArticulos buscarArt) {
        this.buscarArt = buscarArt;
        this.buscarArt.JBT_REGISTRAR.addActionListener(this);
        this.buscarArt.buscartodo.addActionListener(this);
    }

    /**
     * metodo con el que se llena la informacion de la tabla en vista
     *
     * @deprecated
     */
    public void CargarArticulo() {
        DefaultTableModel modelo = (DefaultTableModel) buscarArt.JT_TablaBuscarProducto.getModel();
        modelo.setRowCount(0);
        res = Conexion.Consulta("select * From articulo");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getInt(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getInt(5));
                v.add(res.getFloat(6));
                modelo.addRow(v);
                buscarArt.JT_TablaBuscarProducto.setModel(modelo);
            }
        } catch (SQLException e) {
        }
    }

    /**
     * metodo que selecciona articulo de la vista seleccionar articulo
     *
     * @deprecated
     */
    private void Selecionaarticulo() {

        DefaultTableModel modelo = (DefaultTableModel) Factura.jtableDetalle.getModel();
        int row = buscarArt.JT_TablaBuscarProducto.getSelectedRow();
        String id = buscarArt.JT_TablaBuscarProducto.getValueAt(row, 0).toString();
        String id2 = buscarArt.JT_TablaBuscarProducto.getValueAt(row, 1).toString();
        String nom = buscarArt.JT_TablaBuscarProducto.getValueAt(row, 2).toString();
        String mar = buscarArt.JT_TablaBuscarProducto.getValueAt(row, 3).toString();
        String can = "1";
        String pre = buscarArt.JT_TablaBuscarProducto.getValueAt(row, 5).toString();
        int i = 0;
        i = i + 1;
        Object[] dato = new Object[6];
        dato[0] = id;
        dato[1] = id2;
        dato[2] = nom;
        dato[3] = mar;
        dato[4] = can;
        dato[5] = pre;
        modelo.addRow(dato);
        Factura.jtableDetalle.setModel(modelo);
        Factura.jtableDetalle.editCellAt(row, 4);
        buscarArt.dispose();
    }

    /**
     * Metodo sobreescrito mediante el cual se captan eventos de la vista y se
     * realiza la accion correspondiente
     *
     * @param ae parameto mediante el cual se envia la informacion de action
     * event
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();

        if (boton.equals(buscarArt.JBT_REGISTRAR)) {
            Connection miConexion = Conexion.getConexion();
            try {
                // String ubicacion = System.getProperty("user.dir") + "\\src\\Reportes\\report1.jasper";
                String ubicacion = "C:\\Users\\ayala\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto5b\\proyecto goMarket\\src\\Reportes\\report1_1.jasper";
                JasperReport jb = (JasperReport) JRLoader.loadObject(ubicacion);
                JasperPrint print = JasperFillManager.fillReport(jb, null, miConexion);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte De Articulos");
                view.setVisible(true);
                miConexion.close();
            } catch (JRException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }// fin del metodo override

}// fin de la clase buscarArticuloControl
