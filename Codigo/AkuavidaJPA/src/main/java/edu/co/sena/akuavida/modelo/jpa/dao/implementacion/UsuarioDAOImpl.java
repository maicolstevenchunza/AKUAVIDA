/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Usuario;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IUsuarioDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author maicolsteven
 */
public class UsuarioDAOImpl implements IUsuarioDAO {

    public static final String ROL = "rol";
    public static final String ESTADO = "estado";
    public static final String CONTRASENA = "contrasena";
    public static final String CORREO = "correo";
    protected static final Logger logger = Logger.getLogger(UsuarioDAOImpl.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Usuario entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se insertaron los usuarios");
        } catch (RuntimeException re) {
            logger.error("No se insetaron los usuarios", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Usuario entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se Actualizaron los usuarios");

        } catch (RuntimeException re) {
            logger.error("No se actualizaron los usuarios", re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Usuario entity) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Usuario.class, entity.getIdUsuario()));
            EntityManagerHelper.commit();
            logger.info("Se Borraron los usuarios");

        } catch (RuntimeException re) {
            logger.error("No se Borraron los usuarios", re);

        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Usuario findByIDUsuario(String idUsuario) {

        Usuario usuarioTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {

            usuarioTemporal = em.find(Usuario.class, idUsuario);

        } catch (RuntimeException re) {
            logger.error("No se pudo buscar los usuarios por el ID", re);

        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByAll() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Usuario> usuarioTemporal = null;
        Query query = em.createNamedQuery("Usuario.findAll");
        try {
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No se pudo buscar Todos los usuarios ", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByRol(String rol) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Usuario> usuarioTemporal = null;
        Query query = em.createNamedQuery("Usuario.findByRol");
        query.setParameter(UsuarioDAOImpl.ROL, rol);
        try {
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar los usuarios por el Rol", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByEstado(String estado) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Usuario> usuarioTemporal = null;
        Query query = em.createNamedQuery("Usuario.findByEstado");
        query.setParameter(UsuarioDAOImpl.ESTADO, estado);
        try {
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar los usuarios por el Estado", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByContrasena(String contrasena) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Usuario> usuarioTemporal = null;
        Query query = em.createNamedQuery("Usuario.findByContrasena");
        query.setParameter(UsuarioDAOImpl.CONTRASENA, contrasena);
        try {
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("No se pudo buscar los usuarios por la Contraseña", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByCorreo(String correo) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Usuario> usuarioTemporal = null;
        Query query = em.createNamedQuery("Usuario.findByCorreo");
        query.setParameter(UsuarioDAOImpl.CORREO, correo);
        try {
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("No se pudo buscar los usuarios por el Correo", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

}
