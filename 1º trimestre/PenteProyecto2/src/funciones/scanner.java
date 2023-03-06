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
public class scanner {

    /**
     * @param args the command line arguments
     */
    public static void scanner(String[] args){
    Scanner teclado = new Scanner(System.in);
    }
    
    public static int IntMinMax(String mensaje, String mensajeMinimo, String mensajeMaximo, int minimo, int maximo){
      Scanner teclado = new Scanner(System.in);
      int valor;
      do{
          System.out.println(mensaje);
          valor=teclado.nextInt();
          if (valor<minimo){
              teclado.nextLine();
              System.out.println(mensajeMinimo);
          } else if (valor>maximo) {
              teclado.nextLine();
              System.out.println(mensajeMaximo);
          }
      }while (valor<minimo||valor>maximo);
    return valor;
    }
    public static int IntMinMaxError(String mensaje, int minimo, int maximo){
      Scanner teclado = new Scanner(System.in);
      int valor;
      do{
          System.out.println(mensaje);
          valor=teclado.nextInt();
          if (valor<minimo){
             throw new IllegalArgumentException("El valor introducido es demasiado bajo");
          } else if (valor>maximo) {
              throw new IllegalArgumentException("El valor introducido es demasiado alto");
          }
        } while (valor<minimo||valor>maximo);
    return valor;
    }
    
}
