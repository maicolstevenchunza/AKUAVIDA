/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Categorias;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CategoriaDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICategoriaDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tatiana
 */
public class CategoriaDAOImplTest {

    Categorias entity = new Categorias();

    public CategoriaDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity.setIDCategoria(1);
        entity.setNombre("Categoria prueba");
        entity.setActiva(true);
        entity.setPariente(1);

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
    public void testInsert() throws Exception {
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        ejemplo.insert(entity);

    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        ejemplo.findByIDCategoria(1);
        entity.setNombre("moe");
        ejemplo.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        Categorias ct = ejemplo.findByIDCategoria(1);
        ejemplo.delete(ct);
    }

    @Test
    public void testFindByIdCategoria() throws Exception {
        System.out.println("findByIdCategoria");
        Categorias ct;
        int idCategoria = 2;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        ct = ejemplo.findByIDCategoria(idCategoria);
        System.out.println(ct.toString());

    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        List<Categorias> result = ejemplo.findByAll();
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByNombre() throws Exception {
        System.out.println("findByNombre");
        String nombre = "Categoria prueba";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        List<Categorias> result = ejemplo.findByNombre(nombre);
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByActiva() throws Exception {
        System.out.println("findByActiva");
        boolean activa = true;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        List<Categorias> result = ejemplo.findByActiva(activa);
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByPariente() throws Exception {
        System.out.println("findByPariente");
        int pariente = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO ejemplo = fabrica.createCategoriaDAO();
        List<Categorias> result = ejemplo.findByPariente(pariente);
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }

}
