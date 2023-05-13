/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import fachada.IDatos;
import fachada.FachadaDatos;

/**
 *
 * @author Rosa Rodriguez
 */
public class FabricaDatos {
    public static IDatos getInstance() {
        return new FachadaDatos();
    }
}
