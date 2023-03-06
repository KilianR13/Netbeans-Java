/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

/**
 *
 * @author DAW-B
 */
public class PuntoColor extends Punto {
    private String color;
    
    public PuntoColor(){
        this.color="negro";
    }
    public PuntoColor(int x, int y){
        super(x,y);
        this.color="negro";
    }
    
    public PuntoColor(int x, int y, String c){
        super(x,y);
        this.color=c;
    }
    
    public PuntoColor(int v, String c){
        this(v,v,c);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
    @Override
    public String toString(){
        return "El punto "+super.toString()+" es de color "+color;
    }
    public boolean equals(PuntoColor p){
        return this.color.equalsIgnoreCase(p.color);
    }
}
