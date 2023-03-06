/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectotiempo;

/**
 *
 * @author deifont
 */
public class ProyectoTiempo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tiempo t1 = new Tiempo(0,30,25);
        Tiempo t2 = new Tiempo(1,0,59);
        
        
        System.out.println("Tiempo 1: "+t1);
        System.out.println("Tiempo 2: "+t2);
        
        t1.suma(1, 0, 59);
         System.out.println("Tiempo sumado: "+t1);
         
        t2.resta(2, 30, 33);
        System.out.println("Tiempo restado: "+t2);
        
    }
    
}
