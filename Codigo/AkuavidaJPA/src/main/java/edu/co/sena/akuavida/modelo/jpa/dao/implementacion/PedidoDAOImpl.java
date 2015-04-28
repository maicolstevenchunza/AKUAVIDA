/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Pedido;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPedidoDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author toshiba_
 */
public class PedidoDAOImpl extends AbstractDAO implements IPedidoDAO {

    public static final String IDFACTURA = "facturaIDFactura";
    public static final String SUBTOTAL = "subtotal";
    public static final String TOTAL = "total";
    public static final String FECHA = "fecha";
    protected static final Logger logger = Logger.getLogger(PedidoDAOImpl.class);

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
            logger.info("Se pudieron insertar el pedido");
        } catch (RuntimeException re) {
            logger.error("No se pudieron insertar el pedido", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(Pedido entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron acctualizar los pedido");
        } catch (RuntimeException re) {
            logger.error("No se pudieron actualizar los pedido", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

    }

    @Override
    public void delete(Pedido entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Pedido.class, entity.getFacturaIDFactura()));
            EntityManagerHelper.commit();
            logger.info("Se pudieron borrar los pedido");
        } catch (RuntimeException re) {
            logger.error("No pudieron borrar los pedido", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public Pedido findByAll() {
        Pedido pedidoTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            pedidoTemporal = em.find(Pedido.class, findByAll().getFacturaIDFactura());
        } catch (RuntimeException re) {
            logger.error("No pudieron buscar todos los pedido", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pedidoTemporal;
    }

    @Override
    public List<Pedido> findByFecha(Date fecha) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Pedido> pedidoTemporal = null;
        try {
            Query query = em.createNamedQuery("Pedido.findByFecha");
            query.setParameter(PedidoDAOImpl.FECHA, fecha);
            pedidoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No pudieron buscar todos los pedido por la Fecha", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pedidoTemporal;
    }

    @Override
    public List<Pedido> findBySubtotal(float subtotal) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Pedido> pedidoTemporal = null;
        try {
            Query query = em.createNamedQuery("Pedido.findBySubtotal");
            query.setParameter(PedidoDAOImpl.SUBTOTAL, subtotal);
            pedidoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No pudieron buscar todos los pedido por el Subtotal", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pedidoTemporal;
    }

    @Override
    public List<Pedido> findByTotal(float total) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Pedido> pedidoTemporal = null;

        try {
            Query query = em.createNamedQuery("Pedido.findByTotal");
            query.setParameter(PedidoDAOImpl.TOTAL, total);
            pedidoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No pudieron buscar todos los pedido por el Total", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pedidoTemporal;
    }

    @Override
    public Pedido findByFacturaIDFactura(int idFactura) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Pedido pedidoTemporal = null;
        try {

            pedidoTemporal = em.find(Pedido.class, idFactura);

        } catch (RuntimeException re) {
            logger.error("NO pudieron buscar todos los pedido por El ID", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return pedidoTemporal;
    }

}
