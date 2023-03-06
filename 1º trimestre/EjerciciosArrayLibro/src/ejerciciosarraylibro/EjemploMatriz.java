/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;

/**
 *
 * @author DAW-B
 */
public class EjemploMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int array[][]=new int[5][5];
        // --> Se rellena el array con valores
        for(int i=0;i<array.length;++i){
            for(int j=0;j<array[0].length;++j){
                array[i][j]=i+j;
            }
        }
        // Se recorre por filas
        for(int []num:array){
            for(int elemento:num){
                System.out.print(elemento+" ");
            }
            System.out.println("\n");
        }
        System.out.println("--------------------------------------------------");
        int miarray[][]= new int[6][6];
        int suma=0;
        
        for (int i = 0; i < miarray.length; i++) {
            for (int j = 0; j < miarray.length; j++) {
                miarray[i][j]=suma++;
            }
        }
        for (int []valor:miarray){
            for (int numero:valor){
                System.out.print(+numero+"    ");
            }
            System.out.println("\n");
        }
        
    }
    
}
