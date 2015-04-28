/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Producto;
import edu.co.sena.akuavida.modelo.entitis.Promociones;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.PromocionesDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPromocionesDAO;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Andrea
 */
public class PromocionesDAOImplTest {
    Promociones entity= new Promociones();
    
    public PromocionesDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        entity.setIdPromocion("1");
        entity.setDescuentos(16);
        entity.setNombre("2x1 Promo");
        entity.setPrecio(156000);
        entity.setProductoIDproducto(new Producto("1"));
        
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
    public void testInsert() throws Exception {
        System.out.println("insert");
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IPromocionesDAO instance = fabrica.createPromocionesDAO();
        instance.insert(entity);
        
    }
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");  
          DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IPromocionesDAO instance = fabrica.createPromocionesDAO();
        instance.findByIDPromocion("1");
        entity.setNombre("super promocion");        
        instance.update(entity);
   }
     @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IPromocionesDAO instance = fabrica.createPromocionesDAO();
        Promociones prot = instance.findByIDPromocion("1");
        instance.delete(prot);        
    }
    
    
    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IPromocionesDAO instance = fabrica.createPromocionesDAO();
        List<Promociones> result = instance.findByAll();
        for (Promociones result1 : result) {
            System.out.println(result1.toString());
        }
    }
     @Test
    public void testFindByIdPromocion() throws Exception {
        System.out.println("FindByIdPromocion");
        Promociones promt;   
        String idPromocion="1";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPromocionesDAO instance = fabrica.createPromocionesDAO();
        promt = instance.findByIDPromocion(idPromocion);
        System.out.println(promt.toString());

    }
     @Test
     public void testFindByDescuentos() throws Exception {
        System.out.println("findByDescuentos");
        float descuentos=16;        
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IPromocionesDAO instance = fabrica.createPromocionesDAO();
        List<Promociones> result = instance.findByDescuentos(descuentos);
        for (Promociones result1 : result) {
            System.out.println(result1.toString());
        }
    }
         @Test
     public void testFindByNombre() throws Exception {
        System.out.println("findByNombre");
        String nombre = "2x1 Promo";
         DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IPromocionesDAO instance = fabrica.createPromocionesDAO();
        List<Promociones> result = instance.findByNombre(nombre);
        for (Promociones result1 : result) {
            System.out.println(result1.toString());
        }
    }
      @Test
     public void testFindByPrecio() throws Exception {
        System.out.println("findByPrecio");
        float precio= 156000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
         IPromocionesDAO instance = fabrica.createPromocionesDAO();
        List<Promociones> result = instance.findByPrecio(precio);
        for (Promociones result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
