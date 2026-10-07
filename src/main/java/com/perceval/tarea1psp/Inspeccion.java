package com.perceval.tarea1psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tarea 1
 * Ejecutar comandos del sistema operativo
 * @author Perceval Andreu
 */
public class Inspeccion {
    
    public static void inspeccion() {
        ProcessBuilder builder;
        //Determinar sistema operativo
        if (System.getProperty("os.name").startsWith("Windows")) {
            //Comando Windows
            builder = new ProcessBuilder("tasklist");
        } else {
            //Comando Linux
            builder = new ProcessBuilder("ps", "aux");
        }
        
        //Ejecutar proceso
        try {
            //Ejecutar proceso
            Process proceso = builder.start();
            //Recibir resultado del proceso
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            int lineas = 0;
            boolean java = false; //Es "java" mencionado?
            //Detener bucle cuando el resultado sea null
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas++;
                //Comprobar si se contiene la palabra "java"
                if (linea.contains("java")) {
                    java = true;
                }
            }
            System.out.println("Lineas: "+lineas);
            System.out.println("¿Java mencionado? "+java);
            
        } catch (IOException ex) {
            System.getLogger(Tarea1PSP.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
