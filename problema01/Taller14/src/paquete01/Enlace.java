/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete02.Trabajadores;

/**
 *
 * @author Matias Quezada
 */
public class Enlace {

    private Connection conn;

    public void establecerConexion() {
        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/trabajador.bd.db-journal";
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

    public void insertarTrabajadores(Trabajadores trabajadores) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO Trabajador( nombre,cedula,correo ,sueldo ,mesSueldo)"
                    + "values ('%s','%s' ,'%s' ,'%.2f' ,'%s')",
                    trabajadores.obtenerNombre(),
                    trabajadores.obtenerCedula(),
                    trabajadores.obtenerCorreo(),
                    trabajadores.obtenerSueldo(),
                    trabajadores.obtenerMesSueldo());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<Trabajadores> obtenerDataTrabajadores() {
        ArrayList<Trabajadores> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();  //statement permite ejecutar codigo SQL
            String data = "Select * from Trabajador;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Trabajadores empleado1 = new Trabajadores(rs.getString("nombre"),
                    rs.getString("cedula"),
                    rs.getString("correo"),
                    rs.getInt("sueldo"),
                    rs.getString("mesSueldo"));
                lista.add(empleado1);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
        return lista;
    }
}
