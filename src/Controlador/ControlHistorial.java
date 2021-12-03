/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Factura;
import Modelo.Historial;
import Modelo.Proyecto;
import Modelo.Usuario;
import Recursos.Database;
import Vista.HistorialCliente;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marisol
 */
public class ControlHistorial implements ActionListener {

    HistorialCliente actual;
    VistaPrincipal vp;
    Usuario user;
    Historial historial;
    
    public ControlHistorial(VistaPrincipal v, HistorialCliente a, Usuario u) {
        this.vp=v;
        this.actual=a;
        this.user=u;
        v.cambiarPanel(actual);
        System.out.println("control historial");
        this.actual.btn_bajaFactura.addActionListener(this);
        this.actual.btn_darBaja.addActionListener(this);
        this.actual.btn_detallesFactura1.addActionListener(this);
        this.actual.btn_detallesProy.addActionListener(this);
        this.actual.btn_editarProy.addActionListener(this);
        this.actual.btn_editarform.addActionListener(this);
        this.actual.btn_emitirfac.addActionListener(this);
        this.actual.btn_guardartodo.addActionListener(this);
        this.actual.btn_nuevaFactura.addActionListener(this);
        this.actual.btn_nuevoProy.addActionListener(this);
        this.actual.btn_buscarcuit.addActionListener(this);
        CambiarMensaje(this.user);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== actual.btn_buscarcuit) BuscarHistorial();
        if(e.getSource()== actual.btn_bajaFactura) DarBajaFactura();
        if(e.getSource()==actual.btn_darBaja); DarBajaCliente();
        if(e.getSource()==actual.btn_detallesFactura1)VerDetallesFactura();
        if(e.getSource()== actual.btn_detallesProy) VerDetallesProyecto();
        if(e.getSource()==actual.btn_editarProy); EditarProyecto();
        if(e.getSource()==actual.btn_editarform) DeshabilitarCampos();
        if(e.getSource()== actual.btn_emitirfac) EmitirFactura();
        if(e.getSource()==actual.btn_guardartodo) GuardarTodo();
        if(e.getSource()==actual.btn_nuevaFactura)NuevaFactura();
        if(e.getSource()== actual.btn_nuevoProy) NuevoProyecto();
       
    }
    
    
    private void CambiarMensaje(Usuario u){
        String apenom = u.getEmpleado().getApellido()+", "+u.getEmpleado().getNombre();
        String rol = u.isEsAdmin()==1? "Administrador":"No Administrador";
        String mensaje = "Usuario: "+apenom+" - Rol: "+rol;
        this.actual.lbl_infoUsuario.setText(mensaje);
    }
    private void DeshabilitarCampos() {
       actual.txt_direccion.setEnabled(true);
       actual.txt_mail.setEnabled(true);
       actual.txt_telefono.setEnabled(true);
    }
    private void llenarHistorial(Historial h) {
        
        LlenarDatosGenerales(h);
        LlenarTablaProyectos(h);
        LlenarFacturas(h);
        
        
    }
    private void BuscarHistorial() {
        Database db = new Database();
        int cuit = Integer.parseInt(actual.txt_busqueda.getText());
        boolean encontrado = db.validadCuit(cuit);
        
        if (encontrado){
            historial = db.obtenerHistorial(cuit);
            llenarHistorial(historial);
        }
        else {
            System.out.println("No se encontró el cliente");
        }
    }
    private void DarBajaCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void llenarCbox(){
        
    }
    private void LlenarDatosGenerales(Historial h) {
        actual.txt_cuit.setText(Integer.toString(h.getCliente().getCuit()));
        actual.txt_razonSocial.setText(h.getCliente().getRazonSocial());
        actual.txt_mail.setText(h.getCliente().getCorreoElectronico());
        actual.txt_telefono.setText(Integer.toString(h.getCliente().getTelefono()));
        actual.txt_direccion.setText(h.getCliente().getDomicilio().getDomicilio());
        
        actual.cb_localidad.setSelectedItem(h.getCliente().getDomicilio().getLocalidad());
        actual.cb_provincia.setSelectedItem(h.getCliente().getDomicilio().getProvincia());
        actual.cb_pais.setSelectedItem(h.getCliente().getDomicilio().getPais());
    }
    private void LlenarTablaProyectos(Historial h) {
        DefaultTableModel tablaProyectos = new DefaultTableModel();
        tablaProyectos.addColumn("id");
        tablaProyectos.addColumn("Nombre");
        tablaProyectos.addColumn("Descripción");
        tablaProyectos.addColumn("Fecha de inicio");
        tablaProyectos.addColumn("Horas empleadas");
        
        for(Proyecto p: h.getProyectos()){
            Object[]fila={
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                p.getFechInicio(),
                p.getHorasEmpleadas()
            }; tablaProyectos.addRow(fila);
            actual.table_proyectos.setModel(tablaProyectos);
                
            }
        }
    private void LlenarFacturas(Historial h) {
        DefaultTableModel tablaFactura = new DefaultTableModel();
        tablaFactura.addColumn("N° Factura");
        tablaFactura.addColumn("Fecha de creación");
        tablaFactura.addColumn("Horas total pagadas");
        tablaFactura.addColumn("Total");
      
        
        for(Factura f: h.getFacturas()){
            Object[]fila={
                f.getNroFactura(),
                f.getFechaEmisión(),
                f.getHorasTotalPagadas(),
                f.getTotal()
            }; tablaFactura.addRow(fila);
            actual.tabla_facturas.setModel(tablaFactura);
    }
    
        
        
    }

    private void DarBajaFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void VerDetallesFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void VerDetallesProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void EditarProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void EmitirFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void GuardarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void NuevaFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void NuevoProyecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    


