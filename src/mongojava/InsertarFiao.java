/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mongojava;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

/**
 *
 * @author OsirisBlack
 */
public class InsertarFiao {
    private String nombre;
    private String sexo;
    private int edad;
    private int totalFiao;
    private int id;

    public InsertarFiao() {
        this.edad=0;
        this.nombre="";
        this.sexo="";
        this.totalFiao=0;
        this.id=0;
    }

    public InsertarFiao(String nombre, String sexo, int edad, int totalFiao, int id) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.totalFiao = totalFiao;
        this.id = id;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTotalFiao() {
        return totalFiao;
    }

    public void setTotalFiao(int totalFiao) {
        this.totalFiao = totalFiao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public void guardarFiao(DBCollection tbl){
        BasicDBObject obj=new BasicDBObject();
        obj.put("_id",124);
        obj.put("nombre", ""+this.getNombre()+"");
        obj.put("edad",this.edad);
        obj.put("sexo", ""+this.getSexo()+"");
        obj.put("totalFiao",this.getTotalFiao());
        tbl.insert(obj);
        
    }
    //elimina un dato de mongo
    public void eliminarFiao(DBCollection tbl){
        tbl.remove(new BasicDBObject().append("_id", this.getId()));
    }
    
    public void modificarFiados(DBCollection tbl){
        //crear una sentencia con la informacion a cambiar
        BasicDBObject actualizarNombre=new BasicDBObject();
        actualizarNombre.append("$set",new BasicDBObject().append("nombre", "miguel angel copera"));
        
        //Busca el ausuario a modificar
        BasicDBObject buscarUSer= new BasicDBObject();
        buscarUSer.append("nombre", "migel servantes");
        
        //Realizamos el update
        tbl.update(buscarUSer, actualizarNombre);
        
    }
    
    
}
