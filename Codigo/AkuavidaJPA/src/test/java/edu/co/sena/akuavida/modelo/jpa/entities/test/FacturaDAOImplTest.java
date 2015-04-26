/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.entitis.Factura;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.FacturaDAOImpl;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class FacturaDAOImplTest {
    Factura entity= new Factura();
    Calendar hoy = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
    Date fechaActual = hoy.getTime();
    Date fechaTemporal = hoy.getTime();
    
    public FacturaDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        entity.setIDFactura(1);
        entity.setFecha(fechaActual);
        entity.setCuenta(new Cuenta("C.C", "1033757632"));
                
        
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
        FacturaDAOImpl instance = new FacturaDAOImpl();
        instance.insert(entity);
        
    }
}
