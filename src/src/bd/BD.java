/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 56956
 */
public class BD {

    private String usuario = "root";
    private String clave = "root";
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private Connection con;

    public BD() throws SQLException {
        LoadDriver();
    }

    public Connection getCon() {
        return con;
    }

    public void close() throws SQLException {
        con.close();
    }
    

    public void LoadDriver() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex);
        }

        con = DriverManager.getConnection(url, usuario, clave);
    }
}
