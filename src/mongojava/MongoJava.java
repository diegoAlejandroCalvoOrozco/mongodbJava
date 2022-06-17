/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mongojava;
/**
 *
 * @author OsirisBlack
 */
public class MongoJava {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ConectionMongo con= new ConectionMongo();
      InsertarFiao fiao=new InsertarFiao();
      con.tableFiaos();
      /*fiao.setNombre("migel servantes");
      fiao.setSexo("m");
      fiao.setEdad(30);
      fiao.setTotalFiao(650000);
      fiao.guardarFiao(con.tableFiaos());
      fiao.setId(124);
      //fiao.eliminarFiao(con.tableFiaos());*/
      fiao.modificarFiados(con.tableFiaos());
      con.allTblFiaos();
      
    }
    
}
