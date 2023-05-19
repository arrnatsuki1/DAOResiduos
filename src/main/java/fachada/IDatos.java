/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface IDatos {
    List<Residuo> obtenerTodosLosResiduos();
    List<Residuo> obtenerTodosLosDeProductor(String productor) throws BaseException;
    boolean comprobarResiduo(Residuo residuo);
    void guardarResiduo(Residuo residuo);
    List<Quimico> obtenerTodosLosQuimicos()throws BaseException;
    public void guardarAsignacion(Asignacion a);
    public boolean haySolicitudFechaProductor(Solicitud s);
    public long verificaCantidadFecha(Date dia);
    public void guardarSolicitud(Solicitud s);
    public List<Solicitud> obtenerTodasLasSolicitudes() throws BaseException;
    public List<Empresa> obtenerTodasLasEmpresas() throws BaseException;
}
