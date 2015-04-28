/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarrito;
import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarritoPK;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IItemCarritoDeComprasDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Tatiana
 */
public class ItemCarritoDeComprasDAOImpl extends AbstractDAO implements IItemCarritoDeComprasDAO {

    public static final String CANTIDAD = "cantidad";
    public static final String COSTOUNITARIO = "costoUnitario";
    public static final String COSTOTOTAL = "costoTotal";
    protected static final Logger logger = Logger.getLogger(ItemCarritoDeComprasDAOImpl.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(ItemsDelCarrito entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron insertar los items del carrito");
        } catch (RuntimeException re) {
            logger.error("No se pudieron insertar los items del carrito", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(ItemsDelCarrito entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("se pudieron actualizar los items del carrito");
        } catch (RuntimeException re) {
            logger.error("No se pudieron actualizar los items del carrito", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(ItemsDelCarrito entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = em.getReference(ItemsDelCarrito.class, entity.getItemsDelCarritoPK());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("se pudieron borrar los items del carrito");
        } catch (RuntimeException re) {
            logger.error("No se pudieron borrar los items del carrito", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public List<ItemsDelCarrito> findByAll() {
        EntityManager em = getEntityManager();
        List<ItemsDelCarrito> itemDecarritoTemporales = null;
        Query query = em.createNamedQuery("ItemsDelCarrito.findAll");
        try {
            itemDecarritoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los items del carrito", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemDecarritoTemporales;

    }

    @Override
    public List<ItemsDelCarrito> findByCantidad(int cantidad) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<ItemsDelCarrito> itemDecarritoTemporales = null;
        try {
            Query query = em.createNamedQuery("ItemsDelCarrito.findByCantidad");
            query.setParameter(ItemCarritoDeComprasDAOImpl.CANTIDAD, cantidad);
            itemDecarritoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los items del carrito por cantidad", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemDecarritoTemporales;
    }

    @Override
    public List<ItemsDelCarrito> findByCostoUnitario(float costoUnitario) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<ItemsDelCarrito> itemDecarritoTemporales = null;
        try {
            Query query = em.createNamedQuery("ItemsDelCarrito.findByCostoUnitario");
            query.setParameter(ItemCarritoDeComprasDAOImpl.COSTOUNITARIO, costoUnitario);
            itemDecarritoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los items del carrito por costo unitario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemDecarritoTemporales;
    }

    @Override
    public List<ItemsDelCarrito> findByCostoTotal(float costoTotal) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<ItemsDelCarrito> itemDecarritoTemporales = null;
        try {
            Query query = em.createNamedQuery("ItemsDelCarrito.findByCostoTotal");
            query.setParameter(ItemCarritoDeComprasDAOImpl.COSTOTOTAL, costoTotal);
            itemDecarritoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los items del carrito por costo total", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemDecarritoTemporales;
    }

    @Override
    public ItemsDelCarrito findByIDItemDeCarrito(ItemsDelCarritoPK itemsDelCarritoPK) {
        EntityManager em = getEntityManager();
        ItemsDelCarrito itemDecarritoTemporales = null;
        try {
            itemDecarritoTemporales = em.find(ItemsDelCarrito.class, itemsDelCarritoPK);
        } catch (RuntimeException re) {
            logger.error("No se puedieron buscar los items del carrito por id del item de carrito", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }

        }
        return itemDecarritoTemporales;
    }

}
