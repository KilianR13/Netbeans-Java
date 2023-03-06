/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rectangulo;

/**
 *
 * @author DAW-B
 */
public class MainRectangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo();
        r.setAlto(7);
        r.setAncho(7);
        if (r.getAlto()<=0||r.getAncho()<=0){
            System.out.println("Pero que haces?!");
        } else if (r.getAlto()==r.getAncho()){
            System.out.println("Ole tú, eso es un cuadrado, NO QUERÍAS UN RECTÁNGULO??");
        } else {
        System.out.println(r.getAlto()+"cm de alto x "+r.getAncho()+"cm de ancho");
        }
    }
    
}
