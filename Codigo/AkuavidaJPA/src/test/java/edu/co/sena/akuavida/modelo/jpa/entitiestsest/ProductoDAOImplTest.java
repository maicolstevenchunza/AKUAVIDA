/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entitiestsest;

import edu.co.sena.akuavida.modelo.entitis.Categorias;
import edu.co.sena.akuavida.modelo.entitis.Producto;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ProductoDAOImpl;
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
        entity.setCategoriasIDCategoria(new Categorias(1));
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
}
