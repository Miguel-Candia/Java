/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import src.bd.BD;

/**
 *
 * @author 56956
 */
public class Cargo {

    private int id;
    private String nombre;

    public Cargo() {
    }

    public Cargo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cargo> getCargos() throws SQLException {
        BD bd = new BD();
        Statement s = bd.getCon().createStatement();
        List<Cargo> listCargo = new ArrayList<>();
        ResultSet rs = s.executeQuery("select * from cargo");

        while (rs.next()) {
            listCargo.add(new Cargo(rs.getInt(1), rs.getString(2)));
        }
        bd.close();
        return listCargo;
    }
}
