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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsusario", query = "SELECT u FROM Usuario u WHERE u.idUsusario = :idUsusario"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUsusario")
    private String idUsusario;
    @Basic(optional = false)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ususarioidUsusario", fetch = FetchType.EAGER)
    private Collection<Cuenta> cuentaCollection;

    public Usuario() {
    }

    public Usuario(String idUsusario) {
        this.idUsusario = idUsusario;
    }

    public Usuario(String idUsusario, String rol, String estado, String contrasena, String correo) {
        this.idUsusario = idUsusario;
        this.rol = rol;
        this.estado = estado;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public String getIdUsusario() {
        return idUsusario;
    }

    public void setIdUsusario(String idUsusario) {
        this.idUsusario = idUsusario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsusario != null ? idUsusario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsusario == null && other.idUsusario != null) || (this.idUsusario != null && !this.idUsusario.equals(other.idUsusario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.akuavida.integracion.entitis.Usuario[ idUsusario=" + idUsusario + " ]";
    }
    
}