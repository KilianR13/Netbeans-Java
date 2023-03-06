/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero, suma5, cantidadpar, productonegativo;
        suma5 = 0;
        cantidadpar = 0;
        productonegativo = 0;
        System.out.println("Dado un rango entre -50 y +50...");
        for (numero = -50; numero < 50; numero++) {
            if (numero%5 == 0) {
                suma5 = suma5 + numero;
            }
            if (numero%2 == 0) {
                cantidadpar = cantidadpar + 1;
            }
            if (numero < 0 && productonegativo != 0) {
                productonegativo = productonegativo * numero;
            } else if (numero < 0) {
                productonegativo = numero;
            }
            
        }
        System.out.println("La suma de todos los múltiplos de 5 en el rango es de "+suma5+".");
        System.out.println("La cantidad de números pares encontrados en el rango es de "+cantidadpar+".");
        System.out.println("El producto de todos los números negativos del rango es de "+productonegativo+".");
    }
    
}
