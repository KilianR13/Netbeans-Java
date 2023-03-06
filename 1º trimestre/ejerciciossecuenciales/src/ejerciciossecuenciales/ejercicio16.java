/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double minutos, precio;
        int centimos, euros, segundos;
        segundos = (int) funciones.leerDouble.leerDoublemin("Introduzca la duración en segundos de la llamada.", 0);
        minutos = segundos / 60;
        if (minutos <= 3) {
            precio = minutos * 15;
        } else {
            precio = (15*3) + (minutos-3) * 7;
        }
        centimos = (int) (precio%100);
        euros = (int) precio/100;
        
        System.out.println("El precio de una llamada de "+segundos+" segundos es de "+euros+" euros con "+centimos+" céntimos.");
                
    }
    
}
