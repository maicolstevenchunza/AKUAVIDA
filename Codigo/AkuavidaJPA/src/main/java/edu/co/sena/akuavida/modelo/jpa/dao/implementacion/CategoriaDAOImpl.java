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

/**
 *
 * @author Tatiana
 */
public class CategoriaDAOImpl implements ICategoriaDAO {

    public static final String NOMBRE = "nombre";
    public static final String ACTIVA = "activa";
    public static final String PARIENTE = "pariente";

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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
            em.remove(em.find(Categorias.class, entity.getIDCategoria()));
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
    public Categorias findByIDCategoria(int idCategoria) {
        EntityManager em = getEntityManager();
        Categorias categoriaTemporal = null;
        try {

            categoriaTemporal = em.find(Categorias.class, idCategoria);

        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
        Query query = em.createNamedQuery("Categorias.findAll");
        try {
            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

    @Override
    public List<Categorias> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Categorias> categoriasTemporales = null;
        Query query = em.createNamedQuery("Categorias.findByNombre");
        query.setParameter(CategoriaDAOImpl.NOMBRE, nombre);

        try {
            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

    @Override
    public List<Categorias> findByActiva(boolean activa) {
        EntityManager em = getEntityManager();
        List<Categorias> categoriasTemporales = null;
        Query query = em.createNamedQuery("Categorias.findByActiva");
        query.setParameter(CategoriaDAOImpl.ACTIVA, activa);
        try {
            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

    @Override
    public List<Categorias> findByPariente(int pariente) {
        EntityManager em = getEntityManager();
        List<Categorias> categoriasTemporales = null;
        Query query = em.createNamedQuery("Categorias.findByPariente");
        query.setParameter(CategoriaDAOImpl.PARIENTE, pariente);
        try {
            categoriasTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriasTemporales;
    }

}
