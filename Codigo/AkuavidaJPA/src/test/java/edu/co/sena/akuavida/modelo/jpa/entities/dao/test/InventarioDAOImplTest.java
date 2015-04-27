/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Inventario;
import edu.co.sena.akuavida.modelo.entitis.InventarioPK;
import edu.co.sena.akuavida.modelo.entitis.Producto;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.InventarioDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IInventarioDAO;
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
 * @author ColsutecR
 */
public class InventarioDAOImplTest {

    Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
    Date fechaActual = hoy.getTime();
    Date fechaTemporal = hoy.getTime();

    Inventario entity = new Inventario();

    public InventarioDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setInventarioPK(new InventarioPK(1, "1"));
        entity.setFechaDeCompra(fechaActual);
        entity.setProducto(new Producto("1"));
        entity.setCantidadProductoComprado(5);

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
        IInventarioDAO ejemplo = fabrica.createInventarioDAO();
        ejemplo.insert(entity);

    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        entity.setCantidadProductoComprado(1);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO ejemplo = fabrica.createInventarioDAO();
        ejemplo.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO ejemplo = fabrica.createInventarioDAO();
        Inventario it = ejemplo.findByIDInventario(new InventarioPK(1, "1"));
        ejemplo.delete(it);

    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO ejemplo = fabrica.createInventarioDAO();
        List<Inventario> result = ejemplo.findByAll();
        for (Inventario result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByIdInventario() throws Exception {
        System.out.println("FindByIdInventario");
        Inventario it;
        String idProducto = "1";
        int idInventario = 1;
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO ejemplo = fabrica.createInventarioDAO();
        it = ejemplo.findByIDInventario(new InventarioPK(idInventario, idProducto));
        System.out.println(it.toString());

    }

    @Test
    public void testFindByCantidadProductoComprado() throws Exception {
        System.out.println("FindByCantidadProductoComprado");
        float cantidad = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO ejemplo = fabrica.createInventarioDAO();
        List<Inventario> result = ejemplo.findByCantidadProductoComprado(cantidad);
        for (Inventario result1 : result) {
            System.out.println(result1.toString());
        }

    }

    @Test
    public void testFindByFechaDeCompra() throws Exception {
        System.out.println("FindByFecha");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO ejemplo = fabrica.createInventarioDAO();
        List<Inventario> result = ejemplo.findByFechaDeCompra(fechaActual);
        for (Inventario result1 : result) {
            System.out.println(result1.toString());
        }

    }

}
