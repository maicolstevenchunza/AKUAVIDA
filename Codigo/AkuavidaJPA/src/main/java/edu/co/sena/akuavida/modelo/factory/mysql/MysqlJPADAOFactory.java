/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.factory.mysql;

import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CarritoComprasDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CategoriaDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CuentaDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.DepartamentoDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.DomicilioDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.FacturaDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.InventarioDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ItemCarritoDeComprasDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ItemDaoImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.MunicipioDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.PagoDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.PedidoDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.ProductoDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.PromocionesDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.UsuarioDAOImpl;
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
public class MysqlJPADAOFactory extends DAOAbstractFactory{

    @Override
    public ICarritosComprasDAO createCarritoComprasDAO() {
        return new CarritoComprasDAOImpl();
    }

    @Override
    public ICategoriaDAO createCategoriaDAO() {
        return new CategoriaDAOImpl();
    }

    @Override
    public ICuentaDAO createCuentaDAO() {
        return new CuentaDAOImpl();
    }

    @Override
    public IDepartamentoDAO createDepartamentoDAO() {
        return new DepartamentoDAOImpl();
    }

    @Override
    public IDomicilioDAO createDomicilioDAO() {
        return new DomicilioDAOImpl();
    }

    @Override
    public IFacturaDAO createFacturaDAO() {
        return new FacturaDAOImpl();
    }

    @Override
    public IInventarioDAO createInventarioDAO() {
       return new InventarioDAOImpl();
    }

    @Override
    public IItemCarritoDeComprasDAO createItemDeCarritoDAO() {
       return new ItemCarritoDeComprasDAOImpl();
               
    }

    @Override
    public IItemDAO createItemDAO() {
        return new ItemDaoImpl();                                   
    }

    @Override
    public IMunicipioDAO createMunicipioDAO() {
        return new MunicipioDAOImpl();
    }

    @Override
    public IPagoDAO createPagoDAO() {
         return new PagoDAOImpl();
    }

    @Override
    public IPedidoDAO createPedidoDAO() {
         return new PedidoDAOImpl();
    }

    @Override
    public IProductoDAO createProductoDAO() {
         return new ProductoDAOImpl();
    }

    @Override
    public IPromocionesDAO createPromocionesDAO() {
         return new PromocionesDAOImpl();
    }

    @Override
    public IUsuarioDAO createUsuarioDAO() {
         return new UsuarioDAOImpl();
    }
    
}
