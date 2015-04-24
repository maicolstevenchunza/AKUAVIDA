/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Pago;
import java.util.List;

/**
 *
 * @author toshiba_
 */
public interface IPagoDAO {
    public void insert(Pago entity);
    public void update(Pago entity);
    public void delete(Pago entity);

    public Pago findByFacturaIDFactura(Object idFactura);
    
    public List<Pago> findByAll();
    public List<Pago> findByTipoPago(Object tipoPago); 
    public List<Pago> findByNumeroTarjeta(Object numeroTarjeta); 
}
