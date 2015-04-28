/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.CarritoDeCompras;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICarritosComprasDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author ColsutecR
 */
public class CarritoComprasDAOImpl extends AbstractDAO implements ICarritosComprasDAO {
    
    public static final String TOTAL = "total";
    public static final String SUBTOTAL = "subtotal";
    protected static final Logger logger = Logger.getLogger( CarritoComprasDAOImpl.class );

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
        
    }

    
    @Override
    public void insert(CarritoDeCompras entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el carrito de compras");
        } catch (RuntimeException re) {
          logger.error("No se inserto el carrito", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
            EntityManagerHelper.log(TOTAL, Level.OFF, null);
        }

    }

    @Override
    public void update(CarritoDeCompras entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el carrito de compras");
        } catch (RuntimeException re) {
            logger.error("No se pudo actualizar el carrito de compras", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(CarritoDeCompras entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(CarritoDeCompras.class, entity.getIDCarrito()));
            EntityManagerHelper.commit();
            logger.info("Se borro el carrito de compras");
        } catch (RuntimeException re) {
            logger.error("No se borrar  el carrito de compras", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }
    
    @Override
    public CarritoDeCompras findByIDCarrito(String idCarrito) {
        CarritoDeCompras carritoTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {

            carritoTemporal = em.find(CarritoDeCompras.class, idCarrito);

        } catch (RuntimeException re) {
           logger.error("No se pudo buscar por el ID del carritos", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return carritoTemporal;
    }

    @Override
    public List<CarritoDeCompras> findByAll() {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<CarritoDeCompras> carritoTemporal = null;
        Query query = em.createNamedQuery("CarritoDeCompras.findAll");
        try {
            carritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar todos los carritos de compras", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return carritoTemporal;

    }

    @Override
    public List<CarritoDeCompras> findByTotal(Double total) {

         EntityManager em = EntityManagerHelper.getEntityManager();
        List<CarritoDeCompras> carritoTemporal = null;
        Query query = em.createNamedQuery("CarritoDeCompras.findByTotal");
        query.setParameter(CarritoComprasDAOImpl.TOTAL, total);
        try {
            carritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el total del carrito", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return carritoTemporal;
    }

    @Override
    public List<CarritoDeCompras> findBySubtotal(Double subtotal) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<CarritoDeCompras> carritoTemporal = null;
        Query query = em.createNamedQuery("CarritoDeCompras.findBySubtotal");
        query.setParameter(CarritoComprasDAOImpl.SUBTOTAL, subtotal);
        try {
            carritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el Subtotal del carrito", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return carritoTemporal;
    
    }

}
