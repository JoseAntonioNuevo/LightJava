/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import model.TactilDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.Tactil;

public class EditProd extends HttpServlet {
 private static final long serialVersionUID = 1L;

    public EditProd() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    String num_serie = request.getParameter("num_serie");
    int descuento = Integer.valueOf(request.getParameter("descuento"));
    int id = Integer.valueOf(request.getParameter("categoria"));
    int precio = Integer.valueOf(request.getParameter("precio"));
    int cantidad = Integer.valueOf(request.getParameter("cantidad"));
    int stoc_max = Integer.valueOf(request.getParameter("stock_max"));
    int stoc_min = Integer.valueOf(request.getParameter("stock_min"));
    String block = request.getParameter("num_block");
    String passadis = request.getParameter("num_passadis");
    String lleixa = request.getParameter("num_lleixa");
    String foto = request.getParameter("foto");
   boolean sw=TactilDAO.editarProductos( id, nombre, descripcion, num_serie, descuento, precio, cantidad, stoc_max, stoc_min, block, passadis, lleixa, foto);
    //JOptionPane.showMessageDialog(null, "UPDATE tbl_producte SET prod_nom = '"+nombre+"', prod_foto= '"+foto+"', prod_preu= '"+precio+"', prod_descripcio= '"+descripcion+"', prod_descompte= '"+descuento+"' WHERE id_prod = '"+id+"'");
   response.sendRedirect("productos?categoria=99&oferta=1&filtro_nombre=");
  }
 }
