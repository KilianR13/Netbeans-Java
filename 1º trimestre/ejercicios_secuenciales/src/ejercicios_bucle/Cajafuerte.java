/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_bucle;

/**
 *
 * @author DAW-B
 */
public class Cajafuerte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    short solucion, respuesta, intento;
    boolean open;
    
    solucion=8136;
    open=false;
    intento=0;   
    while (!open && 4>intento){
        intento=(short) (intento+1);
        System.out.println("Este es su "+intento+"º intento.");
        respuesta = (short) funciones1.Intento1.leerDouble("Introduzca el número de 4 dígitos que quiere probar.", 0);
        if (respuesta!=solucion) {
            System.out.println("Lo siento, esa combinación no es correcta.");
        } else {
            System.out.println("¡Felicidades! La caja se ha abierto.");
            open=true;
        }
        
    }
    }
    
}
