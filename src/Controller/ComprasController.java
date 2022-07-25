 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ComprasModel;
import View.ComprasView;
/**
 *
 * @author osale
 */
public class ComprasController {
    private ComprasView comprasVista;
    private ComprasModel comprasModelo;

    public ComprasController(ComprasView compras) {
        this.comprasVista = compras;
        InicializarVista();
    }
    
    public void InicializarVista(){}
    
    public void InicializarControlador(){
        comprasVista.getBtnGuardar().addActionListener( e -> GuardarCompras());
        comprasVista.getBtnCancelar().addActionListener(e -> CancelarCompras());
    }
    
    public void GuardarCompras(){
        int proveedorid = Integer.parseInt(comprasVista.getTxtProveedorId().getText());
        int facturaid = Integer.parseInt(comprasVista.getTxtFacturaId().getText());
        int plazodias = Integer.parseInt(comprasVista.getTxtPlazoDias().getText());
        float saldoinicial = Float.parseFloat(comprasVista.getTxtSaldoInicial().getText());
        float saldoactual = Float.parseFloat(comprasVista.getTxtSaldoActual().getText());
        
        ComprasModel comprasModelo = new ComprasModel();
        comprasModelo.setProveedorId(proveedorid);
        comprasModelo.setFacturaId(facturaid);
        comprasModelo.setPlazoDias(plazodias);
        comprasModelo.setSaldoInicial(saldoinicial);
        comprasModelo.setSaldoActual(saldoactual);
        
        comprasModelo.AgregarCompras();
    }
    public void CancelarCompras(){
        comprasVista.dispose();
    }
    
}
