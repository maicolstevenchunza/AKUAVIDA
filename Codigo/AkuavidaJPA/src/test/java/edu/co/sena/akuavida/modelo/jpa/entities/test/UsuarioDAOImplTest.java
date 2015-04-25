/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Usuario;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.UsuarioDAOImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ColsutecR
 */
public class UsuarioDAOImplTest {
    
    Usuario entity = new Usuario();

    public UsuarioDAOImplTest() {
    }
    
    

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setIdUsuario("Usuario1");
        entity.setContrasena("123456");
        entity.setRol("Cliente");        
        entity.setEstado("Activo");
        entity.setCorreo("usuario1@gmail.com");
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
    public void testInsert() {
        System.out.println("Insert");
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() {
        System.out.println("Update");
        entity.setCorreo("Maicol45@gmail.com");
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() {
        System.out.println("delete");
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        Usuario cct = instance.findByIDUsuario("Usuario1");
        instance.delete(cct);
    }
    
    @Test
    public void testFindByIdUsuario() {
        System.out.println("findByIdUsuario");
        Usuario cct;
        String idUsuario = "Usuario1";
        UsuarioDAOImpl usu = new UsuarioDAOImpl();
        cct = usu.findByIDUsuario(idUsuario);
        System.out.println(cct.toString());
    }
    
    @Test
    public void testFindbyAll() {
        System.out.println("findByAll");
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        List<Usuario> result = instance.findByAll();
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    
    @Test
    public void testFindByContrasena() {
        System.out.println("findByContrasena");
        String contrasena = "123456";
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        List<Usuario> result = instance.findByContrasena(contrasena);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByRol() {
        System.out.println("findByRol");
        String rol = "Cliente";
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        List<Usuario> result = instance.findByRol(rol);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByEstado() {
        System.out.println("findByEstado");
        String activo = "Activo";
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        List<Usuario> result = instance.findByEstado(activo);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    
    @Test
    public void testFindByCorreo() {
        System.out.println("findByCorreo");
        String correo = "usuario1@gmail.com";
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        List<Usuario> result = instance.findByCorreo(correo);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
}
