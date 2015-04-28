/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.factory;

import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICarritosComprasDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICategoriaDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICuentaDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDepartamentoDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IDomicilioDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IFacturaDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IInventarioDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IItemCarritoDeComprasDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IItemDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IMunicipioDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPagoDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPedidoDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IProductoDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IPromocionesDAO;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.IUsuarioDAO;

/**
 *
 * @author ColsutecR
 */
public interface DAOFactory {
     public ICarritosComprasDAO  createCarritoComprasDAO ();
     public ICategoriaDAO createCategoriaDAO();
     public ICuentaDAO createCuentaDAO();
     public IDepartamentoDAO createDepartamentoDAO();
     public IDomicilioDAO createDomicilioDAO();
     public IFacturaDAO createFacturaDAO();
     public IInventarioDAO createInventarioDAO();
     public IItemCarritoDeComprasDAO createItemDeCarritoDAO();
     public IItemDAO createItemDAO();
     public IMunicipioDAO createMunicipioDAO();
     public IPagoDAO createPagoDAO();
     public IPedidoDAO createPedidoDAO();
     public IProductoDAO createProductoDAO();
     public IPromocionesDAO createPromocionesDAO();
     public IUsuarioDAO createUsuarioDAO();
    
}
