/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Municipio;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IMunicipioDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author maicolsteven
 */
public class MunicipioDAOImpl extends AbstractDAO implements IMunicipioDAO {

    public static final String NOMBREMUNICIPIO = "nombreMunicipio";
    protected static final Logger logger = Logger.getLogger(MunicipioDAOImpl.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Municipio entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron insertar el municipio");
        } catch (RuntimeException re) {
            logger.error("No se pudieron insertar los municipios", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Municipio entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron actualizar los municipios");
        } catch (RuntimeException re) {
            logger.error("No se pudieron actuzalizar los municipios", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Municipio entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Municipio.class, entity.getIdMunicipio()));
            EntityManagerHelper.commit();
            logger.info("Se pudieron eliminar los municipios");
        } catch (RuntimeException re) {
            logger.error("No se pudieron borrar los municipios", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }

    }

    @Override
    public Municipio findByIDMunicipio(String idMunicipio) {

        Municipio municipioTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            municipioTemporal = em.find(Municipio.class, idMunicipio);
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar el municipio por id", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return municipioTemporal;

    }

    @Override
    public List<Municipio> findByAll() {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Municipio> municipioTemporal = null;
        Query query = em.createNamedQuery("Municipio.findAll");
        try {
            municipioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar todos los municipios", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return municipioTemporal;

    }

    @Override
    public List<Municipio> findByNombre(String nombreMunicipio) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Municipio> municipioTemporal = null;
        try {
            Query query = em.createNamedQuery("Municipio.findByNombreMunicipio");
            query.setParameter(MunicipioDAOImpl.NOMBREMUNICIPIO, nombreMunicipio);
            municipioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudieron buscar los municipios por nombres", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return municipioTemporal;

    }

}
