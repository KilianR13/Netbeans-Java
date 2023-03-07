/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author DAW-B
 */
public class Pelicula extends Media implements valorable{
    private String director;
    private String actorPrincipal;
    private int duracion;
    private Tematica categoria;
    private ArrayList<Integer> votos;
    
    public Pelicula(String nombre, int calificacionEdad, LocalDate fechaIncorporacion, boolean estaDisponible, String director, String actorPrincipal, int duracion, Tematica categoria) {
        super(nombre, calificacionEdad, fechaIncorporacion, estaDisponible);
        if(duracion<60){
            throw new IllegalArgumentException("La duración de la película no puede ser menor de 60 minutos");
        }
        this.director=director;
        this.actorPrincipal=actorPrincipal;
        this.duracion=duracion;
        this.categoria=categoria;
    }
    
    public Pelicula(Pelicula p){
        this(p.getNombre(),p.getCalificacionEdad(),p.getFechaIncorporacionAlCatalogo(),p.isEstaDisponible(),p.director,p.actorPrincipal,p.duracion,p.categoria);
    }

    public String getDirector() {
        return director;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public int getDuracion() {
        return duracion;
    }

    public Tematica getCategoria() {
        return categoria;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public void setDuracion(int duracion) {
        if(duracion>60){
            this.duracion = duracion;
        }
    }

    public void setCategoria(Tematica categoria) {
        this.categoria = categoria;
    }
    
    public boolean votar(int voto){
        boolean devolver = false;
        if(voto<=10 && voto>=0){
            votos.add(voto);
            devolver=true;
        }
        return devolver;
    }
    
    @Override
    public String toString(){
        return "Director:"+director+", Actor principal:"+actorPrincipal+", Duración:"+duracion+", Categoría:"+categoria;
    }

    @Override
    public int calcularPuntuacion() {
        int votostotal=0;
        for (int i = 0; i < votos.size(); i++) {
            votostotal=votostotal+votos.get(i);
        }
        return votostotal/votos.size();
    }
    
    private enum Tematica{
        COMEDIA,DRAMA,TERROR,SUSPENSE,CIENCIA_FICCION,FANTASIA
    }
    
}
