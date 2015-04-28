/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.CarritoDeCompras;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CarritoComprasDAOImpl;
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
    
     @Test
    public void testUpdate() throws Exception{
        System.out.println("update");
        entity.setTotal(420000);
        CarritoComprasDAOImpl instance = new CarritoComprasDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        CarritoComprasDAOImpl instance = new CarritoComprasDAOImpl();
        CarritoDeCompras ct = instance.findByIDCarrito("1");
        instance.delete(ct);
        
    }
    
     @Test
    public void testFindByIdCarrito() {
        System.out.println("findByIDCarrito");
        CarritoDeCompras ct;
        String idcarrito = "1";
        CarritoComprasDAOImpl carrito = new CarritoComprasDAOImpl();
        ct = carrito.findByIDCarrito(idcarrito);
        System.out.println(ct.toString());

    }
    
     @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        CarritoComprasDAOImpl instance = new CarritoComprasDAOImpl();
        List<CarritoDeCompras> result = instance.findByAll();
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
     @Test
    public void testFindByTotal() {
        System.out.println("findByTotal");
        double total = 0;
        CarritoComprasDAOImpl instance = new CarritoComprasDAOImpl();
        List<CarritoDeCompras> result = instance.findByTotal(total);
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindBySubtotal() {
        System.out.println("findBySubtotal");
        double subtotal = 0;
        CarritoComprasDAOImpl instance = new CarritoComprasDAOImpl();
        List<CarritoDeCompras> result = instance.findBySubtotal(subtotal);
         for (CarritoDeCompras result1 : result) {
            System.out.println(result1.toString());
        }
    }

}
