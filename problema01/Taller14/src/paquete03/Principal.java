/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.sql.SQLException;
import java.util.Scanner;
import paquete01.Enlace;
import paquete02.Trabajadores;

/**
 *
 * @author Matias Quezada
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        Scanner leer = new Scanner(System.in);
        Enlace c = new Enlace();
        boolean bandera = true;

        while (bandera) {
            System.out.println("Ingrese la cedula del Trabajador");
            String cedula = leer.nextLine();
            System.out.println("Ingres el nombre");
            String nombre = leer.nextLine();
            System.out.println("Ingrese el Correo");
            String correo = leer.nextLine();
            System.out.println("Ingrese el Sueldo");
            double sueldo = leer.nextDouble();
            leer.nextLine();
            System.out.println("Ingrese el mes del Sueldo");
            String mes = leer.nextLine();
            
            Trabajadores tra1 = new Trabajadores(cedula,nombre,correo,sueldo,mes);
            c.insertarTrabajadores(tra1);
            
            System.out.println("Ingrese (SI) para salir del programa");
            String condicion = leer.nextLine();            
            if (condicion.equals("SI")) {
                bandera = false;
            }
        }
    }
}
