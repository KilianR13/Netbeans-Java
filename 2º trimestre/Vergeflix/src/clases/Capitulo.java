/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;

/**
 *
 * @author DAW-B
 */
public class Capitulo {
    private int votosPositivos;
    private int votosNegativos;
    private String titulo;
    private LocalDate fechaEmision;
    
    public Capitulo(String titulo, LocalDate fechaEmision){
        this.titulo=titulo;
        this.fechaEmision=fechaEmision;
    }
    
    public Capitulo(Capitulo c){
        this(c.titulo,c.fechaEmision);
    }

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public int getVotosNegativos() {
        return votosNegativos;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    public void meGusta(boolean like){
        if(like==true){
            votosPositivos++;
        } else {
            votosNegativos++;
        }
    }
    
    
    
    
    
    @Override
    public String toString(){
        return "Nombre del capítulo:"+titulo+", Fecha de emisión:"+fechaEmision+".\nVotos positivos:"+votosPositivos+", Votos negativos:"+votosNegativos;
    }
}
