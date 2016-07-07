/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servisi;

import com.sun.jersey.api.core.InjectParam;
import domen.Car;
import helper.RestHelper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author blanusal
 */
@Path("/auto")
public class AutomobiliRestEndpoint {
    
    @InjectParam
    RestHelper helper;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutomobili() {
        List<Car> cars = (ArrayList<Car>)helper.getEntityManager().createNamedQuery("Car.findAll").getResultList();
        for (Car car : cars) {
            car.getImagesList();
        }
        return Response.ok().entity(cars).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteCar(@PathParam("id") Long id){
        EntityManager em = helper.getEntityManager();
        Car c = em.find(Car.class, id);
        helper.removeObject(em, c, id);
        return Response.ok().build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCar(Car car){
        EntityManager em = helper.getEntityManager();
        helper.persistObject(em, car);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCar(Car car){
        EntityManager em = helper.getEntityManager();
        Car oldCar = em.find(Car.class, car.getId());
        helper.mergeObject(em, car);
        return Response.status(Response.Status.OK).build();
    }
    
}
