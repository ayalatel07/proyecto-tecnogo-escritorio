package controlador;

import modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.BuscarCliente;
import vista.Factura;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class buscarClienteControl implements ActionListener {

    BuscarCliente buscarCl = new BuscarCliente();

    /**
     * Esta clase es la clase de control de la vista Interfaz en la cual se
     * captan las acciones efectuadas en los elementos menu del frame.
     *
     * @deprecated
     */
    buscarClienteControl(BuscarCliente buscarCl) {
        this.buscarCl = buscarCl;
        this.buscarCl.buscartodo.addActionListener(this);
        this.buscarCl.jButton2.addActionListener(this);
    }
    
    /**
     * metodo que nos permite seleccionar el cliente de la vista buscar cliente
     * @deprecated 
     */

    private void SelecionaCLiente() {
        int row = this.buscarCl.JT_TablaBuscarCliente.getSelectedRow();
        String id = this.buscarCl.JT_TablaBuscarCliente.getValueAt(row, 0).toString();
        String nom = this.buscarCl.JT_TablaBuscarCliente.getValueAt(row, 1).toString();
        String ape = this.buscarCl.JT_TablaBuscarCliente.getValueAt(row, 2).toString();
        String tel = this.buscarCl.JT_TablaBuscarCliente.getValueAt(row, 3).toString();
        String cor = this.buscarCl.JT_TablaBuscarCliente.getValueAt(row, 4).toString();
        Factura.jTextField7.setText(id);
        Factura.jTextField2.setText(nom);
        Factura.jTextField5.setText(tel);
        Factura.jTextField3.setText(ape);
        Factura.jTextField6.setText(cor);
        buscarCl.dispose();
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

        if (boton.equals(buscarCl.buscartodo)) {
            Connection miConexion = Conexion.getConexion();
            try {
                String ubicacion = System.getProperty("user.dir") + "\\src\\Reportes\\report2_1.jasper";

                JasperReport jb = (JasperReport) JRLoader.loadObject(ubicacion);
                JasperPrint print = JasperFillManager.fillReport(jb, null, miConexion);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte De Clientes");
                view.setVisible(true);

                miConexion.close();

            } catch (JRException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        if (boton.equals(buscarCl.JT_TablaBuscarCliente)) {
            SelecionaCLiente();
        }

    }// fin del metodo sobreescrito

}//fin de la clase buscar cliente control
