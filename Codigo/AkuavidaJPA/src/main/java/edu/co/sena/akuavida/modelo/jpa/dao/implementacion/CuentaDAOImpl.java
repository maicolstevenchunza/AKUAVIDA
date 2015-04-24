/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICuentaDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author toshiba_
 */
public class CuentaDAOImpl implements ICuentaDAO {

    public static final String PRIMERNOMBRE = "primerNombre";
    public static final String SEGUNDONOMBRE = "segundoNombre";
    public static final String PRIMERAAPELLIDO = "primerApellido";
    public static final String SEGUNDOAPELLIDO = "segundoApellido";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
    public static final String ROOL = "rool";
    public static final String ACTIVO = "activo";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();

    }

    @Override
    public void insert(Cuenta entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Cuenta entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Cuenta entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Cuenta.class, entity.getCuentaPK()));
            EntityManagerHelper.commit();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }


    @Override
    public List<Cuenta> findByAll() {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findAll");
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println(" Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findByPrimerNombre(Object primerNombre) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findByPrimerNombre");
        query.setParameter(CuentaDAOImpl.PRIMERNOMBRE, primerNombre);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findBySegundoNombre(Object segundoNombre) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findBySegundoNombre");
        query.setParameter(CuentaDAOImpl.PRIMERNOMBRE, segundoNombre);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findByPrimerApellido(Object primerApellido) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findByPrimerApellido");
        query.setParameter(CuentaDAOImpl.PRIMERAAPELLIDO, primerApellido);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findBySegundoApellido(Object segundoApellido) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findBySegundoApellido");
        query.setParameter(CuentaDAOImpl.SEGUNDOAPELLIDO, segundoApellido);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findByDireccion(Object direccion) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findByDireccion");
        query.setParameter(CuentaDAOImpl.DIRECCION, direccion);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findByTelefono(Object telefono) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findByTelefono");
        query.setParameter(CuentaDAOImpl.TELEFONO, telefono);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findByRool(Object rool) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findByRool");
        query.setParameter(CuentaDAOImpl.ROOL, rool);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;
    }

    @Override
    public List<Cuenta> findByActivo(Object activo) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuentaTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findByActivo");
        query.setParameter(CuentaDAOImpl.ACTIVO, activo);
        try {
            cuentaTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuentaTemporal;

    }

}
