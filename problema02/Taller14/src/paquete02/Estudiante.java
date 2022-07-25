/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

import java.util.ArrayList;

/**
 *
 * @author Matias Quezada
 */
public class Estudiante {

    public String nombre;
    public String apellido;
    public double calificacion1;
    public double calificacion2;
    public double calificacion3;
    public double promedio;
    
    

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void establecerApellido(String apellido) {
        this.apellido = apellido;
    }

    public double obtenerCalificacion1() {
        return calificacion1;
    }

    public void establecerCalificacion1(double calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public double obtenerCalificacion2() {
        return calificacion2;
    }

    public void establecerCalificacion2(double calificacion2) {
        this.calificacion2 = calificacion2;
    }

    public double obtenerCalificacion3() {
        return calificacion3;
    }

    public void establecerCalificacion3(double calificacion3) {
        this.calificacion3 = calificacion3;
    }
    public double obtenerPromedio() {
        return promedio;
    }

    public void establecerPromedio() {
        promedio = (calificacion1 + calificacion2 + calificacion3) / 3;
    }
    
    
     @Override
    public String toString(){
        String data = String.format("\n%s"+"%s\n"+"\n"
                + "calificacion1: %.2f\n"
                + "calificacion2: %.2f\n"
                + "calificacion3: %.2f\n"
                + "promedio: %.2f\n", 
                nombre,
                apellido,
                calificacion1,
                calificacion2,
                calificacion3,
                promedio);
        return data;
    }

}

