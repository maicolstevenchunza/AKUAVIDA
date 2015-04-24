/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Pago;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPagoDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author toshiba_
 */
public class PagoDAOImpl implements IPagoDAO {

    public static final String IDFACTURA = "idFactura";
    public static final String TIPOPAGO = "tipoPago";
    public static final String NUMEROTARJETA = "numeroTarjeta";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();

    }

    @Override
    public void insert(Pago entity) {
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
    public void update(Pago entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
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
    public void delete(Pago entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Pago.class, entity.getFacturaIDFactura());
            em.remove(entity);
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
    public List<Pago> findByAll() {
        EntityManager em = getEntityManager();
        List<Pago> pagoTemporal = null;
        Query query = em.createNamedQuery("Pago.findAll");
        try {
            pagoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println(" Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pagoTemporal;
    }

    @Override
    public Pago findByFacturaIDFactura(int idFactura) {
        EntityManager em = getEntityManager();
        List<Pago> pagoTemporal = null;
        Query query = em.createNamedQuery("Pago.findByFacturaIDFactura");
        query.setParameter(PagoDAOImpl.IDFACTURA, idFactura);
        try {
            pagoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println(" Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return (Pago) pagoTemporal;
    }
    

    @Override
    public List<Pago> findByTipoPago(String tipoPago) {
        EntityManager em = getEntityManager();
        List<Pago> pagoTemporal = null;

        try {
            Query query = em.createNamedQuery("Pago.findByTipoPago");
            query.setParameter(PagoDAOImpl.TIPOPAGO, tipoPago);
            pagoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println(" Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pagoTemporal;

    }

    @Override
    public List<Pago> findByNumeroTarjeta(String numeroTarjeta) {
       
        EntityManager em = getEntityManager();
        List<Pago> pagoTemporal = null;
        try {
            Query query = em.createNamedQuery("Pago.findByNumeroTarjeta");
            query.setParameter(PagoDAOImpl.NUMEROTARJETA, numeroTarjeta);
            pagoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println(" Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pagoTemporal;
    }

}
