/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Desplazar;

/**
 *
 * @author DAW-B
 */
public class Desplazar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int elementos[]=new int [10];
        int matriz[][]=new int [5][5];
            
        elementos[0]=1;
        elementos[1]=2;
        elementos[2]=3;
        elementos[3]=4;
        elementos[4]=5;
        elementos[5]=6;
        elementos[6]=7;
        elementos[7]=8;
        elementos[8]=9;
        elementos[9]=10;
        
        
        for (int array:elementos){
            System.out.print(array+"    ");
        }
        System.out.println("\n");
        rotarIzquierda(elementos,3);
        System.out.println("\n");
        
        matriz[0][0]=1;
        matriz[0][1]=2;
        matriz[0][2]=3;
        matriz[1][0]=4;
        matriz[1][1]=5;
        matriz[1][2]=6;
        matriz[2][0]=7;
        matriz[2][1]=8;
        matriz[2][2]=9;
        
        desplazarFilas(matriz);
        System.out.println("\n");
        for (int filas[]:matriz){
            for(int columna:filas){
                System.out.print(columna+"  ");
            }
            System.out.println("\n");
        }
        
        
    }
    
    public static void rotarIzquierda(int[] elementos, int n){
        if (n<0 || n>elementos.length){
            throw new IllegalArgumentException("No se pueden mover más datos!");
        }
        int contador=0;
        int provisional[]=new int [n];
        
        for (int i = 0; i < provisional.length; i++) {
            provisional[i]=elementos[i];
        }
        for (int i = n; i < elementos.length; i++) {
            elementos[i-n]=elementos[i];
        }
        
        for (int i = elementos.length-n; i < elementos.length; i++) {
            elementos[i]=provisional[contador];
            contador++;
        }
        for (int array:elementos){
            System.out.print(array+"    ");
        }
    }
    
    public static void desplazarFilas(int[][] matriz){
        int rotar=0;
        int arrayTemporal[]=new int[matriz.length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                arrayTemporal[j]=matriz[i][j];
                
            }
            rotarIzquierda(arrayTemporal,rotar);
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j]=arrayTemporal[j];
            }
            rotar++;
        }
        
        
    }
    
    
}
