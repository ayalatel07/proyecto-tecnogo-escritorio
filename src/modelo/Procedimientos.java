package modelo;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 *
 * @author ayala
 */
public class Procedimientos {

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @throws java.sql.SQLException  eventos exceptuados de la operacion
     */
    public static void EntradaArticulo(int a, String b, String c, int d, float e) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaArt(?,?,?,?,?)}");
        entrada.setInt(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setInt(4, d);
        entrada.setFloat(5, e);
        //entrada.setFloat(6, f);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @throws java.sql.SQLException  eventos exceptuados de la operacion
     */
    public static void EntradaCliente(String a, String b, String c, String d) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaCli(?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        //entrada.setString(5, e);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @param f parametro recivido para modificar base de datos
     * @throws java.sql.SQLException eventos exceptuados de la operacion
     * 
     */
    public static void EntradaPedidos(int a, int b, String c, String d, String e, String f) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaPed(?,?,?,?,?,?)}");
        entrada.setInt(1, a);
        entrada.setInt(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setString(5, e);
        entrada.setString(6, f);
        //entrada.setString(7, g);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @throws SQLException  eventos que son exceptuados de la operacion 
     */
    public static void EntradaProveedores(String a, String b, String c) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaPro(?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        //entrada.setString(4, d);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @param f parametro recivido para modificar base de datos
     * @param g parametro recivido para modificar base de datos
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EntradaFactura(String a, String b, String c, String d, String e, String f, Float g) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaFactura(?,?,?,?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setString(5, e);
        entrada.setString(6, f);
        //entrada.setString(7, g);
        entrada.setFloat(7, g);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EntradaArticuloAud(String a, String b, String c, String d, String e) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaArticuloAud(?,?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setString(5, e);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EntradaClientesAud(String a, String b, String c, String d, String e) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaClientesAud(?,?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setString(5, e);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EntradaPedidosAud(String a, String b, String c, String d, String e) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaPedidosAud(?,?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setString(5, e);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EntradaProveedoresAud(String a, String b, String c, String d, String e) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaClientesAud(?,?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setString(5, e);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     * @param b parametro recivido para modificar base de datos
     * @param c parametro recivido para modificar base de datos
     * @param d parametro recivido para modificar base de datos
     * @param e parametro recivido para modificar base de datos
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EntradaFacturaAud(String a, String b, String c, String d, String e) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaFacturaAud(?,?,?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.setString(4, d);
        entrada.setString(5, e);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EliminarArticulo(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarArt(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */

    public static void EliminarCliente(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarCli(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EliminarPedidos(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarPed(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void EliminarProveedores(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarPro(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void BuscarArticulos(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call BuscarArt(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void BuscarProveedores(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call BuscarPro(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void BuscarPedidos(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call BuscarPed(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    /**
     * Metodo de invocacion de procedimientos para efectur modificaciones en
     * base de datos
     *
     * @param a parametro recivido para modificar base de datos
     *
     * @throws SQLException eventos que son exceptuados de la operacion 
     */
    public static void BuscarCliente(int a) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call BuscarCli(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }
}//fin de clase procedimientos
