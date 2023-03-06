/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rectangulo;

/**
 *
 * @author DAW-B
 */

public class Rectangulo{
    private int alto,ancho;
    public void setAlto(int alto){
        if (alto>0){
            this.alto=alto;
        }            
    }
    public int getAlto(){
        return this.alto;
    }
    public void setAncho(int ancho){
        if (ancho>0){
            this.ancho=ancho;
        }
    }
    public int getAncho(){
        return this.ancho;
    }
}

