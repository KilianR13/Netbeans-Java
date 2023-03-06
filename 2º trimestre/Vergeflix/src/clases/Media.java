/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DAW-B
 */
public abstract class Media {
    private String nombre;
    private int calificacionEdad;
    private LocalDate fechaIncorporacionAlCatalogo;
    private boolean estaDisponible;
    
    public Media(String nombre, int calificacionEdad, LocalDate fechaIncorporacion, boolean estaDisponible){
        if(!verificarNombre(nombre)){
           throw new IllegalArgumentException("El nombre contiene carácteres inválidos."); 
        }
        if(calificacionEdad>18||calificacionEdad<0){
            throw new IllegalArgumentException("La calificación de edad está fuera de los límites permitidos.");
        }
        this.nombre=nombre;
        this.calificacionEdad=calificacionEdad;
        this.fechaIncorporacionAlCatalogo=fechaIncorporacion;
        this.estaDisponible=estaDisponible;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!verificarNombre(nombre)){
           throw new IllegalArgumentException("El nombre contiene carácteres inválidos."); 
        }
        this.nombre = nombre;
    }

    public int getCalificacionEdad() {
        return calificacionEdad;
    }

    public void setCalificacionEdad(int calificacionEdad) {
        if(calificacionEdad>18||calificacionEdad<0){
            throw new IllegalArgumentException("La calificación de edad está fuera de los límites permitidos.");
        }
        this.calificacionEdad = calificacionEdad;
    }

    public LocalDate getFechaIncorporacionAlCatalogo() {
        return fechaIncorporacionAlCatalogo;
    }

    public void setFechaIncorporacionAlCatalogo(LocalDate fechaIncorporacionAlCatalogo) {
        this.fechaIncorporacionAlCatalogo = fechaIncorporacionAlCatalogo;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }
    
    
    @Override
    public String toString(){
        return "Nombre: "+nombre+", PGI: "+calificacionEdad+", Fecha de incorporación: "+fechaIncorporacionAlCatalogo+" Disponibilidad: "+estaDisponible+".";
    }
    
    public boolean equals(Media c){
        return this.nombre.equals(c.nombre) && this.calificacionEdad==c.calificacionEdad;
    }
    /*
    public int compareTo(String c){
        
    }
    */
    private boolean verificarNombre(String nombre){
        Pattern patronNombre = Pattern.compile("(([\\D\\d]\\s?){0,})");
        Matcher verificarNombre = patronNombre.matcher(nombre);
        return verificarNombre.matches();
    }
    
}
