/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Categorias;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CategoriaDAOImpl;
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
public class CategoriaDAOImplTest {
    Categorias entity=new  Categorias();
    
    public CategoriaDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setIDCategoria(1);
        entity.setNombre("Categoria prueba");
        entity.setActiva(true);
        entity.setPariente(1);
        
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
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        instance.insert(entity);
        
    }
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");  
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        instance.findByIDCategoria(1);
        entity.setNombre("moe");        
        instance.update(entity);
    }
    @Test
    public void testDelete() {
        System.out.println("delete");
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        Categorias ct = instance.findByIDCategoria(1);
        instance.delete(ct);        
    }
    @Test
    public void testFindByIdCategoria() {
        System.out.println("findByIdCategoria");
        Categorias ct;
        int idCategoria = 3;
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        ct = instance.findByIDCategoria(idCategoria);
        System.out.println(ct.getIDCategoria());

    }
     @Test
    public void testFindByAll() {
        System.out.println("findByAll");
         CategoriaDAOImpl instance = new CategoriaDAOImpl();
        List<Categorias> result = instance.findByAll();
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }
    @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        String nombre = "moe";
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        List<Categorias> result = instance.findByNombre(nombre);
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByActiva() {
        System.out.println("findByActiva");
        boolean activa=true;
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        List<Categorias> result = instance.findByActiva(activa);
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByPariente() {
        System.out.println("findByPariente");
        int pariente=1;
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        List<Categorias> result = instance.findByPariente(pariente);
        for (Categorias result1 : result) {
            System.out.println(result1.toString());
        }
    }
    



    
}
