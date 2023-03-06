/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;

/**
 *
 * @author DAW-B
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeros[]= new int[8];
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = funciones.leerDouble.leerIntError("Introduzca el número "+i);
        }
        System.out.println("----------------------------------------");
        for (int valor:numeros){
            if (valor%2==0) {
                System.out.println(+valor+"     par");
            } else {
                System.out.println(+valor+"     impar");
            }
        }
    }
    
}
