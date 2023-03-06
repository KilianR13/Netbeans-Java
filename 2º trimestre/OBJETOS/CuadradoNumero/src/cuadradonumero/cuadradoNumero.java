/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuadradonumero;

import java.util.Scanner; 

/**
 *
 * @author DAW-B
 */
public class cuadradoNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int valor;
        int respuesta;
        do{
            valor=teclado.nextInt();
            if(valor!=0){
                respuesta=cuadradoSumando(valor);
                System.out.println("El cuadrado es "+respuesta);
            }
        }while (valor!=0);
        
    }
    
    public static int cuadradoSumando(int n){
        int suma=0;
        int contador=0;
        do{
            if(contador%2!=0){
                suma=suma+contador;
                n--;
            }
            contador++;
        }while(n>0);
        return suma;
    }
    
}
