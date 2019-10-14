package controlador;

import modelo.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import vista.Reportes;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 *
 * @author ayala
 */
public class reportesControl implements ActionListener {

    Reportes reporte;

    /**
     * metodo que genera actionListener de los eventos captados de los menus de
     * la vista
     *
     * @param reporte recibe parametro de la vista interfaz
     */
    public reportesControl(Reportes reporte) {
        this.reporte = reporte;
        this.reporte.jButton1.addActionListener(this);
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
        if (boton.equals(reporte.jButton1)) {
            int fila = reporte.JT_TablaHistorial.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {  //lineas para la generacion de archivos jasper
                    String dni = reporte.JT_TablaHistorial.getValueAt(fila, 0).toString();
                    String rutaInforme = "src\\Reportes\\report3_1.jasper";
                    Map parametros = new HashMap();
                    parametros.put("nfac", dni);
                    JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros, Conexion.getConexion());
                    JasperViewer ventanavisor = new JasperViewer(informe, false);
                    ventanavisor.setTitle("Reporte De Venta Individual");
                    ventanavisor.setVisible(true);
                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL CARGAR EL REPORTE DE LA VENTA", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//fin de metodo override

}//fin de clase reportes
