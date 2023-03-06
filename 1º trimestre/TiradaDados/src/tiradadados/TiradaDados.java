/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiradadados;

/**
 *
 * @author DAW-B
 */
public class TiradaDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int arrayDado[]=new int[5];
        
        System.out.println(TiradaDados(arrayDado));
    }
    
    public static int TiradaDados(int arrayDado[]){
        
        int devolver;
        int arrayTipoDado[]=new int [6];
        int pareja=0;
        int trio=0;
        int poker=0;
        int repoker=0;
        
        arrayDado[0]=3;
        arrayDado[1]=3;
        arrayDado[2]=1;
        arrayDado[3]=2;
        arrayDado[4]=1;
        
        if (arrayDado.length > 5){
            throw new IllegalArgumentException("El array es de un tamaño menor al permitido");
        }
        
        for (int i = 0; i < arrayDado.length; i++) {
            if (arrayDado[i]<1||arrayDado[i]>6){
                devolver=-1;
                return devolver;
            }
            switch (arrayDado[i]){
                case 1 -> arrayTipoDado[0]++;
                case 2 -> arrayTipoDado[1]++;
                case 3 -> arrayTipoDado[2]++;
                case 4 -> arrayTipoDado[3]++;
                case 5 -> arrayTipoDado[4]++;
                case 6 -> arrayTipoDado[5]++;   
            }
        }
        
        /*
        Este For lo que hace es recorrer el array en el que se guarda la cantidad de números que se introducen 
        desde el array al llamar la función. Si hay un 1, se ignora. Si hay un 2, 3, 4 o 5, se almacenan en integers externos.
        */
        
        for (int i = 0; i < arrayTipoDado.length; i++) {
            switch(arrayTipoDado[i]){
                case 2 -> pareja++;
                case 3 -> trio++;
                case 4 -> poker++;
                case 5 -> repoker++;
            }
        }
        
        if (pareja==1 && trio==0){
            devolver=1;
        } else if (pareja==2){
            devolver=2;
        } else if (trio==1 && pareja==0){
            devolver=3;
        } else if (trio==1 && pareja==1){
            devolver=4;
        } else if (poker==1){
            devolver=5;
        } else if (repoker==1){
            devolver=6;
        } else {
            devolver=0;
        }
        return devolver;
    }
}
