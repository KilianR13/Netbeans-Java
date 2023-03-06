/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funciones;

import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class leerDouble {

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
    public static double leerDoublemin(String mensaje, double minimo) {
        Scanner teclado = new Scanner(System.in);
        double valor;
        
        do {
            
            System.out.println(mensaje);
            while (!teclado.hasNextDouble()) {
                teclado.nextLine();
                throw new IllegalArgumentException("Error, dato erróneo");
            }
            valor = teclado.nextDouble();
            if (valor <= minimo) {
                throw new IllegalArgumentException("El valor introducido es demasiado bajo");
            }
            
        } while (valor <= minimo);
        
        return valor;
    }
    public static double leerDoubleminmax(String mensaje, double minimo, double maximo) {
        Scanner teclado = new Scanner(System.in);
        double valor;
        
        do {
            
            System.out.println(mensaje);
            while (!teclado.hasNextDouble()) {
                teclado.nextLine();
                throw new IllegalArgumentException("Error, dato erróneo");
            }
            valor = teclado.nextDouble();
            if (valor <= minimo) {
                throw new IllegalArgumentException("El valor introducido es demasiado bajo");
            }
            if (valor >= maximo) {
                throw new IllegalArgumentException("El valor introducido es demasiado alto");
            }
            
        } while (valor <= minimo || valor >= maximo);
        
        return valor;
    }
}
    

