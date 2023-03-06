/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package submatriz;

import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class Submatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamañoMatriz=leerInt("Introduzca el tamaño de la matriz a generar:");
        int[][]matriz=new int[tamañoMatriz][tamañoMatriz];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=(int)(Math.random()*10);
            }
        }
        int filaInicial=leerInt("Seleccione la fila inicial:");
        int filaFinal=leerInt("Seleccione la fila final:");
        int columnaInicial=leerInt("Seleccione la columna inicial:");
        int columnaFinal=leerInt("Seleccione la columna final:");
        int[][]submatriz=submatriz(matriz,filaInicial,columnaInicial,filaFinal,columnaFinal);
        
        System.out.println("\n");
        for(int[] primer:submatriz){
            for(int valor:primer){
                System.out.print(valor+"   ");
            }
            System.out.println("\n");
        }
        
        
    }
    public static int[][] submatriz(int[][]matriz,int filaInicial, int colInicial, int filaFinal, int colFinal){
        if(filaInicial<0||colInicial<0||filaFinal>matriz[colFinal].length||colFinal>matriz.length){
            throw new IllegalArgumentException("Uno de los valores está fuera del límite de la matriz");
        }
        int filaSubmatriz=filaFinal-filaInicial+1;
        int colSubmatriz=colFinal-colInicial+1;
        if(filaSubmatriz<2||colSubmatriz<2){
            throw new IllegalArgumentException("La submatriz a crear es demasiado pequeña.");
        }
        int[][]Submatriz=new int[filaSubmatriz][colSubmatriz];
        for (int i = filaInicial, filaMatriz=0; i <= filaFinal; i++, filaMatriz++) {
            for (int j = colInicial, colMatriz=0; j <= colFinal; j++, colMatriz++) {
               Submatriz[filaMatriz][colMatriz]=matriz[i][j];
            }
        }
        return Submatriz;
    }
    private static int leerInt(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println(mensaje);
        int valor=teclado.nextInt();
        return valor;
    }
}
