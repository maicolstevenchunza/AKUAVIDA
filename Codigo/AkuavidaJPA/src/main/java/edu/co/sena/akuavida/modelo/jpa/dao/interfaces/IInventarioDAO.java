/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Inventario;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface IInventarioDAO {

    public void insert(Inventario entity);
    public void update(Inventario entity);
    public void delete(Inventario entity);
    
    public Inventario findByIDInventario(int idCarrito);
    
    
    public List<Inventario> findByAll();
    public List<Inventario> findByProductoIDproducto(Object prod);
    public List<Inventario> findByCantidadProductoComprado(Object cantProdComprado);
    public List<Inventario> findByFechaDeCompra(Object fecha);
    
}
