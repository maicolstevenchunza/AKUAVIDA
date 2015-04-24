/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Promociones;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPromocionesDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andrea
 */
public class PromocionesDAOImpl implements IPromocionesDAO {

    public static final String DEESCUENTOS = "descuentos";
    public static final String PRECIO = "precio";
    public static final String NOMBRE = "nombre";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Promociones entity) {

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
    public void update(Promociones entity) {

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
    public void delete(Promociones entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Promociones.class, entity.getIdPromocion()));
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
    public Promociones findByIDPromocion(int idPromocion) {
        EntityManager em = getEntityManager();
        Promociones promoTemporal = null;
        try {

            promoTemporal = em.find(Promociones.class, idPromocion);

        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }

        }
        return promoTemporal;
    }

    @Override
    public List<Promociones> findByAll() {

        EntityManager em = getEntityManager();
        List<Promociones> promoTemporales = null;
        Query query = em.createNamedQuery("Promociones.findAll");
        try {
            promoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return promoTemporales;
    }

    @Override
    public List<Promociones> findByDescuentos(Object descuentos) {
        EntityManager em = getEntityManager();
        List<Promociones> promoTemporales = null;
        Query query = em.createNamedQuery("Promociones.findByDescuentos");
        query.setParameter(PromocionesDAOImpl.DEESCUENTOS, descuentos);

        try {
            promoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return promoTemporales;
    }

    @Override
    public List<Promociones> findByNombre(Object nombre) {
        EntityManager em = getEntityManager();
        List<Promociones> promoTemporales = null;
        Query query = em.createNamedQuery("Promociones.findByNombre");
        query.setParameter(PromocionesDAOImpl.NOMBRE, nombre);

        try {
            promoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return promoTemporales;
    }

    @Override
    public List<Promociones> findByPrecio(Object precio) {
        EntityManager em = getEntityManager();
        List<Promociones> promoTemporales = null;
        Query query = em.createNamedQuery("Promociones.findByDescuentos");
        query.setParameter(PromocionesDAOImpl.PRECIO, precio);

        try {
            promoTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return promoTemporales;
    }

}
