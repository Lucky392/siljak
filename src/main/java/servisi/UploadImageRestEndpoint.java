/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servisi;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import domen.Images;
import domen.ImagesPK;
import helper.RestHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author blanusal
 */
@Path("/img")
public class UploadImageRestEndpoint {

    @InjectParam
    RestHelper helper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getImagesPaths(@PathParam("id") Long id) {
        EntityManager em = helper.getEntityManager();
        List<File> fajlovi = new ArrayList<>();
        List<String> putanje = new ArrayList<>();
        for (Images i : (List<Images>) em.createNamedQuery("Images.findByIdCar").setParameter("idCar", id).getResultList()) {
            String [] niz = i.getImage().split("/");
            putanje.add(niz[niz.length - 1]);
        }
        return Response.ok().entity(putanje).build();
    }

    @GET
    @Produces("image/*")
    @Path("{image}")
    public Response getImages(@PathParam("image") Long image) {
        EntityManager em = helper.getEntityManager();
        Images i = (Images) em.createNamedQuery("Images.findById").setParameter("id", image).getSingleResult();
        File f = new File(i.getImage());
        String mt = new MimetypesFileTypeMap().getContentType(f);
        return Response.ok().entity(f).build();
    }

    @POST
    @Path("upload/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail, @PathParam("id") Long id) {
        String fileName = "C://images/" + new Date().getTime() + ".jpg";
        saveFile(uploadedInputStream, fileName, id);
        String output = "File saved to server location : " + fileName;
        return Response.status(200).entity(output).build();
    }

    private void saveFile(InputStream uploadedInputStream, String serverLocation, Long id) {
        try {
            OutputStream outpuStream = null;
            int read = 0;
            byte[] bytes = new byte[1024];
            outpuStream = new FileOutputStream(new File(serverLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }
            outpuStream.flush();

            outpuStream.close();
			EntityManager em = helper.getEntityManager();
            ImagesPK ipk = new ImagesPK(id, 0);
            Images i = new Images(ipk, serverLocation);
            helper.persistObject(em, i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
