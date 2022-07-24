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
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }
    
    // CRUD
    
    public ArrayList<FacturaModel> ListarFactura(){
        ArrayList<FacturaModel> listado = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM FacturasProveedor";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                FacturaModel factura = new FacturaModel();
                factura.setId(rs.getInt("Id"));
                factura.setIsv(rs.getFloat("ISV"));
                factura.setIsv(rs.getFloat("SubTotal"));
                factura.setIsv(rs.getFloat("SubTotal"));
                
                listado.add(factura);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return listado;
    }
    
    public void AgregarFactura(){
        try{
            String query = "INSERT INTO FacturasProveedor(SubTotal,ISV,Total,FechaAgrega) VALUES(?, ?, ?,CURRENT_DATE())";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            ps.setFloat(1, this.Subtotal);
            ps.setFloat(2, this.Isv);
            ps.setFloat(3, this.Total);
            
            ps.executeUpdate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
