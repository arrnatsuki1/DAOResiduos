/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;


import Excepciones.BaseException;
import fachada.Asignacion;
import fachada.Quimico;
import fachada.Residuo;
import java.util.Calendar;
import java.util.Date;
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
        daoasignaciones.guardarAsignacion(a);
    }   
    
    @Override
    public List<Residuo> obtenerTodosLosResiduos(){
        return daoresiduos.obtenerTodosLosResiduos();
    }

    @Override
    public boolean comprobarResiduo(Residuo residuo) {
        return daoresiduos.comprobarResiduo(residuo);
    }

    @Override
    public void guardarResiduo(Residuo residuo) {
        daoresiduos.guardarResiduo(residuo);
    }

    @Override
    public List<Quimico> obtenerTodosLosQuimicos() throws BaseException {
        return daoquimicos.obtenerTodosLosQuimicos();
    }

    @Override
    public List<Residuo> obtenerTodosLosDeProductor(String productor) throws BaseException {
        return daoresiduos.obtenerTodosLosResiduosDeProductor(productor);
    }

    @Override
    public boolean haySolicitudFechaProductor(Solicitud s) {
        return daosolicitudes.haySolicitudFechaProductor(s);
    }
    @Override
    public long verificaCantidadFecha(Date dia) {
        return daotraslados.cantidadTrasladosDia(dia);
    }

    @Override
    public void guardarSolicitud(Solicitud s) {
        daosolicitudes.guardarSolicitud(s);
    }

    @Override
    public List<Solicitud> obtenerTodasLasSolicitudes() throws BaseException {
        return daosolicitudes.obtenerTodasLasSolicitudes();
    }

    @Override
    public List<Empresa> obtenerTodasLasEmpresas() throws BaseException {
        return daoempresas.obtenerTodasLasEmpresas();
    }
    
    

}
