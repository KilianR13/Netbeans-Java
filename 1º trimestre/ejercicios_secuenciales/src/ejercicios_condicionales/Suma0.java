/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_condicionales;


/**
 *
 * @author DAW-B
 */
public class Suma0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    double num1, num2, suma;
    
    num1 = funciones1.Intento1.leerDouble("Introduzca el primer n�mero", 0);
    num2 = funciones1.Intento1.leerDouble("Introduzca el segundo n�mero", 0);
    
    suma = num1 + num2;
        if (suma>0){
            System.out.println("La suma es mayor que 0.");
        } else {
            System.out.println("La suma no es mayor que 0.");
        }
        
    }
    
}
