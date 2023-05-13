/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Entidades.Residuo;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
class ControlResiduos {
    
    private IResiduoDAO daoresiduo;

    public ControlResiduos() {
        daoresiduo = new ResiduoDAO();
    }

    public ControlResiduos(IResiduoDAO daoresiduo) {
        this.daoresiduo = daoresiduo;
    }
  
    public List<Residuo> obtenerTodosLosResiduos() {
        return daoresiduo.obtenerTodosLosResiduos();
    }
    
    public boolean comprobarResiduo(Residuo residuo) {
        return daoresiduo.comprobarResiduo(residuo);
    }
    
    public void guardarResiduo(Residuo residuo) {
        daoresiduo.guardarResiduo(residuo);
    }
    
}
