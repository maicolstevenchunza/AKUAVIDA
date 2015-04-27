/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Pedido;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.PedidoDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPedidoDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author toshiba_
 */
public class PedidoDAOImplTest {

    Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
    Date fechaActual = hoy.getTime();

    Pedido entity;

    public PedidoDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Pedido();
        entity.setFacturaIDFactura(1);
        entity.setSubtotal(420000);
        entity.setTotal(500000);
        entity.setFecha(fechaActual);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        instance.insert(entity);

    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        Pedido pt = instance.findByFacturaIDFactura(1);
        pt.setSubtotal(430000);
        instance.update(pt);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        Pedido pt = instance.findByFacturaIDFactura(1);
        instance.delete(pt);
    }

    @Test
    public void testFindByFacturaIDFactura() throws Exception {
        System.out.println("findByFacturaIDFactura");
        Pedido pt;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        pt = instance.findByFacturaIDFactura(1);
        System.out.println(pt.toString());
    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        PedidoDAOImpl instance = new PedidoDAOImpl();

    }

    @Test
    public void testFindBySubtotal() throws Exception {
        System.out.println("findBySubtotal");
        float subtotal = 420000;
       DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findBySubtotal(subtotal);
        for (Pedido result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByTotal() throws Exception {
        System.out.println("findByTotal");
        float total = 500000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findByTotal(total);
        for (Pedido result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByFecha() throws Exception {
        System.out.println("findByFecha");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findByFecha(fechaActual);
        for (Pedido result1 : result) {
            System.out.println(result1.toString());
        }

    }

}
