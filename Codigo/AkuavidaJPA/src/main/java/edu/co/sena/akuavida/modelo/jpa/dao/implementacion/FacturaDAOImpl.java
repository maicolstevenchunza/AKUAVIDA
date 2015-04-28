/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Factura;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IFacturaDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Andrea
 */
public class FacturaDAOImpl extends AbstractDAO implements IFacturaDAO{
    
    public static final String FECHA = "fecha";
    protected static final Logger logger = Logger.getLogger( FacturaDAOImpl.class );

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Factura entity) {
         EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
             logger.info("Se inserto la factura");
        } catch (RuntimeException re) {
           logger.error("No se inserto la factura", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Factura entity) {
        
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
             logger.info("Se actualizo la factura");
        } catch (RuntimeException re) {
            logger.error("No se puedo actualizar la factura", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Factura entity) {
        
         EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Factura.class, entity.getIDFactura()));
            EntityManagerHelper.commit();
             logger.info("Se elimino la factura");
        } catch (RuntimeException re) {
            logger.error("No se pudo eliminar la factura", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Factura findByIDFactura(int idFactura) {
         Factura facTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {

            facTemporal = em.find(Factura.class,idFactura);

        } catch (RuntimeException re) {
            logger.error("No se pudo buscar la factura", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return facTemporal;
    }

    @Override
    public List<Factura> findByAll() {
EntityManager em = getEntityManager();
        List<Factura> facTemporales = null;
        Query query = em.createNamedQuery("Factura.findAll");
        try {
            facTemporales = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No se pudo buscar todas las facturas", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return facTemporales;
    }

    @Override
    public List<Factura> findByFecha(Date fecha) {
  EntityManager em = getEntityManager();
        List<Factura> facTemporales = null;
        Query query = em.createNamedQuery("Factura.findByFecha");
        query.setParameter(FacturaDAOImpl.FECHA, fecha);

        try {
            facTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar la factura por fecha", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return facTemporales;    }
    
}
