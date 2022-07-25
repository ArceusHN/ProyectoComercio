/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Config.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author osale
 */
public class BancosProveedoresModel {
    private Conexion cnx = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int Id; 
    private int ProveedorId; 
    private int BancoId;
    private String NroCuentaBancaria;
    
    public BancosProveedoresModel(){
    }

    public BancosProveedoresModel(int Id, int ProveedorId, int BancoId, String NroCuentaBancaria) {
        this.Id = Id;
        this.ProveedorId = ProveedorId;
        this.BancoId = BancoId;
        this.NroCuentaBancaria = NroCuentaBancaria;
    }
    
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getNroCuentaBancaria() {
        return NroCuentaBancaria;
    }
    public void setNroCuentaBancaria(String NroCuentaBancaria) {
        this.NroCuentaBancaria = NroCuentaBancaria;
    }
    public int getProveedorId() {
        return ProveedorId;
    }
    public void setProveedorId(int ProveedorId) {
        this.ProveedorId = ProveedorId;
    }
    public int getBancoId() {
        return BancoId;
    }
    public void setBancoId(int BancoId) {
        this.BancoId = BancoId;
    }
    
    public ArrayList<BancosProveedoresModel> ListarBancoProveedores(){
        ArrayList<BancosProveedoresModel> listado = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM BancosProveedores";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                BancosProveedoresModel bancoproveedores = new BancosProveedoresModel();
                bancoproveedores.setId(rs.getInt("Id"));
                bancoproveedores.setNroCuentaBancaria(rs.getString("NroCuentaBancaria"));
                bancoproveedores.setBancoId(rs.getInt("BancoId"));
                bancoproveedores.setProveedorId(rs.getInt("ProveedorId"));
                
                listado.add(bancoproveedores);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listado;
    }
    public void AgregarBancoProveedores(){
        try{
            String query = "INSERT INTO BancosProveedores(NroCuentaBancaria, BancoId, ProveedorId) VALUES(?,?,?)";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, this.NroCuentaBancaria);
            ps.setInt(2, this.BancoId);
            ps.setInt(3, this.ProveedorId);
            
            ps.executeUpdate();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
