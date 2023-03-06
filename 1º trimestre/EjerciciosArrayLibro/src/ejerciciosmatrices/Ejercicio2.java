/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmatrices;

/**
 *
 * @author DAW-B
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][]arraySuma=new int[5][6];
        int sumaLargo;
        int sumaAlto;
        int sumaTotal=0;
        
        for (int i = 0; i < arraySuma.length-1; i++) {
            for (int j = 0; j < arraySuma[0].length-1; j++) {
                arraySuma[i][j]=funciones.leerDouble.leerIntError("Introduzca el elemento "+j+" de la fila "+i);
            }
        }
        for (int i = 0; i < arraySuma.length; i++) {
            sumaLargo=0;
            
            for (int j = 0; j < arraySuma[0].length; j++) {
                sumaLargo=sumaLargo+arraySuma[i][j];
                
            }
            arraySuma[i][arraySuma.length]=sumaLargo;
            sumaTotal=sumaTotal+sumaLargo;
        }
        for (int i = 0; i < arraySuma[0].length-1; i++) {
            sumaAlto=0;
            for (int j = 0; j < arraySuma.length; j++) {
                sumaAlto=sumaAlto+arraySuma[j][i];
            }
            sumaTotal=sumaTotal+sumaAlto;
            arraySuma[4][i]=sumaAlto;
        }
        for (int i = arraySuma.length-1; i == arraySuma.length-1; i++) {
            for (int j = arraySuma[0].length-1; j == arraySuma[0].length-1; j++) {
                arraySuma[i][j]=sumaTotal;
            }
        }
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        
        for (int []valor:arraySuma){
            for (int numero:valor) {
                System.out.print("|"+numero+"|  ");
            }
        System.out.println("\n");    
        }
        
        
        
        
    }
    
}
