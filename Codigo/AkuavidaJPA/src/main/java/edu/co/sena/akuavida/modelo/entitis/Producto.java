/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.entitis;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIDproducto", query = "SELECT p FROM Producto p WHERE p.iDproducto = :iDproducto"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByActivo", query = "SELECT p FROM Producto p WHERE p.activo = :activo"),
    @NamedQuery(name = "Producto.findByImpuesto", query = "SELECT p FROM Producto p WHERE p.impuesto = :impuesto")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_producto")
    private String iDproducto;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Precio")
    private float precio;
    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;
    @Basic(optional = false)
    @Lob
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "impuesto")
    private float impuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIDproducto", fetch = FetchType.EAGER)
    private Collection<Promociones> promocionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private Collection<Inventario> inventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private Collection<ItemsDelCarrito> itemsDelCarritoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private Collection<Item> itemCollection;
    @JoinColumn(name = "Categorias_ID_Categoria", referencedColumnName = "ID_Categoria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categorias categoriasIDCategoria;

    public Producto() {
    }

    public Producto(String iDproducto) {
        this.iDproducto = iDproducto;
    }

    public Producto(String iDproducto, String nombre, float precio, String descripcion, int cantidad, boolean activo, float impuesto) {
        this.iDproducto = iDproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.activo = activo;
        this.impuesto = impuesto;
    }

    public String getIDproducto() {
        return iDproducto;
    }

    public void setIDproducto(String iDproducto) {
        this.iDproducto = iDproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    @XmlTransient
    public Collection<Promociones> getPromocionesCollection() {
        return promocionesCollection;
    }

    public void setPromocionesCollection(Collection<Promociones> promocionesCollection) {
        this.promocionesCollection = promocionesCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @XmlTransient
    public Collection<ItemsDelCarrito> getItemsDelCarritoCollection() {
        return itemsDelCarritoCollection;
    }

    public void setItemsDelCarritoCollection(Collection<ItemsDelCarrito> itemsDelCarritoCollection) {
        this.itemsDelCarritoCollection = itemsDelCarritoCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Categorias getCategoriasIDCategoria() {
        return categoriasIDCategoria;
    }

    public void setCategoriasIDCategoria(Categorias categoriasIDCategoria) {
        this.categoriasIDCategoria = categoriasIDCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDproducto != null ? iDproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.iDproducto == null && other.iDproducto != null) || (this.iDproducto != null && !this.iDproducto.equals(other.iDproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "iDproducto=" + iDproducto + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", activo=" + activo + ", impuesto=" + impuesto + ", categoriasIDCategoria=" + categoriasIDCategoria + '}';
    }

    
    
}
