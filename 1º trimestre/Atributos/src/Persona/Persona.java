/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

/**
 *
 * @author DAW-B
 */
public class Persona {
    private String nombre;
    private byte edad;
    private double estatura;
    
    public Persona(){
        
    }
    public Persona(String nombre, byte edad, double estatura){
        setNombre(nombre);
        setEdad(edad);
        setEstatura(estatura);
        
    }
    public Persona(Persona p){
        p.nombre=nombre;
        p.edad=edad;
        p.estatura=estatura;
    }
    
    public void setNombre(String nombre){
        if (this.length()>0){   
            this.nombre=nombre;
        } else {
            throw new IllegalArgumentException("Nombre inválido");
        }
    }    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setEdad(byte edad){
        if (edad>0){
            this.edad=edad;
        } else {
            throw new IllegalArgumentException("Edad inválida");
        }
    }
    public byte getEdad(){
        return this.edad;
    }
    
    public void setEstatura(double estatura){
        if (estatura>0){
            this.estatura=estatura;
        } else {
            throw new IllegalArgumentException("Estatura inválida");
        }
    }
    public double getEstatura(){
        return this.estatura;
    }
    public int length(){
        return length();
    }
}
