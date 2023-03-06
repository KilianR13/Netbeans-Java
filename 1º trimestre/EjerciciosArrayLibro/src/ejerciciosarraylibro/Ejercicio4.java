/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;


/**
 *
 * @author DAW-B
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero[]=new int[20];
        int cuadrado[]=new int[20];
        int cubo[]=new int[20];
        
        for (int i = 0; i < numero.length; i++) {
            numero[i] = (int) (Math.random()*100+1);
            cuadrado[i] = numero[i] * numero[i];
            cubo[i] = numero[i] * numero[i] * numero[i];
        }
        for (int i = 0; i < numero.length; i++) {
            System.out.println(+numero[i]+"     "+cuadrado[i]+"     "+cubo[i]);
        
        }
    }
}
