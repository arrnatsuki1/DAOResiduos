/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.AsignacionMongo;
import EntidadesMongo.ResiduoMongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fachada.Asignacion;
import java.util.ArrayList;



/**
 *
 * @author Rosa Rodriguez
 */
class AsignacionesDAO {
    
    private String nombreColeccion = "Asignaciones";
    
    public void guardarAsignacion(Asignacion asignacion) {
        MongoCollection<AsignacionMongo> collection = getCollection(Conexion.createInstance());
        
        AsignacionMongo am = new AsignacionMongo();
        am.setCantidadTotal(asignacion.getCantidadTotal());
        am.setResiduo(asignacion.getResiduo());
        am.setTraslados(new ArrayList());
        
        collection.insertOne(am);
        //Lo que tenga que hacer para guardar
        
    }
    
    private MongoCollection<AsignacionMongo> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<AsignacionMongo> collecionAsignaciones = db.getCollection(nombreColeccion, AsignacionMongo.class);
        return collecionAsignaciones;
    }
    
}
