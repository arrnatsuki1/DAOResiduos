/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.ResiduoMongo;
import Excepciones.BaseException;
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
public class QuimicoDAO {

    private final String nombreColeccion = "ResiduoMongo";

    public List<Quimico> obtenerTodosLosQuimicos() throws BaseException {

        //YUPIII SI CONSIGUE TODOS LOS QUIMICOS Y NO LOS REPITEEE
        try {
            Conexion c = Conexion.createInstance();
            MongoCollection collection = this.getCollection(c);

            DistinctIterable<Quimico> lista
                    = collection.distinct("quimicos", Quimico.class);

            MongoCursor<Quimico> a = lista.iterator();

            List<Quimico> quimicos = new ArrayList();

            while (a.hasNext()) {
                quimicos.add(a.next());
            }

            return quimicos;
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    private MongoCollection<ResiduoMongo> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<ResiduoMongo> collecionQuimicos = db.getCollection(nombreColeccion, ResiduoMongo.class);
        return collecionQuimicos;
    }
}
