/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;

/**
 *
 * @author DAW-B
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrayElementos[] = new int[10];
        int valor;
        
        for (int i=0; i<arrayElementos.length;i++) {
            valor = funciones.leerDouble.leerInt("Introduzca el valor "+i);
            arrayElementos[i] = valor;
        }
        for (int i=arrayElementos.length-1; i>=0; i--) {
            System.out.println(+arrayElementos[i]);
        }
    }
    
}
