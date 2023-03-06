/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionTarjetasCredito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase centrada en almacenar los m�todos y constructores de tipo Movimiento.
 * @author Kilian Vidal Barranco
 */
public class Movimiento {
    private double cantidad;
    private String concepto; //maximo 50 car�cteres
    private String fecha;
    /**
     * Constructor de un nuevo Movimiento. A cada movimiento le asigna una fecha.
     * @param cantidad - Cantidad establecida en el movimiento.
     * @param concepto - Texto introducido en cada movimiento.
     * @exception IllegalArgumentException - En caso de que la cantidad introducida para el movimiento sea negativa.
     * @exception IllegalArgumentException - En caso de que el concepto introducido tenga m�s de 50 car�cteres.
     */
    public Movimiento(double cantidad, String concepto){
        if(!comprobarCantidad(cantidad)){
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        } if (!comprobarConcepto(concepto)){
            throw new IllegalArgumentException("El concepto no puede tener m�s de 50 car�cteres.");
        }
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fechaDTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.cantidad=cantidad;
        this.concepto=concepto;
        this.fecha=date.format(fechaDTF);
    }
    
    /**
     * Constructor copia de la clase Movimiento.
     * @param m - Un movimiento ya existente.
     */
    public Movimiento(Movimiento m){
        this(m.getCantidad(),m.getConcepto());
        this.fecha=m.fecha;
    }
    
    /**
     * Devuelve la cantidad establecida en el Movimiento.
     * @return cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Devuelve el concepto establecido en el Movimiento.
     * @return concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Establece un nuevo concepto. Si no es v�lido, no lo establecer�.
     * @param concepto - El nuevo concepto a introducir por el usuario.
     */
    public void setConcepto(String concepto) {
        if(comprobarConcepto(concepto)){
            this.concepto = concepto;
        }
    }

    /**
     * Devuelve la fecha guardada dentro del Movimiento.
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * M�todo privado que comprueba si la cantidad a guardar en el movimiento es mayor o igual a 0.
     * @param cantidad - Cantidad a asignar al Movimiento.
     * @return boolean - Devolver� True si la cantidad es mayor o igual a 0.
     */
    private boolean comprobarCantidad(double cantidad){
        return cantidad>=0;
    }
    /**
     * M�todo privado que comprueba si el m�todo a establecer en el Movimiento es v�lido y tiene la longitud permitida.
     * @param concepto - Concepto a establecer.
     * @return boolean - Devolver� True si el concepto es v�lido y tiene la longitud permitida.
     */
    private boolean comprobarConcepto(String concepto){
        Pattern patronConcepto = Pattern.compile("([\\D\\d]\\s?){0,50}");
        Matcher verificarConcepto = patronConcepto.matcher(concepto);
        return verificarConcepto.matches();
    }
    
    /**
     * Devuelve una cadena que incluye la cantidad del movimiento, el concepto y la fecha en la que fue realizado.
     * @return String 
     */
    @Override
    public String toString(){
        return "Saldo: "+cantidad+", Concepto: "+concepto+", Fecha: "+fecha;
    }
    /**
     * Devuelve verdadero o falso dependiendo si ambos Movimientos tienen todos los par�metros iguales o no.
     * @param m - Un Movimiento ya existente.
     * @return boolean - Ser� True si los tres par�metros son iguales.
     */
    public boolean equals(Movimiento m){
        return this.cantidad==m.cantidad && this.concepto.equals(m.concepto) && this.fecha.equals(m.fecha);
    }
    
}
