/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.AsignacionMongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fachada.Asignacion;
import java.util.ArrayList;



/**
 *
 * @author Rosa Rodriguez
 */
class AsignacionesDAO {
    
    private final String nombreColeccion = "AsignacionesMongo";
    
    public void guardarAsignacion(Asignacion asignacion) {
        MongoCollection<AsignacionMongo> collection = getCollection(Conexion.createInstance());        
        AsignacionMongo asignacionm = transformar(asignacion);
        collection.insertOne(asignacionm);
    }
    
    private AsignacionMongo transformar(Asignacion a) {
        AsignacionMongo am = new AsignacionMongo();
        am.setCantidadTotal(a.getCantidadTotal());
        am.setResiduo(a.getResiduo());
        am.setTraslados(new ArrayList());
        am.setEmpresas(a.getEmpresas());
        return am;
    }
    
    private MongoCollection<AsignacionMongo> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<AsignacionMongo> collecionAsignaciones = db.getCollection(nombreColeccion, AsignacionMongo.class);
        return collecionAsignaciones;
    }
    
}
