package GestionTarjetasCredito;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 * El programa principal, que incluye el menú y la principal función de los constructores.
 * @author Kilian Vidal Barranco
 */
public class AplicacionTarjetasCredito {

    /**
     * La clase principal del programa, que se encarga de gestionar toda la "Interfaz" y mostrar al usuario el menú y pedir sus opciones. EL programa gestiona este menú con un switch y un do-while.
     * En caso de que el usuario pida por un número no considerado, lo redirige al Default, que le muestra un mensaje de error. Para evitar que le salte el Default al introducir el dígito de 
     * salida de cada do-while, he añadido un caso con el número de escape vacío para cada switch.
     * @param args - El array de String creado por defecto
     */
    public static void main(String[] args) {
        int menu;
        TarjetaCredito[]arrayTarjetas=new TarjetaCredito[10];
        do{
            menu=tecladoInt("1. Crear tarjeta de crédito.\n2. Eliminar tarjeta de crédito.\n3. Gestionar tarjeta de crédito.\n4. Consultar gastos totales.\n5. Salir del programa.");
                switch(menu){
                    case 1 ->{
                        boolean tarjetacreada=false;
                        int contador=0;
                        for (int i = 0; i < arrayTarjetas.length && tarjetacreada!=true; i++) {
                            if(arrayTarjetas[i]==null){
                                TarjetaCredito tarjeta = crearTarjeta();
                                int comprobar=buscarTarjeta(arrayTarjetas,tarjeta.getNif());
                                if(comprobar>arrayTarjetas.length){
                                    arrayTarjetas[i]=tarjeta;
                                    System.out.println("Tarjeta guardada.\n");
                                } else {
                                    System.err.println("Ya existe una tarjeta con ese NIF.\n");
                                }
                                tarjetacreada=true;
                            } else {
                                contador++;
                            }
                            if(contador==arrayTarjetas.length){
                                System.err.println("Ha alcanzado el límite de tarjetas de crédito que puede crear.\n");
                            }
                        }
                    }
                    case 2 ->{
                        String nif=tecladoString("\nIntroduzca el NIF asociado con la tarjeta de crédito que desea borrar:");
                        int posicion=buscarTarjeta(arrayTarjetas,nif);
                        if(posicion==arrayTarjetas.length+1){
                            System.err.println("El NIF introducido no corresponde con ninguna tarjeta\n");
                        } else {
                            eliminarTarjeta(arrayTarjetas,posicion);
                        }
                    }
                    case 3 ->{
                        String nif=tecladoString("\nIntroduzca el NIF asociado con la tarjeta de crédito que desea seleccionar:");
                        int posicion=buscarTarjeta(arrayTarjetas,nif);
                        if(posicion==arrayTarjetas.length+1){
                            System.err.println("El NIF introducido no corresponde con ninguna tarjeta\n");
                        } else {
                            int menu3;
                            do{
                                menu3=tecladoInt("1. Mostrar el número de tarjeta completo.\n2. Mostrar el nombre del titular de la tarjeta.\n3. Mostrar la fecha de caducidad.\n4. Modificar el PIN.\n5. Realizar un pago.\n6. Consultar movimientos.\n7. Consultar gasto total.\n8. Volver al menú principal.");
                                    switch(menu3){
                                        case 1->{
                                            System.out.println(arrayTarjetas[posicion].getNumeroTarjeta()+"\n");
                                        }
                                        case 2->{
                                            System.out.println(arrayTarjetas[posicion].getTitular()+"\n");
                                        }
                                        case 3->{
                                            System.out.println(arrayTarjetas[posicion].getMesCaducidad()+"/"+arrayTarjetas[posicion].getAñoCaducidad()+"\n");
                                        }
                                        case 4->{
                                            String newpin=tecladoString("\nIntroduzca el nuevo pin para la tarjeta.");
                                            arrayTarjetas[posicion].setPin(newpin);
                                        }
                                        case 5->{
                                            double cantidad=tecladoDouble("Introduzca la cantidad del pago con la tarjeta.");
                                            String concepto=tecladoString("Introduzca el concepto del pago.");
                                            arrayTarjetas[posicion].pagar(cantidad, concepto);
                                        }
                                        case 6->{
                                            int numeroMovimientos=tecladoInt("Introduzca los últimos movimientos que desee ver.");
                                            if(arrayTarjetas[posicion].movimientos(numeroMovimientos).equals("")){
                                                System.out.println("No ha realizado ningún movimiento con esta tarjeta\n");
                                            } else {
                                                System.out.println(arrayTarjetas[posicion].movimientos(numeroMovimientos)+"\n");
                                            }
                                        }
                                        case 7->{
                                            System.out.println("El total gastado con esta tarjeta es de "+arrayTarjetas[posicion].gastado()+"\n");
                                        }
                                        case 8 ->{
                                            
                                        }
                                        default ->{
                                            System.err.println("Por favor, seleccione una de las opciones presentadas en pantalla.\n");
                                        }
                                    }
                            }while(menu3!=8);
                        }
                    }
                    case 4 ->{
                        System.out.println("El gasto total es de "+calcularGasto(arrayTarjetas)+" euros");
                    }
                    case 5 ->{
                        
                    }
                    default ->{
                        System.err.println("Por favor, seleccione una de las opciones presentadas en pantalla.");
                    }
                }
        }while(menu!=5);
    }
    
    /**
     * Método privado que pide al usuario un número y recoge su elección para navegar el menú.
     * @param mensaje - Mensaje personalizado para mostrar al usuario.
     * @return opcion - La opción elegida por el usuario.
     */
    private static int tecladoInt(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println("\n"+mensaje);
        int opcion=teclado.nextInt();    
        return opcion;
    }
    /**
     * Método privado usado principalmente para pedir números de tipo double, usados en pagos.
     * @param mensaje - Mensaje personalizado para mostrar al usuario.
     * @return cantidad - La cantidad que el usuario desea gastar.
     */
    private static double tecladoDouble(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println("\n"+mensaje);
        double cantidad=teclado.nextInt();
        return cantidad;
    }
    /**
     * Método privado que recoge las cadenas de carácteres que el usuario quiere asignar.
     * @param mensaje - Mensaje personalizado para mostrar al usuario.
     * @return valor - El String que el usuario ha introducido.
     */
    private static String tecladoString(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println("\n"+mensaje);
        String valor=teclado.nextLine();
        return valor;
    }
    
    /**
     * Método privado que llama al constructor TarjetaCrédito, el cual crea una tarjeta de crédito tras pedir al usuario los parámetros para esta.
     * @return tarjeta - Devuelve un objeto de tipo TarjetaCrédito creado por el usuario tras pedirle los parámetros.
     */
    private static TarjetaCredito crearTarjeta(){
        String nombre=tecladoString("\nIntroduzca el titular de la tarjeta.");
        String nif=tecladoString("\nIntroduzca el NIF/DNI del titular.");
        String pin=tecladoString("\nIntroduzca el PIN que desea en su tarjeta.");
        int limite=tecladoInt("\nIntroduzca el límite de gastos que desea.");
        String numeroTarjeta=tecladoString("\nIntroduzca el número de su tarjeta.");
        TarjetaCredito tarjeta = new TarjetaCredito(nombre,nif,pin,limite,numeroTarjeta);
        return tarjeta;
    }
    
    /**
     * Método privado que calcula el total gastado en todas las tarjetas de crédito guardadas en el array arrayTarjetas.
     * @param arrayTarjetas - El array creado al inicio del programa, el cual guarda las tarjetas creadas, si es posible.
     * @return total - Total gastado con todas las tarjetas de crédito.
     */
    private static double calcularGasto (TarjetaCredito[] arrayTarjetas){
        double total=0;
        for (int i = 0; i < arrayTarjetas.length; i++) {
            if(arrayTarjetas[i]!=null){
                total=total+arrayTarjetas[i].gastado();
            }
        }
        return total;
    }
    
    /**
     * Método privado que devuelve la posición exacta en el array de arrayTarjetas de la tarjeta que el usuario busca, en formato Int. 
     * @param arrayTarjetas - El array creado al inicio del programa, el cual guarda las tarjetas creadas, si es posible.
     * @param nif - El DNI del usuario, para poder compararlo con las tarjetas existentes dentro del array.
     * @return posicion - Int que determina en qué posición del array arrayTarjetas se encuentra la tarjeta.
     */
    private static int buscarTarjeta(TarjetaCredito[] arrayTarjetas, String nif){
        int posicion=arrayTarjetas.length+1;
        for (int i = 0; i < arrayTarjetas.length; i++) {
            if(arrayTarjetas[i]!=null){
                if(arrayTarjetas[i].getNif().equals(nif)){
                    posicion=i;
                }
            }
        }
        return posicion;
    }
    
    /**
     * Método privado que elimina la tarjeta que se encuentra en la posición introducida dentro del array arrayTarjetas.
     * @param arrayTarjetas - El array creado al inicio del programa, el cual guarda las tarjetas creadas, si es posible.
     * @param posicion - Posición obtenida gracias al método buscarTarjeta.
     */
    private static void eliminarTarjeta(TarjetaCredito[] arrayTarjetas, int posicion){
        arrayTarjetas[posicion]=null;
        for (int i = posicion+1; i < arrayTarjetas.length; i++) {
            if(arrayTarjetas[i]!=null){
                arrayTarjetas[i-1]=arrayTarjetas[i];
                arrayTarjetas[i]=null;
            }
        }
    }
}
