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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danil
 */
@Entity
@Table(name = "articulo_talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticuloTalla.findAll", query = "SELECT a FROM ArticuloTalla a"),
    @NamedQuery(name = "ArticuloTalla.findById", query = "SELECT a FROM ArticuloTalla a WHERE a.id = :id"),
    @NamedQuery(name = "ArticuloTalla.findByCantidadDisponible", query = "SELECT a FROM ArticuloTalla a WHERE a.cantidadDisponible = :cantidadDisponible")})
public class ArticuloTalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Articulos idArticulo;
    @JoinColumn(name = "id_talla", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tallas idTalla;

    public ArticuloTalla() {
    }

    public ArticuloTalla(Integer id) {
        this.id = id;
    }

    public ArticuloTalla(Integer id, int cantidadDisponible) {
        this.id = id;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Articulos getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulos idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Tallas getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Tallas idTalla) {
        this.idTalla = idTalla;
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
        if (!(object instanceof ArticuloTalla)) {
            return false;
        }
        ArticuloTalla other = (ArticuloTalla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.ArticuloTalla[ id=" + id + " ]";
    }
    
}
