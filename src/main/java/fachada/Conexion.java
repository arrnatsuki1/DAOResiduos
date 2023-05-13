/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Rosa Rodriguez
 */
class Conexion extends MongoClient{
    private static Conexion conexion;
    
    
    private Conexion() {
        
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        
        MongoClient conexion = 
                new MongoClient("127.0.0.1", 
                        MongoClientOptions.builder()
                                .codecRegistry(pojoCodecRegistry)
                                .build());
        
    }
    
    public static Conexion createInstance() {
        if(conexion==null) {
            conexion = new Conexion();
        }
        return conexion;
    }
    
}
