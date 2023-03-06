/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;

/**
 *
 * @author DAW-B
 */
public class Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrayRandom[]=new int[20];
        int arrayPar[]=new int[arrayRandom.length];
        int arrayImpar[]=new int [arrayRandom.length];
        int valorpar=0;
        int valorimpar=0;
        int arrayfinal=0;
        
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i]=(int)(Math.random()*101);
        }
        for (int valor:arrayRandom){
            System.out.println(+valor);
        }
        
        System.out.println("--------------------------------------------------"); // Barra separatoria.
        
        // Ahora hay que separar entre pares e impares. Cada array tendrá un tipo de número. Cada array aumenta de valor
        // tras introducir un valor. Es decir, está a 0, introduce el valor 0, y cambia al 1. Así hasta llegar al límite.
        
        for (int i = 0; i < arrayRandom.length; i++) {
            if (arrayRandom[i]%2==0){
                arrayPar[valorpar++]=arrayRandom[i];
            } else {
                arrayImpar[valorimpar++]=arrayRandom[i];
            }
        }
        
        // Primero, introducimos los pares almacenados en el array para los pares. Empezamos desde 0 así que no hay nada especial.
        
        for (int i = 0; i < valorpar; i++) {
            arrayRandom[i]=arrayPar[i];
        }
        
        // Ahora, necesitamos los impares. Aquí debemos comenzar con el límite de hasta donde llegan los pares en el array par. Y los
        // impares comienzan desde 0 así que necesitan un contador distinto.
        
        for (int i = valorpar; i < arrayRandom.length; i++) {
            arrayRandom[i]=arrayImpar[arrayfinal++];
        }
        for (int valor:arrayRandom){
            System.out.println(+valor);
        }
        
    }
}
