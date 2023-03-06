/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotiempo;

/**
 *
 * @author deifont
 */
public class Tiempo {

    int horas;
    int minutos;
    int segundos;

    public Tiempo(int horas, int minutos, int segundos) {

        validarParametros(horas, minutos, segundos);

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void suma(Tiempo t) {
        suma(t.horas, t.minutos, t.segundos);
    }

    public void suma(int horas, int minutos, int segundos) {
        validarParametros(horas, minutos, segundos);
        int segundosTotales = segundosTotales(this.horas, this.minutos, this.segundos);
        segundosTotales += segundosTotales(horas, minutos, segundos);

        int[] desglose = desglosarSegundos(segundosTotales);
        this.horas = desglose[0];
        this.minutos = desglose[1];
        this.segundos = desglose[2];

    }

    public void resta(Tiempo t) {
        resta(t.horas, t.minutos, t.segundos);
    }

    public void resta(int horas, int minutos, int segundos) {
        validarParametros(horas, minutos, segundos);
        int segundosTotales = segundosTotales(this.horas, this.minutos, this.segundos);
        segundosTotales -= segundosTotales(horas, minutos, segundos);

        if (segundosTotales > 0) {
            int[] desglose = desglosarSegundos(segundosTotales);
            this.horas = desglose[0];
            this.minutos = desglose[1];
            this.segundos = desglose[2];
        } else {
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
        }
    }

    @Override
    public String toString() {
        return horas + "h " + minutos + "m " + segundos + "s";
    }

    private void validarParametros(int horas1, int minutos1, int segundos1) {
        if (!validarHoras(horas1)) {
            throw new IllegalArgumentException("Las horas deben ser mayores o iguales que 0");
        }
        if (!validarMinutosSegundos(minutos1)) {
            throw new IllegalArgumentException("Los minutos deben estar entre 0-59");
        }
        if (!validarMinutosSegundos(segundos1)) {
            throw new IllegalArgumentException("Los minutos deben estar entre 0-59");
        }
    }

    private boolean validarHoras(int horas) {
        return horas >= 0;
    }

    private boolean validarMinutosSegundos(int minutos) {
        return minutos >= 0 && minutos <= 59;
    }

    private int segundosTotales(int horas, int minutos, int segundos) {
        return horas * 3600 + minutos * 60 + segundos;
    }

    private int[] desglosarSegundos(int segundos) {
        int[] tiempoDesglosado = new int[3];

        tiempoDesglosado[0] = segundos / 3600;
        segundos = segundos % 3600;
        tiempoDesglosado[1] = segundos / 60;
        tiempoDesglosado[2] = segundos % 60;

        return tiempoDesglosado;

    }

}
