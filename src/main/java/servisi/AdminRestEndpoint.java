/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servisi;

import com.sun.org.apache.xerces.internal.util.Status;
import domen.Admin;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author blanusal
 */
@Path("admin")
public class AdminRestEndpoint {
    
    @PersistenceContext(unitName = "com.mycompany_ProdajaAutomobila_war_1.0PU")
    private EntityManager em;
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logIn(String authorization) {
        String[] userPass = authorization.split("##");
        Admin user = null;
        try {
            user = (Admin) em
                    .createQuery("SELECT a FROM Admin a WHERE a.username = :userName")
                    .setParameter("username", userPass[0])
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new WebApplicationException("This username doesn't exist");
        }
        boolean pass = false;
        try {
            pass = userPass[1].equals(user.getPassword());
        } catch (Exception e) {
            throw new WebApplicationException(e.getMessage());
        }
        return !pass ? Response.status(403).build() : Response.ok().build();
    }
    
}
