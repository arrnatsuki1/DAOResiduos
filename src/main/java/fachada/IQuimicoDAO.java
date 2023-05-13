/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import Entidades.Quimico;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
public interface IQuimicoDAO {
    public List<Quimico> obtenerTodosLosQuimicos();
}
