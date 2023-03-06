/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conjunto;

/**
 *
 * @author DAW-B
 */
public class ConjuntoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConjuntoOrdenadoEnteros c1=new ConjuntoOrdenadoEnteros(15);
        c1.add(10);
        c1.add(20);
        c1.add(33);
        c1.add(44);
        c1.add(55);
        c1.add(66);
        c1.add(77);
        c1.add(88);
        c1.add(99);
        c1.add(10);
        System.out.println(c1.search(33));
        System.out.println(c1.search(7));
        System.out.println(c1.del(2));
        ConjuntoOrdenadoEnteros c2=new ConjuntoOrdenadoEnteros(c1);
    }
    
}
