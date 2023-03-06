/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPizza;

/**
 *
 * @author DAW-B
 */
public class Pizza {
    private static int TotalPedidas;
    private static int TotalServidas;
    private String tamaño,tipo;
    private String estado="pedida";
    
    public Pizza(){
        
    }
    
    public boolean comprobarTamaño(){
        if("mediana".equals(tamaño)||"familiar".equals(tamaño)){
            return true;
        } else {
            return false;
        }
    }
    public String getTamaño() {
        if (comprobarTamaño()==true){
            return tamaño;
        } else {
            throw new IllegalArgumentException("Esa pizza no está en el menú");
        }
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void sirve(){
        if (this.estado.equals("servida")){
            System.out.println("lorem ipsum");
        } 
    }
    
    
    
    
    
    
    public Pizza(String tipo,String tamaño){
        this.tamaño=tamaño;
        this.tipo=tipo;
    }
    
    
    
}
