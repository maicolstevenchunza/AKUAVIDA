/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.carritodecompras;

import edu.co.sena.akuavida.modelo.entitis.CarritoDeCompras;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CarritoComprasDAOImpl;
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
    CarritoDeCompras entity= new CarritoDeCompras();
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
    public void testInsert() {
        System.out.println("insert");
        CarritoComprasDAOImpl instance = new CarritoComprasDAOImpl();
        instance.insert(entity);
        
    }

}
