/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author DAW-B
 */
public class Serie extends Media {
    private LocalDate fechaEstreno;
    private ArrayList<Temporada> temporadas;
            
    public Serie(String nombre, int calificacionEdad, LocalDate fechaIncorporacion, LocalDate fechaEstreno, boolean estaDisponible) {
        super(nombre, calificacionEdad, fechaIncorporacion, estaDisponible);
        this.fechaEstreno=fechaEstreno;
        this.temporadas=new ArrayList<>();
    }
    
    public Serie(Serie s){
        this(s.getNombre(),s.getCalificacionEdad(),s.getFechaIncorporacionAlCatalogo(),s.fechaEstreno, s.isEstaDisponible());
        this.temporadas=s.temporadas;
    }
    
    public LocalDate getFechaEstreno(){
        return fechaEstreno;
    }
    /*
    public boolean añadirTemporada(LocalDate fechaEstreno){
        Temporada nuevaTemporada = new Temporada(fechaEstreno);
        //if(!temporadas.contains(temporadas.get(0))){
           //!temporadas.contains(temporadas.indexOf(nuevaTemporada.getFechaEstreno().getDayOfMonth())) 
        //}
    }
    */
    
    
    
    
    
    
    
    
    public Temporada getCopiaTemporada(int nTemporada){
        if(temporadas.size()>=nTemporada && nTemporada>=0){
            Temporada devolver = new Temporada(temporadas.get(nTemporada).getFechaEstreno());
            return devolver;
        } else {
            return null;
        }
    }
    
    @Override
    public String toString(){
        return "Fecha de estreno: "+fechaEstreno;
    }
}
