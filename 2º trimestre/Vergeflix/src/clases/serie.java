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
public class Serie extends Media implements valorable{
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
    
    public boolean añadirTemporada(LocalDate fechaEstreno){
        boolean devolver=false;
        Temporada nuevaTemporada = new Temporada(fechaEstreno);
        if(temporadas.indexOf(fechaEstreno.getDayOfMonth())!=-1){ //esto no funciona, seguro
            devolver=true;
            temporadas.add(nuevaTemporada);
        }
        return devolver;
    }
    
    public boolean añadirTemporada(Temporada temporada){
        boolean devolver=false;
        Temporada nuevatemporada=new Temporada(temporada.getFechaEstreno());
        if(temporadas.indexOf(nuevatemporada.getFechaEstreno().getDayOfMonth())!=-1){
            devolver=true;
            temporadas.add(nuevatemporada);
        }
        return devolver;
    }
    
    public boolean eliminarTemporada(int n){
       boolean devolver=false;
       if(temporadas.contains(temporadas.get(n))){
           temporadas.remove(temporadas.get(n));
           devolver=true;
       }
       return devolver;
    }
    
    public boolean añadirCapitulo (int nTemporada, Capitulo capitulo){
        boolean devolver=false;
        Capitulo cap1 = new Capitulo(capitulo);
        if(temporadas.contains(temporadas.get(nTemporada)) && !temporadas.contains(temporadas.get(nTemporada))){ //esto no busca si el capítulo ya existe.
            temporadas.get(nTemporada).añadirCapitulo(cap1);
            devolver=true;
        }
        return devolver;
    }
    
    public boolean añadirCapitulo (int nTemporada, LocalDate fechaEmision, String titulo){
        boolean devolver=false;
        Capitulo cap1 = new Capitulo(titulo,fechaEmision);
        if(temporadas.contains(temporadas.get(nTemporada)) && !temporadas.contains(temporadas.get(nTemporada))){ //esto no busca si el capítulo ya existe.
            temporadas.get(nTemporada).añadirCapitulo(cap1);
            devolver=true;
        }
        return devolver;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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

    @Override
    public int calcularPuntuacion() {
        int totalpuntuacion=0;
        for (int i = 0; i < temporadas.size(); i++) {
            totalpuntuacion=totalpuntuacion+temporadas.get(i).calcularPuntuacion();
        }
        return totalpuntuacion/temporadas.size();
    }
}
