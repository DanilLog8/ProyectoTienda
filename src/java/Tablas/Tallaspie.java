/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Danil
 */
@Entity
@Table(name = "tallaspie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tallaspie.findAll", query = "SELECT t FROM Tallaspie t"),
    @NamedQuery(name = "Tallaspie.findById", query = "SELECT t FROM Tallaspie t WHERE t.id = :id"),
    @NamedQuery(name = "Tallaspie.findByTalla", query = "SELECT t FROM Tallaspie t WHERE t.talla = :talla")})
public class Tallaspie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "talla")
    private int talla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtallaPie")
    private Collection<ArticuloTallapie> articuloTallapieCollection;

    public Tallaspie() {
    }

    public Tallaspie(Integer id) {
        this.id = id;
    }

    public Tallaspie(Integer id, int talla) {
        this.id = id;
        this.talla = talla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    @XmlTransient
    public Collection<ArticuloTallapie> getArticuloTallapieCollection() {
        return articuloTallapieCollection;
    }

    public void setArticuloTallapieCollection(Collection<ArticuloTallapie> articuloTallapieCollection) {
        this.articuloTallapieCollection = articuloTallapieCollection;
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
        if (!(object instanceof Tallaspie)) {
            return false;
        }
        Tallaspie other = (Tallaspie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tallaspie[ id=" + id + " ]";
    }
    
}
