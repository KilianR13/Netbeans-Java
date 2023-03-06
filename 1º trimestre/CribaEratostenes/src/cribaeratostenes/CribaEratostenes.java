/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cribaeratostenes;

/**
 *
 * @author DAW-B
 */
public class CribaEratostenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int array=10;
        
        cribaEratostenes(array);
        
        
    }
    
    
    public static boolean[] cribaEratostenes(int n){
        
        boolean arrayEratostenes[]=new boolean[n];
        
        arrayEratostenes[0]=false;
        arrayEratostenes[1]=false;
        
        
        for (int i = 2; i < arrayEratostenes.length; i++) {
            int divisor=1;
            int multiplicador=i;
            boolean primo=true;
            while (i>divisor || primo!=false){
                if (i/divisor!=0){
                    
                    divisor++;
                } else if (i/divisor==0 && i!=divisor){
                    primo=false;
                    
                }
            }
            if (primo==true){
                arrayEratostenes[i]=true;
            }
        }
        
        for (boolean valor:arrayEratostenes){
            System.out.println(valor);
        }
        
        return arrayEratostenes;
        
        
        
    }
    
}
