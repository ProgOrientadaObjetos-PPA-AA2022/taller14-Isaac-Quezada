/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

/**
 *
 * @author Matias Quezada
 */
public class Trabajadores {

    private String nombre;
    private String cedula;
    private String correo;
    private double sueldo;
    private String mesSueldo;

     public  Trabajadores( String n,String c, String co, double su, String msue){
        nombre = n; 
        cedula = c; 
        correo = co; 
        sueldo = su; 
        mesSueldo = msue; 
    }
    
    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerCedula(String c) {
        cedula = c;
    }

    public void establecerCorreo(String rr) {
        correo = rr;
    }

    public void establecerSueldo(double d) {
        sueldo = d;
    }

    public void establecerMesSueldo(String ms) {
        mesSueldo = ms;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public String obtenerMesSueldo() {
        return mesSueldo;
    }

}
