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
    private int capacidadMáxima;
    private int cantidadActual;
    
    
    public cafetera(){
        this.capacidadMáxima=1000;
        this.cantidadActual=0;
    }
    public cafetera(int capacidadMáxima){
        this.capacidadMáxima=capacidadMáxima;
        this.cantidadActual=capacidadMáxima;
    }
    public cafetera(int capacidadMáxima, int cantidadActual){
        if(cantidadmaxima(capacidadMáxima)){
            this.capacidadMáxima=cantidadActual;
            this.cantidadActual=cantidadActual;
        } else {
            this.capacidadMáxima=capacidadMáxima;
            this.cantidadActual=cantidadActual;
        }
    }

    public int getCapacidadMáxima() {
        return capacidadMáxima;
    }

    public void setCapacidadMáxima(int capacidadMáxima) {
        this.capacidadMáxima = capacidadMáxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    
    public int llenarCafetera(){
        return this.cantidadActual=this.capacidadMáxima;
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
        if(!cantidadmaxima(capacidadMáxima)){
            return this.cantidadActual=this.capacidadMáxima;
        } else {
        return this.cantidadActual;
        }
    }
    
    
    private boolean cantidadmaxima(int capacidadMáxima){
        return cantidadActual<capacidadMáxima;
    }
}
