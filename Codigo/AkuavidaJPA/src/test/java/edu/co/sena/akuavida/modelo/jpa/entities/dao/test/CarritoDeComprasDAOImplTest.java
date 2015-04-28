/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.CarritoDeCompras;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CarritoComprasDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICarritosComprasDAO;
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
public class CarritoDeComprasDAOImplTest {

    CarritoDeCompras entity = new CarritoDeCompras();

    public CarritoDeComprasDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity.setIDCarrito("1");
        entity.setTotal(0);
        entity.setSubtotal(0);
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
        ICarritosComprasDAO ejemplo = fabrica.createCarritoComprasDAO();
        ejemplo.insert(entity);

    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        entity.setTotal(420000);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritosComprasDAO ejemplo = fabrica.createCarritoComprasDAO();
        ejemplo.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritosComprasDAO ejemplo = fabrica.createCarritoComprasDAO();
        CarritoDeCompras ct = ejemplo.findByIDCarrito("1");
        ejemplo.delete(ct);

    }

    @Test
    public void testFindByIdCarrito() throws Exception {
        System.out.println("findByIDCarrito");
        CarritoDeCompras ct;
        String idcarrito = "1";
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritosComprasDAO ejemplo = fabrica.createCarritoComprasDAO();
        ct = ejemplo.findByIDCarrito(idcarrito);
        System.out.println(ct.toString());

    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
       DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritosComprasDAO ejemplo = fabrica.createCarritoComprasDAO();
        List<CarritoDeCompras> result = ejemplo.findByAll();
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByTotal() throws Exception {
        System.out.println("findByTotal");
        double total = 0;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritosComprasDAO ejemplo = fabrica.createCarritoComprasDAO();
        List<CarritoDeCompras> result = ejemplo.findByTotal(total);
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindBySubtotal() throws Exception {
        System.out.println("findBySubtotal");
        double subtotal = 0;
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritosComprasDAO ejemplo = fabrica.createCarritoComprasDAO();
        List<CarritoDeCompras> result = ejemplo.findBySubtotal(subtotal);
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.toString());
        }
    }

}
