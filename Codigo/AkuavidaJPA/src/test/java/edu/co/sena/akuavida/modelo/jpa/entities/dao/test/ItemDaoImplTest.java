/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Item;
import edu.co.sena.akuavida.modelo.entitis.ItemPK;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ItemDaoImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IInventarioDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IItemDAO;
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
    public void testInsert() throws Exception {
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        ejemplo.insert(entity);

    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        Item it = ejemplo.findByIDItem(new ItemPK("1", 1));
        it.setCantidad(5);
        ejemplo.update(it);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        Item it = ejemplo.findByIDItem(new ItemPK("1", 1));
        ejemplo.delete(entity);

    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        List<Item> result = ejemplo.findByAll();
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByIDItem() throws Exception {
        Item it;
        String idProducto = "1";
        int idPedidoFactura = 1;
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        it = ejemplo.findByIDItem(new ItemPK(idProducto, idPedidoFactura));
        System.out.println(it.toString());

    }

    @Test
    public void testFindByCantidad() throws Exception {
        System.out.println("findByCantidad");
        int cantidad = 2;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        List<Item> result = ejemplo.findByCantidad(cantidad);
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByCostoTotal() throws Exception {
        System.out.println("findByCostoTotal");
        float costoTotal = 30000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        List<Item> result = ejemplo.findByCostoTotal(costoTotal);
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByCostoUnitario() throws Exception {
        System.out.println("findByCostoUnitario");
        float costoUnitario = 150000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO ejemplo = fabrica.createItemDAO();
        List<Item> result = ejemplo.findByCostoUnitario(costoUnitario);
        for (Item result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
