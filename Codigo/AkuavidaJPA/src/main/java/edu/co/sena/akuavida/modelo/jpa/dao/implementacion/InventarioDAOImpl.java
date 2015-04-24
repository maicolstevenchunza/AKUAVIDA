/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Inventario;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IInventarioDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andrea
 */
public class InventarioDAOImpl implements IInventarioDAO{
    
     public static final String PRODID = "producto";
    public static final String CANTIDADPROD = "cantidadProd";
    public static final String FECHA = "fechaDeCompra";
    
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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Inventario entity) {
        
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
    public void delete(Inventario entity) {
        
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Inventario.class, entity.getInventarioPK()));
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
    public Inventario findByIDInventario(int idInventario) {
        
         EntityManager em = getEntityManager();
        Inventario inventarioTemporal = null;
        try {

            inventarioTemporal = em.find(Inventario.class, idInventario);

        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }

        }
        return inventarioTemporal;
    }

    @Override
    public List<Inventario> findByAll() {
       
        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;
        Query query = em.createNamedQuery("Inventario.findAll");
        try {
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }

    @Override
    public List<Inventario> findByProductoIDproducto(Object prod) {
       
         EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;
        Query query = em.createNamedQuery("Inventario.findByProductoIDproducto");
        query.setParameter(InventarioDAOImpl.PRODID, prod);

        try {
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }

    @Override
    public List<Inventario> findByCantidadProductoComprado(Object cantProdComprado) {
        
        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;
        Query query = em.createNamedQuery("Inventario.findByCantidadProductoComprado");
        query.setParameter(InventarioDAOImpl.CANTIDADPROD, cantProdComprado);

        try {
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }

    @Override
    public List<Inventario> findByFechaDeCompra(Object fecha) {
       
         EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporales = null;
        Query query = em.createNamedQuery("Inventario.findByFechaDeCompra");
        query.setParameter(InventarioDAOImpl.FECHA, fecha);

        try {
            inventarioTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporales;
    }
    
   
    
     
}
