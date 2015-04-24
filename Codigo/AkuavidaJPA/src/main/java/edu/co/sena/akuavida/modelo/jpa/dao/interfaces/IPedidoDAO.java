/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Pedido;
import java.util.List;

/**
 *
 * @author toshiba_
 */
public interface IPedidoDAO {
    public void insert(Pedido entity);
    public void update(Pedido entity);
    public void delete(Pedido entity);
    
    public Pedido findByAll();
    
    public List<Pedido> findByFecha (Object fecha);
    public List<Pedido> findBySubtotal(Object subtotal);
    public List<Pedido> findByTotal(Object total);  
}
