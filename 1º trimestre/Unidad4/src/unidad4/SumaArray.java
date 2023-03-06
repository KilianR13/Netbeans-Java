/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unidad4;

/**
 *
 * @author DAW-B
 */
public class SumaArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int suma;
        int elementos = funciones.leerDouble.leerInt("Introduzca el número de valores");
        int [] arrayelementos;
        int valor;
        arrayelementos = new int[elementos];
        
        for (int i=0;i<arrayelementos.length;i++) {
            valor = funciones.leerDouble.leerInt("Introduzca el valor "+i);
            arrayelementos[i] = valor;
        }
        suma = sumarArray(arrayelementos);
    }
    
    public static int sumarArray(int [] vector){
        int suma=0;
        for(int i=0;i<vector.length;i++){
            suma=vector[i] + suma;
        }
        System.out.println("La suma de los valores es de "+suma);
        return suma;
                
    }
}
