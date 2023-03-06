/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjunto;

/**
 *
 * @author DAW-B
 */
public class ConjuntoOrdenadoEnteros {
    private int[]conjunto=new int[100];
    private int elementos=0;
    
    public ConjuntoOrdenadoEnteros(){
        this.conjunto=conjunto;
        this.elementos=elementos;
    }
    public ConjuntoOrdenadoEnteros(int capacidad){
        this.conjunto=new int[capacidad];
        this.elementos=elementos;
    }
    public ConjuntoOrdenadoEnteros(ConjuntoOrdenadoEnteros c){
        this.conjunto=c.conjunto;
        this.elementos=c.elementos;
    }
    public void add(int valor){
        boolean duplicado=false;
        for (int i = 0; i < conjunto.length; i++) {
            if(conjunto[i]==valor){
                duplicado=true;
            }
        }
        if(duplicado==false){
        for (int i = 0; i < conjunto.length; i++) {
            if(conjunto[i]>valor&&conjunto[i]!=0){
                for (int j = conjunto.length-1; j >= i; j--) {
                    if(conjunto[j]!=0 && conjunto[j+1]<=conjunto.length){
                        conjunto[j+1]=conjunto[j];
                    }
                }
                conjunto[i]=valor;
                i=conjunto.length-1;
            } else if(conjunto[i]==0){
                conjunto[i]=valor;
                i=conjunto.length-1;
            }
        }   
        this.elementos++;
        }
    }
        
    public void add(ConjuntoOrdenadoEnteros c){
        
    }
    public int search(int valor){
        int valorDevolver=-1;
        for (int i = 0; i < conjunto.length; i++) {
            if(conjunto[i]==valor){
                valorDevolver=i;
            }
        }
        return valorDevolver;
    }
    public int del(int posicion){
        if(posicion>elementos){
            throw new IllegalArgumentException("En la posición solicitada no existe ningún valor");
        }
        int valorArrayDevolver=conjunto[posicion];
        for (int i = posicion; i < conjunto.length; i++) {
            if(i+1<conjunto.length){
                conjunto[i]=conjunto[i+1];
            }else{
                conjunto[i]=0;
            }
        }
        
        
        return valorArrayDevolver;
    }
}

