/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.jpa.util.EntityManagerHelper;
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
public class ProductoTestJPA {

    Producto producto;

    EntityManagerFactory emf;
    EntityManager em;

    public ProductoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        producto = new Producto();
        producto.setIDproducto("1");
        producto.setNombre("Purificador Tipo Oso");
        producto.setPrecio(150000);
        producto.setDescripcion("Un nuevo producto que innovara su casa");
        producto.setCantidad(25);
        producto.setActivo(true);
        producto.setImpuesto(16);
        producto.setCategoriasIDCategoria(new Categorias(2));
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
    public void insertarProducto() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(producto);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarProducto() {

        String idPro = JOptionPane.showInputDialog("Escriba el id del producto");
        String actPrecio = JOptionPane.showInputDialog("Escriba El Precio");
        String actCan = JOptionPane.showInputDialog("Escriba La Cantidad");

        producto.setIDproducto(idPro);
        producto.setPrecio(Float.valueOf(actPrecio));
        producto.setCantidad(Integer.parseInt(actCan));

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(producto);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarProducto() {

        String idPro = JOptionPane.showInputDialog("Inserte El id del producto");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Producto pro = em.find(Producto.class, idPro);

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(pro.toString());
    }

    @Test
    public void borrarUnProducto() {
        String idProducto = JOptionPane.showInputDialog("Escriba el id del producto");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Producto.class, idProducto));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el producto" + e.getMessage());
        }

    }

    @Test
    public void buscarProductos() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findAll");
        List<Producto> lis = q.getResultList();
        for (Producto productoT : lis) {

            System.out.println(productoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void actualizarPkProducto() {
        em = EntityManagerHelper.getEntityManager();

        String viejoId = JOptionPane.showInputDialog("Digite el id del producto actualizar");
        String nuevoId = JOptionPane.showInputDialog("Digite el nuevo Id");

        String sql = "UPDATE `akuavida`.`producto` "
                + "SET "
                + "`ID_producto` = '" + nuevoId + "' "
                + "WHERE `ID_producto` = '" + viejoId + "';";

        System.out.println(sql);
        Query query = em.createNativeQuery(sql);
        EntityManagerHelper.beginTransaction();
        int rowCount = query.executeUpdate();
        System.out.println("Se actualizaron " + rowCount + "Registros");
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorNombre() {
        String nombre = JOptionPane.showInputDialog("Insertar el nombre del producto");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByNombre");
        query.setParameter("nombre", nombre);

        List<Producto> lis = query.getResultList();
        for (Producto productoT : lis) {

            System.out.println(productoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorPrecio() {
        String precio = JOptionPane.showInputDialog("Insertar el precio del producto");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByPrecio");
        query.setParameter("precio", Float.parseFloat(precio));

        List<Producto> lis = query.getResultList();
        for (Producto productoT : lis) {

            System.out.println(productoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorCantidad() {
        String cantidad = JOptionPane.showInputDialog("Insertar la cantidad del producto");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByCantidad");
        query.setParameter("cantidad", Integer.parseInt(cantidad));

        List<Producto> lis = query.getResultList();
        for (Producto productoT : lis) {

            System.out.println(productoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorActivo() {

        String activo = JOptionPane.showInputDialog("Insertar si esta activo el producto o no");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByActivo");
        query.setParameter("activo", Boolean.parseBoolean(activo));

        List<Producto> lis = query.getResultList();
        for (Producto productoT : lis) {

            System.out.println(productoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    @Test
    public void buscarPorImpuesto() {
        String impuesto = JOptionPane.showInputDialog("Insertar el impuesto del producto");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByImpuesto");
        query.setParameter("impuesto", Float.parseFloat(impuesto));

        List<Producto> lis = query.getResultList();
        for (Producto productoT : lis) {

            System.out.println(productoT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
