/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.entitis.Factura;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.FacturaDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IFacturaDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class FacturaDAOImplTest {
    Factura entity= new Factura();
    Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
    Date fechaActual = hoy.getTime();
    
    public FacturaDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        entity.setIDFactura(1);
        entity.setFecha(fechaActual);
        entity.setCuenta(new Cuenta("C.C", "1033757632"));
                
        
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
        IFacturaDAO ejemplo = fabrica.createFacturaDAO();
        ejemplo.insert(entity);
        
    }
    
     @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        entity.setIDFactura(1);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO ejemplo = fabrica.createFacturaDAO();
        ejemplo.update(entity);
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO ejemplo = fabrica.createFacturaDAO();
        Factura fact = ejemplo.findByIDFactura(1);
        ejemplo.delete(fact);
    }
    
     @Test
    public void testFindbyAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO ejemplo = fabrica.createFacturaDAO();
        List<Factura> result = ejemplo.findByAll();
        for (Factura result1 : result) {
            System.out.println(result1.getIDFactura());
        }
    }
    
     @Test
    public void testFindByIdFactura() throws Exception {
        System.out.println("findByIdFactura");
        Factura factt;
        int idFactura = 1;
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO ejemplo = fabrica.createFacturaDAO();
        factt = ejemplo.findByIDFactura(idFactura);
        
    }
    
    @Test
    public void testFindByFecha() throws Exception {
        System.out.println("FindByFecha");              
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO ejemplo = fabrica.createFacturaDAO();
        List<Factura> result = ejemplo.findByFecha(fechaActual);
        for (Factura result1 : result) {
            System.out.println(result1.toString());
        }

    }
}
