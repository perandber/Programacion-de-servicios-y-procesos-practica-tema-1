package com.perceval.tarea1psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Tarea 2
 * Ejecutar clase java a traves de processBuilder
 * @author Perceval Andreu
 */
public class ProcessMonitorCLI {
    final static int LINEAS = 2; //Cantidad de lineas a enviar
    static Scanner scan = new Scanner (System.in);
    
    public static void procesoJava() {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "java",
                "-cp",
                "target/classes",
                "com.perceval.tarea1psp.LogFilterEngine"
            );
            Process proceso = builder.start();

            PrintWriter writer = new PrintWriter(proceso.getOutputStream(), true);
            for (int i = 0; i < LINEAS; i++){
                System.out.println("Linea "+(i+1));
                String linea = scan.nextLine();
                writer.println(linea);
            }
            writer.flush();
            writer.close();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String respuesta;
            while ((respuesta = reader.readLine()) != null) {
            //for (int i = 0; i<LINEAS; i++) {
            //    respuesta = reader.readLine();
                System.out.println(respuesta);
            }
            
        }catch (IOException ex) {
            System.getLogger(ProcessMonitorCLI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
