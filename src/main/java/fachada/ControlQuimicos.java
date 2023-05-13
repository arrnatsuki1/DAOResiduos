/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Entidades.Quimico;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
public class ControlQuimicos {
    private IQuimicoDAO daoquimico;
     
    public ControlQuimicos() {
        daoquimico = new QuimicoDAO();
    }
    
    public List<Quimico> obtenerTodosLosQuimicos()  {
        return daoquimico.obtenerTodosLosQuimicos();
    };
    
}
