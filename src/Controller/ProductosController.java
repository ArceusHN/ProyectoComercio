/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProductosModel;
import View.Productos.MainProductos;
import View.Productos.ProductoView;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fgarcia
 */
public class ProductosController {

    private MainProductos _mainProductos;    
    private ProductoView _Productos;
    private ProductosModel productosModel= new ProductosModel();
               
    public ProductosController(MainProductos productos) {
        _mainProductos=productos;
    }
    
     public void InicializarControlador(){
        _mainProductos.getBtnAgregar().addActionListener(e -> VistaAgregar()); 
        _mainProductos.getBtnActualizar().addActionListener(e -> VistaActualizar());
        _mainProductos.getBtnCancelar().addActionListener(e -> Volver());        
    }
    
      public void InicializarVista(){
         _Productos = new ProductoView();
         _Productos.gettxtInventarioGlobal().setText("0");
        ArrayList<ProductosModel> listado = productosModel.ListarProductos();
        llenarTablaProductos(listado);
    }
      
     private void llenarTablaProductos( ArrayList<ProductosModel> listado) {
        DefaultTableModel tabla =  new DefaultTableModel();
        String[] fila = new String[4];
        tabla.addColumn("Código");
        tabla.addColumn("Nombre");
        tabla.addColumn("Inventario Global");
        tabla.addColumn("Fecha Agregado");        
        for(int f=0; f<listado.size();f++){
            fila[0] = String.valueOf(listado.get(f).getId());
            fila[1] = listado.get(f).getDescripcion();
            fila[2] = String.valueOf(listado.get(f).getInventarioGlobal());
            fila[3] = listado.get(f).getFechaAgrega();
            tabla.addRow(fila);
        }
        _mainProductos.getTableProductos().setModel(tabla);
    }
     
    public void VistaAgregar(){
        _Productos.gettxtCodigo().setVisible(false);
        _Productos.getlblCodigo().setVisible(false);
        _Productos.setVisible(true);
        _Productos.getBtnCancelar().addActionListener(e -> VolverProducto());
        _Productos.getBtnSalvar().addActionListener(e->AgregarActualizarProducto(_Productos.gettxtDescripcion().getText(),0,
                Integer.parseInt(_Productos.gettxtInventarioGlobal().getText())));
    }
    
     public void VistaActualizar(){
        int row  = _mainProductos.getTableProductos().getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null,"Selecciona un producto","Actualizar Productos",JOptionPane.INFORMATION_MESSAGE);
        }else{
        _Productos.gettxtCodigo().setVisible(true);
        _Productos.getlblCodigo().setVisible(true);
        _Productos.setVisible(true);
        _Productos.gettxtCodigo().setText(_mainProductos.getTableProductos().getModel().getValueAt(row, 0).toString());
        _Productos.gettxtDescripcion().setText(_mainProductos.getTableProductos().getModel().getValueAt(row, 1).toString());
        _Productos.gettxtInventarioGlobal().setText(_mainProductos.getTableProductos().getModel().getValueAt(row, 2).toString());

        _Productos.getBtnCancelar().addActionListener(e -> VolverProducto());
        _Productos.getBtnSalvar().addActionListener(e->AgregarActualizarProducto(_Productos.gettxtDescripcion().getText(),
                Integer.parseInt(_Productos.gettxtCodigo().getText()),
                Integer.parseInt(_Productos.gettxtInventarioGlobal().getText())));
        }

    }
    public void Volver(){
        _mainProductos.setVisible(false);
    }
    public void VolverProducto(){
        _Productos.setVisible(false);
        InicializarVista();
    }
 
    public void AgregarActualizarProducto(String Descripcion,int Codigo,int Inventario){
        if(Codigo==0){
        try{      
        productosModel.setDescripcion(Descripcion);
        productosModel.setInventarioGlobal(Inventario);
        productosModel.AgregarProducto();
        _Productos.gettxtDescripcion().setText("");
        _Productos.gettxtInventarioGlobal().setText("0");
        JOptionPane.showMessageDialog(null,"Producto agregado exitosamente","Agregar Productos",JOptionPane.INFORMATION_MESSAGE);
        _Productos.setVisible(false);
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,"Ha ocurrido un error!","Agregar Productos",JOptionPane.ERROR_MESSAGE);
         _Productos.setVisible(false);
        }
       }
        else{
         try{
        productosModel.setId(Codigo);
        productosModel.setDescripcion(Descripcion);
        productosModel.setInventarioGlobal(Inventario);
        productosModel.ActualizarProducto();
        _Productos.gettxtDescripcion().setText("");        
        _Productos.gettxtCodigo().setText("");
        _Productos.gettxtInventarioGlobal().setText("0");
        JOptionPane.showMessageDialog(null,"Producto actualizado exitosamente","Actualizar Productos",JOptionPane.INFORMATION_MESSAGE);
        _Productos.setVisible(false);
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,"Ha ocurrido un error!","Actualizar Productos",JOptionPane.ERROR_MESSAGE);
         _Productos.setVisible(false);
        }
       }
      InicializarVista();
    }
}
