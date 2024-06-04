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
@Table(name = "articulo_tallapie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticuloTallapie.findAll", query = "SELECT a FROM ArticuloTallapie a"),
    @NamedQuery(name = "ArticuloTallapie.findById", query = "SELECT a FROM ArticuloTallapie a WHERE a.id = :id"),
    @NamedQuery(name = "ArticuloTallapie.findByCantidadDisponible", query = "SELECT a FROM ArticuloTallapie a WHERE a.cantidadDisponible = :cantidadDisponible")})
public class ArticuloTallapie implements Serializable {

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
    @JoinColumn(name = "id_tallaPie", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tallaspie idtallaPie;

    public ArticuloTallapie() {
    }

    public ArticuloTallapie(Integer id) {
        this.id = id;
    }

    public ArticuloTallapie(Integer id, int cantidadDisponible) {
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

    public Tallaspie getIdtallaPie() {
        return idtallaPie;
    }

    public void setIdtallaPie(Tallaspie idtallaPie) {
        this.idtallaPie = idtallaPie;
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
        if (!(object instanceof ArticuloTallapie)) {
            return false;
        }
        ArticuloTallapie other = (ArticuloTallapie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.ArticuloTallapie[ id=" + id + " ]";
    }
    
}
