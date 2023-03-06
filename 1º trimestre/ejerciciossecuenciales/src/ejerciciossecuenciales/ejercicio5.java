/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N, multiplicador, respuesta;
        System.out.println("Este programa le mostrará los múltiplos de 3 que desee.");    
        N = (int) funciones.leerDouble.leerDoublemin("Introduzca la cantidad de múltiplos que desea ver:", 0);
        for (multiplicador = 1; multiplicador <= N; multiplicador++) {
            respuesta = multiplicador * 3;
            System.out.println(+respuesta);
        }
    }
    
}
