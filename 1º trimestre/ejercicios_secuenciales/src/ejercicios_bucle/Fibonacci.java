/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_bucle;

/**
 *
 * @author DAW-B
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    short fib0, fib1, fibN;
    byte respuesta;
    
    respuesta = (byte) funciones1.Intento1.leerDouble("Introduzca cuántos números de la serie de Fibonacci quiere ver.", -1);
    
    fib0 = 0;
    fib1 = 1;
    
    if (0 == respuesta) {
                System.out.println(+fib0);
    } else if (respuesta == 1) {
                System.out.println(+fib1);
    } else {
        System.out.println(+fib0);
        System.out.println(+fib1);
        for (byte cont = 0; cont < (respuesta-2);cont++) {
        fibN = (short) (fib0+fib1);
        System.out.println(+fibN);
        fib0 = fib1;
        fib1 = fibN;
        }
    }
    }
            
}
    

