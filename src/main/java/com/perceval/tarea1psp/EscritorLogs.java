package com.perceval.tarea1psp;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Tarea 3
 * Escribir la salida y errores de un proceso de manera directa a un archivo
 * @author Perceval Andreu
 */
public class EscritorLogs {
    
    public static void sistemaLog(File archivo) {
        ProcessBuilder info;
        ProcessBuilder filtro;
        List<ProcessBuilder> procesos;
        //Determinar sistema operativo
        if (System.getProperty("os.name").startsWith("Windows")) {
            //Comandos Windows
            //Obtener informacion
            info = new ProcessBuilder("systeminfo");
            //Filtrar información
            filtro = new ProcessBuilder("findstr", "Memoria");
        } else {
            //Comando Linux
            //Obtener informacion
            info = new ProcessBuilder("free", "-h");
            //Filtrar informacion
            filtro = new ProcessBuilder("grep", "Mem");
        }
        
        procesos = List.of(info, filtro);
        
        try {
            //Crear archivo (Si no existe)
            archivo.createNewFile();           
            
            //Redirigir
            filtro.redirectOutput(ProcessBuilder.Redirect.to(archivo));
            filtro.redirectErrorStream(true);
            
            //Ejecutar procesos
            List<Process> procesos2 = ProcessBuilder.startPipeline(procesos);
            //Process proceso = info.start(); //Version para un solo proceso
            
            //Terminar procesos
            for (Process proceso : procesos2) {
                proceso.waitFor();
            }
            
        } catch (IOException ex) {
            System.getLogger(EscritorLogs.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (InterruptedException ex) {
            System.getLogger(EscritorLogs.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
