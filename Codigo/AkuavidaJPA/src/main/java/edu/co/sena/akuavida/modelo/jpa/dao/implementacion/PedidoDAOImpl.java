/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Pedido;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPedidoDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author toshiba_
 */
public class PedidoDAOImpl implements IPedidoDAO {

    public static final String SUBTOTAL = "subtotal";
    public static final String TOTAL = "total";
    public static final String FECHA = "fecha";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Pedido entity) {
        EntityManager em = getEntityManager();
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
    public void update(Pedido entity) {
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
    public void delete(Pedido entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Pedido.class, entity.getFacturaIDFactura()));
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
    public Pedido findByAll() {
        Pedido pedidoTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            pedidoTemporal = em.find(Pedido.class, findByAll().getFacturaIDFactura());
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pedidoTemporal;
    }

    @Override
    public List<Pedido> findByFecha(Object fecha) {
        Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        hoy.set(2015, 3, 24);
        Date fechaTemporal = hoy.getTime();
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Pedido> itemTemporal = null;
        Query query = em.createNamedQuery("Item.findByFecha");
        query.setParameter(PedidoDAOImpl.FECHA, fecha);
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
    public List<Pedido> findBySubtotal(Object subtotal) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Pedido> itemTemporal = null;
        Query query = em.createNamedQuery("Item.findBySubtotal");
        query.setParameter(PedidoDAOImpl.SUBTOTAL, subtotal);
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
    public List<Pedido> findByTotal(Object total) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Pedido> itemTemporal = null;
        Query query = em.createNamedQuery("Item.findByTotal");
        query.setParameter(PedidoDAOImpl.TOTAL, total);
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
