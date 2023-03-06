/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_condicionales;

/**
 *
 * @author DAW-B
 */
public class Medianoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    byte hora, min, hresp, minresp, medianoche, medmin;
    
    hora = (byte) funciones1.minmax.leerDouble("Introduzca las horas.", -1, 24);
    min = (byte) funciones1.minmax.leerDouble("Introduzca los minutos.", -1, 60);
    
    
    medianoche=23;
    medmin=60;
    
    if (min == 0) {
        medianoche = 24;
        medmin = 0;
    }
    hresp = (byte) (medianoche - hora);
    minresp = (byte) (medmin - min);
    
        System.out.println("Faltan "+hresp+" horas y "+minresp+" minutos hasta medianoche.");
    
    }
 
    
}
