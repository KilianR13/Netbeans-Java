/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funciones1;

/**
 *
 * @author DAW-B
 */
import java.util.Scanner;


public class leerteclado1 {

    public static double leerDouble(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        while (!teclado.hasNextDouble()) {
            teclado.nextLine();
            System.out.println("No se ha introducido un double. Vuelve a introducir el valor ");
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
                System.out.println("No se ha introducido un double. Vuelve a introducir el valor ");
            }
            valor = teclado.nextDouble();
            if (valor <= minimo) {
                System.out.println("El valor no tiene el rango adecuado.");
            }

        } while (valor <= minimo);

        return valor;
    }
    

}
