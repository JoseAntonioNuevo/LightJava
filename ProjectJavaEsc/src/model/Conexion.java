/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manu
 */
public class Conexion {
   private String basededatos="bd_estoc";
   private String url="jdbc:mysql://127.0.0.1/"+basededatos;
   private String usuario="root";
   private String password="";
   public Connection con;
   
   public Conexion(){
       try {
           Class.forName("org.gjt.mm.mysql.Driver");
           con=(Connection) DriverManager.getConnection(this.url,this.usuario,this.password);
           //JOptionPane.showMessageDialog(null,"Conexion Exitosa");
       } catch (Exception ex) {
  
          JOptionPane.showMessageDialog(null, ex);
       }
   }
       public Connection getConexion(){
       return con;
       }
}   
   


