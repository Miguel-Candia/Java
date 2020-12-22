/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.bd.BD;

/**
 *
 * @author 56956
 */
public class Empleado extends Administrador {

    private int id;
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private int cargo_id;

    public Empleado() {

    }

    public Empleado(int id, String rut, String nombre, String apellido, String email, String password, int cargo_id) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.cargo_id = cargo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public void ingresarEmpleado() throws SQLException {
        BD bd = new BD();
        Statement st = bd.getCon().createStatement();
        st.executeUpdate("INSERT INTO empleado (rut , nombre, apellido, email, password, cargo_id) "
                + "VALUES ('" + this.rut + "', '" + this.nombre + "', '" + this.apellido + "', '" + this.email + "', '" + this.password + "', " + this.cargo_id + ")");
        bd.close();
    }

    public void modificarEmpleado() throws SQLException {
        BD bd = new BD();
        Statement st = bd.getCon().createStatement();
        st.executeUpdate("UPDATE empleado SET rut = '" + this.rut + "', nombre = '" + this.nombre + "', apellido = '" + this.apellido + "', email = '" + this.email + "', password = '" + this.password + "', cargo_id = " + this.cargo_id + " WHERE id = " + this.id);
        bd.close();
    }

    public void eliminarEmpleado() throws SQLException {
        BD bd = new BD();
        Statement st = bd.getCon().createStatement();
        st.executeUpdate("DELETE FROM empleado WHERE id = " + this.id);
        bd.close();
    }

    public void consultarEmpleado(String rut) throws SQLException {
        BD bd = new BD();
        Statement st = bd.getCon().createStatement();
        Empleado empleado = new Empleado();
        ResultSet rs = st.executeQuery("select * from empleado where rut = '" + rut + "'");

        while (rs.next()) {

            this.id = rs.getInt(1);
            this.rut = rs.getString(2);
            this.nombre = rs.getString(3);
            this.apellido = rs.getString(4);
            this.email = rs.getString(5);
            this.password = rs.getString(6);
            this.cargo_id = rs.getInt(7);

        }
        bd.close();
    }

    public boolean loginEmpleado(String password, String nombre) throws SQLException {
        BD bd = new BD();
        Statement st = bd.getCon().createStatement();
        ResultSet rs = st.executeQuery("select * from empleado where nombre ='" + nombre + "' and password ='" + password + "'");

        while (rs.next()) {
            this.id = rs.getInt(1);
            this.rut = rs.getString(2);
            this.nombre = rs.getString(3);
            this.apellido = rs.getString(4);
            this.email = rs.getString(5);
            this.password = rs.getString(6);
            this.cargo_id = rs.getInt(7);

            bd.close();
            return true;
        }
        bd.close();
        return false;
    }
}
