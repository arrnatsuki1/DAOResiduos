/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Entidades.Quimico;
import fachada.ControlResiduos;
import Entidades.Residuo;
import fachada.IDatos;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
class FachadaDatos implements IDatos {

    private ControlResiduos controlResiduos;
    private ControlQuimicos controlQuimicos;
    
    public FachadaDatos() {
        controlQuimicos = new ControlQuimicos();
        controlResiduos = new ControlResiduos();
    }
    
    @Override
    public List<Residuo> obtenerTodosLosResiduos() {
        return controlResiduos.obtenerTodosLosResiduos();
    }

    @Override
    public boolean comprobarResiduo(Residuo residuo) {
        return controlResiduos.comprobarResiduo(residuo);
    }

    @Override
    public void guardarResiduo(Residuo residuo) {
        controlResiduos.guardarResiduo(residuo);
    }

    @Override
    public List<Quimico> obtenerTodosLosQuimicos() {
        return controlQuimicos.obtenerTodosLosQuimicos();
    }

}
