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
    private String tama�o,tipo;
    private String estado="pedida";
    
    public Pizza(){
        
    }
    
    public boolean comprobarTama�o(){
        if("mediana".equals(tama�o)||"familiar".equals(tama�o)){
            return true;
        } else {
            return false;
        }
    }
    public String getTama�o() {
        if (comprobarTama�o()==true){
            return tama�o;
        } else {
            throw new IllegalArgumentException("Esa pizza no est� en el men�");
        }
    }

    public void setTama�o(String tama�o) {
        this.tama�o = tama�o;
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
    
    
    
    
    
    
    public Pizza(String tipo,String tama�o){
        this.tama�o=tama�o;
        this.tipo=tipo;
    }
    
    
    
}
