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
import model.Tactil;

public class InsertarUsuarios extends HttpServlet {
 private static final long serialVersionUID = 1L;

    public InsertarUsuarios() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String usuario = request.getParameter("usuario");
    String pass = request.getParameter("num_serie");

   boolean sw=TactilDAO.insertarUsers(nombre, usuario, pass);
     response.sendRedirect("usuarios");
  }
 }
