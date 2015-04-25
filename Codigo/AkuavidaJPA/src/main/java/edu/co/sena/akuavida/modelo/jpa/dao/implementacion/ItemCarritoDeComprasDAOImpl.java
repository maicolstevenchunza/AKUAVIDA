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

/**
 *
 * @author Tatiana
 */
public class ItemCarritoDeComprasDAOImpl implements IItemCarritoDeComprasDAO {

    public static final String CANTIDAD = "cantidad";
    public static final String COSTOUNITARIO = "costoUnitario";
    public static final String COSTOTOTAL = "costoTotal";

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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemDecarritoTemporales;

    }

    @Override
    public List<ItemsDelCarrito> findByCantidad(int cantidad) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<ItemsDelCarrito> itemDecarritoTemporales = null;
        Query query = em.createNamedQuery("ItemsDelCarrito.findByCantidad");
        query.setParameter(ItemCarritoDeComprasDAOImpl.CANTIDAD, cantidad);

        try {
            itemDecarritoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemDecarritoTemporales;
    }

    @Override
    public List<ItemsDelCarrito> findByCostoUnitario(float costoUnitario) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<ItemsDelCarrito> itemDecarritoTemporales = null;
        Query query = em.createNamedQuery("ItemsDelCarrito.findByCostoUnitario");
        query.setParameter(ItemCarritoDeComprasDAOImpl.COSTOUNITARIO, costoUnitario);

        try {
            itemDecarritoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return itemDecarritoTemporales;
    }

    @Override
    public List<ItemsDelCarrito> findByCostoTotal(float costoTotal) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<ItemsDelCarrito> itemDecarritoTemporales = null;
        Query query = em.createNamedQuery("ItemsDelCarrito.findByCostoTotal");
        query.setParameter(ItemCarritoDeComprasDAOImpl.COSTOTOTAL, costoTotal);

        try {
            itemDecarritoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }

        }
        return itemDecarritoTemporales;
    }

}
