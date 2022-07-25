/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProveedoresModel;
import View.ProveedoresView;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Robredo
 */
public class ProveedoresController {
    private ProveedoresView ProveedoresVista;
    private ProveedoresModel proveedoresModelo = new ProveedoresModel();
   
    public ProveedoresController(ProveedoresView proveedores){
        this.ProveedoresVista = proveedores;
        InicializarVista();
    }
    
    public void InicializarVista(){
        ProveedoresVista.getTxtNombre().setText("");
        ProveedoresVista.getTxtCorreo().setText("");
        ProveedoresVista.getTxtDireccion().setText("");
        ProveedoresVista.getTxtTelefono().setText("");
    }
    
    public void InicializarControlador(){
        ProveedoresVista.getBtnGuardar().addActionListener(e -> GuardarProveedor()); 
        ProveedoresVista.getBtnCancelar().addActionListener(e -> CancelarOperacion());
  
    }
    
    public void GuardarProveedor(){
        String nombre = ProveedoresVista.getTxtNombre().getText();
        String correo = ProveedoresVista.getTxtCorreo().getText();
        String direccion = ProveedoresVista.getTxtDireccion().getText();
        String telefono = ProveedoresVista.getTxtTelefono().getText();
        
        ProveedoresModel proveedoresModelo = new ProveedoresModel();
        proveedoresModelo.setNombre(nombre);
        proveedoresModelo.setCorreoElectronico(correo);
        proveedoresModelo.setDireccion(direccion);
        proveedoresModelo.setTelefono(telefono);
        
        proveedoresModelo.AgregarProveedor();
    }
    
    public void CancelarOperacion(){
        ProveedoresVista.dispose();
    }
       
}
