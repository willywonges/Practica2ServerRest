/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import modelo.TbAlumno;

/**
 *
 * @author u05521
 */
@Stateless
@Path("modelo.tbalumno")
public class TbAlumnoFacadeREST extends AbstractFacade<TbAlumno> {
    @PersistenceContext(unitName = "WebAlumnosRestPU")
    private EntityManager em;

    public TbAlumnoFacadeREST() {
        super(TbAlumno.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(TbAlumno entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(TbAlumno entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TbAlumno find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<TbAlumno> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TbAlumno> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

       @GET
    @Path("{apellidos}") 
//  @Produces({"application/json"})  solo permite text/xml
    public List<TbAlumno> findByApellidos(@PathParam("apellidos") String apellidos) {
    CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
    Root<TbAlumno> c = criteriaQuery.from(TbAlumno.class);
    criteriaQuery.select(c);
    criteriaQuery.where(criteriaBuilder.equal(c.get("apellidos"), apellidos));
 // criteriaQuery.where(criteriaBuilder.like(c.get("dniPersona"), apellido));
                       
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }  
    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
