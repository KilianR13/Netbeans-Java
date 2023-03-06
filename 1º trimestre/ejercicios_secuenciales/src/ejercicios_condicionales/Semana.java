/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_condicionales;

/**
 *
 * @author DAW-B
 */
public class Semana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    byte dia;
    
    dia = (byte) funciones1.Intento1.leerDouble("Introduce el número del día de la semana.", 0);
        
        
        switch (dia){
            case 1 ->{
                System.out.println("Ese día tenemos matemáticas.");
            }
            case 2 ->{
                System.out.println("Ese día tenemos programación.");
            }
            case 3 ->{
                System.out.println("Ese día tenemos base de datos.");
            }
            case 4 ->{
                System.out.println("Ese día tenemos lengua.");
            }
            case 5 ->{
                System.out.println("Ese día tenemos tutoría.");
            }
            default ->{
                System.out.println("Ese día no tenemos clase / Día incorrecto.");
            }
        }
        
    }
    
}
