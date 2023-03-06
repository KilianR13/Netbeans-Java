/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

/**
 *
 * @author DAW-B
 */
public abstract class Figura {
    private String color;
    
    public Figura(String c){
        this.color=c;
    }
    public String getColor(){
        return this.color;
    }
    /**
     * Calcula y devuelve el área de la figura.
     * @return area
     */
    public abstract double area();
}
