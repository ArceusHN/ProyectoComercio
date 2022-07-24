/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class BancoModel{
    private Conexion cnx = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int Id;
    private String Descripcion;
   
    // Constructores
    public BancoModel() {
    }

    public BancoModel(int Id, String Descripcion) {
        this.Id = Id;
        this.Descripcion = Descripcion;
    }

    // Propiedades
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
    
    public void AgregarBanco(){
        try{
            String query = "INSERT INTO Bancos(Descripcion, FechaAgrega) VALUES(?,CURRENT_DATE())";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, Descripcion);
            
            ps.executeUpdate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
