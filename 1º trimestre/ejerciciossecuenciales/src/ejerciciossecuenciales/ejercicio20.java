/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double N,divisor;
        boolean primo;
        N = funciones.leerDouble.leerDoublemin("Introduzca el número a comprobar.", 1);
        primo = true;
        for (divisor = 1; divisor < N && primo == true; divisor++) {
            if (N%divisor != 0){
                primo = true;
            } else if (N%divisor == 0) {
                primo = false;
            }
        }
        if (primo == true) {
            System.out.println("El número es primo");
        } else if (primo == false) {
            System.out.println("El número no es primo");
        }
    }
    
}
