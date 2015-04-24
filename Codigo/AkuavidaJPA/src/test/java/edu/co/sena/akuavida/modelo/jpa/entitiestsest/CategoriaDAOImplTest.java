/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entitiestsest;

import edu.co.sena.akuavida.modelo.entitis.Categorias;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CategoriaDAOImpl;
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

    
}
