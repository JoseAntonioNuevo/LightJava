/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


   import java.text.*;
   import java.util.*;
   import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class TactilDAO extends Conexion{

    
    Conexion con=new Conexion();
    Connection cn=con.getConexion();
    String sql="";

    
        public void getCategoria( ArrayList <Tactil> micat){
            PreparedStatement pst= null;
            ResultSet rs= null;
            try {
      String consulta = "select * from tbl_categoria";
            pst = getConexion().prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()){
            Tactil ta=new Tactil();
            ta.setCategoria(rs.getString("categoria_nom"));
            ta.setCategoriaId(rs.getInt("categoria_id"));
            micat.add(ta);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      }
        
     
           public void getTactil(ArrayList <Tactil> milista){
            PreparedStatement pst= null;
            ResultSet rs= null;
            String consulta=null;
            try {
          consulta = "select * from tbl_producte INNER JOIN tbl_serie ON tbl_producte.serie_id=tbl_serie.serie_id INNER JOIN tbl_categoria ON tbl_serie.categoria_id=tbl_categoria.categoria_id INNER JOIN tbl_estoc ON tbl_producte.prod_id=tbl_estoc.prod_id INNER JOIN tbl_lloc ON tbl_estoc.lloc_id=tbl_lloc.lloc_id ORDER BY tbl_producte.prod_id";
          
         
            pst = getConexion().prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()){
            Tactil ta=new Tactil();
            ta.setNombre(rs.getString("prod_nom"));
            ta.setDescripcion(rs.getString("prod_descripcio"));
            ta.setDescuento(rs.getInt("prod_descompte"));
            ta.setCategoria(rs.getString("categoria_nom"));
            ta.setLloc_id(rs.getInt("lloc_id"));
            ta.setProd_id(rs.getInt("prod_id"));
            ta.setCategoriaId(rs.getInt("serie_id"));
            ta.setCantidad(rs.getInt("estoc_cantidad"));
            ta.setNum_serie(rs.getString("serie_nom"));
            ta.setPrecio(rs.getInt("prod_preu"));
            ta.setStock_max(rs.getInt("estoc_q_max"));
            ta.setStock_min(rs.getInt("estoc_q_min"));
            ta.setNum_block(rs.getString("num_bloc"));
            ta.setNum_passadis(rs.getString("num_passadis"));
            ta.setNum_lleixa(rs.getString("num_lleixa"));
            ta.setFoto(rs.getString("prod_foto"));
            milista.add(ta);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
           }
    
        
              
        public void getUsuarios( ArrayList <Tactil> miusu){
            PreparedStatement pst= null;
            ResultSet rs= null;
            try {
      String consulta = "select * from tbl_users";
            pst = getConexion().prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()){
            Tactil ta=new Tactil();
            ta.setCategoriaId(rs.getInt("id_user"));
            ta.setCategoria(rs.getString("user"));
            ta.setDescripcion(rs.getString("nombre"));
            miusu.add(ta);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      }
        
        
        
        public void getStockMax( ArrayList <Tactil> mistockMax){
            PreparedStatement pst= null;
            ResultSet rs= null;
            int cantidad;
            int stock_max;
            try {
      String consulta = "select * from tbl_estoc INNER JOIN tbl_producte ON tbl_producte.prod_id=tbl_estoc.prod_id";
            pst = getConexion().prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()){
            Tactil ta=new Tactil();
            cantidad=rs.getInt("estoc_cantidad");
            stock_max=rs.getInt("estoc_q_max");
          
            
            if (cantidad>stock_max){
            ta.setNombre(rs.getString("prod_nom"));   
            ta.setCantidad(rs.getInt("estoc_cantidad"));
            ta.setStock_max(rs.getInt("estoc_q_max"));
            ta.setStock_min(rs.getInt("estoc_q_min"));
            mistockMax.add(ta);
            }
                        
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      }
        
            public void getStockMin( ArrayList <Tactil> mistockMin){
            PreparedStatement pst= null;
            ResultSet rs= null;
            int cantidad;
            int stock_min;
            try {
      String consulta = "select * from tbl_estoc INNER JOIN tbl_producte ON tbl_producte.prod_id=tbl_estoc.prod_id";
            pst = getConexion().prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()){
            Tactil ta=new Tactil();
            cantidad=rs.getInt("estoc_cantidad");
            stock_min=rs.getInt("estoc_q_min");
            
            if (cantidad<stock_min){
            ta.setNombre(rs.getString("prod_nom"));   
            ta.setCantidad(rs.getInt("estoc_cantidad"));
            ta.setStock_max(rs.getInt("estoc_q_max"));
            ta.setStock_min(rs.getInt("estoc_q_min"));
            mistockMin.add(ta);
            }
                        
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      }
        
    
    public boolean autenticacion(String email, String password){
    PreparedStatement pst= null;
    ResultSet rs= null;
    
    try {
    String consulta = "select * from tbl_users where user=? and pass=?"; 
    pst = getConexion().prepareStatement(consulta);
    pst.setString(1, email);
    pst.setString(2, password);
    rs = pst.executeQuery();
    
    if(rs.absolute(1)){
    return true;
    }
    
    }catch (Exception e){
        System.err.println("Error" + e);
    }finally{
        try {
        if(getConexion() != null) getConexion().close();
        if(pst != null) pst.close();
        if(rs != null) rs.close();
    }catch (Exception e){
          System.err.println("Error" + e);
     }
    }
    
    return false;
    }
    
    
   public static boolean insertarSerie (String nombre, String foto, String descripcion, int descuento, int precio, int cantidad, String num_serie, String categoria, int stoc_max, int stoc_min, String block, String passadis, String lleixa, int IDcategoria, int categoriaID){
       
boolean agregado=false;
 int lloc_id=0; 
  int prod_id=0; 
try {
   Conexion c=new Conexion();
   Connection con=c.getConexion();
    Statement st;
    st = con.createStatement();
    
    ResultSet rs=null;
    
 rs = st.executeQuery("SELECT categoria_id FROM tbl_categoria WHERE categoria_nom='"+categoria+"'");

if (rs!=null){
    
while(rs.next())

categoriaID=(rs.getInt("categoria_id"));
}
    
    st.executeUpdate("INSERT INTO tbl_serie(`serie_nom`, `categoria_id`) VALUES ('"+num_serie+"','"+categoriaID+"')");
    
rs=null;
rs = st.executeQuery("SELECT MAX(serie_id) FROM tbl_serie");

if (rs!=null){
    

    
while(rs.next())

IDcategoria=(rs.getInt("MAX(serie_id)"));
}
    st.executeUpdate("INSERT INTO tbl_producte(`prod_nom`, `prod_foto`, `prod_preu`, `serie_id`, `prod_descripcio`, `prod_descompte`) VALUES ('"+nombre+"','"+foto+"','"+precio+"','"+IDcategoria+"','"+descripcion+"','"+descuento+"')");
    st.executeUpdate("INSERT INTO tbl_lloc(`num_bloc`, `num_passadis`, `num_lleixa`) VALUES ('"+block+"','"+passadis+"','"+lleixa+"')");
  
  rs=null;   
rs = st.executeQuery("SELECT MAX(prod_id) FROM tbl_producte");

if (rs!=null){
     
while(rs.next())

    
prod_id=(rs.getInt("MAX(prod_id)"));

}

 rs=null;   
rs = st.executeQuery("SELECT MAX(lloc_id) FROM tbl_lloc");

if (rs!=null){
    

while(rs.next())

    
lloc_id=(rs.getInt("MAX(lloc_id)"));

}

st.executeUpdate("INSERT INTO tbl_estoc(`estoc_cantidad`, `estoc_q_max`, `estoc_q_min`, `prod_id`, `lloc_id`) VALUES ('"+cantidad+"','"+stoc_max+"','"+stoc_min+"','"+prod_id+"','"+lloc_id+"')");

    agregado=true;
    st.close();
  } catch (SQLException e) {
   agregado=false;
   e.printStackTrace();
  }
  return agregado;
 }


public static boolean insertarUsers (String nombre, String usuario, String pass){
       
boolean agregado=false;
  try {
   Conexion c=new Conexion();
   Connection con=c.getConexion();
    Statement st;
    st = con.createStatement();
    st.executeUpdate("INSERT INTO tbl_users(`user`, `pass`, `nombre`) VALUES ('"+usuario+"','"+pass+"','"+nombre+"')");

agregado=true;
    st.close();
  } catch (SQLException e) {
   agregado=false;
   e.printStackTrace();
  }
  return agregado;
 }

public static boolean editarUsers (String nombre, String usuario, String pass, int id){
       
boolean agregado=false;
  try {
   Conexion c=new Conexion();
   Connection con=c.getConexion();
    Statement st;
    st = con.createStatement();
    
   if ( (pass != null) && (!pass.equals("")) ) {
    st.executeUpdate("UPDATE tbl_users SET user = '"+usuario+"', nombre= '"+nombre+"', pass= '"+pass+"' WHERE id_user = '"+id+"'");
    }else{
    st.executeUpdate("UPDATE tbl_users SET user = '"+usuario+"', nombre= '"+nombre+"' WHERE id_user = '"+id+"'");
    }
    
agregado=true;
    st.close();
  } catch (SQLException e) {
   agregado=false;
   e.printStackTrace();
  }
  return agregado;
 }


public static boolean editarProductos (String nombre, String foto, String descripcion, int descuento, int precio, int cantidad, String num_serie, String categoria, int stoc_max, int stoc_min, String block, String passadis, String lleixa, int IDcategoria, int categoriaID){
       
boolean agregado=false;
  try {
   Conexion c=new Conexion();
   Connection con=c.getConexion();
    Statement st;
    st = con.createStatement();
    st.executeUpdate("UPDATE tbl_lloc SET num_bloc='"+block+"', num_passadis='"+passadis+"', num_lleixa='"+lleixa+"' WHERE lloc_id = '"+categoriaID+"'"); 
    
   st.executeUpdate("UPDATE tbl_producte SET prod_nom = '"+nombre+"', prod_foto= '"+foto+"', prod_preu= '"+precio+"', prod_descripcio= '"+descripcion+"', prod_descompte= '"+descuento+"' WHERE prod_id = '"+categoriaID+"'");  
   st.executeUpdate("UPDATE tbl_estoc SET estoc_cantidad='"+cantidad+"', estoc_q_max='"+stoc_max+"', estoc_q_min='"+stoc_min+"' WHERE estoc_id='"+categoriaID+"'" );
 
    

     agregado=true;
    st.close();
  } catch (SQLException e) {
   agregado=false;
   e.printStackTrace();
  }
  return agregado;
 }


public static boolean eliminarUsers (int id){
       
boolean agregado=false;
  try {
   Conexion c=new Conexion();
   Connection con=c.getConexion();
    Statement st;
    st = con.createStatement();
    st.executeUpdate("DELETE FROM tbl_users WHERE id_user= '"+id+"'");
agregado=true;
    st.close();
  } catch (SQLException e) {
   agregado=false;
   e.printStackTrace();
  }
  return agregado;
 }



public static boolean eliminarProductos (int id){
       
boolean agregado=false;
  try {
   Conexion c=new Conexion();
   Connection con=c.getConexion();
    Statement st;
    st = con.createStatement();
    st.executeUpdate("DELETE FROM tbl_estoc WHERE estoc_id= '"+id+"'");
    st.executeUpdate("DELETE FROM tbl_lloc WHERE lloc_id= '"+id+"'");
    st.executeUpdate("DELETE FROM tbl_producte WHERE prod_id= '"+id+"'");
    st.executeUpdate("DELETE FROM tbl_serie WHERE serie_id= '"+id+"'");
    
    
agregado=true;
    st.close();
  } catch (SQLException e) {
   agregado=false;
   e.printStackTrace();
  }
  return agregado;
 }





    public DefaultTableModel cargarDefaultTableModel(String filtro_oferta, String filtro_nombre, String categoria){
    String [] cabecera = {"id","nombre", "descripcion", "categoria", "descuento"};
    DefaultTableModel model= new DefaultTableModel(null, cabecera);
    if (categoria.equals("Todos")){      
    if ((filtro_oferta=="0") && (filtro_nombre.equals(""))){
    sql="select * from tbl_producte INNER JOIN tbl_serie ON tbl_producte.serie_id=tbl_serie.serie_id INNER JOIN tbl_categoria ON tbl_serie.categoria_id=tbl_categoria.categoria_id ORDER BY prod_id";    
    }else if((filtro_oferta!="0") && filtro_nombre!=""){
    sql="select * from tbl_producte INNER JOIN tbl_serie ON tbl_producte.serie_id=tbl_serie.serie_id INNER JOIN tbl_categoria ON tbl_serie.categoria_id=tbl_categoria.categoria_id WHERE tbl_producte.prod_descompte>'0' AND tbl_producte.prod_nom LIKE '%"+filtro_nombre+"%' ORDER BY tbl_producte.prod_id";
    }else if((filtro_oferta=="0") && filtro_nombre!=("")){
    sql="select * from tbl_producte INNER JOIN tbl_serie ON tbl_producte.serie_id=tbl_serie.serie_id INNER JOIN tbl_categoria ON tbl_serie.categoria_id=tbl_categoria.categoria_id WHERE tbl_producte.prod_nom LIKE '%"+filtro_nombre+"%' ORDER BY tbl_producte.prod_id";
    }
    }else{
    if ((filtro_oferta=="0") && (filtro_nombre.equals(""))){
    sql="select * from tbl_producte INNER JOIN tbl_serie ON tbl_producte.serie_id=tbl_serie.serie_id INNER JOIN tbl_categoria ON tbl_serie.categoria_id=tbl_categoria.categoria_id WHERE tbl_categoria.categoria_nom='"+categoria+"' ORDER BY prod_id";    
    }else if((filtro_oferta!="0") && filtro_nombre!=""){
    sql="select * from tbl_producte INNER JOIN tbl_serie ON tbl_producte.serie_id=tbl_serie.serie_id INNER JOIN tbl_categoria ON tbl_serie.categoria_id=tbl_categoria.categoria_id WHERE tbl_categoria.categoria_nom='"+categoria+"' AND tbl_producte.prod_descompte>'0' AND tbl_producte.prod_nom LIKE '%"+filtro_nombre+"%' ORDER BY tbl_producte.prod_id";
    }else if((filtro_oferta=="0") && filtro_nombre!=("")){
    sql="select * from tbl_producte INNER JOIN tbl_serie ON tbl_producte.serie_id=tbl_serie.serie_id INNER JOIN tbl_categoria ON tbl_serie.categoria_id=tbl_categoria.categoria_id WHERE tbl_categoria.categoria_nom='"+categoria+"' AND tbl_producte.prod_nom LIKE '%"+filtro_nombre+"%' ORDER BY tbl_producte.prod_id";
    }
    }
    
            try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            String registro[]=new String[5];
            while (rs.next()){  
           // Animales ani=new Animales();
           registro[0]=String.valueOf(rs.getInt("prod_id"));
           registro[1]=String.valueOf(rs.getString("prod_nom"));
           registro[2]=String.valueOf(rs.getString("prod_descripcio"));
            registro[3]=String.valueOf(rs.getString("categoria_nom"));
            registro[4]=String.valueOf(rs.getString("prod_descompte")+"%");
            model.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
             return null;
        }
           return model;
    }  
    



    public DefaultTableModel cargarDefaultTableModel2(){
    String [] cabecera = {"ID Usuario", "Usuario", "Nombre"};
    DefaultTableModel model= new DefaultTableModel(null, cabecera);
           sql="select * from tbl_users ORDER BY id_user";
            try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            String registro[]=new String[3];
            while (rs.next()){  
           // Animales ani=new Animales();
            registro[0]=String.valueOf(rs.getInt("id_user"));
           registro[1]=String.valueOf(rs.getString("user"));
            registro[2]=String.valueOf(rs.getString("nombre"));
            model.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
             return null;
        }
           return model;
    }  
    
}