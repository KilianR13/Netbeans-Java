/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;


public class Ejercicio00AreaTriangulo {

    public static void main(String[] args) {
        double base, altura, area;

        System.out.println("Bienvenido al programa de cálculo de áreas de triángulos");
        System.out.println("--------------------------------------------------------");

        base = LeerDatosTeclado.leerDouble("Introduce la base del triángulo (>0): ",0);
        altura = LeerDatosTeclado.leerDouble("Introduce la altura del triángulo (>0): ",0);

        area = (base * altura) / 2;
        System.out.println("El área del triángulo con b=" + base + " y h=" + altura + " es: " + area);

    }


}
