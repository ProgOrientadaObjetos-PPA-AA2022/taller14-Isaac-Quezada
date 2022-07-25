/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import Paquete01.Enlace;

/**
 *
 * @author Matias Quezada
 */
public class Principal {
    public static void main(String[] args) {
        // TODO code application logic here
        Enlace c = new Enlace();
        for (int i = 0; i < c.obtenerDataEstudiante().size(); i++) {
            System.out.printf("%s", c.obtenerDataEstudiante().get(i));
        } 
        
    }
}
