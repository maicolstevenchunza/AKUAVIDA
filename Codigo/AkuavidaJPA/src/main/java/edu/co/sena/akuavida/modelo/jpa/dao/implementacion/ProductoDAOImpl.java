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
import org.apache.log4j.Logger;

/**
 *
 * @author Tatiana
 */
public class ProductoDAOImpl extends AbstractDAO implements IProductoDAO {

    public static final String NOMBRE = "nombre";
    public static final String PRECIO = "precio";
    public static final String CANTIDAD = "cantidad";
    public static final String ACTIVO = "activo";
    public static final String IMPUESTO = "impuesto";
    protected static final Logger logger = Logger.getLogger(ProductoDAOImpl.class);

    @Override
    public void insert(Producto entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron insertar los productos");
        } catch (RuntimeException re) {
            logger.error("Se pudieron insertar los productos", re);
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
            logger.info("Se pudieron actualizar los producto");
        } catch (RuntimeException re) {
            logger.error("No pudieron actualizar los productos", re);
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
            entity = em.getReference(Producto.class,
                    entity.getIDproducto());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se pudieron borrar los producto");
        } catch (RuntimeException re) {
            logger.error("No pudieron borrar los productos", re);
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
            logger.error("No pudieron buscar los productos por el ID", re);
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
            logger.error("No pudieron buscar todos los productos ", re);

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
            logger.error("No pudieron buscar los productos por el Nombre", re);

        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;

    }

    @Override
    public List<Producto> findByPrecio(float precio) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByPrecio");
        query.setParameter(ProductoDAOImpl.PRECIO, precio);

        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No pudieron buscar los productos por el Precio", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;
    }

    @Override
    public List<Producto> findByCantidad(int cantidad) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByCantidad");
        query.setParameter(ProductoDAOImpl.CANTIDAD, cantidad);

        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No pudieron buscar los productos por la Cantidad", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;

    }

    @Override
    public List<Producto> findByActivo(boolean activo) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByActivo");
        query.setParameter(ProductoDAOImpl.ACTIVO, activo);

        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No pudieron buscar los productos por el Activo", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;

    }

    @Override
    public List<Producto> findByImpuesto(float impuesto) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Producto> productosTemporales = null;
        Query query = em.createNamedQuery("Producto.findByImpuesto");
        query.setParameter(ProductoDAOImpl.IMPUESTO, impuesto);

        try {
            productosTemporales = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No pudieron buscar los productos por el Impuesto", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productosTemporales;

    }

}
