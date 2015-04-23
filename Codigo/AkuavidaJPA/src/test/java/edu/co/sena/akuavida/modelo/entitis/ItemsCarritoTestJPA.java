/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarritoPK;
import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarrito;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
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
public class ItemsCarritoTestJPA {

    ItemsDelCarrito itemCarrito;
    EntityManagerFactory emf;
    EntityManager em;

    public ItemsCarritoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        itemCarrito = new ItemsDelCarrito();
        itemCarrito.setItemsDelCarritoPK(new ItemsDelCarritoPK("1", "123456789abc"));
        itemCarrito.setCantidad(3);
        itemCarrito.setCostoUnitario(250000);
        itemCarrito.setCostoTotal(750000);

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
    public void insertarItemsCarritoCompras() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(itemCarrito);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarItemsCarrito() {

        String idPro = JOptionPane.showInputDialog("Escriba el id de la producto");
        String idCarrito = JOptionPane.showInputDialog("Escriba el id del Carrito");
        String actCan = JOptionPane.showInputDialog("Escriba La Cantidad");
        String actCosTo = JOptionPane.showInputDialog("Escriba El Costo Total");
        String actCosUni = JOptionPane.showInputDialog("Escriba El Costo Unitario");

        itemCarrito.setItemsDelCarritoPK(new ItemsDelCarritoPK(idPro, idCarrito));
        itemCarrito.setCantidad(Integer.parseInt(actCan));
        itemCarrito.setCostoTotal(Float.valueOf(actCosTo));
        itemCarrito.setCostoUnitario(Float.valueOf(actCosUni));

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(itemCarrito);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarItemCarrito() {

        String idPro = JOptionPane.showInputDialog("Inserte El id del Producto");
        String idCar = JOptionPane.showInputDialog("Inserte El id del Carrito");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        ItemsDelCarrito itemCar = em.find(ItemsDelCarrito.class, new ItemsDelCarritoPK(idPro, idCar));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(itemCar.toString());
    }

    @Test
    public void borrarUnItemDeCarrito() {
        String idPro = JOptionPane.showInputDialog("Inserte El id del Producto");
        String idCar = JOptionPane.showInputDialog("Inserte El id del Carrito");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(ItemsDelCarrito.class, new ItemsDelCarritoPK(idPro, idCar)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el item del carrito" + e.getMessage());
        }

    }

    @Test
    public void buscarTodosLosItemDelCarrito() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("ItemsDelCarrito.findAll");
        List<ItemsDelCarrito> lis = q.getResultList();
        for (ItemsDelCarrito itemsT : lis) {

            System.out.println(itemsT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorCantidad() {
        String cantidad = JOptionPane.showInputDialog("Insertar la cantidad de productos");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("ItemsDelCarrito.findByCantidad");
        query.setParameter("cantidad", Integer.parseInt(cantidad));

        List<ItemsDelCarrito> lis = query.getResultList();
        for (ItemsDelCarrito li : lis) {
            System.out.println(li.toString());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorCostoTotal() {
        String costoTotal = JOptionPane.showInputDialog("Insertar el costo total");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("ItemsDelCarrito.findByCostoTotal");
        query.setParameter("costoTotal", Float.parseFloat(costoTotal));

        List<ItemsDelCarrito> lis = query.getResultList();
        for (ItemsDelCarrito li : lis) {
            System.out.println(li.toString());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorCostoUnitario() {
        String costoUnitario = JOptionPane.showInputDialog("Insertar el costo unitario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("ItemsDelCarrito.findByCostoUnitario");
        query.setParameter("costoUnitario", Float.parseFloat(costoUnitario));

        List<ItemsDelCarrito> lis = query.getResultList();
        for (ItemsDelCarrito li : lis) {
            System.out.println(li.toString());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
}
