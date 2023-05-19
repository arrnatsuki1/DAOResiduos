/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.EmpresaMongo;
import Excepciones.BaseException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
class EmpresasDAO {

    private final String nombreColeccion = "EmpresasMongo";

    public List<Empresa> obtenerTodasLasEmpresas() throws BaseException {
        try {
            MongoCollection<EmpresaMongo> collection = this.getCollection(Conexion.createInstance());

            MongoCursor<EmpresaMongo> empresasMongo = collection.find(
                    Filters.eq("disponible", true)
            ).iterator();

            List<Empresa> empresas = new ArrayList();

            while (empresasMongo.hasNext()) {

                empresas.add(transformar(empresasMongo.next()));

            }
            return empresas;
        } catch (Exception e) {
            throw new BaseException("Error al recuperar las empresas"); 
        }
    }

    private Empresa transformar(EmpresaMongo em) {
        return new Empresa(em.getNombre(), em.isDisponible());
    }

    private MongoCollection<EmpresaMongo> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<EmpresaMongo> collectionSolicitud = db.getCollection(nombreColeccion, EmpresaMongo.class);
        return collectionSolicitud;
    }

}
