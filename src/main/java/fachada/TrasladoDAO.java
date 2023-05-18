/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Rosa Rodriguez
 */
class TrasladoDAO {
    
    private final String nombreColeccion = "SolicitudesMongo";
    
    public long cantidadTrasladosDia(Date dia) {
        MongoCollection collection = this.getCollection(Conexion.createInstance());
        
        long cantidad = collection.countDocuments
        (
                Filters.eq("fechaSalida", dia)
        );
        return cantidad;
    }
    
    private MongoCollection<Traslado> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<Traslado> collectionTaslado = db.getCollection(nombreColeccion, Traslado.class);
        return collectionTaslado;
    }
    
}
