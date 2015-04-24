/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.Usuario;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ColsutecR
 */
public class UsuarioTestJPA {

    Usuario usuario;

    EntityManagerFactory emf;
    EntityManager em;

    public UsuarioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        usuario = new Usuario();
        usuario.setIdUsuario("1");
        usuario.setContrasena("123456789");
        usuario.setRol("Cliente");
        usuario.setEstado("Activo");
        usuario.setCorreo("jdmontero0@misena.edu.co");

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insertarUsuario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarUsuario() {

        String idUsu = JOptionPane.showInputDialog("Escriba el id del Usuario");
        String actRol = JOptionPane.showInputDialog("Escriba El Rol");

        usuario.setIdUsuario(idUsu);
        usuario.setRol(actRol);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnUsuario() {

        String idUsuario = JOptionPane.showInputDialog("Inserte El Id A Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Usuario usu = em.find(Usuario.class, idUsuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(usu.toString());
    }

    @Test
    public void borrarUnUsuario() {
        String idUsuario = JOptionPane.showInputDialog("Escriba el id del usuario a eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Usuario.class, idUsuario));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el usuario" + e.getMessage());
        }

    }

    @Test
    public void buscarUsuarios() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Ususario.findAll");
        List<Usuario> lis = q.getResultList();
        for (Usuario usuarioT : lis) {
            System.out.println("ID Usuario " + usuarioT.getIdUsuario() + " / Contrasena: " + usuarioT.getContrasena()+ " / Rol: " + usuarioT.getRol() + " / Estado: " + usuarioT.getEstado());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorPassword() {
        String password = JOptionPane.showInputDialog("Insertar el password del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Ususario.findByPassword");
        query.setParameter("password", password);

        List<Usuario> lis = query.getResultList();
        for (Usuario usuarioT : lis) {
            System.out.println("ID Usuario " + usuarioT.getIdUsuario() + " / Contrasena: " + usuarioT.getContrasena() + " / Rol: " + usuarioT.getRol() + " / Estado: " + usuarioT.getEstado());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    @Test
    public void buscarPorRool() {
        String rool = JOptionPane.showInputDialog("Insertar el rool del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Ususario.findByRol");
        query.setParameter("rol", rool);

        List<Usuario> lis = query.getResultList();
        for (Usuario usuarioT : lis) {
            System.out.println("ID Usuario " + usuarioT.getIdUsuario() + " / Contrasena: " + usuarioT.getContrasena() + " / Rol: " + usuarioT.getRol() + " / Estado: " + usuarioT.getEstado());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    @Test
    public void buscarPorEstado() {
        String estado = JOptionPane.showInputDialog("Insertar el estado del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Ususario.findByEstado");
        query.setParameter("estado", estado);

        List<Usuario> lis = query.getResultList();
        for (Usuario usuarioT : lis) {
            System.out.println("ID Usuario " + usuarioT.getIdUsuario() + " / Contrasena: " + usuarioT.getContrasena() + " / Rol: " + usuarioT.getRol() + " / Estado: " + usuarioT.getEstado());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }


}
