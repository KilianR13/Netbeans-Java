/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_secuenciales;

/**
 *
 * @author DAW-B
 */
public class Examenmedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    double exam1, exam2, media;
        
    exam1 = funciones1.Intento1.leerDouble("¿Qué nota obtuvo en el primer exámen?", 0);
    
    media = funciones1.Intento1.leerDouble("¿Cuál es la media?", 0);
            
    exam2 = (media - (exam1 * 0.4))/6;
    System.out.println("La nota del segundo examen fue de "+exam2);
    }
    
}
