/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafetera;

/**
 *
 * @author DAW-B
 */
public class MainCafetera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        cafetera c1 = new cafetera();
        c1.llenarCafetera();
        System.out.println("La cafetera 1 tiene "+c1.getCantidadActual()+"ml");
        cafetera c2 = new cafetera(250);
        System.out.println("La cafetera 2 puede tener hasta "+c2.getCapacidadMáxima()+"ml, actualmente tiene "+c2.getCantidadActual()+"ml");
        
        System.out.println("Tras servir una taza, se usó "+c2.servirTaza(150)+"ml, la cafetera 2 actualmente tiene "+c2.getCantidadActual()+"ml");
        
        System.out.println("Tras servir otra taza, se usó "+c2.servirTaza(150)+"ml, la cafetera 2 actualmente tiene "+c2.getCantidadActual()+"ml");
        
        cafetera c3 = new cafetera();
        c3.agregarCafe(200);
        System.out.println("La cafetera 3 tiene "+c3.getCantidadActual()+"ml");
        c3.agregarCafe(2000);
        System.out.println("Tras agregarle 2000ml,la cafetera 3 ahora tiene "+c3.getCantidadActual()+"ml");
        
        cafetera c4 = new cafetera(1500,2000);
        System.out.println("La cafetera 4 actualmente tiene "+c4.getCantidadActual()+" ml, con una capacidad máxima de "+c4.getCapacidadMáxima()+"ml.");
        
        
        
        
        
    }
    
}
