package GestionTarjetasCredito;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 * El programa principal, que incluye el men� y la principal funci�n de los constructores.
 * @author Kilian Vidal Barranco
 */
public class AplicacionTarjetasCredito {

    /**
     * La clase principal del programa, que se encarga de gestionar toda la "Interfaz" y mostrar al usuario el men� y pedir sus opciones. EL programa gestiona este men� con un switch y un do-while.
     * En caso de que el usuario pida por un n�mero no considerado, lo redirige al Default, que le muestra un mensaje de error. Para evitar que le salte el Default al introducir el d�gito de 
     * salida de cada do-while, he a�adido un caso con el n�mero de escape vac�o para cada switch.
     * @param args - El array de String creado por defecto
     */
    public static void main(String[] args) {
        int menu;
        TarjetaCredito[]arrayTarjetas=new TarjetaCredito[10];
        do{
            menu=tecladoInt("1. Crear tarjeta de cr�dito.\n2. Eliminar tarjeta de cr�dito.\n3. Gestionar tarjeta de cr�dito.\n4. Consultar gastos totales.\n5. Salir del programa.");
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
                                System.err.println("Ha alcanzado el l�mite de tarjetas de cr�dito que puede crear.\n");
                            }
                        }
                    }
                    case 2 ->{
                        String nif=tecladoString("\nIntroduzca el NIF asociado con la tarjeta de cr�dito que desea borrar:");
                        int posicion=buscarTarjeta(arrayTarjetas,nif);
                        if(posicion==arrayTarjetas.length+1){
                            System.err.println("El NIF introducido no corresponde con ninguna tarjeta\n");
                        } else {
                            eliminarTarjeta(arrayTarjetas,posicion);
                        }
                    }
                    case 3 ->{
                        String nif=tecladoString("\nIntroduzca el NIF asociado con la tarjeta de cr�dito que desea seleccionar:");
                        int posicion=buscarTarjeta(arrayTarjetas,nif);
                        if(posicion==arrayTarjetas.length+1){
                            System.err.println("El NIF introducido no corresponde con ninguna tarjeta\n");
                        } else {
                            int menu3;
                            do{
                                menu3=tecladoInt("1. Mostrar el n�mero de tarjeta completo.\n2. Mostrar el nombre del titular de la tarjeta.\n3. Mostrar la fecha de caducidad.\n4. Modificar el PIN.\n5. Realizar un pago.\n6. Consultar movimientos.\n7. Consultar gasto total.\n8. Volver al men� principal.");
                                    switch(menu3){
                                        case 1->{
                                            System.out.println(arrayTarjetas[posicion].getNumeroTarjeta()+"\n");
                                        }
                                        case 2->{
                                            System.out.println(arrayTarjetas[posicion].getTitular()+"\n");
                                        }
                                        case 3->{
                                            System.out.println(arrayTarjetas[posicion].getMesCaducidad()+"/"+arrayTarjetas[posicion].getA�oCaducidad()+"\n");
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
                                            int numeroMovimientos=tecladoInt("Introduzca los �ltimos movimientos que desee ver.");
                                            if(arrayTarjetas[posicion].movimientos(numeroMovimientos).equals("")){
                                                System.out.println("No ha realizado ning�n movimiento con esta tarjeta\n");
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
     * M�todo privado que pide al usuario un n�mero y recoge su elecci�n para navegar el men�.
     * @param mensaje - Mensaje personalizado para mostrar al usuario.
     * @return opcion - La opci�n elegida por el usuario.
     */
    private static int tecladoInt(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println("\n"+mensaje);
        int opcion=teclado.nextInt();    
        return opcion;
    }
    /**
     * M�todo privado usado principalmente para pedir n�meros de tipo double, usados en pagos.
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
     * M�todo privado que recoge las cadenas de car�cteres que el usuario quiere asignar.
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
     * M�todo privado que llama al constructor TarjetaCr�dito, el cual crea una tarjeta de cr�dito tras pedir al usuario los par�metros para esta.
     * @return tarjeta - Devuelve un objeto de tipo TarjetaCr�dito creado por el usuario tras pedirle los par�metros.
     */
    private static TarjetaCredito crearTarjeta(){
        String nombre=tecladoString("\nIntroduzca el titular de la tarjeta.");
        String nif=tecladoString("\nIntroduzca el NIF/DNI del titular.");
        String pin=tecladoString("\nIntroduzca el PIN que desea en su tarjeta.");
        int limite=tecladoInt("\nIntroduzca el l�mite de gastos que desea.");
        String numeroTarjeta=tecladoString("\nIntroduzca el n�mero de su tarjeta.");
        TarjetaCredito tarjeta = new TarjetaCredito(nombre,nif,pin,limite,numeroTarjeta);
        return tarjeta;
    }
    
    /**
     * M�todo privado que calcula el total gastado en todas las tarjetas de cr�dito guardadas en el array arrayTarjetas.
     * @param arrayTarjetas - El array creado al inicio del programa, el cual guarda las tarjetas creadas, si es posible.
     * @return total - Total gastado con todas las tarjetas de cr�dito.
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
     * M�todo privado que devuelve la posici�n exacta en el array de arrayTarjetas de la tarjeta que el usuario busca, en formato Int. 
     * @param arrayTarjetas - El array creado al inicio del programa, el cual guarda las tarjetas creadas, si es posible.
     * @param nif - El DNI del usuario, para poder compararlo con las tarjetas existentes dentro del array.
     * @return posicion - Int que determina en qu� posici�n del array arrayTarjetas se encuentra la tarjeta.
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
     * M�todo privado que elimina la tarjeta que se encuentra en la posici�n introducida dentro del array arrayTarjetas.
     * @param arrayTarjetas - El array creado al inicio del programa, el cual guarda las tarjetas creadas, si es posible.
     * @param posicion - Posici�n obtenida gracias al m�todo buscarTarjeta.
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
