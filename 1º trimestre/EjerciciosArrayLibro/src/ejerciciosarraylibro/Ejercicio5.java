/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;


/**
 *
 * @author DAW-B
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int lista[]=new int[10];
        int max;
        int min;
        
        max=0;
        lista[1]=funciones.leerDouble.leerInt("Introduce el número 0");
        min = lista[1];
        
        
        for (int i = 1; i < lista.length; i++) {
            lista[i]=funciones.leerDouble.leerInt("Introduce el número "+i);
            
            if (max < lista[i]) {
                max = lista[i];
            } 
            if (min > lista[i]){
                min = lista[i];
            }
        }
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < lista.length; i++) {
            if (lista[i]==max){
                System.out.println(+lista[i]+"  máximo");
            } else if (lista[i]==min){
                System.out.println(+lista[i]+"  mínimo");
            } else {
                System.out.println(+lista[i]);
            }
        }
    }
}
    

