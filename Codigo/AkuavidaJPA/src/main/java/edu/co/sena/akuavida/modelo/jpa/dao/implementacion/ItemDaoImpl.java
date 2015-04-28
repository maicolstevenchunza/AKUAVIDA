/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Item;
import edu.co.sena.akuavida.modelo.entitis.ItemPK;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IItemDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author toshiba_
 */
public class ItemDaoImpl extends AbstractDAO implements IItemDAO {

    public static final String CANTIDAD = "cantidad";
    public static final String COSTOTOTAL = "costoTotal";
    public static final String COSTOUNITARIO = "costoUnitario";
    protected static final Logger logger = Logger.getLogger(ItemDaoImpl.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();

    }

    @Override
    public void insert(Item entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron insertar los items");
        } catch (RuntimeException re) {
            logger.error("No se pudieron insertar los items",re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }

    }

    @Override
    public void update(Item entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron actualizar los items");
        } catch (RuntimeException re) {
            logger.error("No se pudieron actualizar los items", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Item entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Item.class, entity.getItemPK()));
            EntityManagerHelper.commit();
            logger.info("Se pudieron eliminar los items");
        } catch (RuntimeException re) {
            logger.error("No se pudieron eliminar los items", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Item findByIDItem(ItemPK itemsPK) {
        EntityManager em = getEntityManager();
        Item itemTemporales = null;
        try {
            itemTemporales = em.find(Item.class, itemsPK);
        } catch (RuntimeException re) {
             logger.error("No se pudieron buscar los items por id", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemTemporales;
    }

    @Override
    public List<Item> findByAll() {
        EntityManager em = getEntityManager();
        List<Item> itemTemporales = null;
        Query query = em.createNamedQuery("Item.findAll");
        try {
            itemTemporales = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No se pudieron buscar todos los items por id", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemTemporales;
    }

    @Override
    public List<Item> findByCantidad(int cantidad) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Item> itemTemporal = null;
        Query query = em.createNamedQuery("Item.findByCantidad");
        query.setParameter(ItemDaoImpl.CANTIDAD, cantidad);
        try {
            itemTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los items por cantidad", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemTemporal;
    }

    @Override
    public List<Item> findByCostoTotal(float costoTotal) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Item> itemTemporal = null;
        try {
            Query query = em.createNamedQuery("Item.findByCostoTotal");
            query.setParameter(ItemDaoImpl.COSTOTOTAL, costoTotal);
            itemTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los items por costo total", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemTemporal;
    }

    @Override
    public List<Item> findByCostoUnitario(float costoUnitario) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Item> itemTemporal = null;
        try {
            Query query = em.createNamedQuery("Item.findByCostoUnitario");
            query.setParameter(ItemDaoImpl.COSTOUNITARIO, costoUnitario);
            itemTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los items por costo unitario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemTemporal;
    }

}
