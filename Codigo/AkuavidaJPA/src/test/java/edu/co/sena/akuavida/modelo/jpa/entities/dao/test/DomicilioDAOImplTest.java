/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.entitis.Domicilio;
import edu.co.sena.akuavida.modelo.entitis.DomicilioPK;
import edu.co.sena.akuavida.modelo.entitis.Municipio;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.DomicilioDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDepartamentoDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDomicilioDAO;
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
public class DomicilioDAOImplTest {
    
    Domicilio entity = new Domicilio();

    public DomicilioDAOImplTest() {
    }

       
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setMunicipioidMunicipio(new Municipio("20009"));
        entity.setDomicilioPK(new DomicilioPK("C.C", "10337576329"));
        entity.setCiudad("El Bronx");
        entity.setDireccion("Calle 49 G # 6 A 29 sur ");
        entity.setTelefono("3217915742");
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
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        ejemplo.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setTelefono("3125487264");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        ejemplo.update(entity);
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        Domicilio cct = ejemplo.findByIDDomicilio(new DomicilioPK("C.C", "1033757632"));
        ejemplo.delete(cct);
    }
    
    @Test
    public void testFindByIDDomicilio() throws Exception {
        System.out.println("findByIDDomicilio");
        Domicilio cct;
        String idDomicilio = "C.C";
        String idDomicilio2 = "1033757632";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        cct =ejemplo.findByIDDomicilio(new DomicilioPK(idDomicilio, idDomicilio2));
        System.out.println(cct.toString());
    }
    
    @Test
    public void testFindbyAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        List<Domicilio> result = ejemplo.findByAll();
        for (Domicilio result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    
    @Test
    public void testFindByCiudad() throws Exception {
        System.out.println("findByCiudad");
        String ciudad = "El Bronx";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        List<Domicilio> result = ejemplo.findByCiudad(ciudad);
        for (Domicilio result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByDireccion() throws Exception {
        System.out.println("findByDireccion");
        String direccion = "Calle 49 G # 6 A 29 sur";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        List<Domicilio> result = ejemplo.findByDireccion(direccion);
        for (Domicilio result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByTelefono() throws Exception {
        System.out.println("findByTelefono");
        String telefono = "3217915742";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioDAO ejemplo = fabrica.createDomicilioDAO();
        List<Domicilio> result = ejemplo.findByTelefono(telefono);
        for (Domicilio result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
}
