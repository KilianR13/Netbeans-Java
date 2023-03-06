/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmatrices;

/**
 *
 * @author DAW-B
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][]num=new int[3][6];
        
        num[0][0]=0;
        num[0][1]=30;
        num[0][2]=2;
        num[0][5]=5;
        num[1][0]=75;
        num[1][4]=0;
        num[2][2]=-2;
        num[2][3]=9;
        num[2][4]=11;
        
        for (int []valor:num){
            for (int numero:valor) {
                System.out.print(+numero+"  ");
            }
        System.out.println("\n");    
        }
    }
}
