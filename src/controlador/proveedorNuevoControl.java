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
import vista.ProveedoresNuevo;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 *
 * @author ayala
 */
public class proveedorNuevoControl implements ActionListener {

    private final int limite = 10;
    static ResultSet res;
    int cont;
    ProveedoresNuevo prNuevo;

    /**
     * metodo que capta las acciones en los menus de la vista proveedores
     *
     * @param prNuevo dato que recive metodo de la calses vista
     */
    public proveedorNuevoControl(ProveedoresNuevo prNuevo) {
        this.prNuevo = prNuevo;
        this.prNuevo.jButton1.addActionListener(this);
    }

    /**
     * metodo que se encarga de cargar la tabla de la vista proveedores
     *
     * @deprecated
     */
    public void CargarProveedores() {
        DefaultTableModel modelo = (DefaultTableModel) vista.Proveedores.jTable1.getModel();
        modelo.setRowCount(0);
        res = Conexion.Consulta("select * From proveedores");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                modelo.addRow(v);
                vista.Proveedores.jTable1.setModel(modelo);
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

        if (boton.equals(prNuevo.jButton1)) {
            if (prNuevo.jTextField1.getText().isEmpty()) //linea de validacion de campos nulos
            {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL NOMBRE DEL PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
                prNuevo.jTextField1.requestFocus();
            } else if (prNuevo.jTextField2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR EL TELEFONO DEL PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
                prNuevo.jTextField2.requestFocus();
            } else if (prNuevo.jTextField3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FALTA INGRESAR LA DIRECCION DEL PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
                prNuevo.jTextField3.requestFocus();
            } else {
                try {
                    res = modelo.Conexion.Consulta("Select COUNT(nombre_proveedores)from proveedores where nombre_proveedores='" + prNuevo.jTextField1.getText() + "'");
                    try {
                        while (res.next()) {
                            cont = res.getInt(1);
                        }
                    } catch (SQLException e) {
                    }
                    if (cont >= 1) {// lineas de validacion de dato existente en base de datos
                        JOptionPane.showMessageDialog(null, "ESTE ELEMENTO YA EXISTE", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        prNuevo.jTextField1.setText("");
                        prNuevo.jTextField2.setText("");
                        prNuevo.jTextField3.setText("");
                        prNuevo.jTextField4.setText("");
                        prNuevo.jTextField1.requestFocus();
                        prNuevo.jTextField2.requestFocus();
                        prNuevo.jTextField3.requestFocus();
                        prNuevo.jTextField4.requestFocus();
                    } else {
                        Procedimientos.EntradaProveedores(prNuevo.jTextField1.getText(), prNuevo.jTextField2.getText(), prNuevo.jTextField3.getText());
                        prNuevo.jTextField1.setText("");
                        prNuevo.jTextField2.setText("");
                        prNuevo.jTextField3.setText("");
                        prNuevo.jTextField4.setText("");
                        prNuevo.jTextField1.requestFocus();
                        prNuevo.jTextField2.requestFocus();
                        prNuevo.jTextField3.requestFocus();
                        prNuevo.jTextField4.requestFocus();
                        JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO GUARDADOS CORRECTAMENTE");
                        prNuevo.CargarProveedores();
                        prNuevo.dispose();
                    }
                } catch (SQLException e) {
                }
            }
        }

    }//fin de metodo override
}//fin de clase proveedorNuevoContro
