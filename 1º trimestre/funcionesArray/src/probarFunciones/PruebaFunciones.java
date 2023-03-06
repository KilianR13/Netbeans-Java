/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package probarFunciones;

/**
 *
 * @author DAW-B
 */
public class PruebaFunciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[]=funcionesarray.Ejercicio1.crearArrayAleatorio(20, -10, -5);
        for (int i = 0; i < array.length; i++) {
            if (array[i]==-5){
                System.out.print("\""+array[i]+"\"    ");
            } else {
                System.out.print(+array[i]+"    ");
            }
        }
        System.out.println();
        
        int array2[]=funcionesarray.Ejercicio1.cargarArrayTeclado(5, 5, 9);
           
        
        
        
        
    }
    
}
