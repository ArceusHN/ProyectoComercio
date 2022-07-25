/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author osale
 */
public class ComprasModel {
    private Conexion cnx = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int Id;
    private int ProveedorId;
    private int FacturaId;
    private int PlazoDias;
    private float SaldoInicial;
    private float SaldoActual;
    private boolean Cancelado; 
    
    public ComprasModel(){}

    public ComprasModel(int ProveedorId, int FacturaId, int PlazoDias, float SaldoInicial, float SaldoActual, boolean Cancelado) {
        this.ProveedorId = ProveedorId;
        this.FacturaId = FacturaId;
        this.PlazoDias = PlazoDias;
        this.SaldoInicial = SaldoInicial;
        this.SaldoActual = SaldoActual;
        this.Cancelado = Cancelado;
    }
    
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public int getProveedorId() {
        return ProveedorId;
    }
    public void setProveedorId(int ProveedorId) {
        this.ProveedorId = ProveedorId;
    }
    public int getFacturaId() {
        return FacturaId;
    }
    public void setFacturaId(int FacturaId) {
        this.FacturaId = FacturaId;
    }
    public int getPlazoDias() {
        return PlazoDias;
    }
    public void setPlazoDias(int PlazoDias) {
        this.PlazoDias = PlazoDias;
    }
    public float getSaldoInicial() {
        return SaldoInicial;
    }
    public void setSaldoInicial(float SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }
    public float getSaldoActual() {
        return SaldoActual;
    }
    public void setSaldoActual(float SaldoActual) {
        this.SaldoActual = SaldoActual;
    }
    public boolean isCancelado() {
        return Cancelado;
    }
    public void setCancelado(boolean Cancelado) {
        this.Cancelado = Cancelado;
    }
    
    public ArrayList<ComprasModel> ListarCompras(){
        ArrayList<ComprasModel> listado = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM Compras";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ComprasModel compras = new ComprasModel();
                compras.setId(rs.getInt("Id"));
                compras.setProveedorId(rs.getInt("ProveedorId"));
                compras.setFacturaId(rs.getInt("FacturaId"));
                compras.setSaldoInicial(rs.getFloat("SaldoInicial"));
                compras.setSaldoActual(rs.getFloat("SaldoActual"));
                compras.setPlazoDias(rs.getInt("PlazoDias"));
                compras.setCancelado(rs.getBoolean("Cancelado"));
                
                listado.add(compras);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return listado;
    }
    
    public void AgregarCompras(){
        try{
            String query = "INSERT INTO Compras(ProveedorId,FacturaId,SaldoInicial,SaldoActual,PlazoDias,FechaAgrega,Cancelado) VALUES(?,?,?,?,?,CURRENT_DATE(),0)";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.ProveedorId);
            ps.setInt(2, this.FacturaId);
            ps.setFloat(3, this.SaldoInicial);
            ps.setFloat(4, this.SaldoActual);
            ps.setInt(5, this.PlazoDias);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog (null, "Registro Guardado!", "Guardar", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
