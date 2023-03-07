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
public class Temporada implements valorable {
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
        boolean devolver = false;
        Capitulo c1=new Capitulo(capitulo);
        if(!capitulos.contains(c1) && c1.getFechaEmision().isAfter(this.fechaEstreno)){
            devolver=true;
        }
        return devolver;
    }
    
    public boolean añadirCapitulo(LocalDate fechaEmision, String Titulo){
        boolean devolver = false;
        Capitulo c1 = new Capitulo(Titulo,fechaEmision);
        if(!capitulos.contains(c1) && c1.getFechaEmision().isAfter(this.fechaEstreno)){
            devolver=true;
        }
        return devolver;
    }
    
    public boolean añadirCapitulo(int posicion, Capitulo capitulo){
        boolean devolver = false;
        Capitulo c1=new Capitulo(capitulo);
        if(!capitulos.contains(c1) && c1.getFechaEmision().isAfter(this.fechaEstreno) && capitulos.size() >= posicion){ 
            devolver=true;
        }
        return devolver;
    }
    
    public boolean añadirCapitulo(int posicion, LocalDate fechaEmision, String titulo){
        boolean devolver = false;
        Capitulo c1 = new Capitulo(titulo,fechaEmision);
        if(!capitulos.contains(c1) && c1.getFechaEmision().isAfter(this.fechaEstreno) && capitulos.size() >= posicion ){ 
            devolver=true;
        }
        return devolver;
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
        boolean devolver = false;
        if(capitulos.contains(capitulos.get(posicion))){
            capitulos.get(posicion).setFechaEmision(fechaEmision);
            capitulos.get(posicion).setTitulo(Titulo);
            devolver=true;
        }
        return devolver;
    }
    
    public boolean setCapitulo(int posicion, LocalDate fechaEmision){
        boolean devolver = false;
        if(capitulos.contains(capitulos.get(posicion))){
            capitulos.get(posicion).setFechaEmision(fechaEmision);
            devolver=true;
        }
        return devolver;
    }
    
    public boolean setCapitulo(int posicion, String Titulo){
        boolean devolver = false;
        if(capitulos.contains(capitulos.get(posicion))){
            capitulos.get(posicion).setTitulo(Titulo);
            devolver=true;
        }
        return devolver;
    }
    
    public boolean meGusta(int posicionCapitulo, boolean like){
        boolean devolver = false;
        if(capitulos.contains(capitulos.get(posicionCapitulo))){
            capitulos.get(posicionCapitulo).meGusta(like);
            devolver=true;
        }
        return devolver;
    }
    
    public boolean meGusta(String titulo, boolean like){
        boolean devolver = false;
        if(capitulos.contains(capitulos.get(capitulos.indexOf(titulo)))){
            capitulos.get(capitulos.indexOf(titulo)).meGusta(like);
            devolver = true;
        }        
        return devolver;
    }
    
    public boolean setFechaEstreno(LocalDate fecha){
        boolean devolver = false;
        if(capitulos.contains(capitulos.get(capitulos.indexOf(fecha)))){
            this.fechaEstreno=fecha;
            devolver=true;
        }
        return devolver;
    }
    /*
    public ArrayList<Capitulo> capitulosMejorValorados(int n){ //hora de llorar.
        ArrayList<Capitulo> devolver;
        for (int i = 0; i <= n; i++) {
            
            devolver.add(capitulos.get(n).getVotosNegativos());
            
        }
        
        
        
        
        return devolver;
    }
    */
    
    
    
    
    
    
    @Override
    public String toString(){
        return "Fecha de estreno de la temporada: "+fechaEstreno;
    }

    @Override
    public int calcularPuntuacion() {
        int totalpuntuacion=0;
        for (int i = 0; i < capitulos.size(); i++) {
            totalpuntuacion=totalpuntuacion+capitulos.get(i).calcularPuntuacion();
        }
        return totalpuntuacion/capitulos.size();
    }
}
