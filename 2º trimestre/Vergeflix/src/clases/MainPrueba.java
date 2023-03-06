/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DAW-B
 */
public class MainPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        enum Tematica{
            COMEDIA,DRAMA,TERROR,SUSPENSE,CIENCIA_FICCION,FANTASIA
        }   
        
        
        
        
        
        
        
        
        
        LocalDate fecha=LocalDate.of(2000, Month.MARCH, 5);
        LocalDate fecha2=LocalDate.of(2000, 2, 23);
        DateTimeFormatter fechaDTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(fecha2.format(fechaDTF));
        
    }
    
}
