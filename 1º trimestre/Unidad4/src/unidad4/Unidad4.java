/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unidad4;


/**
 *
 * @author DAW-B
 */
public class Unidad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int elementos = 10;
        int [] arrayEnteros;
        int [] arrayImpares = {1,3,5,7,9};
        
        
        arrayEnteros = new int[elementos];
        
                
        for (int i = 0; i < arrayEnteros.length; i++) {
            arrayEnteros[i]=i*2;
        }
        
        for (int valor:arrayEnteros){
            System.out.println(+valor);
        }
        
        System.out.println("Valor de la posición 0: "+arrayImpares[4]);
        
        
        
    }
    
}
