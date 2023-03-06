/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funcionesarray;

import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class Ejercicio1 {

    /**
     * @param n
     * @return 
     */
    
    // Crea un array con una longitud N, y cada valor del array contiene un valor Integer aleatorio
        
    public static int [] crearArrayAleatorio(int n){
        int array[]=new int [n];
        for (int i = 0; i < array.length; i++) {
            array[i]=(int)(Math.random()*0);
        }
        return array;
    }
    
    // Crea un array con una longitud N, y cada valor del array contiene un valor Integer aleatorio, 
    // comprendido entre un valor mínimo y uno máximo. El valor mínimo y el máximo están
    // incluidos en el intervalo. Si el mínimo es un número negativo, se tendrá en cuenta de forma especial
        
    public static int [] crearArrayAleatorio(int n, int minimo, int maximo){
        int array[]= new int[n];
        
        if (minimo<0){
            minimo=minimo-1;
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=(int)(Math.random()*((maximo+1)-minimo)+minimo);
        }
        
        if (minimo>maximo){
            throw new IllegalArgumentException("Error, el mínimo es mayor que el máximo.");
        }
        
        return array;
    }
    
    // Crea un array con una longitud N, y el usuario introduce por teclado los valores que desea introducir en el array.
    // De por sí, el usuario no puede introducir caracteres que no sean números, 
    // ya que el propio .nextInt() tiene su propia excepción. 
    // Hacer una nueva excepción si el usuario introduce un carácter es redundante, y jamás se llega a leer.
        
    public static int[] cargarArrayTeclado(int n){
        int array[]= new int[n];
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduzca el valor "+i);
            array[i]=teclado.nextInt();
        }
        
        System.out.println("\nEl array introducido es:\n");
        for(int valor:array){
            System.out.print(+valor+"   ");
        }
        
        return array;
    }
    
    // Crea un array con una longitud N. Es lo mismo que el anterior pero con un mínimo y máximo.
    
    public static int[] cargarArrayTeclado(int n, int minimo, int maximo){
        int array[]= new int[n];
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduzca el valor "+i);
            array[i]=teclado.nextInt();
            if (array[i]>maximo){
                throw new IllegalArgumentException("Error, el número introducido es mayor al máximo permitido");
            } else if (array[i]<minimo){
                throw new IllegalArgumentException("Error, el número introducido es menor al mínimo permitido");
            }
        }
        
        System.out.println("\nEl array introducido es:\n");
        for(int valor:array){
            System.out.print(+valor+"   ");
        }
        
        return array;
    }
    public static void mostrarArrayPantalla(int []array){
        for (int valor:array){
            System.out.print(+valor+"   ");
        }
    }
    
    
}
