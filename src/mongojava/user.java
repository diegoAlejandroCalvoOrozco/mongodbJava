/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mongojava;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author OsirisBlack
 */
public class user {
    private String user;
    private String password;
    private String nombre;
    private String id_cedula;

    public user() {
        this.id_cedula="";
        this.nombre="";
        this.user="";
        this.password="";
    }

    public user(String user, String password, String nombre, String id_cedula) {
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.id_cedula = id_cedula;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(String id_cedula) {
        this.id_cedula = id_cedula;
    }
    
    //metodos de la clase user
    
    //::verificamos que el ingreso de datos este correcto
    public boolean verificarUserPass(DBCollection tbl){
        boolean entradaUser=false;
        if(!"".equals(this.getUser()) && this.getUser().length() < 20 && seguridadCadena(this.getUser())){
             
            if(!"".equals(this.getPassword()) && this.getPassword().length() < 10){
                
               entradaUser= this.verificarUSer(tbl)==true?true:false;
               
            }else{
                JOptionPane.showMessageDialog(null,"error en el password verifique que este escrito correctamente", "Error de password", JOptionPane.ERROR_MESSAGE);
            }  
        }else{
            JOptionPane.showMessageDialog(null,"campo vacio o sobre paso la longitud", "Error de usuario", JOptionPane.ERROR_MESSAGE);
        }
        return entradaUser;
    }
    
    //verifica que el campo usuario sea solo texto
     public boolean seguridadCadena(String usuario){
        for (int i = 0; i < usuario.length(); i++) {
          char c=usuario.charAt(i);
           // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
        
    }
     
    //PETICIONES A LA BD
     
   private boolean verificarUSer(DBCollection tbl){
       boolean ingreso=false;
       BasicDBObject user = new BasicDBObject();
       user.append("user",this.getUser());
       user.append("password",this.getPassword());
       //DBCursor cursor=tbl.find(user);
       List<DBObject> obj = tbl.find(user).toArray();
       try {
           if(obj.size() > 0){
                if(obj.get(0).get("user").equals(this.getUser())&& obj.get(0).get("password").equals(this.getPassword())){
                    ingreso=true;
                }
           }else{
               ingreso=false;
           } 
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return ingreso;
        
   }
    
    
}
