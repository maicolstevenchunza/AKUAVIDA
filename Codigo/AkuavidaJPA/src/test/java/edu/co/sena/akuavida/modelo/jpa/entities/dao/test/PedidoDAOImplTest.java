/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Pedido;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.PedidoDAOImpl;
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
    public void testInsert() {
        System.out.println("insert");
        PedidoDAOImpl instance = new PedidoDAOImpl();
        instance.insert(entity);

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        PedidoDAOImpl instance = new PedidoDAOImpl();
        Pedido pt = instance.findByFacturaIDFactura(1);
        pt.setSubtotal(430000);
        instance.update(pt);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        PedidoDAOImpl instance = new PedidoDAOImpl();
        Pedido pt = instance.findByFacturaIDFactura(1);
        instance.delete(pt);
    }

    @Test
    public void testFindByFacturaIDFactura() {
        System.out.println("findByFacturaIDFactura");
        Pedido pt;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        pt = instance.findByFacturaIDFactura(1);
        System.out.println(pt.toString());
    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        PedidoDAOImpl instance = new PedidoDAOImpl();

    }

    @Test
    public void testFindBySubtotal() {
        System.out.println("findBySubtotal");
        float subtotal = 420000;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findBySubtotal(subtotal);
        for (Pedido result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByTotal() {
        System.out.println("findByTotal");
        float total = 500000;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findByTotal(total);
        for (Pedido result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByFecha() {
        System.out.println("findByFecha");
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findByFecha(fechaActual);
        for (Pedido result1 : result) {
            System.out.println(result1.toString());
        }

    }

}
