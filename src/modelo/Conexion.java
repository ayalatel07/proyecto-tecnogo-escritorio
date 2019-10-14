package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 * @author ayala
 */
public class Conexion {

    static Connection contacto = null;
    public static String usuario;
    public static String password;
    public static boolean status = false;

    ////////////////////////////////////////////////////////////////////////////
   /**
    * metodo que se encarga de ralizar la Conexion con la base de datos
    * @return  con retorna el valor de la veriable contacto
    */
    
    public static Connection getConexion() {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=proyecto_goMarket";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la clase "
                    + "revizar el Driver " + ex.getMessage());
        }//catch

        try {
            contacto = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
            status = true;

            //JOptionPane.showMessageDialog(null, "Bienvenido" + " " + usuario + " " + " la Conexion fuè exitosa");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar" + ex.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }///catch
        return contacto;

    }//fin de metodo getConexion

    ////////////////////////////////////////////////////////////////////////////
    /**
     * metodo encargado de desconectar la base de datos 
     * una vez realizada la operacion
     * @deprecated 
     */
    
    public void desconectar() {
        try {

            contacto.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar" + ex.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }

    }//fin de metodo desconectar

    ////////////////////////////////////////////////////////////////////////////
   /**
    * metodo que genera consulta en base de datos
    * @param consulta parametro para filtrar la busqueda
    * @return valor null
    */
    
    public static ResultSet Consulta(String consulta) {

        Connection con = getConexion(); //se realiza Conexion

        Statement declara;

        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar" + e.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }//catch
        return null;

    }//fin metodo consulta

    ////////////////////////////////////////////////////////////////////////////
   
    /**
     * metodo para validar valor de usuario y contraseña 
     * @param usuario enviado de la vista login
     * @param password enviado de la vista login
     */
    
    public static void setcuenta(String usuario, String password) {

        if (usuario == null || password == null) {
            JOptionPane.showMessageDialog(null, "Asegurate de llenar tus campos");
        } else {
            Conexion.usuario = usuario;
            Conexion.password = password;
        }

    }//set cuenta

    ////////////////////////////////////////////////////////////////////////////
   
    /**
     * metodo para valorar el estatus de la Conexion
     * @return getstatus nos envia estatus de la Conexion
     */
    public static boolean getstatus() {

        return status;

    }//getStatus

    ////////////////////////////////////////////////////////////////////////////
}//fin de clase Conexion
