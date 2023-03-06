/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sumapar, sumaimpar, N, suma;
        System.out.println("Este programa comprobará un rango de números, y "
                + "sumará todos los números pares por un lado, y los impares por otro.");
        N = (int) funciones.leerDouble.leerDoublemin("Introduzca el número más alto a comprobar. Debe de ser mayor que 1.", 0);
        sumapar = 0;
        sumaimpar = 0;
        for (suma = 1; suma <= N; suma++) {
            if (suma%2 == 0) {
                sumapar = sumapar + suma;
            } else {
                sumaimpar = sumaimpar + suma;
            }
        }
        System.out.println("La suma de todos los números pares es de "+sumapar+".");
        System.out.println("La suma de todos los números impares es de "+sumaimpar+".");
    }
    
}
