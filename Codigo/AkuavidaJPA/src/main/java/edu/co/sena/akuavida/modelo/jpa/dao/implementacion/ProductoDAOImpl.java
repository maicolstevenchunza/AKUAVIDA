/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Producto;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IProductoDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Tatiana
 */
public class ProductoDAOImpl implements IProductoDAO{
    public static final String NOMBRE = "nombre";
    public static final String PRECIO = "precio";
    public static final String CANTIDAD = "cantidad";
    public static final String ACTIVO = "activo";
    public static final String IMPUESTO = "impuesto";

    @Override
    public void insert(Producto entity) {
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
    public void update(Producto entity) {
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
    public void delete(Producto entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Producto.class, entity.getIDproducto()));
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
    public Producto findByIDproducto(String idProducto) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Producto productoTemporal = null;
        try {

            productoTemporal = em.find(Producto.class, idProducto);

        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }

        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByAll() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findAll");
        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByNombre");
        query.setParameter(ProductoDAOImpl.NOMBRE, nombre);
        
        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;
        
    }

    @Override
    public List<Producto> findByPrecio(float precio) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByNombre");
        query.setParameter(ProductoDAOImpl.PRECIO, precio);
        
        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;
    }

    @Override
    public List<Producto> findByCantidad(int cantidad) {
         EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByNombre");
        query.setParameter(ProductoDAOImpl.CANTIDAD, cantidad);
        
        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;
        
    }

    @Override
    public List<Producto> findByActivo(boolean activo) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByNombre");
        query.setParameter(ProductoDAOImpl.ACTIVO, activo);
        
        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;
        
    }

    @Override
    public List<Producto> findByImpuesto(float impuesto) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByNombre");
        query.setParameter(ProductoDAOImpl.IMPUESTO, impuesto);
        
        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;
        
        
    }
    
}
