/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete02.Estudiante;

/**
 *
 * @author Matias Quezada
 */
public class Enlace {

    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/base001.base";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarEstudiante(Estudiante estudiante) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO estudiante (nombre,"
                    + "apellido, calificacion1, calificacion2, calificacion3)"
                    + "values ('%s', '%s', '%.2f', '%.2f', '%.2f')",
                    estudiante.obtenerNombre(),
                    estudiante.obtenerApellido(), 
                    estudiante.obtenerCalificacion1(),
                    estudiante.obtenerCalificacion2(),
                    estudiante.obtenerCalificacion3());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarEstudiante");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<Estudiante> obtenerDataEstudiante() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Estudiante;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Estudiante estu = new Estudiante();
                estu.establecerNombre(rs.getString("nombre"));
                estu.establecerApellido(rs.getString("apellido"));
                estu.establecerCalificacion1(rs.getDouble("calificacion1"));
                estu.establecerCalificacion2(rs.getDouble("calificacion2"));
                estu.establecerCalificacion3(rs.getDouble("calificacion3"));
                lista.add(estu);
                estu.establecerPromedio();
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCiudad");
            System.out.println(e.getMessage());

        }
        return lista;
    }
}
