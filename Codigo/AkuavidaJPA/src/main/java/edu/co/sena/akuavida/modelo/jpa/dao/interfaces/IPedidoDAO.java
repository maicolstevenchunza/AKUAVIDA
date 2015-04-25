/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Pedido;
import java.util.Date;
import java.util.List;

/**
 *
 * @author toshiba_
 */
public interface IPedidoDAO {
    public void insert(Pedido entity);
    public void update(Pedido entity);
    public void delete(Pedido entity);
    
    public Pedido findByFacturaIDFactura(int idFactura);
    
    public Pedido findByAll();
    public List<Pedido> findByFecha (Date fecha);
    public List<Pedido> findBySubtotal(float subtotal);
    public List<Pedido> findByTotal(float total);  
}
