/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmatrices;

/**
 *
 * @author DAW-B
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrayprincipal[][]= new int[6][10];
        int max=0;
        int min=1000;
        int coordenadaimax=0;
        int coordenadajmax=0;
        int coordenadaimin=0;
        int coordenadajmin=0;
        
        for (int i = 0; i < arrayprincipal.length; i++) {
            for (int j = 0; j < arrayprincipal[0].length; j++) {
                arrayprincipal[i][j]=(int)(Math.random()*1001);
                if (arrayprincipal[i][j]>max){
                    max=arrayprincipal[i][j];
                    coordenadaimax=i;
                    coordenadajmax=j;
                } else if (arrayprincipal[i][j]<min){
                    min=arrayprincipal[i][j];
                    coordenadaimin=i;
                    coordenadajmin=j;
                }
            }
        }
        
        for (int num[]:arrayprincipal){
            for (int valor:num){
                System.out.print(+valor+"   ");
            }
            System.out.println("\n");
        }
        System.out.println();
        System.out.println("El número máximo es "+max+", sus coordenadas son: Fila "+coordenadaimax+", columna "+coordenadajmax);
        System.out.println("El número máximo es "+min+", sus coordenadas son: Fila "+coordenadaimin+", columna "+coordenadajmin);
    }
    
    
}
