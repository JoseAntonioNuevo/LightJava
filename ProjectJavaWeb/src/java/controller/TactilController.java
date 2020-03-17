/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import static javax.swing.text.StyleConstants.ModelAttribute;
import javax.validation.Valid;
import model.Tactil;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import model.TactilDAO; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import model.Tactil;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Administrator
 */
 
@Controller
@RequestMapping("/")
@SessionAttributes(("nombreLogin"))

public class TactilController {
    
    String nombreSesion;
    int id=0;
 TactilDAO tactildao=new TactilDAO();
 ArrayList <Tactil> milista = new ArrayList<>();
 ArrayList <Tactil> micat = new ArrayList<>();
 ArrayList <Tactil> mistockMax = new ArrayList<>();
 ArrayList <Tactil> mistockMin = new ArrayList<>();
 ArrayList <Tactil> miusu = new ArrayList<>();
 
@RequestMapping(value="productos",method=RequestMethod.GET)    
public String tactilController(HttpServletRequest request, HttpServletResponse response, Model model){
    milista.clear();
    mistockMax.clear();
    mistockMin.clear();
    micat.clear();
    int categoria=Integer.valueOf(request.getParameter("categoria"));
    int oferta=Integer.valueOf(request.getParameter("oferta"));
    String filtro_nombre=request.getParameter("filtro_nombre");
    tactildao.getListaTactil (filtro_nombre, oferta, categoria, milista);
    tactildao.getStockMax(mistockMax);
    tactildao.getStockMin(mistockMin);
    tactildao.getCategoria(micat);
    if (nombreSesion != null){
    model.addAttribute("nombreLogin",nombreSesion);
    nombreSesion=null;
    }
    model.addAttribute("milista", milista);
    model.addAttribute("mistockMax", mistockMax);
    model.addAttribute("mistockMin", mistockMin);
     model.addAttribute("micat", micat);
return "productos";
} 
 
    @RequestMapping(value="index", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String loginController(){ //COn @RequestParam("id") int id recupero el tactil con la id
     
        return "index";
    }
    
       @RequestMapping(value="usuarios", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String UsuariosController(HttpServletRequest request, HttpServletResponse response, Model model){ //COn @RequestParam("id") int id recupero el tactil con la id
     
    miusu.clear();
    tactildao.getUsuarios(miusu);
    if (nombreSesion != null){
    model.addAttribute("nombreLogin",nombreSesion);
    nombreSesion=null;
    }
    model.addAttribute("miusu", miusu);
        
        
        return "usuarios";
    }
    
    
    
    @RequestMapping(value="login", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String indexController(Model modelo){ //COn @RequestParam("id") int id recupero el tactil con la id
      
        Tactil tactil = new Tactil();
        modelo.addAttribute("tactil", tactil);
        
        return "login";
    }
    
        
    @RequestMapping(value="exito", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String ExitoController(Model modelo){ //COn @RequestParam("id") int id recupero el tactil con la id
        
        return "exito";
    }
    
        @RequestMapping(value="cerrarSesion", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String cerrarSesionController(Model modelo){ //COn @RequestParam("id") int id recupero el tactil con la id
        
        return "cerrarSesion";
    }
    
    
          @RequestMapping(value="insertar_prod", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String insertarController(Model model){ //COn @RequestParam("id") int id recupero el tactil con la id
        
           Tactil tactil = new Tactil();
        model.addAttribute("tactil", tactil);
        
         micat.clear();
         mistockMax.clear();
         mistockMin.clear();
    tactildao.getCategoria(micat);
    tactildao.getStockMax(mistockMax);
    tactildao.getStockMin(mistockMin);  
    if (nombreSesion != null){
    model.addAttribute("nombreLogin",nombreSesion);
    nombreSesion=null;
    }
     model.addAttribute("micat", micat);
     model.addAttribute("mistockMax", mistockMax);
     model.addAttribute("mistockMin", mistockMin);
        
        return "insertar_prod";
    }
    
    
        @RequestMapping(value="insertar_prod", method=RequestMethod.POST) //asocio urls a metodos y asocio metodos a jsp.
    public String formularioController(@Valid @ModelAttribute("tactil") Tactil tactil , BindingResult result, Model model){ //EL bindingResult no puede ir al final de todo cuando está el model, pq es el model el que tiene que ir al final del todo. /@Valid @ModelAttribute("persona") Persona "con esto consigues decir que lo que recuperas es de tipo Persona"
      //El BindingResult sirve para que funcione la validación en el servidor.
        if(result.hasErrors()){

            return "insertar_prod";
        }else{
            return "index";
        } 
    }
       
        @RequestMapping(value="insertar_usuarios", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String InsertarUsuario(@Valid @ModelAttribute("tactil") Tactil tactil , BindingResult result, Model model){ //EL bindingResult no puede ir al final de todo cuando está el model, pq es el model el que tiene que ir al final del todo. /@Valid @ModelAttribute("persona") Persona "con esto consigues decir que lo que recuperas es de tipo Persona"
      //El BindingResult sirve para que funcione la validación en el servidor.
        if(result.hasErrors()){

            return "insertar_usuarios";
        }else{
            return "index";
        } 
    }
    
            @RequestMapping(value="editar_usuarios", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String editar_usuariosController(@Valid @ModelAttribute("tactil") Tactil tactil , BindingResult result, Model model){ //EL bindingResult no puede ir al final de todo cuando está el model, pq es el model el que tiene que ir al final del todo. /@Valid @ModelAttribute("persona") Persona "con esto consigues decir que lo que recuperas es de tipo Persona"
      //El BindingResult sirve para que funcione la validación en el servidor.
    
            return "editar_usuarios";
       
    }
    
    
                @RequestMapping(value="editar_prod", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
    public String editar_prodController(@Valid @ModelAttribute("tactil") Tactil tactil , BindingResult result, Model model){ //EL bindingResult no puede ir al final de todo cuando está el model, pq es el model el que tiene que ir al final del todo. /@Valid @ModelAttribute("persona") Persona "con esto consigues decir que lo que recuperas es de tipo Persona"
      //El BindingResult sirve para que funcione la validación en el servidor.
    
            return "editar_prod";
       
    }


    
                @RequestMapping(value="eliminar_usuarios", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
public String eliminar_usuariosController(HttpServletRequest request, HttpServletResponse response, Model model){ //EL bindingResult no puede ir al final de todo cuando está el model, pq es el model el que tiene que ir al final del todo. /@Valid @ModelAttribute("persona") Persona "con esto consigues decir que lo que recuperas es de tipo Persona"
      //El BindingResult sirve para que funcione la validación en el servidor.
    
      int id=Integer.valueOf(request.getParameter("user"));     
      
      tactildao.eliminarUsers(id);
      
      return "eliminar_usuarios";
       
    }

                @RequestMapping(value="eliminar_producto", method=RequestMethod.GET) //asocio urls a metodos y asocio metodos a jsp.
public String eliminar_productoController(HttpServletRequest request, HttpServletResponse response, Model model){ //EL bindingResult no puede ir al final de todo cuando está el model, pq es el model el que tiene que ir al final del todo. /@Valid @ModelAttribute("persona") Persona "con esto consigues decir que lo que recuperas es de tipo Persona"
      //El BindingResult sirve para que funcione la validación en el servidor.
    
      int producto=Integer.valueOf(request.getParameter("producto"));    
      int serie=Integer.valueOf(request.getParameter("serie"));  
      int lloc=Integer.valueOf(request.getParameter("lloc"));  
      int estoc=Integer.valueOf(request.getParameter("lloc")); 
      
      tactildao.eliminarProductos(producto, serie, lloc, estoc);
      
      return "eliminar_producto";
       
    }
    
}

