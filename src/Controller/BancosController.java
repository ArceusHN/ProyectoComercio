/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BancoModel;
import View.Banco;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Administrator
 */

public class BancosController {
    private Banco _bancos;
    private BancoModel bancoModelo = new BancoModel();
   
    public BancosController(Banco bancos){
        this._bancos = bancos;
        InicializarVista();
    }
    
    public void InicializarVista(){
        _bancos.getTxtDescripcion().setText("Hola soy omar");
        
        ArrayList<BancoModel> listado = bancoModelo.ListarBanco();
        BancoModel[] comboBoxModel = listado.toArray(new BancoModel[0]);  
        _bancos.getCboBancos().setModel(new DefaultComboBoxModel<BancoModel>(comboBoxModel));
    }
    
    public void InicializarControlador(){
        _bancos.getBtnGuardar().addActionListener(e -> GuardarBanco()); 
    }
    
    public void GuardarBanco(){
        
    }
}
