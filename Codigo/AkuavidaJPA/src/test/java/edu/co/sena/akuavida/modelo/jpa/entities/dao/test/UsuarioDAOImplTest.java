/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Usuario;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.UsuarioDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IUsuarioDAO;

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

        entity.setIdUsuario("Usuariolool");
        entity.setRol("Cliente");
        entity.setEstado("Activo");
        entity.setContrasena("123456");
        entity.setCorreo("usuario1@gmail.com");
        

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() throws Exception {
        System.out.println("Insert");
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setCorreo("Maicol45@gmail.com");
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        Usuario cct = instance.findByIDUsuario("Usuario1");
        instance.delete(cct);
    }

    @Test
    public void testFindByIdUsuario() throws Exception {
        System.out.println("findByIdUsuario");
        Usuario cct;
        String idUsuario = "Usuario1";
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        cct = instance.findByIDUsuario(idUsuario);
        System.out.println(cct.toString());
    }

    @Test
    public void testFindbyAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByAll();
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByContrasena() throws Exception {
        System.out.println("findByContrasena");
        String contrasena = "123456";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByContrasena(contrasena);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByRol() throws Exception {
        System.out.println("findByRol");
        String rol = "Cliente";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByRol(rol);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByEstado() throws Exception {
        System.out.println("findByEstado");
        String activo = "Activo";
      DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByEstado(activo);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByCorreo() throws Exception {
        System.out.println("findByCorreo");
        String correo = "usuario1@gmail.com";
       DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByCorreo(correo);
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
        }
    }

}
