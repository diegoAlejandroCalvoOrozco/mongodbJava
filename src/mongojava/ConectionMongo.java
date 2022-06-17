/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mongojava;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author OsirisBlack
 */
public class ConectionMongo {
    private Mongo mongo;
    private String server;
    private int puerto;
    private DBCollection table;

    public ConectionMongo() {
        this.mongo=null;
        this.server="localhost";
        this.puerto=27017;
    }
    
    
    public Mongo crearconexion(){
        try {
            this.mongo=new Mongo(this.server, this.puerto);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConectionMongo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.mongo;
      
    }
    
    public void allDatabases(){
        List<String> data = crearconexion().getDatabaseNames();
        System.out.println(data.toString()); 
    }
    //
    public DB dbComerciante(){
        //selecciono la BD
        DB db=crearconexion().getDB("comerciante");
        return db;
    }
    public DBCollection tableFiaos(){
        return this.table=dbComerciante().getCollection("fiaos");
       
    }
    
    public DBCollection tableUser(){
        return this.table=dbComerciante().getCollection("user");
       
    }
    
    public void allTblFiaos(){
         DBCursor cursor=tableFiaos().find();
        while (cursor.hasNext()) {
             System.out.println(cursor.next().get("nombre")); 
        }  
    }
    
     
    public void allTblUser(){
         DBCursor cursor=tableUser().find();
        while (cursor.hasNext()) {
             System.out.println(cursor.next()); 
        }  
    }
    
   
}
