/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class FacturaModel {
    private Conexion cnx = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int Id;
    private float Subtotal;
    private float Isv;
    private float Total;

    public FacturaModel(){}
    
    public FacturaModel(int Id, float Subtotal, float Isv, float Total) {
        this.Id = Id;
        this.Subtotal = Subtotal;
        this.Isv = Isv;
        this.Total = Total;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public float getIsv() {
        return Isv;
    }

    public void setIsv(float Isv) {
        this.Isv = Isv;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    
}
