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

/**
 *
 * @author toshiba_
 */
public class ItemDaoImpl implements IItemDAO {

    public static final String CANTIDAD = "cantidad";
    public static final String COSTOTOTAL = "costoTotal";
    public static final String COSTOUNITARIO = "costoUnitario";

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
        } catch (RuntimeException re) {
            System.out.println(" Error : " + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
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
            System.out.println(" Error : " + re.getMessage());
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
            System.out.println("erorrr:----------------" + re.getMessage());
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
            System.out.println("Error : " + re.getMessage());
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
            System.out.println("Error : " + re.getMessage());
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
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemTemporal;
    }

}
