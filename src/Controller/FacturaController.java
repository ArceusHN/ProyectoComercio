/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FacturaModel;
import View.Factura.FacturaView;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Administrator
 */
public class FacturaController {
    private FacturaView FacturaVista;
    private FacturaModel FacturaModelo = new FacturaModel();
   
    public FacturaController(FacturaView factura){
        this.FacturaVista = factura;
        InicializarVista();
    }
    
    public void InicializarVista(){
        
    }
    
    public void InicializarControlador(){
        FacturaVista.getBtnGuardar().addActionListener(e -> GuardarFactura()); 
        FacturaVista.getBtnCancelar().addActionListener(e -> CancelarOperacion());
    }
    
    public void GuardarFactura(){
        float ISV = Float.parseFloat(FacturaVista.getTxtIsv().getText());
        float SubTotal = Float.parseFloat(FacturaVista.getTxtSubtotal().getText());
        float Total = Float.parseFloat(FacturaVista.getTxtIsv().getText());

        FacturaModel facturaModelo = new FacturaModel();
        facturaModelo.setIsv(ISV);
        facturaModelo.setTotal(Total);
        facturaModelo.setSubtotal(SubTotal);
        
        facturaModelo.AgregarFactura();
    }
    
    public void CancelarOperacion(){
        FacturaVista.dispose();
    }
    
}
