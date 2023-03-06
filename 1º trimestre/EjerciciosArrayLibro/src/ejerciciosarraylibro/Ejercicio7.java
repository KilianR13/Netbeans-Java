/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarraylibro;

/**
 *
 * @author DAW-B
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int random[]=new int[100];
        int numerobuscar;
        int numeroreemplazar;
        
        
        for (int i = 0; i < random.length; i++) {
            random[i]=(int) (Math.random()*21);
        }
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < random.length; i++) {
            System.out.print(+random[i]+" ");
        }
        System.out.println("--------------------------------------------------");
        numerobuscar=funciones.leerDouble.leerIntError("Introduzca el número que quiere buscar para reemplazar");
        numeroreemplazar=funciones.leerDouble.leerIntError("Ahora introduzca el número que quiere usar para reemplazar");
        System.out.println("--------------------------------------------------");
            
        for (int i = 0; i < random.length; i++) {
            if (random[i]==numerobuscar){
                random[i]=numeroreemplazar;
                System.out.print("\""+random[i]+"\" ");
            } else {
                System.out.print(""+random[i]+" ");
            }
        }
        
    }
    
}
