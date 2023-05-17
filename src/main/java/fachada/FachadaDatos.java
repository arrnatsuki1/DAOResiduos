/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;


import fachada.Asignacion;
import fachada.Quimico;
import fachada.Residuo;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
class FachadaDatos implements IDatos {

    private EmpresasDAO daoempresas;
    private QuimicoDAO daoquimicos;
    private TrasladoDAO daotraslados;
    private TransportesDAO daotransportes;
    private SolicitudesDAO daosolicitudes;
    private ResiduoDAO daoresiduos;
    private AsignacionesDAO daoasignaciones;
    
    public FachadaDatos() {
        this.daoempresas = new EmpresasDAO();
        this.daoquimicos = new QuimicoDAO();
        this.daoresiduos = new ResiduoDAO();
        this.daosolicitudes = new SolicitudesDAO();
        this.daotransportes = new TransportesDAO();
        this.daotraslados = new TrasladoDAO();
        this.daoasignaciones = new AsignacionesDAO();
    }
    
    @Override
    public void guardarAsignacion(Asignacion a) {
        
    }   
    
    @Override
    public List<Residuo> obtenerTodosLosResiduos() {
        return null;
    }

    @Override
    public boolean comprobarResiduo(Residuo residuo) {
        return false;
    }

    @Override
    public void guardarResiduo(Residuo residuo) {
    }

    @Override
    public List<Quimico> obtenerTodosLosQuimicos() {
        return daoquimicos.obtenerTodosLosQuimicos();
    }

}
