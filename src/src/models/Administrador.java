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
public class Administrador {
    
    
    private int id;
    private int claveSeguridad;
    
    public Administrador(){
    }

    public Administrador(int id, int claveSeguridad) {
        this.id = id;
        this.claveSeguridad = claveSeguridad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClaveSeguridad() {
        return claveSeguridad;
    }

    public void setClaveSeguridad(int claveSeguridad) {
        this.claveSeguridad = claveSeguridad;
    }
        public boolean loginAdministrador(String claveSeguridad, String nombre) throws SQLException {
        BD bd = new BD();
        Statement st = bd.getCon().createStatement();
        ResultSet rs = st.executeQuery("select * from empleado inner join administrador on empleado.administrador_id = administrador.id where nombre = '"+nombre+"' and clave_seguridad = '"+claveSeguridad+"'");
        boolean confirmed = (rs.next());
        bd.close();
        return true;
    }
    
}
