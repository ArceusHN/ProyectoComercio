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
 * @author Robredo
 */
public class ProveedoresModel {
     private Conexion cnx = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int Id;
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private String CorreoElectronico;
    private String FechaAgrega;
   
    // Constructores
    public ProveedoresModel() {
    }

    public ProveedoresModel(int Id, String Nombre,String Direccion,String Telefono,String CorreoElectronico, String FechaAgrega) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.CorreoElectronico = CorreoElectronico;
        this.FechaAgrega = FechaAgrega;
    }

    public String getFechaAgrega() {
        return FechaAgrega;
    }

    public void setFechaAgrega(String FechaAgrega) {
        this.FechaAgrega = FechaAgrega;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }
    @Override
    public String toString(){
       return this.Nombre;
    }

    // CRUD
    
 public ArrayList<ProveedoresModel> ListarProveedores(){
        ArrayList<ProveedoresModel> listado = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM Proveedor";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ProveedoresModel proveedores = new ProveedoresModel();
                proveedores.setId(rs.getInt("Id"));
                proveedores.setNombre(rs.getString("Nombre"));
                proveedores.setDireccion(rs.getString("Direccion"));
                proveedores.setTelefono(rs.getString("Telefono"));
                proveedores.setCorreoElectronico(rs.getString("CorreoElectronico"));
                proveedores.setFechaAgrega(rs.getString("FechaAgrega"));

                
                listado.add(proveedores);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return listado;
    }


    
    public void AgregarProveedor(){
        try{
            String query = "INSERT INTO Proveedor(Nombre,Direccion,Telefono,CorreoElectronico,FechaAgrega) VALUES(?,?,?,?,CURRENT_DATE())";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, Nombre);
            ps.setString(2, Direccion);
            ps.setString(3, Telefono);
            ps.setString(4, CorreoElectronico);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog (null, "Registro Guardado!", "Guardar", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
         public void ActualizarProveedor(){
        try{
            String query = "Update Proveedor set Nombre = ?, Direccion = ?, Telefono = ?, CorreoElectronico = ? where Id = ?";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
         
            ps.setString(1, Nombre);
            ps.setString(2, Direccion);
            ps.setString(3, Telefono);
            ps.setString(4, CorreoElectronico);
            ps.setInt(5, Id);
            
            
            ps.executeUpdate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
