/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafetera;

/**
 *
 * @author DAW-B
 */
public class cafetera {
    private int capacidadM�xima;
    private int cantidadActual;
    
    
    public cafetera(){
        this.capacidadM�xima=1000;
        this.cantidadActual=0;
    }
    public cafetera(int capacidadM�xima){
        this.capacidadM�xima=capacidadM�xima;
        this.cantidadActual=capacidadM�xima;
    }
    public cafetera(int capacidadM�xima, int cantidadActual){
        if(cantidadmaxima(capacidadM�xima)){
            this.capacidadM�xima=cantidadActual;
            this.cantidadActual=cantidadActual;
        } else {
            this.capacidadM�xima=capacidadM�xima;
            this.cantidadActual=cantidadActual;
        }
    }

    public int getCapacidadM�xima() {
        return capacidadM�xima;
    }

    public void setCapacidadM�xima(int capacidadM�xima) {
        this.capacidadM�xima = capacidadM�xima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    
    public int llenarCafetera(){
        return this.cantidadActual=this.capacidadM�xima;
    }
    public int servirTaza(int cantidad){
        int taza;
        if (this.cantidadActual<cantidad){
            taza=this.cantidadActual;
            this.cantidadActual=0;
        } else {
            taza=cantidad;
            this.cantidadActual=this.cantidadActual-cantidad;
        }
        return taza;
    }
    public int vaciarCafetera(){
        return this.cantidadActual=0;
    }
    public int agregarCafe(int cantidad){
        this.cantidadActual=this.cantidadActual+cantidad;
        if(!cantidadmaxima(capacidadM�xima)){
            return this.cantidadActual=this.capacidadM�xima;
        } else {
        return this.cantidadActual;
        }
    }
    
    
    private boolean cantidadmaxima(int capacidadM�xima){
        return cantidadActual<capacidadM�xima;
    }
}
