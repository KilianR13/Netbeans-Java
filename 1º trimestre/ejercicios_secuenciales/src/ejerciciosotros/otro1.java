/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosotros;

import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class otro1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
    Scanner sc = new Scanner(System.in);
        
    
    String nombre;
    int edad;
            System.out.println("Introduzca su nombre:");
            nombre = sc.next();
            System.out.println("Indique su edad:");
            do{
                while(!sc.hasNextInt())
                sc.next();
                edad = sc.nextInt();
        }while(edad<0);
            System.out.println("Su nombre es "+nombre+" y tiene "+edad+" años");
        

    
        // TODO code application logic here
    }
    
}
