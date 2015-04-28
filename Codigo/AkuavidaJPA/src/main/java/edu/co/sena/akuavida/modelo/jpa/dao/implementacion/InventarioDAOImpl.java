/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Inventario;
import edu.co.sena.akuavida.modelo.entitis.InventarioPK;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IInventarioDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Andrea
 */
public class InventarioDAOImpl extends AbstractDAO implements IInventarioDAO {

    public static final String PRODID = "producto";
    public static final String CANTIDADPROD = "cantidadProd";
    public static final String FECHA = "fechaDeCompra";
    protected static final Logger logger = Logger.getLogger(InventarioDAOImpl.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Inventario entity) {

        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudo insertar el inventario");
        } catch (RuntimeException re) {
            logger.error("No se pudo insertar el inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(Inventario entity) {

        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudo actualizar el inventario");
        } catch (RuntimeException re) {
            logger.error("No se pudo actualizar el inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void delete(Inventario entity) {

        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Inventario.class, entity.getInventarioPK()));
            EntityManagerHelper.commit();
            logger.info("Se pudo eliminar el inventario");
        } catch (RuntimeException re) {
            logger.error("No se pudo eliminar el inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public Inventario findByIDInventario(InventarioPK inventarioPK) {

        EntityManager em = getEntityManager();
        Inventario inventarioTemporal = null;
        try {

            inventarioTemporal = em.find(Inventario.class, inventarioPK);

        } catch (RuntimeException re) {
            logger.error("No se pudo buscar el inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();

        }
        return inventarioTemporal;
    }

    @Override
    public List<Inventario> findByAll() {

        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;

        try {
            Query query = em.createNamedQuery("Inventario.findAll");
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar todos los inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }

    @Override
    public List<Inventario> findByProductoIDproducto(Object prod) {

        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;

        try {
            Query query = em.createNamedQuery("Inventario.findByProductoIDproducto");
            query.setParameter(InventarioDAOImpl.PRODID, prod);
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por id de producto el inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }

    @Override
    public List<Inventario> findByCantidadProductoComprado(float cantProdComprado) {

        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;

        try {
            Query query = em.createNamedQuery("Inventario.findByCantidadProductoComprado");
            query.setParameter(InventarioDAOImpl.CANTIDADPROD, cantProdComprado);
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por cantidad comprada el inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }

    @Override
    public List<Inventario> findByFechaDeCompra(Object fecha) {

        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;

        try {
            Query query = em.createNamedQuery("Inventario.findByFechaDeCompra");
            query.setParameter(InventarioDAOImpl.FECHA, fecha);
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por fecha el inventario", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }

}
