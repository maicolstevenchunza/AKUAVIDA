/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Domicilio;
import edu.co.sena.akuavida.modelo.entitis.DomicilioPK;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDomicilioDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author maicolsteven
 */
public class DomicilioDAOImpl implements IDomicilioDAO{
    
    public static final String CIUDAD = "ciudad";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
     protected static final Logger logger = Logger.getLogger( DomicilioDAOImpl.class );

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Domicilio entity) {
            
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el domicilio");
        } catch (RuntimeException re) {
            logger.error("No se inserto el domicilio", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Domicilio entity) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el domicilio");
        } catch (RuntimeException re) {
            logger.error("No se actualizo el domicilio", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Domicilio entity) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
           entity = em.getReference(Domicilio.class, entity.getDomicilioPK());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se borro el domicilio");
        } catch (RuntimeException re) {
            logger.error("No se borro el domicilio", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Domicilio findByIDDomicilio(DomicilioPK domicilioPK) {
    
        Domicilio domicilioTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {

            domicilioTemporal = em.find(Domicilio.class, domicilioPK);

        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el ID", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domicilioTemporal;
    }

    @Override
    public List<Domicilio> findByAll() {
    
         EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findAll");
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar todos los domicilios", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    
    }

    @Override
    public List<Domicilio> findByCiudad(String ciudad) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findByCiudad");
        query.setParameter(DomicilioDAOImpl.CIUDAD, ciudad);
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No se pudo buscar por la cuidad", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    }

    @Override
    public List<Domicilio> findByDireccion(String direccion) {
    
         EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findByDireccion");
        query.setParameter(DomicilioDAOImpl.DIRECCION, direccion);
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No se pudo buscar por la direccion", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    }

    @Override
    public List<Domicilio> findByTelefono(String telefono) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findByTelefono");
        query.setParameter(DomicilioDAOImpl.TELEFONO, telefono);
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el telefono", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    }
    
}
