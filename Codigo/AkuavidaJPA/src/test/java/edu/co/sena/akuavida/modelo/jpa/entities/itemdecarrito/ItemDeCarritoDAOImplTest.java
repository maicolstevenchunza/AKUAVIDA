/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.itemdecarrito;

import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarrito;
import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarritoPK;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ItemCarritoDeComprasDAOImpl;
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
public class ItemDeCarritoDAOImplTest {
    ItemsDelCarrito entity=new ItemsDelCarrito();
    
    public ItemDeCarritoDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setItemsDelCarritoPK(new ItemsDelCarritoPK("1","1" ));
        entity.setCantidad(5);
        entity.setCostoUnitario(180000);
        entity.setCostoTotal(9000000);
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
        ItemCarritoDeComprasDAOImpl instance = new ItemCarritoDeComprasDAOImpl();
        instance.insert(entity);
        
    }
    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setCostoUnitario(170000);
        ItemCarritoDeComprasDAOImpl instance = new ItemCarritoDeComprasDAOImpl();
        instance.update(entity);
    }
     @Test
    public void testDelete() {
        System.out.println("delete");
       ItemCarritoDeComprasDAOImpl instance = new ItemCarritoDeComprasDAOImpl();
        ItemsDelCarrito ct = instance.findByIDCarrito("1");
        instance.delete(ct);
        
    }
    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
       ItemCarritoDeComprasDAOImpl instance = new ItemCarritoDeComprasDAOImpl();
        List<ItemsDelCarrito> result = instance.findByAll();
        for (ItemsDelCarrito result1 : result) {
            System.out.println(result1.getItemsDelCarritoPK());
        }
    }
    @Test
    public void testFindByCostoTotal() {
        System.out.println("findByCostoTotal");
        float costoTotal = 9000000;
        ItemCarritoDeComprasDAOImpl instance = new ItemCarritoDeComprasDAOImpl();
        List<ItemsDelCarrito> result = instance.findByCostoTotal(costoTotal);
        for (ItemsDelCarrito result1 : result) {
            System.out.println(result1.getItemsDelCarritoPK());
        }
    }


}
