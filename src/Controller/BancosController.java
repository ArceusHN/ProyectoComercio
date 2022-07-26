/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BancoModel;
import View.BancoView;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Administrator
 */

public class BancosController {
    private BancoView BancoVista;
    private BancoModel bancoModelo = new BancoModel();
   
    public BancosController(BancoView bancos){
        this.BancoVista = bancos;
        InicializarVista();
    }
    
    public void InicializarVista(){
        BancoVista.getTxtDescripcion().setText("");   
    }
    
    public void InicializarControlador(){
        BancoVista.getBtnGuardar().addActionListener(e -> GuardarBanco()); 
        BancoVista.getBtnCancelar().addActionListener(e -> CancelarOperacion());
    }
    
    public void GuardarBanco(){
        String descripcion = BancoVista.getTxtDescripcion().getText();
        BancoModel bancoModelo = new BancoModel();
        bancoModelo.setDescripcion(descripcion);
        
        bancoModelo.AgregarBanco();
    }
    
    public void CancelarOperacion(){
        BancoVista.dispose();
    }
}
