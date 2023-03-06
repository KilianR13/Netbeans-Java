/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funciones1;

import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class Intento1 {

    
    public static double leerDouble(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        while (!teclado.hasNextDouble()) {
            teclado.nextLine();
            System.out.println("El dato introducido no es válido");
        }
        double valor = teclado.nextDouble();
        return valor;
    }
    public static double leerDouble(String mensaje, double minimo) {
        Scanner teclado = new Scanner(System.in);
        double valor;
        
        do {
            
            System.out.println(mensaje);
            while (!teclado.hasNextDouble()) {
                teclado.nextLine();
                System.out.println("El valor introducido no es válido");
            }
            valor = teclado.nextDouble();
            if (valor <= minimo) {
                System.out.println("El rango introducido no está permitido");
            }
            
        } while (valor <= minimo);
        
        return valor;
    }
}
