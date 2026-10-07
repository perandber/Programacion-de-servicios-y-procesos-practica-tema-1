package com.perceval.tarea1psp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Tarea 4
 * Comprobar la velocidad de procesamiento
 * @author Perceval Andreu
 */
public class TestVelocidad {
    
    /**
     * Comprobar la velocidad del sistema a traves de un comando ping
     */
    public static void testPing() {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "ping -n 2 127.0.0.1");
            Process proceso = builder.start();
            
            if (!proceso.waitFor(3, TimeUnit.SECONDS)) {
                //El proceso tardo demasiado
                proceso.destroyForcibly();
                System.out.println("Velocidad demasiado lenta");
            }
            
        } catch (InterruptedException ex) {
            System.getLogger(TestVelocidad.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(TestVelocidad.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
