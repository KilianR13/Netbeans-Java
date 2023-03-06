/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_condicionales;

/**
 *
 * @author DAW-B
 */
public class Saludo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
    byte hora;
    
    hora = (byte) funciones1.Intento1.leerDouble("¿Qué hora es?", -1);
    
        switch (hora){
            case 6,7,8,9,10,11,12 ->{
                System.out.println("¡Buenos días!");
            }
            case 13,14,15,16,17,18,19,20 ->{
                System.out.println("¡Buenas tardes!");
            }
            case 0,1,2,3,4,5,21,22,23 ->{
                System.out.println("¡Buenas noches!");
            }
            default ->{
                System.out.println("La hora introducida no es válida.");
            }
        }
    
    }
    
}
