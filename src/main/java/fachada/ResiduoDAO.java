/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import EntidadesMongo.ResiduoMongo;
import EntidadesMongo.SolicitudMongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import fachada.Quimico;
import fachada.Residuo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosa Rodriguez
 */
class ResiduoDAO {

    private final String nombreColeccion = "ResiduoMongo";
    
    public List<Residuo> obtenerTodosLosResiduos() {
        MongoCollection<ResiduoMongo> c = getCollection(Conexion.createInstance());
        MongoCursor<ResiduoMongo> cursor = c.find().iterator();
        
        List<Residuo> lista = new ArrayList();
        
        while(cursor.hasNext()) {
            ResiduoMongo rm = cursor.next();
            Residuo r = new Residuo();
            r.setCodigo(cursor.next().getCodigo().toString());
            r.setQuimicos(rm.getQuimicos());
            lista.add(r);
        }
        return lista;
    }

    public boolean comprobarResiduo(Residuo residuo) {
        Conexion c = Conexion.createInstance();
        //EN UN TXT POR AHORA
        try {
            File f = new File("residuos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            Residuo r = new Residuo();
            while (line != null) {
                List<Quimico> quimicos = new ArrayList();

                while (line.length() > 2) {
                    String quimico = line.substring(0, line.indexOf("/"));
                    quimicos.add(new Quimico(quimico));
                    line = line.substring(line.indexOf("/") + 1);
                    System.out.println(quimico);
                }

                r.setQuimicos(quimicos);
                
                if (residuo.getQuimicos().equals(r.getQuimicos())) {
                    return true;
                }
                line = br.readLine();
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public void guardarResiduo(Residuo residuo) {
        Conexion c = Conexion.createInstance();
        //EN UN TXT POR AHORA
        try {
            String texto = "";
            File f = new File("residuos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            
            while (line != null) {
                texto += line+"\n";
                line = br.readLine();
            }

            
            for(Quimico q : residuo.getQuimicos()) {
                texto+=q.getNombre()+"/";
            }

            br.close();
            fr.close();
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(texto);
            bw.close();
            fw.close();

        } catch (Exception e) {
        }
    }

    private MongoCollection<ResiduoMongo> getCollection(Conexion c) {
        MongoDatabase db = c.getDatabase("DISEÑO");
        MongoCollection<ResiduoMongo> collecionAsignaciones = db.getCollection(nombreColeccion, ResiduoMongo.class);
        return collecionAsignaciones;
    }
    
}
