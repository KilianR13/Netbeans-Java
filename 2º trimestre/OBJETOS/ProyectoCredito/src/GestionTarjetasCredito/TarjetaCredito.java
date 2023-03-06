/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionTarjetasCredito;

import static java.lang.String.valueOf;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase centrada en almacenar los métodos y constructores de tipo TarjetaCredito.
 * @author Kilian Vidal Barranco
 */
public class TarjetaCredito {
    private String titular;
    private String nif;
    private String pin;
    private int limite;
    private String mesCaducidad;
    private String añoCaducidad;
    private String numeroTarjeta;
    private String cvv;
    private Movimiento[] movimientos;
    /**
     * Constructor de tarjetas de crédito del formato TarjetaCredito.
     * Guardan el nombre, DNI, pin, límite de gasto, número de tarjeta, CVV, mes y año de caducidad, y crea un array de tipo
     * Movimiento. Este array siempre será de 50.
     * @param nombre - Nombre del propietario de la tarjeta. Es verificado con una clase externa privada.
     * @param nif - El DNI/NIE/CIF del propietario de la tarjeta. Los tres son verificados con una clase externa privada.
     * @param pin - Código PIN para acceder a la tarjeta. Es verificado con una clase externa privada.
     * @param limite - Límite de gastos en la tarjeta. Es verificado con una clase externa privada.
     * @param numeroTarjeta - Número de la tarjeta es cliente. Es verificado con una clase externa privada.
     * @exception IllegalArgumentException - Si el nombre del titular no es válido.
     * @exception IllegalArgumentException - Si el NIF no es válido.
     * @exception IllegalArgumentException - Si el PIN no es válido.
     * @exception IllegalArgumentException - Si el límite de gasto no es válido.
     * @exception IllegalArgumentException - Si el número de la tarjeta no es válido.
     */
    public TarjetaCredito(String nombre, String nif, String pin, int limite, String numeroTarjeta){
        if(!verificarNombre(nombre)){
            throw new IllegalArgumentException("El nombre del titular de la tarjeta no es válido.");
        }
        if(!verificarNif(nif)){
            throw new IllegalArgumentException("El NIF introducido no es válido.");
        }
        if(!verificarPIN(pin)){
            throw new IllegalArgumentException("El PIN introducido no es válido.");
        }
        if(!limiteGasto(limite)){
            throw new IllegalArgumentException("El límite de gasto introducido no es válido.");
        }
        if (!comprobarNumeroTarjeta(numeroTarjeta)){
            throw new IllegalArgumentException("El número de tarjeta no es valido");
        }
        this.titular=nombre;
        this.nif=nif;
        this.pin=pin;
        this.limite=limite;
        this.numeroTarjeta=numeroTarjeta;
        this.cvv=generarCVV();
        LocalDateTime dateMes = LocalDateTime.now();
        LocalDateTime dateAño = LocalDateTime.now().plusYears(5);
        DateTimeFormatter fechaMes = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter fechaAño = DateTimeFormatter.ofPattern("yyyy");
        this.mesCaducidad = dateMes.format(fechaMes);
        this.añoCaducidad = dateAño.format(fechaAño);
        this.movimientos = new Movimiento[50];
    }
    /**
     * Constructor copia. Copia todos los parámetros de una tarjeta a la nueva tarjeta.
     * @param tarjeta - Una tarjeta ya existente.
     */
    public TarjetaCredito(TarjetaCredito tarjeta){
        this(tarjeta.getTitular(),tarjeta.getNif(),tarjeta.getPin(),tarjeta.getLimite(),tarjeta.getNumeroTarjeta());
        this.cvv=tarjeta.cvv;
        this.mesCaducidad=tarjeta.mesCaducidad;
        this.añoCaducidad=tarjeta.añoCaducidad;
        this.movimientos=tarjeta.movimientos;
    }
    
    /**
     * Devuelve el nombre completo del titular de la tarjeta.
     * @return titular - El nombre completo del titular de la tarjeta.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Devuelve el DNI/NIF/CIF del titular de la tarjeta.
     * @return NIF
     */
    public String getNif() {
        return nif;
    }

    /**
     * Devuelve el PIN que el titular ha establecido en la tarjeta.
     * @return pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * Establece un nuevo pin a la tarjeta. Si el PIN no es válido, no se cambiará.
     * @param pin - El nuevo pin establecido por el usuario.
     */
    public void setPin(String pin) {
        if(verificarPIN(pin)){
            this.pin = pin;
        }
    }

    /**
     * Devuelve el límite de gastos en la tarjeta.
     * @return limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Establece un nuevo límite de gastos en la tarjeta. Si el límite de gastos no está permitido, no lo cambiará.
     * @param limite - El nuevo límite de pago en la tarjeta.
     */
    public void setLimite(int limite) {
        if(limiteGasto(limite)){
            this.limite = limite;
        }
    }

    /**
     * Devuelve el mes de caducidad de la tarjeta.
     * @return mesCaducidad
     */
    public String getMesCaducidad() {
        return mesCaducidad;
    }

    /**
     * Devuelve el año de caducidad de la tarjeta.
     * @return añoCaducidad
     */
    public String getAñoCaducidad() {
        return añoCaducidad;
    }

    /**
     * Devuelve el número asignado a la tarjeta.
     * @return numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Devuelve el CVV generado para la tarjeta.
     * @return cvv
     */
    public String getCvv() {
        return cvv;
    }
    
    /**
     * Método que permite realizar pagos con la tarjeta de crédito. Comprueba que ambos valores establecidos estén permitidos, 
     * y si lo están, crea un objeto de la clase Movimiento y lo añade al array previamente creado.
     * @param cantidad - Cantidad a pagar.
     * @param concepto - "Razón" del usuario para realizar el pago.
     * @return boolean - Devuelve True o False dependiendo si se ha podido realizar el pago. Debido a que si alguno de los valores es incorrecto, lanza una Exception, no 
     * tiene sentido poner que pueda salir False si consigue atravesar la "barrera" del error.
     * @exception IllegalArgumentException - En caso de que la cantidad a gastar sea negativa.
     * @exception IllegalArgumentException - En caso de que el gasto sea mayor al límite establecido.
     */
    public boolean pagar(double cantidad, String concepto){
        if(!comprobarGastarNegativo(cantidad)){
            throw new IllegalArgumentException("No es posible gastar una cantidad negativa.");
        }
        if(!comprobarGastarLimite(cantidad)){
            throw new IllegalArgumentException("No puede gastar más del límite establecido en la tarjeta.");
        }
        for (int i = 0; i < movimientos.length; i++) {
            if(movimientos[i]==null){
                movimientos[i]=new Movimiento(cantidad,concepto);
                i=movimientos.length;
            }
        }
        return true;
    }
    
    /**
     * Método que permite al usuario comprobar todos los gastos realizados en la tarjeta. Esto lo hace recorriendo el array de movimientos y comprobando la cantidad guardada en cada movimiento.
     * @return gastado - El dinero gastado en la tarjeta.
     */    
    public double gastado(){
        double gastado=0;
        for (int i = 0; i < movimientos.length; i++) {
            if(movimientos[i]!=null){
                gastado=gastado+this.movimientos[i].getCantidad();
            }
        }
        return gastado;
    }
    
    /**
     * Devuelve en formato String los N últimos movimientos que el usuario ha realizado. N = numero.
     * @param numero - Número de movimientos que el usuario quiere comprobar.
     * @return devolver - Es el nombre establecido para el String, en realidad devuelve el system.out establecido para cada movimiento, en un solo String.
     * @exception IllegalArgumentException - Si el número de movimientos que el usuario quiere comprobar es erróneo, ya sea negativo o mayor que el tamaño del array.
     */
    public String movimientos(int numero){ 
        if(!comprobarMovimientos(numero)){
            throw new IllegalArgumentException("El número de movimientos a comprobar es erróneo");
        }
        String devolver="";
        int contador=numero;
        for (int i = movimientos.length-1; i >= 0 && contador>0; i--) {
            if(movimientos[i]!=null){
                devolver=devolver+movimientos[i]+"\n";
                contador--;
            }
        }
        return devolver;
    }
    
    /**
     * Método que permite saber el total de movimientos realizados en una tarjeta.
     * @return numeroTotal - El número total de movimientos que están almacenados en el array.
     */
    public int numeroMovimientos(){
        int numeroTotal=0;
        for (int i = 0; i < movimientos.length; i++) {
            if(movimientos[i]!=null){
                numeroTotal++;
            }
        }
        return numeroTotal;
    }

    /**
     * Comprueba si el último dígito del número de la tarjeta de crédito es el mismo que el dígito de control, calculado en otro método.
     * @param numero - Número de la tarjeta.
     * @return boolean - Devuelve verdadero o falso dependiendo de que el método obtenerDigitoControl sea verdadero o falso.
     */
    public static boolean comprobarNumeroTarjeta(String numero){
        String ultimoNumero=numero.substring(15, 16);
        return obtenerDigitoControl(numero).equals(ultimoNumero);
    }
    
    /**
     * Método que calcula el dígito de control de el número de una tarjeta de crédito, y devuelve el dígito de control en formato String.
     * @param numero - Número de la tarjeta.
     * @return digitoControl - Un String que contiene un solo caracter, el cual es el dígito de control.
     */
    public static String obtenerDigitoControl(String numero){
        int suma=0;
        int sumatemp;
        char aux;
        String aux2;
        String digitoControl;
        String numero15 = numero.substring(0, 15);
        String numeroReverse = new StringBuffer(numero15).reverse().toString();
        int control;
        
        for (int i = 0; i < numeroReverse.length(); i++) {
            if(i%2!=0){
                aux = numeroReverse.charAt(i);
                aux2 = valueOf(aux);
                suma = suma + Integer.parseInt(aux2);
            } else {
                aux = numeroReverse.charAt(i);
                aux2 = valueOf(aux);
                sumatemp = Integer.parseInt(aux2)*2;
                if(sumatemp>9){
                    sumatemp=sumatemp-9;
                }
                suma=suma+sumatemp;
            }
        }
        control=(suma*9)%10;
        digitoControl=valueOf(control);
        return digitoControl;
    }
    
    /**
     * Método privado que comprueba si el límite de gasto establecido en la tarjeta es válido.
     * @param limite - Límite de gasto
     * @return boolean - Será True si el límite está dentro de lo establecido.
     */
    private boolean limiteGasto(int limite){
        return limite<5000 && limite>500;
    }
    
    /**
     * Método privado que comprueba si el número de movimientos que el usuario desea comprobar es válido.
     * @param numero - Número de movimientos.
     * @return boolean - Será True si la cantidad de movimientos está dentro de los límites.
     */
    private boolean comprobarMovimientos(int numero){
        return numero>0 && numero<=50;
    }
    /**
     * Método privado que comprueba si la cantidad que el usuario quiere gastar es positiva.
     * @param cantidad - La cantidad que el usuario desea gastar.
     * @return boolean - Será True si la cantidad es 0 o más.
     */
    private boolean comprobarGastarNegativo(double cantidad){
        return cantidad>=0;
    }
    /**
     * Método privado que comprueba si la cantidad que el usuario quiere gastar está por debajo del límite.
     * @param cantidad - La cantidad que el usuario desea gastar.
     * @return boolean - Será True si la cantidad que el usuario quiere gastar es menos que el límite establecido.
     */
    private boolean comprobarGastarLimite(double cantidad){
        return cantidad<=this.limite;
    }
    
    /**
     * Método privado pensado para generar un CVV de forma totalmente aleatoria.
     * @return cvvString - Un String de 3 números aleatorios.
     */
    private String generarCVV(){
        String cvvString="";
        int[] cvvArray=new int[3];
        for (int i = 0; i < cvvArray.length; i++) {
            cvvArray[i]=(int)(Math.random()*10);
        }
        for (int i:cvvArray) {
            cvvString+=Integer.toString(i);
        }
        return cvvString;
    }
    
    /**
     * Comprueba mediante una expresión regular si el nombre del titular es válido.
     * @param nombre - Nombre del titular.
     * @return boolean - Será True si el nombre del titular es válido.
     */
    private boolean verificarNombre(String nombre){
        Pattern patronNombre = Pattern.compile("([\\D]\\s?){15,80}");
        Matcher verificarNombre = patronNombre.matcher(nombre);
        return verificarNombre.matches();
    }
    /**
     * Comprueba mediante una expresión regular si el pin elegido por el titular es válido.
     * @param pin - Pin elegido por del titular.
     * @return boolean - Será True si el pin es válido.
     */
    private boolean verificarPIN(String pin){
        Pattern patronPin = Pattern.compile("([\\d]){4,}");
        Matcher verificarPin = patronPin.matcher(pin);
        return verificarPin.matches();
    }
    /**
     * Comprueba mediante una expresión regular si el DNI/NIE/CIF del titular es válido.
     * @param nif - DNI del titular.
     * @return boolean - Será True si el DNI/NIE/CIF del titular es válido.
     */
    private boolean verificarNif(String nif){
        Pattern patronNIF = Pattern.compile("(([\\d]){8})([\\D])|([XYZ])([\\d]{7})([\\D\\d])|([\\D])([\\d]{7})([\\D\\d])");
        Matcher verificarNIF = patronNIF.matcher(nif);
        return verificarNIF.matches();
    }
    
    /**
     * Devuelve un String con los valores de la tarjeta.
     * @return String - Un String con todos los valores de interés sobre la tarjeta de crédito.
     */
    @Override
    public String toString(){
        return "Titular: "+titular+", PIN: "+pin+", número de tarjeta: "+numeroTarjeta+", limite de gasto: "+limite+", caducidad: "+mesCaducidad+"/"+añoCaducidad+", CVV: "+cvv;
    }
    /**
     * Método que compara dos tarjetas de crédito, y si tienen el mismo número de tarjeta, las declara como iguales.
     * @param t - Un objeto TarjetaCrédito ya existente.
     * @return boolean - Será True si ambas tarjetas tienen el mismo número de tarjeta.
     */     
    public boolean equals(TarjetaCredito t){
        return this.numeroTarjeta.equals(t.numeroTarjeta);
    }
    
    
    
    
    
    
}
