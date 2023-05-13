/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import Entidades.Residuo;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
interface IResiduoDAO {
    public List<Residuo> obtenerTodosLosResiduos();
    public boolean comprobarResiduo(Residuo residuo);
    public void guardarResiduo(Residuo residuo);
}
