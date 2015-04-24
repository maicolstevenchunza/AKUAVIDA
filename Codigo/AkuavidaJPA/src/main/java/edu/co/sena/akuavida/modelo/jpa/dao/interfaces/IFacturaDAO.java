/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Factura;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface IFacturaDAO {

    public void insert(Factura entity);
    public void update(Factura entity);
    public void delete(Factura entity);

    public Factura findByIDFactura(int idFactura);
    public List<Factura> findByAll();
    public List<Factura> findByFecha(Date fecha);

}
