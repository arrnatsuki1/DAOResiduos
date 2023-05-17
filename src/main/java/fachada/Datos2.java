/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fachada;

import EntidadesMongo.ResiduoMongo;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Rosa Rodriguez
 */
public class Datos2 {

    public static void main(String[] args) {
        ResiduoDAO rs = new ResiduoDAO();
        Residuo r = new Residuo();
        r.setCodigo("12345");
        r.setNombre("HOLA123");
        r.setQuimicos(Arrays.asList(new Quimico("Hol"), new Quimico("Adio")));
        
        ResiduoMongo rm = new ResiduoMongo();
        rm.setNombre(r.getNombre());
        rm.setQuimicos(r.getQuimicos());
        rm.setCodigo(r.getCodigo());
        
        System.out.println(rs.comprobarResiduo(r));;
        
        
    }
}
