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
public class minmax {

    /**
     * @param mensaje
     * @param minimo
     * @param maximo
     * @return 
     */
    public static double leerDouble(String mensaje, double minimo, double maximo) {
    Scanner teclado = new Scanner(System.in);
    double Valor;
    
    do {
        System.out.println(mensaje);
        while (!teclado.hasNextDouble()) {
            teclado.nextLine();
            System.out.println("El valor introducido no es válido");
        }
        Valor = teclado.nextDouble();
        if (Valor <= minimo) {
        System.out.println("El rango introducido es menor al permitido");
        }
        if (Valor >= maximo) {
            System.out.println("El rango permitido es mayor al permitido");
        }
    } while (Valor <= minimo || Valor >= maximo);
    
    return Valor;
    }
}
