/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuras;

/**
 *
 * @author DAW-B
 */
public class PuntoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto p1 = new Punto(2,2);
        PuntoColor pcol1 = new PuntoColor();
        PuntoColor pcol2 = new PuntoColor(5,"rojo");
        System.out.println(pcol1);
        System.out.println(pcol2);
        PuntoColor punto3 = new PuntoColor(4,6);
        System.out.println(punto3);
    }
    
}
