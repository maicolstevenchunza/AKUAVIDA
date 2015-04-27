/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Item;
import edu.co.sena.akuavida.modelo.entitis.ItemPK;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ItemDaoImpl;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author toshiba_
 */
public class ItemDaoImplTest {

    Item entity;

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public ItemDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Item();
        entity.setItemPK(new ItemPK("1", 1));
        entity.setCantidad(2);
        entity.setCostoTotal(30000);
        entity.setCostoUnitario(150000);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        ItemDaoImpl instance = new ItemDaoImpl();
        instance.insert(entity);

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        ItemDaoImpl instance = new ItemDaoImpl();
        Item it = instance.findByIDItem(new ItemPK("1", 1));
        it.setCantidad(5);
        instance.update(it);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        ItemDaoImpl instance = new ItemDaoImpl();
        Item it = instance.findByIDItem(new ItemPK("1", 1));
        instance.delete(entity);

    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        ItemDaoImpl instance = new ItemDaoImpl();
        List<Item> result = instance.findByAll();
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByIDItem() {
        Item it;
        String idProducto = "1";
        int idPedidoFactura = 1;
        ItemDaoImpl instance = new ItemDaoImpl();
        it = instance.findByIDItem(new ItemPK(idProducto, idPedidoFactura));
        System.out.println(it.toString());

    }

    @Test
    public void testFindByCantidad() {
        System.out.println("findByCantidad");
        int cantidad = 2;
        ItemDaoImpl instance = new ItemDaoImpl();
        List<Item> result = instance.findByCantidad(cantidad);
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByCostoTotal() {
        System.out.println("findByCostoTotal");
        float costoTotal = 30000;
        ItemDaoImpl instance = new ItemDaoImpl();
        List<Item> result = instance.findByCostoTotal(costoTotal);
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByCostoUnitario() {
        System.out.println("findByCostoUnitario");
        float costoUnitario = 150000;
        ItemDaoImpl instance = new ItemDaoImpl();
        List<Item> result = instance.findByCostoUnitario(costoUnitario);
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
