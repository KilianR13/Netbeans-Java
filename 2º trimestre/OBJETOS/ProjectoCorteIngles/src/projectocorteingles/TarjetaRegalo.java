/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectocorteingles;
/**
 *
 * @author DAW-B
 */
public class TarjetaRegalo {
    private int[] numID=new int[5];
    private double saldo;
    private String leerID;
    
    /*
    Crea la tarjeta, le asigna el saldo, y genera un número de ID aleatorio, que se le asigna a dicha tarjeta.
    Cuando se llama a esa función, el ID termina en un String.
    */
    
    public TarjetaRegalo (double saldo){
        if (!validarPositivo(saldo)){
            throw new IllegalArgumentException("No se puede crear una tarjeta con saldo negativo");
        } else {
            this.saldo=saldo;
            leerID=generarNumID(numID);
        }
    }
    
    /*
    Si el usuario gasta dinero, se le resta de la tarjeta. Si intenta gastar más de lo que tiene, no puede,
    */
    
    public void gasta(double dinero) {
        if (!validarPositivo(dinero)) {
            System.err.println("No se puede gastar dinero positivo\n");
        } else if (dinero > this.saldo) {
            System.err.println("No tiene suficiente saldo para gastar " + dinero + "\u20ac \n");
        } else {
            this.saldo -= dinero;
        }
    }
    
    /*
    En caso de querer fusionar tarjetas, deja ambas a 0 y le mete los ingresos a la nueva.
    */
    
    public TarjetaRegalo fusionaCon(TarjetaRegalo tarjeta){
        TarjetaRegalo nueva = new TarjetaRegalo(this.saldo+tarjeta.saldo);
        this.saldo = tarjeta.saldo = 0;
        return nueva;
    }
    
    /*
    El texto que aparece en pantalla al llamar a System.out. Por esto el ID tiene que ser un string.
    */
    
    @Override
    public String toString(){
        return "Tarjeta nº " + leerID + " - Saldo "+saldo+"\u20ac \n";
    }
    
    /*
    Comprueba si el valor es positivo o no.
    */
    
    private boolean validarPositivo(double valor){
        return valor>0;
    }
    
    /*
    Usa el array para guardar números aleatorios del 0 al 9. Entonces, los inserta en un string.
    */
    
    private String generarNumID(int[] numID){
        String numString="";
        for (int i = 0; i < numID.length; i++) {
            numID[i]=(int)(Math.random()*10);
        }
        for (int i:numID){
            numString+=Integer.toString(i);
        }
        return numString;
    }
}