/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.ResiduoMongo;
import Excepciones.BaseException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
class SolicitudesDAO {
    
    private final String nombreColeccion = "SolicitudesMongo";
    
    public boolean haySolicitudFechaProductor(Solicitud solicitud) {
        MongoCollection collection = this.getCollection(Conexion.createInstance());
        
        
        ResiduoSolicitud temp;
        List<ResiduoSolicitud> lista = solicitud.getResiduosSolicitud();
        int n = lista.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // to compare one string with other strings
                if (lista.get(i).getResiduo().getNombre().compareTo(lista.get(j).getResiduo().getNombre()) > 0) {
                    // swapping
                    temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        
        //Hay solicitud del mismo productor y con los mismos residuos
        MongoCursor<Solicitud> solicitudes = collection.find(
                Filters.and
        (
                Filters.eq("productor", solicitud.getProductor()),
                Filters.eq("residuosSolicitud", solicitud.getResiduosSolicitud())
        )
        ).iterator();
        
        if(solicitudes.hasNext()) {
            return true;
        }
        return false;
    }
    
    public void guardarSolicitud(Solicitud s) {
        MongoCollection collection = this.getCollection(Conexion.createInstance());
        collection.insertOne(s);
    }
    
    public List<Solicitud> obtenerTodasLasSolicitudes() throws BaseException
    {
        MongoCollection<Solicitud> collection = this.getCollection(Conexion.createInstance());
        MongoCursor<Solicitud> cursor = collection.find(
                Filters.eq("estado", false)
        ).iterator();
        List<Solicitud> temp = new LinkedList();
        while(cursor.hasNext()) {
            temp.add(cursor.next());
       }
        return temp;
    }
    
    private MongoCollection<Solicitud> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<Solicitud> collectionSolicitud = db.getCollection(nombreColeccion, Solicitud.class);
        return collectionSolicitud;
    }
    
}
