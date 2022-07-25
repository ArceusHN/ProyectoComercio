/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ComprasAbonosModel;
import View.ComprasAbonosView;

/**
 *
 * @author osale
 */
public class ComprasAbonosController {
    private ComprasAbonosView comprasabonosVista;
    private ComprasAbonosModel comprasabonosModelo = new ComprasAbonosModel();

    public ComprasAbonosController(ComprasAbonosView comprasabonos) {
        this.comprasabonosVista = comprasabonos;
        InicializarVista();
    }
    
    public void InicializarVista(){}
    
    public void InicializarControlador(){
        comprasabonosVista.getBtnGuardar().addActionListener(e -> GuardarComprasAbonos());
        comprasabonosVista.getBtnCancelar().addActionListener(e -> CancelarComprasAbonos());
    }
    
    public void GuardarComprasAbonos(){
        int compraid = Integer.parseInt(comprasabonosVista.getTxtCompraId().getText());
        int proveedorbancoid = Integer.parseInt(comprasabonosVista.getTxtProveedorBancoId().getText());
        int nrocomprobante = Integer.parseInt(comprasabonosVista.getTxtNroComprobante().getText());
        float saldoabonado = Float.parseFloat(comprasabonosVista.getTxtSaldoAbonado().getText());
        
        ComprasAbonosModel comprasabonosModelo = new ComprasAbonosModel();
        comprasabonosModelo.setCompraId(compraid);
        comprasabonosModelo.setProveedorBancoId(proveedorbancoid);
        comprasabonosModelo.setNroComprobante(nrocomprobante);
        comprasabonosModelo.setSaldoAbonado(saldoabonado);
        
        comprasabonosModelo.AgregarComprasAbonos();
    }
    
    public void CancelarComprasAbonos(){
        comprasabonosVista.dispose();
    }
}
