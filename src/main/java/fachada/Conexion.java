/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Rosa Rodriguez
 */
class Conexion extends com.mongodb.MongoClient {

    private static Conexion conexion;

    private Conexion() {
        super("192.168.0.29",
                MongoClientOptions.builder()
                        .codecRegistry(
                                fromRegistries(MongoClient.getDefaultCodecRegistry(),
                                        fromProviders(PojoCodecProvider.builder().automatic(true).build()))).build()
    

    );
    }

    public static Conexion createInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    private void onShutDown() {
        
        Conexion.conexion.close();
        
    }
    
}
