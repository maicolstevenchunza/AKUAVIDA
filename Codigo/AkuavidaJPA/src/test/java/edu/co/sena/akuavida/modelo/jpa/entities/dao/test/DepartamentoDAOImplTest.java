/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.DepartamentoDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDepartamentoDAO;
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
public class DepartamentoDAOImplTest {

    Departamento entity = new Departamento();

    public DepartamentoDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setIdDepartamento("33");
        entity.setNombreDepartamento("Johana");
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
        System.out.println("Insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO ejemplo = fabrica.createDepartamentoDAO();
        ejemplo.insert(entity);
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setNombreDepartamento("Maicol");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO ejemplo = fabrica.createDepartamentoDAO();
        ejemplo.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO ejemplo = fabrica.createDepartamentoDAO();
        Departamento cct = ejemplo.findByIDDepartamento("33");
        ejemplo.delete(cct);
    }

    @Test
    public void testFindByIdDepartamento() throws Exception {
        System.out.println("findByIdDepartamento");
        Departamento cct;
        String idDepartamento = "33";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO ejemplo = fabrica.createDepartamentoDAO();
        cct = ejemplo.findByIDDepartamento(idDepartamento);
        System.out.println(cct.toString());
    }

    @Test
    public void testFindbyAll() throws Exception {
        System.out.println("findByAll");
       DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO ejemplo = fabrica.createDepartamentoDAO();
        List<Departamento> result = ejemplo.findByAll();
        for (Departamento result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByNombre() throws Exception {
        System.out.println("findByNombre");
        String nombre = "Johana";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO ejemplo = fabrica.createDepartamentoDAO();
        List<Departamento> result = ejemplo.findByNombre(nombre);
        for (Departamento result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
