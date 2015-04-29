/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Inventario;
import edu.co.sena.akuavida.modelo.entitis.InventarioPK;
import edu.co.sena.akuavida.modelo.entitis.Producto;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.InventarioDAOImpl;
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
    public void testInsert() {
        System.out.println("insert");
        InventarioDAOImpl instance = new InventarioDAOImpl();
        instance.insert(entity);

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setCantidadProductoComprado(1);
        InventarioDAOImpl instance = new InventarioDAOImpl();
        instance.update(entity);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        InventarioDAOImpl instance = new InventarioDAOImpl();
        Inventario it = instance.findByIDInventario(new InventarioPK(1, "1"));
        instance.delete(it);

    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        InventarioDAOImpl instance = new InventarioDAOImpl();
        List<Inventario> result = instance.findByAll();
        for (Inventario result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByIdInventario() {
        System.out.println("FindByIdInventario");
        Inventario it;
        String idProducto = "1";
        int idInventario = 1;
        InventarioDAOImpl instance = new InventarioDAOImpl();
        it = instance.findByIDInventario(new InventarioPK(idInventario, idProducto));
        System.out.println(it.toString());

    }

    @Test
    public void testFindByCantidadProductoComprado() {
        System.out.println("FindByCantidadProductoComprado");
        float cantidad = 5;
        InventarioDAOImpl instance = new InventarioDAOImpl();
        List<Inventario> result = instance.findByCantidadProductoComprado(cantidad);
        for (Inventario result1 : result) {
            System.out.println(result1.toString());
        }

    }

    @Test
    public void testFindByFechaDeCompra() {

        System.out.println("FindByFecha");              
        InventarioDAOImpl instance = new InventarioDAOImpl();
        List<Inventario> result = instance.findByFechaDeCompra(fechaActual);
        for (Inventario result1 : result) {
            System.out.println(result1.toString());
        }

    }
   

}
