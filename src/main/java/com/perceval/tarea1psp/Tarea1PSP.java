package com.perceval.tarea1psp;

import static com.perceval.tarea1psp.EscritorLogs.sistemaLog;
import static com.perceval.tarea1psp.Inspeccion.inspeccion;
import static com.perceval.tarea1psp.ProcessMonitorCLI.procesoJava;
import static com.perceval.tarea1psp.TestVelocidad.testPing;
import java.io.File;

/**
 * Uso de ProcessBuilder para la ejecucion de sub procesos
 * @author Perceval Andreu
 */
public class Tarea1PSP {

    public static void main(String[] args) {
        //Tarea1
        inspeccion();
        //Tarea2
        procesoJava();
        //Tarea3
        File log = new File("reporte_sistema.log");
        sistemaLog(log);
        //Tarea4
        testPing();
    }
    
}
