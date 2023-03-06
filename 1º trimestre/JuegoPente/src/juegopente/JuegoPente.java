/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegopente;

import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class JuegoPente { 
public static final int CASILLA_VACIA=0;
public static final int FICHA_CIRCULO=1;
public static final int FICHA_EQUIS=2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        do{
            System.out.println("\n");
        System.out.println("Da comienzo el juego!");
                
        int dimensiones=IntMinMax("Por favor, introduzca las dimensiones que desea del tablero. "
                + "Recuerde: Será un cuadrado, mínimo 10x10 y máximo 19x19.", "¡El tablero no puede"
                        + " ser tan pequeño!", "¡El tablero no puede ser tan grande!", 10, 19);
        
        int fichasganar=IntMinMax("Ahora, introduzca el número de fichas necesario para ganar. 5 mínimo, 10 máximo.", 
                "El valor introducido es demasiado bajo.", "El valor introducido es demasiado alto.", 
                5, 10);
        
        /*
        Aquí el juego pide y almacena el nombre de los jugadores.
        */
        
        System.out.println("\n");
        String Jugador1=playername("Introduzca el nombre del primer jugador:");
        System.out.println("\n");
        String Jugador2=playername("Introduzca el nombre del segundo jugador:");
        System.out.println("\n");
        
        /*
        El juego le pide al jugador números superiores al 0. Es decir,
        EL ARRAY COMIENZA EN 1, NO EN 0. 
        Es de 1 hasta el número elegido por el usuario. Y para evitar errores, inmediatamente después de que el usuario
        introduzca los valores de fila y columna, se le resta uno a ambos. Para el usuario, se verá como la línea que ha elegido, pero las funciones
        recibirán el número anterior al escrito por el usuario. 
        La razón para esto es simplemente para mejorar la experiencia del usuario. Por eso he decidido escribirlo y dejarlo claro en las reglas.
        */
        
        System.out.println("Las reglas establecidas son:\nEl tablero es de "+dimensiones+"x"+dimensiones+", es necesario capturar "+fichasganar+" fichas"
        + " para ganar.\nLas filas y líneas jugables son de 1 hasta "+dimensiones+". Si un usuario consigue poner 5 fíchas en línea en cualquier "
        + "dirección, gana de forma automática.");
        
        /*
        Se crea el tablero con las dimensiones establecidas por el usuario, y procede a llenarse con casillas vacías con bucles. Tras llenarse,
        se muestra por pantalla usando la función mostrarTablero.
        */
        
        int tablero[][]=new int [dimensiones][dimensiones];
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j]=CASILLA_VACIA;
            }
        }
        System.out.println("\n");
        mostrarTablero(tablero);
        System.out.println("\n");
        
        int ficha;
        int fichasJ1=0;
        int fichasJ2=0;
        int jugada=0;
        int fila;
        int columna;
        String JugadorActivo;
        
        /*
        Comienza el bucle del juego. Primero, comprueba una variable llamada "jugada", la cual siempre empezará por 0, haciendo que la ficha a usar sea
        el círculo, y que el string "JugadorActivo" sea el nombre del jugador 1. Esto es para hacer que pueda nombrar al jugador de forma genérica.
        El bucle siempre comienza comprobando el jugador, seguido de pidiéndole a dicho jugador dónde quiere posicionar su ficha.
        */
        
        do {
            if (jugada%2==0){
                ficha=FICHA_CIRCULO;
                JugadorActivo=Jugador1;
            } else {
                ficha=FICHA_EQUIS;
                JugadorActivo=Jugador2;
            }
            fila=IntMinMax("Jugador "+JugadorActivo+", introduzca la fila en la que desea añadir su ficha:", "La fila introducida no existe", 
                "La fila introducida no existe", 1, tablero.length);
            columna=IntMinMax("Ahora, introduzca la columna en la que desea añadir su ficha:", "La columna introducida no existe", 
                "La columna introducida no existe", 1, tablero.length);
            int fichascomidas;
            fila=fila-1;
            columna=columna-1;
            
            /*
            El programa comprueba con un "if" si el usuario ha introducido una casilla vacía. Si está vacía, se coloca la ficha y entra en el bucle if. 
            Si no, entra en un "else if" que informa al usuario que la ficha que ha colocado no es válida. 
            Si no es válida, el bucle comienza desde el principio, pero como no ha cambiado el jugador, sigue siendo turno de dicho jugador.
            Si el jugador pone la ficha, varias funciones comienzan a ser llamadas. Primera, la función para comprobar si el usuario ha comido alguna ficha.
            Tanto si lo ha hecho como si no, el valor que devuelve la función capturarFichas se almacena, y muestra por pantalla la variante de mostrarTablero,
            la cual resalta la última ficha colocada rodeándola con un paréntesis. Y sirve de multifunción ya que también muestra todo el tablero.
            Tras eso, el juego comprueba si hay 5 en línea. Si comprobarLinea devuelve un booleano true, el juego termina.
            Ahora, el juego comprueba el número almacenado en fichascomidas. Si es distinto de 0, pone por pantalla el jugador que ha comido fichas, 
            y dice el número de fichas. Tras eso, compara el valor almacenado en JugadorActivo con Jugador1 y Jugador2.
            Y dependiendo quién sea, suma las fichas a la cuenta de fichas de dicho jugador.
            Finalmente, suma 1 al contador de "jugada", que es el que decide qué jugador está jugando. Y el bucle comienza de nuevo.
            */
            
            if (colocarFicha(tablero, ficha, fila, columna)==true){
                fichascomidas=capturarFichas(tablero, fila, columna);
                System.out.println("\n");
                mostrarTablero(tablero, fila, columna);
                comprobarLinea(tablero, fila, columna);
                if (fichascomidas!=0){
                    System.out.println("El jugador "+JugadorActivo+" ha comido "+fichascomidas+" fichas!");
                    
                    if (JugadorActivo.equals(Jugador1)){
                        fichasJ1=fichasJ1+fichascomidas;
                    } else if (JugadorActivo.equals(Jugador2)){
                        fichasJ2=fichasJ2+fichascomidas;
                    }
                    System.out.println("Fichas capturadas por "+Jugador1+" = "+fichasJ1);
                    System.out.println("Fichas capturadas por "+Jugador2+" = "+fichasJ2);
                }
                jugada++;
                
            } else {
                System.out.println("Esa casilla ya está ocupada. Vuelva a intentarlo.");
            }
            System.out.println("\n");
        
        /*
        El bucle continúa hasta que uno de los valores deje de cumplirse.    
        */
        
        } while (casillasLibres(tablero)==true && comprobarLinea(tablero, fila, columna)!=true 
                && fichasJ1 < fichasganar && fichasJ2 < fichasganar);
        
        /*
        Una vez finalizado el bucle, el programa busca qué ha provocado que el bucle, y por tanto la partida, termine. Si es por culpa del tablero
        estando lleno, el programa dice que es un empate. Si es porque un usuario ha conseguido 5 en línea, llama al usuario y proclama su 5 en línea.
        Y si uno de los dos usuarios ha conseguido más fichas de las introducidas para ganar, el programa comprueba qué jugador lo ha hecho, y con ello,
        llama al nombre específico de dicho jugador y lo nombra ganador.
        */
        
        if (casillasLibres(tablero)==false){
            System.out.println("¡Empate! No quedan más casillas disponibles en el tablero.");
        }
        if (comprobarLinea(tablero, fila, columna)==true){
            System.out.println("¡El jugador "+JugadorActivo+" gana! ¡Ha conseguido poner 5 fichas en línea!");
        }
        if (fichasJ1>=fichasganar){
            System.out.println("¡El jugador "+Jugador1+" gana! Ha conseguido capturar "+fichasJ1+" fichas.");
        } else if (fichasJ2>=fichasganar){
            System.out.println("¡El jugador "+Jugador2+" gana! Ha conseguido capturar "+fichasJ2+" fichas.");
        }
        
        /*
        El juego llega al final, y pregunta al usuario si desea volver a jugar. Si el usuario introduce "Si", comienza de nuevo el juego.
        Si el usuario introduce "No", el juego termina. Y si el usuario no introduce ninguna de las dos posibilidades, vuelve a preguntar al usuario.
        */
        
        } while(reiniciarJuego("Desea volver a jugar? Si/No")==true);
    }
    
    //A partir de este punto, comienzan las funciones.
    
    /*
    Estas dos funciones permiten asignar valores máximos y mínimos a la hora de pedir valores, y adicionalmente, permite poner mensajes personalizados
    en caso de que el usuario meta un valor no permitido.
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
            
    
    /*
    CapturarFichas comprueba en todas las direcciones si, partiendo desde la última ficha colocada, se pueden capturar fichas del rival. En caso de
    que se pueda, toma las casillas de las fichas capturadas y les asigna un valor de casilla vacía. Tras esto, pone un contador interno, al cual he llamado
    "fichascomidas", y le suma 2. Si se come en varios sentidos, se suma la cantidad de fichas que se han comido.
    Finalmente, devuelve el número de fichas comidas. 
    */
    
    public static int capturarFichas(int [][] tablero, int fila, int columna){
        int fichascomidas = 0;
        
        /*
        Comprueba las columnas a la derecha de la última ficha colocada.
        */
        
        if (columna+3 < tablero.length){
            if (tablero[fila][columna]==tablero[fila][columna+3] && tablero[fila][columna+1]==tablero[fila][columna+2] && 
                    tablero[fila][columna+1]!=CASILLA_VACIA && tablero[fila][columna+1]!=tablero[fila][columna]){
                tablero[fila][columna+1]=CASILLA_VACIA;
                tablero[fila][columna+2]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
            }  
        }
        
        /*
        Comprueba las columnas a la izquierda de la última ficha colocada.
        */
        
        if (columna-3 >= 0){
            if (tablero[fila][columna]==tablero[fila][columna-3] && tablero[fila][columna-1]==tablero[fila][columna-2] && 
                    tablero[fila][columna-1]!=CASILLA_VACIA && tablero[fila][columna-1]!=tablero[fila][columna]){
                tablero[fila][columna-1]=CASILLA_VACIA;
                tablero[fila][columna-2]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
            }  
        }
        
        /*
        Comprueba las filas que se encuentran bajo la última ficha colocada.
        */
        
        if (fila+3 < tablero.length){
            if (tablero[fila][columna]==tablero[fila+3][columna] && tablero[fila+1][columna]==tablero[fila+2][columna] && 
                    tablero[fila+1][columna]!=CASILLA_VACIA && tablero[fila+1][columna]!=tablero[fila][columna]){
                tablero[fila+1][columna]=CASILLA_VACIA;
                tablero[fila+2][columna]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
            }  
        }
        
        /*
        Comprueba las filas que se encuentran encima de la última ficha colocada.
        */
        
        if (fila-3 >= 0){
            if (tablero[fila][columna]==tablero[fila-3][columna] && tablero[fila-1][columna]==tablero[fila-2][columna] && 
                    tablero[fila-1][columna]!=CASILLA_VACIA && tablero[fila-1][columna]!=tablero[fila][columna]){
                tablero[fila-1][columna]=CASILLA_VACIA;
                tablero[fila-2][columna]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
            }  
        }
        
        /*
        Comprueba diagonalmente hacia abajo a la derecha.
        */
        
        if (fila+3 < tablero.length && columna+3 < tablero.length){
            if (tablero[fila][columna]==tablero[fila+3][columna+3] && tablero[fila+1][columna+1]==tablero[fila+2][columna+2] && 
                    tablero[fila+1][columna+1]!=CASILLA_VACIA && tablero[fila+1][columna+1]!=tablero[fila][columna]){
                tablero[fila+1][columna+1]=CASILLA_VACIA;
                tablero[fila+2][columna+2]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
            }  
        }
        
        /*
        Comprueba diagonalmente hacia arriba a la izquierda.
        */
        
        if (fila-3 >= 0 && columna-3 >= 0){
            if (tablero[fila][columna]==tablero[fila-3][columna-3] && tablero[fila-1][columna-1]==tablero[fila-2][columna-2] && 
                    tablero[fila-1][columna-1]!=CASILLA_VACIA && tablero[fila-1][columna-1]!=tablero[fila][columna]){
                tablero[fila-1][columna-1]=CASILLA_VACIA;
                tablero[fila-2][columna-2]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
            }  
        }
        
        /*
        Comprueba diagonalmente hacia arriba a la derecha.
        */
        
        if (fila-3 > 0 && columna+3 < tablero.length){
            if (tablero[fila][columna]==tablero[fila-3][columna+3] && tablero[fila-1][columna+1]==tablero[fila-2][columna+2] && 
                    tablero[fila-1][columna+1]!=CASILLA_VACIA && tablero[fila-1][columna+1]!=tablero[fila][columna]){
                tablero[fila-1][columna+1]=CASILLA_VACIA;
                tablero[fila-2][columna+2]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
            }  
        }
        
        /*
        Comprueba diagonalmente hacia abajo a la izquierda.
        */
        
        if (fila+3 < tablero.length && columna-3 >= 0){
            if (tablero[fila][columna]==tablero[fila+3][columna-3] && tablero[fila+1][columna-1]==tablero[fila+2][columna-2] && 
                    tablero[fila+1][columna-1]!=CASILLA_VACIA && tablero[fila+1][columna-1]!=tablero[fila][columna]){
                tablero[fila+1][columna-1]=CASILLA_VACIA;
                tablero[fila+2][columna-2]=CASILLA_VACIA;
                fichascomidas=fichascomidas+2;
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
        Comprueba las columnas a la derecha de la última ficha colocada.
        */
        
        if (columna+4 < tablero.length){
            if (tablero[fila][columna]==tablero[fila][columna+1] && tablero[fila][columna]==tablero[fila][columna+2] &&
                tablero[fila][columna]==tablero[fila][columna+3] && tablero[fila][columna]==tablero[fila][columna+4]){
                return true;
            }
        } 
        
        /*
        Comprueba las columnas a la izquierda de la última ficha colocada.
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
        
        if (fila+4 < tablero.length){
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
        
        if (fila+4 < tablero.length && columna+4 < tablero.length){
            if (tablero[fila][columna]==tablero[fila+1][columna+1] && tablero[fila][columna]==tablero[fila+2][columna+2] &&
                tablero[fila][columna]==tablero[fila+3][columna+3]&& tablero[fila][columna]==tablero[fila+4][columna+4]){
                return true;
                
            }
        }
        
        /*
        Comprueba diagonalmente hacia arriba a la derecha.
        */
        
        if (fila-4 >= 0 && columna+4 < tablero.length){
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
        
        if (fila+4 < tablero.length && columna-4 >= 0){
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
    reiniciarJuego se usa únicamente después de que el juego termine, a modo de preguntar al usuario si desea volver a jugar.
    Si el usuario introduce "Si", comienza de nuevo el juego. Si el usuario introduce "No", el juego termina. 
    Y si el usuario no introduce ninguna de las dos posibilidades, vuelve a preguntar al usuario.
    */
    
    public static boolean reiniciarJuego(String mensaje){
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        String confirmacion;
        
        do {
        confirmacion=teclado.next();
        if ("Si".equals(confirmacion)){
            return true;
        } else if ("No".equals(confirmacion)){
            return false;
        } else {
            teclado.nextLine();
            System.out.println("Por favor, introduzca solo \"Si\" o \"No\". Con la primera letra en mayúscula.");
        }
        } while (!confirmacion.equals("Si")||!confirmacion.equals("No"));
        return false;
    }
}