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
public class FacturaDetalleModel {
    private Conexion cnx = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int Id;
    private int ProductoId;
    private int FacturaId;
    private int Cantidad;
    private float PrecioUnitario;
    private float Subtotal;

    public FacturaDetalleModel(){}
    public FacturaDetalleModel(int Id, int ProductoId, int FacturaId, int Cantidad, float PrecioUnitario, float Subtotal) {
        this.Id = Id;
        this.ProductoId = ProductoId;
        this.FacturaId = FacturaId;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Subtotal = Subtotal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getProductoId() {
        return ProductoId;
    }

    public void setProductoId(int ProductoId) {
        this.ProductoId = ProductoId;
    }

    public int getFacturaId() {
        return FacturaId;
    }

    public void setFacturaId(int FacturaId) {
        this.FacturaId = FacturaId;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }
   
}
