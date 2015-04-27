/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Categorias;
import edu.co.sena.akuavida.modelo.entitis.Producto;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ProductoDAOImpl;
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
public class ProductoDAOImplTest {
    Producto entity= new Producto();
    
    public ProductoDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setIDproducto("1");
        entity.setNombre("All star");
        entity.setPrecio(180000);
        entity.setDescripcion("Este purificador es uno de los mejores que tenemos ya que esta hecho con la ultima tecnologia");
        entity.setCantidad(30);
        entity.setActivo(true);
        entity.setImpuesto(16);
        entity.setCategoriasIDCategoria(new Categorias(3));
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
        ProductoDAOImpl instance = new ProductoDAOImpl();
        instance.insert(entity);
        
    }
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");  
        ProductoDAOImpl instance = new ProductoDAOImpl();
        instance.findByIDproducto("1");
        entity.setNombre("moe1");        
        instance.update(entity);
   }
     @Test
    public void testDelete() {
        System.out.println("delete");
        ProductoDAOImpl instance = new ProductoDAOImpl();
        Producto pt = instance.findByIDproducto("1");
        instance.delete(pt);        
    }
    @Test
    public void testFindByIdProducto() {
        System.out.println("FindByIdProducto");
        Producto pt;        
        ProductoDAOImpl instance = new ProductoDAOImpl();
        pt = instance.findByIDproducto("1");
        System.out.println(pt.getIDproducto());

    }
     @Test
    public void testFindByAll() {
        System.out.println("findByAll");
         ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> result = instance.findByAll();
        for (Producto result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        String nombre = "moe1";
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> result = instance.findByNombre(nombre);
        for (Producto result1 : result) {
            System.out.println(result1.toString());
        }
    }
    @Test
    public void testFindByPrecio() {
        System.out.println("findByPrecio");
        float precio = 180000;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> result = instance.findByPrecio(precio);
        for (Producto result1 : result) {
            System.out.println(result1.toString());
        }
    }
     @Test
    public void testFindByCantidad() {
        System.out.println("findByCantidad");
        int cantidad = 30;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> result = instance.findByCantidad(cantidad);
        for (Producto result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
     @Test
    public void testFindByActivo() {
        System.out.println("findByActivo");
        boolean activo = true;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> result = instance.findByActivo(activo);
        for (Producto result1 : result) {
            System.out.println(result1.toString());
        }
    }
     @Test
    public void testFindByImpuesto() {
        System.out.println("findByImpuesto");
        float impuesto = 16;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> result = instance.findByImpuesto(impuesto);
        for (Producto result1 : result) {
            System.out.println(result1.toString());
        }
    }
   
    
}

