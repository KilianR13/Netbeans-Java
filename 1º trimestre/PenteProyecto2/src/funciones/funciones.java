/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funciones;

import java.util.Scanner;
/**
 *
 * @author DAW-B
 */
public class funciones {
public static final int CASILLA_VACIA=0;
public static final int FICHA_CIRCULO=1;
public static final int FICHA_EQUIS=2;
    /**
     * @param mensaje
     * @param mensajeMinimo
     * @param mensajeMaximo
     * @param minimo
     * @param maximo
     * @return 
     */
    public static int IntMinMax(String mensaje, String mensajeMinimo, String mensajeMaximo, int minimo, int maximo){
      Scanner teclado = new Scanner(System.in);
      int valor;
      do{
          System.out.println(mensaje);
          valor=teclado.nextInt();
          if (valor<minimo){
              teclado.nextLine();
              System.out.println(mensajeMinimo);
          } else if (valor>maximo) {
              teclado.nextLine();
              System.out.println(mensajeMaximo);
          }
      }while (valor<minimo||valor>maximo);
    return valor;
    }
    public static int IntMinMaxError(String mensaje, int minimo, int maximo){
      Scanner teclado = new Scanner(System.in);
      int valor;
      do{
          System.out.println(mensaje);
          valor=teclado.nextInt();
          if (valor<minimo){
             throw new IllegalArgumentException("El valor introducido es demasiado bajo");
          } else if (valor>maximo) {
              throw new IllegalArgumentException("El valor introducido es demasiado alto");
          }
        } while (valor<minimo||valor>maximo);
    return valor;
    }
    
    
    /*
    Playername existe para leer los caracteres introducidos por teclado para asignar los nombres de los jugadores.
    */
    public static String playername(String mensaje){
        Scanner teclado = new Scanner(System.in);
        String nombre;
            System.out.println(mensaje);
            nombre=teclado.nextLine();
        return nombre;
    }
    
    /*
    MostrarTablero existe para mostrar por pantalla la conversión de los números del array de 
    una forma comprensiva para el usuario. Cambia 0's, 1's y 2's por símbolos y espacios en blanco. Solo tiene el uso de mostrar
    cómo se ve el tablero al iniciar la partida. 
    */ 
    public static void mostrarTablero(int [][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                switch (tablero[i][j]){
                    case CASILLA_VACIA -> System.out.print("| |  "); //Espacio vacío.
                    case FICHA_CIRCULO -> System.out.print("|O|  "); //Ficha del jugador 1.
                    case FICHA_EQUIS -> System.out.print("|X|  "); //Ficha del jugador 2.
                }  
            }
            System.out.println("\n");    
        }
    }
    
    
    /*
    Este MostrarTablero marca con un paréntesis la última ficha colocada. Esta versión de MostrarTablero
    es la predeterminada para usar tras poner fichas.
    */
    public static void mostrarTablero(int [][] tablero, int fila, int columna){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i==fila && j==columna){
                    switch (tablero[i][j]){
                        case CASILLA_VACIA -> System.out.print("| |  "); //Espacio vacío.
                        case FICHA_CIRCULO -> System.out.print("|\033(O)|  "); //Ficha del jugador 1.
                        case FICHA_EQUIS -> System.out.print("|(X)|  "); //Ficha del jugador 2.  
                    }
                } else {
                    switch (tablero[i][j]){
                        case CASILLA_VACIA -> System.out.print("| |  "); //Espacio vacío.
                        case FICHA_CIRCULO -> System.out.print("|O|  "); //Ficha del jugador 1.
                        case FICHA_EQUIS -> System.out.print("|X|  "); //Ficha del jugador 2.           
                    }  
                }
            }
            System.out.println("\n"); 
        }
    }
    
    
    /*
    ColocarFicha comprueba si la casilla indicada está vacía. Si lo está, aplica el valor "ficha" y devuelve True. 
    Si no, devuelve False.
    */
    public static boolean colocarFicha(int [][] tablero, int ficha, int fila, int columna){
        if (tablero[fila][columna]==CASILLA_VACIA){
            tablero[fila][columna]=ficha;
            return true;
        } 
        return false;
    }
            
    
    public static int capturarFichas(int [][] tablero, int fila, int columna){
        
    return 0;
        
    }
    public static boolean comprobarLinea(int [][] tablero, int fila, int columna){
        
    return false;
        
    }
    
    /*
    CasillasLibres recorre todo el tablero en busca de una casilla vacía. Si la encuentra, devuelve True.
    En caso de no encontrar ninguna casilla vacía, devuelve False.
    */
    public static boolean casillasLibres(int [][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j]==CASILLA_VACIA){
                    return true;
                }                
            }   
        }
        return false;
    }
    
}
