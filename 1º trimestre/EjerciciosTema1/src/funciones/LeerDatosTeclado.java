
package funciones;

import java.util.Scanner;

public class LeerDatosTeclado {
    
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
