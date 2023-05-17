/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import Entidades.Asignacion;
import Entidades.Quimico;
import Entidades.Residuo;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
public interface IDatos {
    List<Residuo> obtenerTodosLosResiduos();
    boolean comprobarResiduo(Residuo residuo);
    void guardarResiduo(Residuo residuo);
    List<Quimico> obtenerTodosLosQuimicos();
    public void guardarAsignacion(Asignacion a);
}
