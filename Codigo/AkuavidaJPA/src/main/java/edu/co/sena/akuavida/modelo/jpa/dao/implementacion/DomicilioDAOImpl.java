/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Domicilio;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDomicilioDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author maicolsteven
 */
public class DomicilioDAOImpl implements IDomicilioDAO{
    
    public static final String CIUDAD = "ciudad";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Domicilio entity) {
            
        EntityManager em = EntityManagerHelper.getEntityManager();
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
    public void update(Domicilio entity) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
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
    public void delete(Domicilio entity) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Domicilio.class, entity.getDomicilioPK().getCuentaTipoDocumento()));
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
    public Domicilio findByIDDomicilio() {
    
        Domicilio domicilioTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {

            domicilioTemporal = em.find(Domicilio.class, findByIDDomicilio().getDomicilioPK().getCuentaTipoDocumento());

        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domicilioTemporal;
    }

    @Override
    public List<Domicilio> findByAll() {
    
         EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findAll");
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    
    }

    @Override
    public List<Domicilio> findByCiudad(Object ciudad) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findByCiudad");
        query.setParameter(DomicilioDAOImpl.CIUDAD, ciudad);
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    }

    @Override
    public List<Domicilio> findByDireccion(Object direccion) {
    
         EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findByDireccion");
        query.setParameter(DomicilioDAOImpl.DIRECCION, direccion);
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    }

    @Override
    public List<Domicilio> findByTelefono(Object telefono) {
    
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Domicilio> domicilioTemporal = null;
        Query query = em.createNamedQuery("Domicilio.findByTelefono");
        query.setParameter(DomicilioDAOImpl.TELEFONO, telefono);
        try {
            domicilioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domicilioTemporal;
    }
    
}
