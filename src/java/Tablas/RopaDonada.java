/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danil
 */
@Entity
@Table(name = "ropa_donada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RopaDonada.findAll", query = "SELECT r FROM RopaDonada r"),
    @NamedQuery(name = "RopaDonada.findById", query = "SELECT r FROM RopaDonada r WHERE r.id = :id"),
    @NamedQuery(name = "RopaDonada.findByCantidad", query = "SELECT r FROM RopaDonada r WHERE r.cantidad = :cantidad"),
    @NamedQuery(name = "RopaDonada.findByNombre", query = "SELECT r FROM RopaDonada r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RopaDonada.findByTalla", query = "SELECT r FROM RopaDonada r WHERE r.talla = :talla"),
    @NamedQuery(name = "RopaDonada.findByCatalogo", query = "SELECT r FROM RopaDonada r WHERE r.catalogo = :catalogo"),
    @NamedQuery(name = "RopaDonada.findByImagen", query = "SELECT r FROM RopaDonada r WHERE r.imagen = :imagen")})
public class RopaDonada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "talla")
    private String talla;
    @Size(max = 255)
    @Column(name = "catalogo")
    private String catalogo;
    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuarios usuarioId;

    public RopaDonada() {
    }

    public RopaDonada(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RopaDonada)) {
            return false;
        }
        RopaDonada other = (RopaDonada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.RopaDonada[ id=" + id + " ]";
    }
    
}
