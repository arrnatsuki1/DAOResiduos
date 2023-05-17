/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fachada;

/**
 *
 * @author Rosa Rodriguez
 */
public class Datos2 {

    public static void main(String[] args) {
       QuimicoDAO d = new QuimicoDAO();
       for(Quimico q : d.obtenerTodosLosQuimicos()) {
           System.out.println(q.getNombre());
       }
    }
}
