/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int año;
        año = (int) funciones.leerDouble.leerDouble("Introzuca el año que quiere comprobar. Se permiten años Antes de Cristo.");
        if (año%400 == 0) {
            System.out.println("El año introducido es bisiesto.");
        } else if (año%4 == 0 && año%100 != 0) {
            System.out.println("El año introducido es bisiesto.");
        } else {
            System.out.println("El año introducido no es bisiesto.");
        }
    }
    
}
