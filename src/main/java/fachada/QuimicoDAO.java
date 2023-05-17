/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.ResiduoMongo;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import fachada.Quimico;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
public class QuimicoDAO{

    private final String nombreColeccion = "ResiduoMongo";
    
    public List<Quimico> obtenerTodosLosQuimicos() {
        
        //YUPIII SI CONSIGUE TODOS LOS QUIMICOS Y NO LOS REPITEEE
        
        Conexion c = Conexion.createInstance();     
        MongoCollection collection = this.getCollection(c);
   
        DistinctIterable lista = 
                collection.distinct("quimicos", String.class);
        
        MongoCursor<String> a = lista.iterator();
        
        List<Quimico> quimicos = new ArrayList();
        
        while(a.hasNext()) {
            quimicos.add(new Quimico(a.next()));
        }
        
        return quimicos;
    }
    
    private MongoCollection<ResiduoMongo> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<ResiduoMongo> collecionQuimicos = db.getCollection(nombreColeccion, ResiduoMongo.class);
        return collecionQuimicos;
    }
}
