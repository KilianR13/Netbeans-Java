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
public class Temporada {
    private LocalDate fechaEstreno;
    private ArrayList<Capitulo> capitulos;
    
    public Temporada(LocalDate fechaEstreno){
        this.fechaEstreno=fechaEstreno;
        this.capitulos = new ArrayList<>(); //Puede que esto esté mal. Hace falta probar de forma extensa.
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }
    
    public boolean añadirCapitulo(Capitulo capitulo){
        Capitulo c1=new Capitulo(capitulo);
        if(capitulos.contains(c1) || c1.getFechaEmision().isBefore(this.fechaEstreno)){
            return false;
        } else {
            capitulos.add(c1);
            return true;
        }
    }
    
    public boolean añadirCapitulo(LocalDate fechaEmision, String Titulo){
        Capitulo c1 = new Capitulo(Titulo,fechaEmision);
        if(capitulos.contains(c1) || c1.getFechaEmision().isBefore(this.fechaEstreno)){
            return false;
        } else {
            capitulos.add(c1);
            return true;
        }
    }
    
    public boolean añadirCapitulo(int posicion, Capitulo capitulo){
        Capitulo c1=new Capitulo(capitulo);
        if(capitulos.contains(c1) || c1.getFechaEmision().isBefore(this.fechaEstreno) || capitulos.size() < posicion){ 
            return false;
        } else {
            capitulos.add(posicion, c1);
            return true;
        }
    }
    
    public boolean añadirCapitulo(int posicion, LocalDate fechaEmision, String titulo){
        Capitulo c1 = new Capitulo(titulo,fechaEmision);
        if(capitulos.contains(c1) || c1.getFechaEmision().isBefore(this.fechaEstreno) || capitulos.size() < posicion ){ 
            return false;
        } else {
            capitulos.add(posicion, c1);
            return true;
        }
    }
    
    public boolean eliminarCapitulo(String Titulo){
        return capitulos.remove(capitulos.get(capitulos.indexOf(Titulo))); //Esto va a petar seguro. No puede ser tan facil.
    }
    
    public int eliminarCapitulos(String expresionRegular){
        return 1;//ejemplo
    }
    
    public Capitulo getCapitulo(int posicion){
        Capitulo c1 = new Capitulo(capitulos.get(posicion));
        return c1;
    }
    
    /*
    Esto probablemente explotará por algún lado.
    Es necesario comprobar que funciona correctamente.
    */
    public boolean setCapitulo(int posicion, LocalDate fechaEmision, String Titulo){
        if(capitulos.contains(capitulos.get(posicion))){
            capitulos.get(posicion).setFechaEmision(fechaEmision);
            capitulos.get(posicion).setTitulo(Titulo);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean setCapitulo(int posicion, LocalDate fechaEmision){
        if(capitulos.contains(capitulos.get(posicion))){
            capitulos.get(posicion).setFechaEmision(fechaEmision);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean setCapitulo(int posicion, String Titulo){
        if(capitulos.contains(capitulos.get(posicion))){
            capitulos.get(posicion).setTitulo(Titulo);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean meGusta(int posicionCapitulo, boolean like){
        if(capitulos.contains(capitulos.get(posicionCapitulo))){
            capitulos.get(posicionCapitulo).meGusta(like);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean meGusta(String titulo, boolean like){
        return true;//ejemplo
    }
    
    public boolean setFechaEstreno(LocalDate fecha){
        if(capitulos.contains(capitulos.get(capitulos.indexOf(fecha)))){
            this.fechaEstreno=fecha;
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
    
    
    
    @Override
    public String toString(){
        return "Fecha de estreno de la temporada: "+fechaEstreno;
    }
}
