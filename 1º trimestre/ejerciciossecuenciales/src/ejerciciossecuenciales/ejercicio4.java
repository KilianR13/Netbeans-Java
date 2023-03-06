/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N, resultado;
        System.out.println("Bienvenido al programa para calcular la suma de los X primeros números.");
        N = (int) funciones.leerDouble.leerDoublemin("Introduzca un número menor que 0", 0);
        resultado = N*(N+1)/2;
        System.out.println("El resultado de la suma es de "+resultado);
    }
    
}
