/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProductosModel;
import Model.ProveedoresModel;
import View.Productos.MainProductos;
import View.Productos.ProductoView;
import View.Proveedores.MainProveedores;
import View.Proveedores.ProveedoresView;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robredo
 */
public class ProveedoresController {
    private MainProveedores _mainProveedores;    
    private ProveedoresView _Proveedores;
    private ProveedoresModel proveedoresModel= new ProveedoresModel();
               
    public ProveedoresController(MainProveedores proveedores) {
        _mainProveedores=proveedores;
    }
    
    
        public void InicializarControlador(){
        _mainProveedores.getBtnAgregarProveedor().addActionListener(e -> VistaAgregar()); 
        _mainProveedores.getBtnActualizarProveedor().addActionListener(e -> VistaActualizar());
        _mainProveedores.getBtnCancelar().addActionListener(e -> Volver());        
    }
    
      public void InicializarVista(){
         _Proveedores = new ProveedoresView();
           ArrayList<ProveedoresModel> listado = proveedoresModel.ListarProveedores();
        llenarTablaProveedores(listado);
    }
      
      private void llenarTablaProveedores( ArrayList<ProveedoresModel> listado) {
        DefaultTableModel tabla =  new DefaultTableModel();
        String[] fila = new String[6];
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Direccion");
        tabla.addColumn("Telefono");     
        tabla.addColumn("Correo"); 
        tabla.addColumn("Fecha"); 
        
        for(int f=0; f<listado.size();f++){
            fila[0] = String.valueOf(listado.get(f).getId());
            fila[1] = listado.get(f).getNombre();
            fila[2] = listado.get(f).getDireccion();
            fila[3] = listado.get(f).getTelefono();
            fila[4] = listado.get(f).getCorreoElectronico();
            fila[5] = listado.get(f).getFechaAgrega();
            tabla.addRow(fila);
        }
        _mainProveedores.getTbProveedores().setModel(tabla);
    }
     
      
          public void VistaAgregar(){
        _Proveedores.getTxtId().setVisible(false);
        _Proveedores.getLbid().setVisible(false);
        _Proveedores.setVisible(true);
        _Proveedores.getBtnCancelar().addActionListener(e -> VolverProveedor());
        _Proveedores.getBtnGuardar().addActionListener(e->AgregarActualizarProveedor(0,_Proveedores.getTxtNombre().getText(),_Proveedores.getTxtDireccion().getText(),_Proveedores.getTxtTelefono().getText(),_Proveedores.getTxtCorreo().getText()));
    }
          public void VistaActualizar(){
        int row  = _mainProveedores.getTbProveedores().getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null,"Selecciona un proveedor","Actualizar Proveedor",JOptionPane.INFORMATION_MESSAGE);
        }else{
        _Proveedores.getTxtId().setVisible(true);
        _Proveedores.getLbid().setVisible(true);
        _Proveedores.setVisible(true);
        _Proveedores.getTxtId().setText(_mainProveedores.getTbProveedores().getModel().getValueAt(row, 0).toString());
        _Proveedores.getTxtNombre().setText(_mainProveedores.getTbProveedores().getModel().getValueAt(row, 1).toString());
        _Proveedores.getTxtDireccion().setText(_mainProveedores.getTbProveedores().getModel().getValueAt(row, 2).toString());
        _Proveedores.getTxtTelefono().setText(_mainProveedores.getTbProveedores().getModel().getValueAt(row, 3).toString());
        _Proveedores.getTxtCorreo().setText(_mainProveedores.getTbProveedores().getModel().getValueAt(row, 4).toString());

        _Proveedores.getBtnCancelar().addActionListener(e -> VolverProveedor());
        _Proveedores.getBtnGuardar().addActionListener(e->AgregarActualizarProveedor(Integer.parseInt(_Proveedores.getTxtId().getText()),_Proveedores.getTxtNombre().getText(),_Proveedores.getTxtDireccion().getText(),_Proveedores.getTxtTelefono().getText(),_Proveedores.getTxtCorreo().getText()));
        }

    }
    public void Volver(){
        _mainProveedores.setVisible(false);
    }
    public void VolverProveedor(){
        _Proveedores.setVisible(false);
        InicializarVista();
    }
 
    public void AgregarActualizarProveedor(int id, String nombre,String direccion,String  telefono, String correo){
        if(id==0){
        try{      
        proveedoresModel.setNombre(nombre);
        proveedoresModel.setDireccion(direccion);
        proveedoresModel.setTelefono(telefono);
        proveedoresModel.setCorreoElectronico(correo);
        proveedoresModel.AgregarProveedor();
        _Proveedores.getTxtNombre().setText("");
        _Proveedores.getTxtDireccion().setText("");
        _Proveedores.getTxtTelefono().setText("");
        _Proveedores.getTxtCorreo().setText("");
  
        JOptionPane.showMessageDialog(null,"Proveedor agregado exitosamente!","Agregar Proveedor",JOptionPane.INFORMATION_MESSAGE);
        _Proveedores.setVisible(false);
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,"Ha ocurrido un error!","Agregar Proveedor",JOptionPane.ERROR_MESSAGE);
         _Proveedores.setVisible(false);
        }
       }
        else{
         try{
        proveedoresModel.setId(id);
        proveedoresModel.setNombre(nombre);
        proveedoresModel.setDireccion(direccion);
        proveedoresModel.setTelefono(telefono);
        proveedoresModel.setCorreoElectronico(correo);
      
        proveedoresModel.ActualizarProveedor();
        
        _Proveedores.getTxtId().setText("");
        _Proveedores.getTxtNombre().setText("");
        _Proveedores.getTxtDireccion().setText("");
        _Proveedores.getTxtTelefono().setText("");
        _Proveedores.getTxtCorreo().setText("");
        JOptionPane.showMessageDialog(null,"Proveedor actualizado exitosamente!","Actualizar Proveedor",JOptionPane.INFORMATION_MESSAGE);
        _Proveedores.setVisible(false);
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,"Ha ocurrido un error!","Actualizar Proveedor",JOptionPane.ERROR_MESSAGE);
         _Proveedores.setVisible(false);
        }
       }
      InicializarVista();
    }
}
