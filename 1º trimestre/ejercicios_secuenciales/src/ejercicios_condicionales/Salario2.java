/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_condicionales;

/**
 *
 * @author DAW-B
 */
public class Salario2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
    byte horas;
    short salario;
    
    horas = (byte) funciones1.Intento1.leerDouble("Introduzca las horas trabajadas.", 0);
    
    if (40<horas){
        salario=(short) ((horas-40)*16+40*12);
    } else {
        salario=(short) (horas*12);
    }
        System.out.println("El salario es de "+salario+" euros.");
    }
    
}
