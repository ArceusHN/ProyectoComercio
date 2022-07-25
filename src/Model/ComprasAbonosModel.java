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
public class ComprasAbonosModel {
     private Conexion cnx = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int Id;
    private int CompraId;
    private int ProveedorBancoId;
    private int NroComprobante;
    private float SaldoAbonado;
    
    public ComprasAbonosModel(){}
    public ComprasAbonosModel(int Id, int CompraId, int ProveedorBancoId, int NroComprobante, float SaldoAbonado) {
        this.Id = Id;
        this.CompraId = CompraId;
        this.ProveedorBancoId = ProveedorBancoId;
        this.NroComprobante = NroComprobante;
        this.SaldoAbonado = SaldoAbonado;
    }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public int getCompraId() {
        return CompraId;
    }
    public void setCompraId(int CompraId) {
        this.CompraId = CompraId;
    }
    public int getProveedorBancoId() {
        return ProveedorBancoId;
    }
    public void setProveedorBancoId(int ProveedorBancoId) {
        this.ProveedorBancoId = ProveedorBancoId;
    }
    public int getNroComprobante() {
        return NroComprobante;
    }
    public void setNroComprobante(int NroComprobante) {
        this.NroComprobante = NroComprobante;
    }
    public float getSaldoAbonado() {
        return SaldoAbonado;
    }
    public void setSaldoAbonado(float SaldoAbonado) {
        this.SaldoAbonado = SaldoAbonado;
    }
  
    public ArrayList<ComprasAbonosModel> ListarComprasAbonos(){
        ArrayList<ComprasAbonosModel> listado = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM ComprasAbonos";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ComprasAbonosModel comprasabonos = new ComprasAbonosModel();
                comprasabonos.setId(rs.getInt("Id"));
                comprasabonos.setCompraId(rs.getInt("CompraId"));
                comprasabonos.setProveedorBancoId(rs.getInt("ProveedorBancoId"));
                comprasabonos.setNroComprobante(rs.getInt("NroComprobante"));
                comprasabonos.setSaldoAbonado(rs.getFloat("SaldoAbonado"));
                
                listado.add(comprasabonos);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return listado;
    }
    
    public void AgregarComprasAbonos(){
        try{
            String query = "INSERT INTO ComprasAbonos(CompraId,ProveedorBancoId,SaldoAbonado,NroComprobante,FechaAbono,FechaAgrega) VALUES(?,?,?,?,CURRENT_DATE(),CURRENT_DATE())";
            con = cnx.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, this.CompraId);
            ps.setInt(2, this.ProveedorBancoId);
            ps.setFloat(3, this.SaldoAbonado);
            ps.setInt(4, this.NroComprobante);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog (null, "Registro Guardado!", "Guardar", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
