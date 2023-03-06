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
                        case FICHA_CIRCULO -> System.out.print("|(O)|  "); //Ficha del jugador 1.
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
        for (int i = columna; i < tablero[fila].length; i++) {
           if (tablero[fila][columna]==tablero[fila][columna+3] && tablero[fila][columna+1]==tablero[fila][columna+2]){
               System.out.println("Probando");
           } 
        }
        int fichascomidas=0;
        
        
        
        if (columna+3 <= tablero.length){
            if (tablero[fila][columna]==tablero[fila][columna+3] && tablero[fila][columna+1]==tablero[fila][columna+2]){
                tablero[fila][columna+1]=CASILLA_VACIA;
                tablero[fila][columna+2]=CASILLA_VACIA;
                fichascomidas=2;
            }  
        }
        if (columna-3 >= 0){
            if (tablero[fila][columna]==tablero[fila][columna-3] && tablero[fila][columna-1]==tablero[fila][columna-2]){
                tablero[fila][columna-1]=CASILLA_VACIA;
                tablero[fila][columna-2]=CASILLA_VACIA;
                System.out.println("Se han comido fichas!");
                
            }  
        }
    return fichascomidas;
        
    }
    
    
    /*
    ComprobarLinea toma la posición de la última ficha colocada, tanto la fila como la columna, y comprueba en todas 
    las direcciones posibles si existe una alineación de 5 fichas del mismo tipo. Si la encuentra, devuelve True, 
    finalizando el juego a favor del usuario que tiene 5 fichas seguidas. Si no, devuelve False, y el juego continúa.
    */
    public static boolean comprobarLinea(int [][] tablero, int fila, int columna){
        /*
        Comprueba las columnas a la derecha.
        */
        
        if (columna+5 <= tablero.length){
            if (tablero[fila][columna]==tablero[fila][columna+1] && tablero[fila][columna]==tablero[fila][columna+2] &&
                tablero[fila][columna]==tablero[fila][columna+3] && tablero[fila][columna]==tablero[fila][columna+4]){
                return true;
            }
        } 
        
        /*
        Comprueba las columnas a la izquierda.
        */
        
        if (columna-4 >= 0){
            if (tablero[fila][columna]==tablero[fila][columna-1] && tablero[fila][columna]==tablero[fila][columna-2] &&
                tablero[fila][columna]==tablero[fila][columna-3] && tablero[fila][columna]==tablero[fila][columna-4]){
                    return true;
            }
        }
        
        /*
        Comprueba las filas que se encuentran bajo la última ficha colocada.
        */
        
        if (fila+5 <= tablero.length){
           if (tablero[fila][columna]==tablero[fila+1][columna] && tablero[fila][columna]==tablero[fila+2][columna] &&
                tablero[fila][columna]==tablero[fila+3][columna]&& tablero[fila][columna]==tablero[fila+4][columna]){
                    return true;
            }
        }
        
        /*
        Comprueba las filas que se encuentran encima de la última ficha colocada.
        */
        
        if (fila-4 >= 0){
           if (tablero[fila][columna]==tablero[fila-1][columna] && tablero[fila][columna]==tablero[fila-2][columna] &&
                tablero[fila][columna]==tablero[fila-3][columna]&& tablero[fila][columna]==tablero[fila-4][columna]){
                    return true;
                
            } 
        }
        
        /*
        Comprueba diagonalmente hacia abajo a la derecha.
        */
        
        if (fila+5 <= tablero.length && columna+5 <= tablero.length){
            if (tablero[fila][columna]==tablero[fila+1][columna+1] && tablero[fila][columna]==tablero[fila+2][columna+2] &&
                tablero[fila][columna]==tablero[fila+3][columna+3]&& tablero[fila][columna]==tablero[fila+4][columna+4]){
                return true;
                
            }
        }
        
        /*
        Comprueba diagonalmente hacia arriba a la derecha.
        */
        
        if (fila-4 >= 0 && columna+5 <= tablero.length){
            if (tablero[fila][columna]==tablero[fila-1][columna+1] && tablero[fila][columna]==tablero[fila-2][columna+2] &&
                tablero[fila][columna]==tablero[fila-3][columna+3]&& tablero[fila][columna]==tablero[fila-4][columna+4]){
                return true;
                
            }
        }
        
        /*
        Comprueba diagonalmente hacia arriba a la izquierda.
        */
        
        if (fila-4 >= 0 && columna-4 >= 0){
            if (tablero[fila][columna]==tablero[fila-1][columna-1] && tablero[fila][columna]==tablero[fila-2][columna-2] &&
                tablero[fila][columna]==tablero[fila-3][columna-3]&& tablero[fila][columna]==tablero[fila-4][columna-4]){
                return true;
            }
        }    
        
        /*
        Comprueba diagonalmente hacia abajo a la izquierda
        */
        
        if (fila+5 <= tablero.length && columna-4 >= 0){
            if (tablero[fila][columna]==tablero[fila+1][columna-1] && tablero[fila][columna]==tablero[fila+2][columna-2] &&
                tablero[fila][columna]==tablero[fila+3][columna-3]&& tablero[fila][columna]==tablero[fila+4][columna-4]){
                return true;
            }
        }    
        return false;    
    }        
        
    /*
    CasillasLibres recorre todo el tablero en busca de una casilla vacía. Si la encuentra, devuelve True.
    En caso de no encontrar ninguna casilla vacía, devuelve False, lo cual finaliza el juego.
    */
    public static boolean casillasLibres(int [][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j]==CASILLA_VACIA){
                    return true;
                }                
            }   
        }
        System.out.println("¡Empate! No quedan casillas libres.");
        return false;
    }
    
    
    /*
    Esto es usado para poder reiniciar el juego tras haber finalizado. Es experimental. A las muy malas, voy a coger
    y hacer que solo "Si" reinicie el juego. Cualquier otra cosa? A la mierda!
    */
    public static boolean reiniciarJuego(String mensaje){
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        String confirmacion=teclado.next();
        
        do {
        if ("Si".equals(confirmacion)){
            return true;
        } else if ("No".equals(confirmacion)){
            return false;
        } else {
            teclado.nextLine();
            System.out.println("Por favor, introduzca solo \"Si\" o \"No\"");
        }
        } while (!confirmacion.equals("Si")||!confirmacion.equals("No"));
        return false;
    }
}
