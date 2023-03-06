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
 * Clase centrada en almacenar los m�todos y constructores de tipo TarjetaCredito.
 * @author Kilian Vidal Barranco
 */
public class TarjetaCredito {
    private String titular;
    private String nif;
    private String pin;
    private int limite;
    private String mesCaducidad;
    private String a�oCaducidad;
    private String numeroTarjeta;
    private String cvv;
    private Movimiento[] movimientos;
    /**
     * Constructor de tarjetas de cr�dito del formato TarjetaCredito.
     * Guardan el nombre, DNI, pin, l�mite de gasto, n�mero de tarjeta, CVV, mes y a�o de caducidad, y crea un array de tipo
     * Movimiento. Este array siempre ser� de 50.
     * @param nombre - Nombre del propietario de la tarjeta. Es verificado con una clase externa privada.
     * @param nif - El DNI/NIE/CIF del propietario de la tarjeta. Los tres son verificados con una clase externa privada.
     * @param pin - C�digo PIN para acceder a la tarjeta. Es verificado con una clase externa privada.
     * @param limite - L�mite de gastos en la tarjeta. Es verificado con una clase externa privada.
     * @param numeroTarjeta - N�mero de la tarjeta es cliente. Es verificado con una clase externa privada.
     * @exception IllegalArgumentException - Si el nombre del titular no es v�lido.
     * @exception IllegalArgumentException - Si el NIF no es v�lido.
     * @exception IllegalArgumentException - Si el PIN no es v�lido.
     * @exception IllegalArgumentException - Si el l�mite de gasto no es v�lido.
     * @exception IllegalArgumentException - Si el n�mero de la tarjeta no es v�lido.
     */
    public TarjetaCredito(String nombre, String nif, String pin, int limite, String numeroTarjeta){
        if(!verificarNombre(nombre)){
            throw new IllegalArgumentException("El nombre del titular de la tarjeta no es v�lido.");
        }
        if(!verificarNif(nif)){
            throw new IllegalArgumentException("El NIF introducido no es v�lido.");
        }
        if(!verificarPIN(pin)){
            throw new IllegalArgumentException("El PIN introducido no es v�lido.");
        }
        if(!limiteGasto(limite)){
            throw new IllegalArgumentException("El l�mite de gasto introducido no es v�lido.");
        }
        if (!comprobarNumeroTarjeta(numeroTarjeta)){
            throw new IllegalArgumentException("El n�mero de tarjeta no es valido");
        }
        this.titular=nombre;
        this.nif=nif;
        this.pin=pin;
        this.limite=limite;
        this.numeroTarjeta=numeroTarjeta;
        this.cvv=generarCVV();
        LocalDateTime dateMes = LocalDateTime.now();
        LocalDateTime dateA�o = LocalDateTime.now().plusYears(5);
        DateTimeFormatter fechaMes = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter fechaA�o = DateTimeFormatter.ofPattern("yyyy");
        this.mesCaducidad = dateMes.format(fechaMes);
        this.a�oCaducidad = dateA�o.format(fechaA�o);
        this.movimientos = new Movimiento[50];
    }
    /**
     * Constructor copia. Copia todos los par�metros de una tarjeta a la nueva tarjeta.
     * @param tarjeta - Una tarjeta ya existente.
     */
    public TarjetaCredito(TarjetaCredito tarjeta){
        this(tarjeta.getTitular(),tarjeta.getNif(),tarjeta.getPin(),tarjeta.getLimite(),tarjeta.getNumeroTarjeta());
        this.cvv=tarjeta.cvv;
        this.mesCaducidad=tarjeta.mesCaducidad;
        this.a�oCaducidad=tarjeta.a�oCaducidad;
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
     * Establece un nuevo pin a la tarjeta. Si el PIN no es v�lido, no se cambiar�.
     * @param pin - El nuevo pin establecido por el usuario.
     */
    public void setPin(String pin) {
        if(verificarPIN(pin)){
            this.pin = pin;
        }
    }

    /**
     * Devuelve el l�mite de gastos en la tarjeta.
     * @return limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Establece un nuevo l�mite de gastos en la tarjeta. Si el l�mite de gastos no est� permitido, no lo cambiar�.
     * @param limite - El nuevo l�mite de pago en la tarjeta.
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
     * Devuelve el a�o de caducidad de la tarjeta.
     * @return a�oCaducidad
     */
    public String getA�oCaducidad() {
        return a�oCaducidad;
    }

    /**
     * Devuelve el n�mero asignado a la tarjeta.
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
     * M�todo que permite realizar pagos con la tarjeta de cr�dito. Comprueba que ambos valores establecidos est�n permitidos, 
     * y si lo est�n, crea un objeto de la clase Movimiento y lo a�ade al array previamente creado.
     * @param cantidad - Cantidad a pagar.
     * @param concepto - "Raz�n" del usuario para realizar el pago.
     * @return boolean - Devuelve True o False dependiendo si se ha podido realizar el pago. Debido a que si alguno de los valores es incorrecto, lanza una Exception, no 
     * tiene sentido poner que pueda salir False si consigue atravesar la "barrera" del error.
     * @exception IllegalArgumentException - En caso de que la cantidad a gastar sea negativa.
     * @exception IllegalArgumentException - En caso de que el gasto sea mayor al l�mite establecido.
     */
    public boolean pagar(double cantidad, String concepto){
        if(!comprobarGastarNegativo(cantidad)){
            throw new IllegalArgumentException("No es posible gastar una cantidad negativa.");
        }
        if(!comprobarGastarLimite(cantidad)){
            throw new IllegalArgumentException("No puede gastar m�s del l�mite establecido en la tarjeta.");
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
     * M�todo que permite al usuario comprobar todos los gastos realizados en la tarjeta. Esto lo hace recorriendo el array de movimientos y comprobando la cantidad guardada en cada movimiento.
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
     * Devuelve en formato String los N �ltimos movimientos que el usuario ha realizado. N = numero.
     * @param numero - N�mero de movimientos que el usuario quiere comprobar.
     * @return devolver - Es el nombre establecido para el String, en realidad devuelve el system.out establecido para cada movimiento, en un solo String.
     * @exception IllegalArgumentException - Si el n�mero de movimientos que el usuario quiere comprobar es err�neo, ya sea negativo o mayor que el tama�o del array.
     */
    public String movimientos(int numero){ 
        if(!comprobarMovimientos(numero)){
            throw new IllegalArgumentException("El n�mero de movimientos a comprobar es err�neo");
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
     * M�todo que permite saber el total de movimientos realizados en una tarjeta.
     * @return numeroTotal - El n�mero total de movimientos que est�n almacenados en el array.
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
     * Comprueba si el �ltimo d�gito del n�mero de la tarjeta de cr�dito es el mismo que el d�gito de control, calculado en otro m�todo.
     * @param numero - N�mero de la tarjeta.
     * @return boolean - Devuelve verdadero o falso dependiendo de que el m�todo obtenerDigitoControl sea verdadero o falso.
     */
    public static boolean comprobarNumeroTarjeta(String numero){
        String ultimoNumero=numero.substring(15, 16);
        return obtenerDigitoControl(numero).equals(ultimoNumero);
    }
    
    /**
     * M�todo que calcula el d�gito de control de el n�mero de una tarjeta de cr�dito, y devuelve el d�gito de control en formato String.
     * @param numero - N�mero de la tarjeta.
     * @return digitoControl - Un String que contiene un solo caracter, el cual es el d�gito de control.
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
     * M�todo privado que comprueba si el l�mite de gasto establecido en la tarjeta es v�lido.
     * @param limite - L�mite de gasto
     * @return boolean - Ser� True si el l�mite est� dentro de lo establecido.
     */
    private boolean limiteGasto(int limite){
        return limite<5000 && limite>500;
    }
    
    /**
     * M�todo privado que comprueba si el n�mero de movimientos que el usuario desea comprobar es v�lido.
     * @param numero - N�mero de movimientos.
     * @return boolean - Ser� True si la cantidad de movimientos est� dentro de los l�mites.
     */
    private boolean comprobarMovimientos(int numero){
        return numero>0 && numero<=50;
    }
    /**
     * M�todo privado que comprueba si la cantidad que el usuario quiere gastar es positiva.
     * @param cantidad - La cantidad que el usuario desea gastar.
     * @return boolean - Ser� True si la cantidad es 0 o m�s.
     */
    private boolean comprobarGastarNegativo(double cantidad){
        return cantidad>=0;
    }
    /**
     * M�todo privado que comprueba si la cantidad que el usuario quiere gastar est� por debajo del l�mite.
     * @param cantidad - La cantidad que el usuario desea gastar.
     * @return boolean - Ser� True si la cantidad que el usuario quiere gastar es menos que el l�mite establecido.
     */
    private boolean comprobarGastarLimite(double cantidad){
        return cantidad<=this.limite;
    }
    
    /**
     * M�todo privado pensado para generar un CVV de forma totalmente aleatoria.
     * @return cvvString - Un String de 3 n�meros aleatorios.
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
     * Comprueba mediante una expresi�n regular si el nombre del titular es v�lido.
     * @param nombre - Nombre del titular.
     * @return boolean - Ser� True si el nombre del titular es v�lido.
     */
    private boolean verificarNombre(String nombre){
        Pattern patronNombre = Pattern.compile("([\\D]\\s?){15,80}");
        Matcher verificarNombre = patronNombre.matcher(nombre);
        return verificarNombre.matches();
    }
    /**
     * Comprueba mediante una expresi�n regular si el pin elegido por el titular es v�lido.
     * @param pin - Pin elegido por del titular.
     * @return boolean - Ser� True si el pin es v�lido.
     */
    private boolean verificarPIN(String pin){
        Pattern patronPin = Pattern.compile("([\\d]){4,}");
        Matcher verificarPin = patronPin.matcher(pin);
        return verificarPin.matches();
    }
    /**
     * Comprueba mediante una expresi�n regular si el DNI/NIE/CIF del titular es v�lido.
     * @param nif - DNI del titular.
     * @return boolean - Ser� True si el DNI/NIE/CIF del titular es v�lido.
     */
    private boolean verificarNif(String nif){
        Pattern patronNIF = Pattern.compile("(([\\d]){8})([\\D])|([XYZ])([\\d]{7})([\\D\\d])|([\\D])([\\d]{7})([\\D\\d])");
        Matcher verificarNIF = patronNIF.matcher(nif);
        return verificarNIF.matches();
    }
    
    /**
     * Devuelve un String con los valores de la tarjeta.
     * @return String - Un String con todos los valores de inter�s sobre la tarjeta de cr�dito.
     */
    @Override
    public String toString(){
        return "Titular: "+titular+", PIN: "+pin+", n�mero de tarjeta: "+numeroTarjeta+", limite de gasto: "+limite+", caducidad: "+mesCaducidad+"/"+a�oCaducidad+", CVV: "+cvv;
    }
    /**
     * M�todo que compara dos tarjetas de cr�dito, y si tienen el mismo n�mero de tarjeta, las declara como iguales.
     * @param t - Un objeto TarjetaCr�dito ya existente.
     * @return boolean - Ser� True si ambas tarjetas tienen el mismo n�mero de tarjeta.
     */     
    public boolean equals(TarjetaCredito t){
        return this.numeroTarjeta.equals(t.numeroTarjeta);
    }
    
    
    
    
    
    
}
