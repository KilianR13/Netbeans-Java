/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int precio, distancia;
        distancia = (int) funciones.leerDouble.leerDoublemin("Introduzca la cantidad recorrida por el cliente en kilómetros.", 0);
        if (distancia <= 300) {
            precio = 500;
        } else if (distancia > 300 && distancia < 1000) {
            precio = 500 + 2 * (distancia-300);
        } else {
            precio = 500 + (distancia - 300);
        }
        System.out.println("El precio a pagar del cliente es de "+precio+" euros.");
    }
    
}
