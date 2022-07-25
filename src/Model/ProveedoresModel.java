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
   
    // Constructores
    public ProveedoresModel() {
    }

    public ProveedoresModel(int Id, String Nombre,String Direccion,String Telefono,String CorreoElectronico) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.CorreoElectronico = CorreoElectronico;
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

    // CRUD
    
    public ArrayList<BancoModel> ListarBanco(){
        ArrayList<BancoModel> listado = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM Bancos";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                BancoModel banco = new BancoModel();
                banco.setId(rs.getInt("Id"));
                banco.setDescripcion(rs.getString("Descripcion"));
                
                listado.add(banco);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return listado;
    }
    
    public void AgregarProveedor(){
        try{
            String query = "INSERT INTO Proveedor(Nombre,Direccion,Telefono,CorreoElectronico, FechaAgrega) VALUES(?,?,?,?,CURRENT_DATE())";
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
    
}
