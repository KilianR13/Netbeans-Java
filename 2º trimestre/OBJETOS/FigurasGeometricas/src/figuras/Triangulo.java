/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

/**
 *
 * @author DAW-B
 */
public class Triangulo extends Figura {
    double base;
    double altura;
    
    public Triangulo(String c){
        super(c);
        this.base=0;
        this.altura=0;
    }
    
    public Triangulo(double base, double altura, String c){
        super(c);
        this.base=base;
        this.altura=altura;
    }
    
    @Override
    public double area(){
        if(base<=0||altura<=0){
            throw new IllegalArgumentException("Los valores no pueden valer 0");
        }
        return (base * altura)/2;
    }
}
