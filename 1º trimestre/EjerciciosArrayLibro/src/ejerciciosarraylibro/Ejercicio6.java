/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;

/**
 *
 * @author DAW-B
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrayint []= new int[15];
        int temporal;
        
        for (int i = 0; i < arrayint.length; i++) {
            arrayint[i]=funciones.leerDouble.leerIntError("Introduzca el elemento "+i+" a añadir al array");
        }
        temporal=arrayint[14];
        for (int i = arrayint.length-1; i >= 0; i--) {
            if (i != 0){
                arrayint[i]=arrayint[i-1];
            }
        }
        arrayint[0]=temporal;
        System.out.println("--------------------------------------------------");
        for (int valor:arrayint) {
            System.out.println(+valor);
        }
    }
    
}
