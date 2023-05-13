/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Entidades.Quimico;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
public class QuimicoDAO{

    private String nombreColeccion = "Quimicos";
    
    public List<Quimico> obtenerTodosLosQuimicos() {
        Conexion c = Conexion.createInstance();
        MongoCollection collection = this.getCollection(c);
        
        MongoCursor<Quimico> quimicos = collection.find().iterator();
        
        
            List<Quimico> listaQuimicos = new ArrayList();
        
        while(quimicos.hasNext()) {
            listaQuimicos.add(quimicos.next());
        }
        return listaQuimicos;
    }
    
    
    private MongoCollection<Quimico> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("Quimicos");
        MongoCollection<Quimico> collecionQuimicos = db.getCollection(nombreColeccion, Quimico.class);
        return collecionQuimicos;
    } 
    
    
}
