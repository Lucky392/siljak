/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servisi;

import java.io.File;
import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author blanusal
 */
@Path("/img")
public class UploadImageRestEndpoint {
    
    @GET
    @Produces("image/*")
    public Response getFullImage(@PathParam("image") String img) {

        File f = new File("C:\\slike\\siljak.png");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok(f).build();
    }
    
    @GET
    @Path("/nesto")
    @Produces("text/plain")
    public Response getNesto(@PathParam("image") String img) {
        return Response.ok("pusi kurac").build();
    }

}
