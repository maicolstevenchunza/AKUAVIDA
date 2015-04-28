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
import org.apache.log4j.Logger;

/**
 *
 * @author toshiba_
 */
public class PagoDAOImpl extends AbstractDAO implements IPagoDAO {

    public static final String IDFACTURA = "facturaIDFactura";
    public static final String TIPOPAGO = "tipoPago";
    public static final String NUMEROTARJETA = "numeroTarjeta";
    protected static final Logger logger = Logger.getLogger(PagoDAOImpl.class);

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
            logger.info("Se pudieron insertar el pago");
        } catch (RuntimeException re) {
            logger.error("No se pudieron insertar el pago", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(Pago entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudo actualizar el pago");

        } catch (RuntimeException re) {
            logger.error("No se pudo actualizar el pago", re);

        } finally {
            EntityManagerHelper.closeEntityManager();
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
            logger.info("Se pudo borrar el pago");

        } catch (RuntimeException re) {
            logger.error("No se pudo borrar el pago", re);

        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public List<Pago> findByAll() {
        EntityManager em = getEntityManager();
        List<Pago> pagoTemporal = null;
        try {
            Query query = em.createNamedQuery("Pago.findAll");
            pagoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar todos los pagos", re);

        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pagoTemporal;
    }

    @Override
    public Pago findByFacturaIDFactura(int idFactura) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Pago pagoTemporal = null;
        try {
            pagoTemporal = em.find(Pago.class, idFactura);

        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los pagos por ID", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pagoTemporal;
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
            logger.error("No se pudieron buscar los pagos por Tipo de Pago", re);

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
            logger.error("No se pudieron buscar los pagos por el Numero De Tarjeta", re);

        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pagoTemporal;
    }

}
