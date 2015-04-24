/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Item;
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
    public Item findByAll() {
        Item itemTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            itemTemporal = em.find(Item.class, findByAll().getItemPK());

        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemTemporal;
    }

    @Override
    public List<Item> findByCantidad(Object cantidad) {
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
    public List<Item> findByCostoTotal(Object costoTotal) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Item> itemTemporal = null;
        Query query = em.createNamedQuery("Item.findByCostoTotal");
        query.setParameter(ItemDaoImpl.COSTOTOTAL, costoTotal);
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
    public List<Item> findByCostoUnitario(Object costoUnitario) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Item> itemTemporal = null;
        Query query = em.createNamedQuery("Item.findByCostoUnitario");
        query.setParameter(ItemDaoImpl.COSTOUNITARIO, costoUnitario);
        try {
            itemTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemTemporal;
    }

}
