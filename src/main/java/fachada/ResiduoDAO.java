/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.ResiduoMongo;
import Excepciones.BaseException;
import Excepciones.ResiduoExistenteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fachada.Residuo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
class ResiduoDAO {

    private final String nombreColeccion = "ResiduoMongo";
    private final String nombreEmpresaGenerico = "ITSON";

    public List<Residuo> obtenerTodosLosResiduos() {
        MongoCollection<ResiduoMongo> c = getCollection(Conexion.createInstance());
        MongoCursor<ResiduoMongo> cursor = c.find().iterator();

        List<Residuo> lista = new ArrayList();

        while (cursor.hasNext()) {
            ResiduoMongo rm = cursor.next();
            Residuo r = new Residuo();
            r.setCodigo(rm.getCodigo());
            r.setQuimicos(rm.getQuimicos());
            r.setNombre(rm.getNombre());
            lista.add(r);
        }
        return lista;
    }

    public List<Residuo> obtenerTodosLosResiduosDeProductor(String productor) throws BaseException {

        try {
            MongoCollection<ResiduoMongo> c = getCollection(Conexion.createInstance());

            MongoCursor<ResiduoMongo> residuos = c.find(
                    Filters.eq("nombreProductor", productor)
            ).iterator();
            List<Residuo> res = new ArrayList();
            while (residuos.hasNext()) {
                ResiduoMongo rm = residuos.next();
                Residuo r = new Residuo();
                r.setCodigo(rm.getCodigo());
                r.setNombre(rm.getNombre());
                r.setQuimicos(rm.getQuimicos());
                res.add(r);
            }
            return res;
        } catch (Exception e) {
            
            throw new BaseException(e.getMessage());
            
        }

    }

    public boolean comprobarResiduo(Residuo residuo) {
        MongoCollection<ResiduoMongo> c = getCollection(Conexion.createInstance());

        /*
            IGNORE ESTO, NO LE SABEMO CASI A LAS CONSULTAS ASI QUE OCUPAMOS
            ORDENAR LOS RESIDUOS ANTES DE CONSULTARLOS
         */
        List<String> quimicos = new ArrayList();
        for (Quimico q : residuo.getQuimicos()) {
            quimicos.add(q.getNombre());
        }
        Collections.sort(quimicos);
        List<Quimico> q = new ArrayList();
        for (String sq : quimicos) {
            q.add(new Quimico(sq));
        }
        residuo.setQuimicos(q);
        /* FIN DE NUESTRA ASQUEROSIDAD */

        //Con la misma composicion quimica
        MongoCursor<ResiduoMongo> comprobacion = c.find(
                Filters.eq("quimicos", residuo.getQuimicos())
        ).iterator();

        if (comprobacion.hasNext()) {
            return true;
        }
        //Con el mismo nombre
        comprobacion = c.find(
                Filters.eq("nombre", residuo.getNombre())
        ).iterator();

        if (comprobacion.hasNext()) {
            return true;
        }
        //Que tenga el mismo codigo
        comprobacion = c.find(
                Filters.eq("codigo", residuo.getCodigo())
        ).iterator();

        if (comprobacion.hasNext()) {
            return true;
        }

        return false;
    }

    public void guardarResiduo(Residuo residuo) {
        MongoCollection<ResiduoMongo> c = getCollection(Conexion.createInstance());
        ResiduoMongo rm = new ResiduoMongo();
        rm.setNombre(residuo.getNombre());
        rm.setCodigo(residuo.getCodigo());
        rm.setNombreProductor(nombreEmpresaGenerico);
        rm.setQuimicos(residuo.getQuimicos());
        c.insertOne(rm);
    }

    private MongoCollection<ResiduoMongo> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<ResiduoMongo> collecionAsignaciones = db.getCollection(nombreColeccion, ResiduoMongo.class);
        return collecionAsignaciones;
    }

    private void SortArray() {

    }

}
