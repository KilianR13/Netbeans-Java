/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_secuenciales;


/**
 *
 * @author DAW-B
 */
public class Operaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    double valor1, valor2, suma, resta, multi, divi;
    
        System.out.println("Bienvenido al programa para calcular.");
        
        valor1 = funciones1.Intento1.leerDouble("Introduzca el primer valor", 0);
        valor2 = funciones1.Intento1.leerDouble("Introduzca el primer valor", 0);
        
        suma = valor1 + valor2;
        resta = valor1 - valor2;
        multi = valor1 * valor2;
        divi = valor1 / valor2;
        
        System.out.println("Suma="+suma);
        System.out.println("Resta="+resta);
        System.out.println("Multiplicación="+multi);
        System.out.println("División="+divi);
               
    }
    
}
