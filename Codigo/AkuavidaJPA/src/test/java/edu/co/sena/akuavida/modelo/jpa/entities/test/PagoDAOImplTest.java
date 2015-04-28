/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Pago;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.PagoDAOImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author toshiba_
 */
public class PagoDAOImplTest {

    Pago entity;

    public PagoDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Pago();
        entity.setFacturaIDFactura(1);
        entity.setNumeroTarjeta("1234-5678-9876-5432");
        entity.setTipoPago("Tarjeta Debito");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        PagoDAOImpl instance = new PagoDAOImpl();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        PagoDAOImpl instance = new PagoDAOImpl();
        Pago pt = instance.findByFacturaIDFactura(1);
        pt.setTipoPago("Tarjeta Credito ");
        instance.update(pt);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        PagoDAOImpl instance = new PagoDAOImpl();
        Pago pt = instance.findByFacturaIDFactura(1);
        instance.delete(pt);

    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        Pago pt;
        PagoDAOImpl instance = new PagoDAOImpl();
        pt = instance.findByFacturaIDFactura(1);
        System.out.println(pt.toString());

    }

    @Test
    public void testFindByFacturaIDFactura() {
        System.out.println("findByFacturaIDFactura");
        Pago pt;
        PagoDAOImpl instance = new PagoDAOImpl();
        pt = instance.findByFacturaIDFactura(1);
        System.out.println(pt.toString());
    }

    @Test
    public void testFindByTipoPago() {
        System.out.println("findByTipoPago");
        String tipoPago = "Tarjeta Debito";
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByTipoPago(tipoPago);
        for (Pago result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByNumeroTarjeta() {
        System.out.println("findByNumeroTarjeta");
        String numeroTarjeta = "1234-5678-9876-5432";
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByNumeroTarjeta(numeroTarjeta);
        for (Pago result1 : result) {
            System.out.println(result1.toString());
        }
    }

}
