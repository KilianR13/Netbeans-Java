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
    // comprendido entre un valor m�nimo y uno m�ximo. El valor m�nimo y el m�ximo est�n
    // incluidos en el intervalo. Si el m�nimo es un n�mero negativo, se tendr� en cuenta de forma especial
        
    public static int [] crearArrayAleatorio(int n, int minimo, int maximo){
        int array[]= new int[n];
        
        if (minimo<0){
            minimo=minimo-1;
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=(int)(Math.random()*((maximo+1)-minimo)+minimo);
        }
        
        if (minimo>maximo){
            throw new IllegalArgumentException("Error, el m�nimo es mayor que el m�ximo.");
        }
        
        return array;
    }
    
    // Crea un array con una longitud N, y el usuario introduce por teclado los valores que desea introducir en el array.
    // De por s�, el usuario no puede introducir caracteres que no sean n�meros, 
    // ya que el propio .nextInt() tiene su propia excepci�n. 
    // Hacer una nueva excepci�n si el usuario introduce un car�cter es redundante, y jam�s se llega a leer.
        
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
    
    // Crea un array con una longitud N. Es lo mismo que el anterior pero con un m�nimo y m�ximo.
    
    public static int[] cargarArrayTeclado(int n, int minimo, int maximo){
        int array[]= new int[n];
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduzca el valor "+i);
            array[i]=teclado.nextInt();
            if (array[i]>maximo){
                throw new IllegalArgumentException("Error, el n�mero introducido es mayor al m�ximo permitido");
            } else if (array[i]<minimo){
                throw new IllegalArgumentException("Error, el n�mero introducido es menor al m�nimo permitido");
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
