/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.CarritoDeCompras;
import java.util.List;

/**
 *
 * @author ColsutecR
 */
public interface ICarritosComprasDAO {
    
    public void insert(CarritoDeCompras entity);
    public void update(CarritoDeCompras entity);
    public void delete(CarritoDeCompras entity);
    
    public CarritoDeCompras findByIDCarrito(String idCarrito);
    
    public List<CarritoDeCompras> findByAll();
    public List<CarritoDeCompras> findByTotal(Double total);
    public List<CarritoDeCompras> findBySubtotal(Double subtotal);        
}
