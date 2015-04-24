/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.Pago;
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

    Pago entity = new Pago();

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
        entity.setFacturaIDFactura(1);
        entity.setTipoPago("Tarjeta Debito");
        entity.setNumeroTarjeta(("1234-5678-9087-7654"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class PagoDAOImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        PagoDAOImpl instance = new PagoDAOImpl();
        instance.insert(entity);

    }

    /**
     * Test of update method, of class PagoDAOImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setTipoPago("Tarjeta Credito");
        PagoDAOImpl instance = new PagoDAOImpl();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class PagoDAOImpl.
     */
    @Test
    public void testDelete() {

    }

    /**
     * Test of findByAll method, of class PagoDAOImpl.
     */
    @Test
    public void testFindByAll() {

    }

    /**
     * Test of findByFacturaIDFactura method, of class PagoDAOImpl.
     */
    @Test
    public void testFindByFacturaIDFactura() {

    }

    /**
     * Test of findByTipoPago method, of class PagoDAOImpl.
     */
    @Test
    public void testFindByTipoPago() {

    }

    /**
     * Test of findByNumeroTarjeta method, of class PagoDAOImpl.
     */
    @Test
    public void testFindByNumeroTarjeta() {
        
    }

}
