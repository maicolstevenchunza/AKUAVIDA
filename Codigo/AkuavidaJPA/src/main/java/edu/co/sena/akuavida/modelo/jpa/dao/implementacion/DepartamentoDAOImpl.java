/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDepartamentoDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author maicolsteven
 */
public class DepartamentoDAOImpl implements IDepartamentoDAO {

    public static final String NOMBREDEPARTAMENTO = "nombreDepartamento";
    protected static final Logger logger = Logger.getLogger( DepartamentoDAOImpl.class );

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Departamento entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el departamento");
        } catch (RuntimeException re) {
            logger.error("No se inserto el departamento", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Departamento entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el departamento");
        } catch (RuntimeException re) {
            logger.error("No se actualizo el departamento", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Departamento entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Departamento.class, entity.getIdDepartamento()));
            EntityManagerHelper.commit();
            logger.info("Se borro el departamento");
        } catch (RuntimeException re) {
            logger.error("No se borro el departamento", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Departamento findByIDDepartamento(String idDepartamento) {

        Departamento departamentoTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {

            departamentoTemporal = em.find(Departamento.class, idDepartamento);

        } catch (RuntimeException re) {
            logger.error("No se pudo buscar por el ID", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return departamentoTemporal;
    }

    @Override
    public List<Departamento> findByAll() {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Departamento> departamentoTemporal = null;
        Query query = em.createNamedQuery("Departamento.findAll");
        try {
            departamentoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se ipudo buscar todos los departamentos", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return departamentoTemporal;
    }

    @Override
    public List<Departamento> findByNombre(String nombreDepartamento) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Departamento> departamentoTemporal = null;
        Query query = em.createNamedQuery("Departamento.findByNombreDepartamento");
        query.setParameter(DepartamentoDAOImpl.NOMBREDEPARTAMENTO, nombreDepartamento);
        try {
            departamentoTemporal = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No se pudo buscar por nombre", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return departamentoTemporal;
    }

}
