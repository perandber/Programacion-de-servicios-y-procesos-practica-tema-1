package com.perceval.tarea1psp;

import java.util.Scanner;

/**
 * Tarea 2
 * Leer texto e imprimirlo en mayusculas
 * @author Perceval Andreu
 */
public class LogFilterEngine {
    /** Cantidad de lineas a leer */
    final static int LINEAS = 2;
            
    public static void main(String[] args) {
        String[] lineas = new String[LINEAS];
        //Leer
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < LINEAS; i++) {
            //System.out.println("Linea "+(i+1));
            lineas[i] = scan.nextLine();
        } 
        
        //Convertir a mayuscula
        for (int i = 0; i < LINEAS; i++) {
            lineas[i] = lineas[i].toUpperCase();
        }
        
        //Escribir
        for (int i = 0; i < LINEAS; i++) {
            //Filtrar segun palabras de alerta
            if(lineas[i].contains("WARNING")) {
                System.out.println(lineas[i]);
            }
        }
    }
}
