/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BancoModel;
import Model.BancosProveedoresModel;
import Model.ProveedoresModel;
import View.BancosProveedoresView;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author osale
 */
public class BancosProveedoresController {
    private BancosProveedoresView BancosProveedoresVista;
    private BancosProveedoresModel bancosproveedoresModelo = new BancosProveedoresModel();
    private BancoModel bancoModelo = new BancoModel();
    private ProveedoresModel proveedoresModelo = new ProveedoresModel();

    public BancosProveedoresController(BancosProveedoresView bancosproveedores) {
        this.BancosProveedoresVista = bancosproveedores;
        InicializarVista();
    }
    
    public void InicializarVista(){
        
        ArrayList<BancoModel> listado = bancoModelo.ListarBanco();
        BancoModel[] comboBoxModel = listado.toArray(new BancoModel[0]);
        BancosProveedoresVista.getCboBancoId().setModel(new DefaultComboBoxModel<BancoModel>(comboBoxModel));
        
//        ArrayList<ProveedoresModel> listados = proveedoresModelo.ListarProveedores();
//        ProveedoresModel[] comboBoxModelo = listados.toArray(new ProveedoresModel[0]);
//        BancosProveedoresVista.getCboProveedorId().setModel(new DefaultComboBoxModel<ProveedoresModel>(comboBoxModelo));
    }
    
    public void InicializarControlador(){
        BancosProveedoresVista.getBtnGuardar().addActionListener(e -> GuardarBancosProveedores());
        BancosProveedoresVista.getBtnCancelar().addActionListener(e -> CancelarBancosProveedores());
        
    }
    
    public void GuardarBancosProveedores(){
        int nrocuentabancaria = Integer.parseInt(BancosProveedoresVista.getTxtNroCuentaBancaria().getText());
        int bancoid = BancosProveedoresVista.getCboBancoId().getItemAt(this. BancosProveedoresVista.getCboBancoId().getSelectedIndex()).getId();
        int proveedorid = BancosProveedoresVista.getCboProveedorId().getItemAt(this.BancosProveedoresVista.getCboProveedorId().getSelectedIndex()).getId();
        
        BancosProveedoresModel bancosproveedoresModelo = new BancosProveedoresModel();
        bancosproveedoresModelo.setNroCuentaBancaria(String.valueOf(nrocuentabancaria));
        bancosproveedoresModelo.setBancoId(bancoid);
        bancosproveedoresModelo.setProveedorId(proveedorid);
        
        bancosproveedoresModelo.AgregarBancoProveedores();
    }
    public void CancelarBancosProveedores(){
        BancosProveedoresVista.dispose();
    }
}
