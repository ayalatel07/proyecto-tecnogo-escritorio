package modelo;

import javax.swing.JProgressBar;

/**
 * GRUPO TECNO GO 6B Integrantes JULIO AYALA, GUSTAVO MORALES,ABRAHAM RODRIGUEZ,
 * DANIEL ONOFRE,LUIS PEREZ.
 *
 * @author ayala
 */
public class Cargar extends Thread {

    JProgressBar progreso;

    /**
     * metodo encargado del progreso de la barra de inicio
     *
     * @param progreso recibe el valor de progreso de la barra 
     */
    public Cargar(JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }

    /**
     * metodo override encargado de iniciar el hilo de la clase
     *
     * @deprecated
     */
    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {

            progreso.setValue(i);
            pausa(100);

        }

    }//fin metodo

    /**
     * metodo override encargado de pausar el hilo de la clase
     *
     * @deprecated
     * @param mlseg recive el valor en milisegundos de retardo
     */
    public void pausa(int mlseg) {

        try {
            Thread.sleep(mlseg);
        } catch (Exception e) {
        }

    }//din de metodo

}//fin de clase Cargar
