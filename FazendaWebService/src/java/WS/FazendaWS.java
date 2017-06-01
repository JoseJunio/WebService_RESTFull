/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author José_Junio
 */
@Path("fazenda")
public class FazendaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    public FazendaWS() {
    }

    /**
     * Retrieves representation of an instance of WS.FazendaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    @Path("Usuario/json")
    public String getJson() {
        //TODO return proper representation object
        return "meu primeiro WS RESTFULL !!";
                }
    
    @GET
    @Produces("application/json")
    @Path("Usuario/get/{login}")
    public String getUsuario(@PathParam("login")String login) {
        
        Usuario     usuario       = new Usuario();
        UsuarioDAO  usuario_banco = new UsuarioDAO();
        
        
        usuario.setLogin(login);
        
        usuario = usuario_banco.buscar(usuario);
        
        Gson g = new Gson();
        //TODO return proper representation object
        return g.toJson(usuario);
                }
    
    @GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listUsuario() {
        
        List<Usuario> lista;
        
        UsuarioDAO dao = new UsuarioDAO();
        
        lista = dao.listar();
        
        Gson g = new Gson();
        //TODO return proper representation object
        return g.toJson(lista);
                }
    
    
    /**
     * PUT method for updating or creating an instance of FazendaWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
