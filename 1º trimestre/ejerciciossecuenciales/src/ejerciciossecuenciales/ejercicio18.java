/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

/**
 *
 * @author DAW-B
 */
public class ejercicio18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a�os, meses, semanas, dias;
        dias = (int) funciones.leerDouble.leerDoublemin("Introduzca la cantidad de d�as.", 0);
        a�os = dias/365;
        dias = dias - (a�os * 365);
        
        meses = dias / 30;
        dias = dias - (meses * 30);
        
        semanas = dias / 7;
        dias = dias - (semanas * 7);
        
        System.out.println("La cantidad introducida equivale a "+a�os+" a�os sin contar bisiestos, "+meses+" meses est�ndares de 30 d�as, "+semanas+" semanas, y "+dias+" d�as.");
        
        
    }
    
}
