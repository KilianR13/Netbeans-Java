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
        int a�o;
        a�o = (int) funciones.leerDouble.leerDouble("Introzuca el a�o que quiere comprobar. Se permiten a�os Antes de Cristo.");
        if (a�o%400 == 0) {
            System.out.println("El a�o introducido es bisiesto.");
        } else if (a�o%4 == 0 && a�o%100 != 0) {
            System.out.println("El a�o introducido es bisiesto.");
        } else {
            System.out.println("El a�o introducido no es bisiesto.");
        }
    }
    
}
