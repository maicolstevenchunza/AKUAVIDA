/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.modelo.entitis.CarritoDeCompras;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICarritosComprasDAO;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ColsutecR
 */
public class CarritoComprasDAOImpl implements ICarritosComprasDAO {

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();

    }


    @Override
    public void insert(CarritoDeCompras entity) {
       
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
     } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        }finally{
            if(em != null){
             EntityManagerHelper.closeEntityManager();
            }
        }
    
    }

    @Override
    public void update(CarritoDeCompras entity) {
       EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
     } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        }finally{
            if(em != null){
             EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(CarritoDeCompras entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(CarritoDeCompras.class, entity.getIDCarrito()));
            EntityManagerHelper.commit();
     } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        }finally{
            if(em != null){
             EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public CarritoDeCompras findByIDCarrito() {
         EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            return em.find(CarritoDeCompras.class, );
            EntityManagerHelper.commit();
     } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        }finally{
            if(em != null){
             EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public List<CarritoDeCompras> findByAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarritoDeCompras> findByTotal(Object total) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarritoDeCompras> findBySubtotal(Object subtotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
