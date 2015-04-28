/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Categorias;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICategoriaDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Tatiana
 */
public class CategoriaDAOImpl extends AbstractDAO implements ICategoriaDAO {

    public static final String NOMBRE = "nombre";
    public static final String ACTIVA = "activa";
    public static final String PARIENTE = "pariente";
    protected static final Logger logger = Logger.getLogger(CategoriaDAOImpl.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Categorias entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto la categoria con satisfaccion");
        } catch (RuntimeException re) {
            logger.error("No se inserto la categoria", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }

    }

    @Override
    public void update(Categorias entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo la categoria con satisfaccion");
        } catch (RuntimeException re) {
            logger.error("No se actualizo la categoria", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Categorias entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = em.getReference(Categorias.class,
                    entity.getIDCategoria());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se borro la categoria con satisfaccion");
        } catch (RuntimeException re) {
            logger.error("No se borro la categoria", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Categorias findByIDCategoria(int idCategoria) {
        EntityManager em = getEntityManager();
        Categorias categoriaTemporal = null;
        try {

            categoriaTemporal = em.find(Categorias.class, idCategoria);

        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el ID de la categoria", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }

        }
        return categoriaTemporal;
    }

    @Override
    public List<Categorias> findByAll() {
        EntityManager em = getEntityManager();
        List<Categorias> categoriasTemporales = null;

        try {
            Query query = em.createNamedQuery("Categorias.findAll");
            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar todas las categorias", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

    @Override
    public List<Categorias> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Categorias> categoriasTemporales = null;

        try {
            Query query = em.createNamedQuery("Categorias.findByNombre");
            query.setParameter(CategoriaDAOImpl.NOMBRE, nombre);

            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el nombre de la categoria", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

    @Override
    public List<Categorias> findByActiva(boolean activa) {
        EntityManager em = getEntityManager();
        List<Categorias> categoriasTemporales = null;

        try {
            Query query = em.createNamedQuery("Categorias.findByActiva");
            query.setParameter(CategoriaDAOImpl.ACTIVA, activa);
            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por activa la categoria", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

    @Override
    public List<Categorias> findByPariente(int pariente) {
        EntityManager em = getEntityManager();
        List<Categorias> categoriasTemporales = null;

        try {
            Query query = em.createNamedQuery("Categorias.findByPariente");
            query.setParameter(CategoriaDAOImpl.PARIENTE, pariente);
            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el Pariente de la categoria", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

}
