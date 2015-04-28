/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.entitis.Municipio;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.MunicipioDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IMunicipioDAO;
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
public class MunicipioDAOImplTest {

    Municipio entity = new Municipio();

    public MunicipioDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setIdMunicipio("2000");
        entity.setNombreMunicipio("Johana");
        entity.setDepartamentoidDepartamento(new Departamento("1"));
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
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setNombreMunicipio("Maicol");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        Municipio cct = instance.findByIDMunicipio("2000");
        instance.delete(cct);
    }

    @Test
    public void testFindByIdMunicipio() throws Exception {
        System.out.println("findByIdMunicipio");
        Municipio cct;
        String idMunicipio = "2000";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        cct = instance.findByIDMunicipio(idMunicipio);
        System.out.println(cct.getIdMunicipio());
    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        List<Municipio> result = instance.findByAll();
        for (Municipio result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByNombre() throws Exception {
        System.out.println("findByNombre");
        String nombre = "Johana";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        List<Municipio> result = instance.findByNombre(nombre);
        for (Municipio result1 : result) {
            System.out.println(result1.toString());
        }
    }

}
