/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import funciones.funciones;
import static funciones.funciones.CASILLA_VACIA;
import static funciones.funciones.FICHA_CIRCULO;
import static funciones.funciones.FICHA_EQUIS;

/**
 *
 * @author DAW-B
 */
public class PenteProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Da comienzo el juego!");
        
        int dimensiones=funciones.IntMinMax("Por favor, introduzca las dimensiones que desea del tablero. "
                + "Recuerde: Será un cuadrado, mínimo 10x10 y máximo 19x19.", "¡El tablero no puede"
                        + " ser tan pequeño!", "¡El tablero no puede ser tan grande!", 10, 19);
        
        int fichasganar=funciones.IntMinMax("Ahora, introduzca el número de fichas necesario para ganar. 5 mínimo, 10 máximo.", 
                "El valor introducido es demasiado bajo.", "El valor introducido es demasiado alto.", 
                5, 10);
        
        String Jugador1=funciones.playername("Introduzca el nombre del primer jugador:");
        String Jugador2=funciones.playername("Introduzca el nombre del segundo jugador:");
        
        int tablero[][]=new int [dimensiones][dimensiones];
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j]=0;
            }
        }
        funciones.mostrarTablero(tablero);
        
        int ficha;
        int jugada=0;
        int fila;
        int columna;
        String JugadorActivo;
        
        do {
            if (jugada%2==0){
                ficha=FICHA_CIRCULO;
                JugadorActivo=Jugador1;
            } else {
                ficha=FICHA_EQUIS;
                JugadorActivo=Jugador2;
            }
            fila=funciones.IntMinMax(JugadorActivo+", introduzca la fila en la que desea añadir su ficha", "La fila introducida no existe", 
                "La fila introducida no existe", 0, tablero.length-1);
            columna=funciones.IntMinMax("Ahora, introduzca la columna en la que desea añadir su ficha", "La columna introducida no existe", 
                "La columna introducida no existe", 0, tablero.length-1);
            if (funciones.colocarFicha(tablero, ficha, fila, columna)==true){
                funciones.colocarFicha(tablero, ficha, fila, columna);
                funciones.mostrarTablero(tablero, fila, columna);
                jugada++;
            } else {
                System.out.println("Esa casilla ya está ocupada. Vuelva a intentarlo.");
            }
        } while (funciones.casillasLibres(tablero)==true);
    }
}