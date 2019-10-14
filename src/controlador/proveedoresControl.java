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
import vista.Interfaz;
import vista.Proveedores;
import static vista.Proveedores.jTable1;
import vista.ProveedoresNuevo;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class proveedoresControl implements ActionListener {

    private final int limite = 10;
    ProveedoresNuevo obj2 = new ProveedoresNuevo();
    static ResultSet res;
    Proveedores proveedor;

    /**
     * este metodo se encarga de generar un ActinListener a los eventos de los
     * menus de la vista proveedor
     *
     * @param proveedor mediate esta variable el metodo recive los eventos
     * ocurridos en la vista
     */
    proveedoresControl(Proveedores proveedor) {
        this.proveedor = proveedor;
        this.proveedor.jMenuItem1.addActionListener(this);//Regresar
        this.proveedor.jMenuItem2.addActionListener(this);//Regresar
        this.proveedor.jMenuItem3.addActionListener(this);//Regresar
        this.proveedor.jMenuItem4.addActionListener(this);//Regresar
        this.proveedor.jMenuItem5.addActionListener(this);//Regresar
        this.proveedor.jMenuItem6.addActionListener(this);//Regresar
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
        if (ae.getSource().getClass().toString().equals("class javax.swing.JMenuItem")) {

            JMenuItem opcion = (JMenuItem) ae.getSource();

            if (opcion.equals(proveedor.jMenuItem1)) {
                proveedor.dispose();
            }
            if (opcion.equals(proveedor.jMenuItem2)) {
                ProveedoresNuevo obj = new ProveedoresNuevo();
                proveedorNuevoControl control = new proveedorNuevoControl(obj);
                obj.setVisible(true);
            }
            if (opcion.equals(proveedor.jMenuItem3)) {
                proveedor.jTextField1.setEnabled(true);
                proveedor.jTextField2.setEnabled(true);
                proveedor.jTextField3.setEnabled(true);
            }
            if (opcion.equals(proveedor.jMenuItem6)) {
                try {
                    PreparedStatement pps = Conexion.getConexion().prepareStatement("update proveedores set nombre_proveedores='"
                            + proveedor.jTextField1.getText() + "', telefono='"
                            + proveedor.jTextField2.getText() + "', direccion='"
                            + proveedor.jTextField3.getText() + "' WHERE id_proveedores='"
                            + proveedor.jTextField4.getText() + "'");
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                    proveedor.jTextField1.setText("");
                    proveedor.jTextField2.setText("");
                    proveedor.jTextField3.setText("");
                    proveedor.jTextField4.setText("");
                    proveedor.jTextField1.requestFocus();
                    proveedor.jTextField2.requestFocus();
                    proveedor.jTextField3.requestFocus();
                    proveedor.jTextField4.requestFocus();
                    obj2.CargarProveedores();
                } catch (SQLException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals(proveedor.jMenuItem4)) { //lineas de validacion de campos nulos
                int fila = jTable1.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    int row = jTable1.getSelectedRow();

                    int opc = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (opc == JOptionPane.YES_OPTION) {
                        try {
                            Procedimientos.EliminarProveedores(Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
                            obj2.CargarProveedores();
                        } catch (SQLException e) {
                        }
                    }
                }
            }
            if (opcion.equals(proveedor.jMenuItem5)) {
                if (proveedor.jTextField4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "META BIEN SUS DATOS", "Error", JOptionPane.ERROR_MESSAGE);
                    proveedor.jTextField4.setText("");
                    proveedor.jTextField4.requestFocus();
                } else {
                    String b;
                    try {   //lineas para generar busqueda en la tabla proveedores
                        Procedimientos.BuscarProveedores(Integer.parseInt(proveedor.jTextField4.getText()));
                        b = proveedor.jTextField4.getText();
                        proveedor.jTextField1.setText("");
                        proveedor.jTextField2.setText("");
                        proveedor.jTextField3.setText("");
                        proveedor.jTextField4.setText("");
                        proveedor.jTextField1.requestFocus();
                        proveedor.jTextField2.requestFocus();
                        proveedor.jTextField3.requestFocus();
                        proveedor.jTextField4.requestFocus();
                        res = Conexion.Consulta("select * From proveedores");
                        while (res.next()) {
                            if (res.getString(1).equals(b)) {
                                JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
                                proveedor.jTextField4.setText(res.getString(1));
                                proveedor.jTextField1.setText(res.getString(2));
                                proveedor.jTextField2.setText(res.getString(3));
                                proveedor.jTextField3.setText(res.getString(4));
                            }
                        }
                        JOptionPane.showMessageDialog(null, "DATOS NO ENCONTRADOS");
                    } catch (NumberFormatException | SQLException | HeadlessException ex) {
                    }
                }
            }
        }

    }// fin de metodo override

}//fin de clase proveedoresControl
