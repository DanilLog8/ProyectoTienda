/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Danil
 */
@Entity
@Table(name = "catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogos.findAll", query = "SELECT c FROM Catalogos c"),
    @NamedQuery(name = "Catalogos.findById", query = "SELECT c FROM Catalogos c WHERE c.id = :id"),
    @NamedQuery(name = "Catalogos.findByNombre", query = "SELECT c FROM Catalogos c WHERE c.nombre = :nombre")})
public class Catalogos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "catalogoId")
    private Collection<CodigosDescuento> codigosDescuentoCollection;
    @OneToMany(mappedBy = "catalogoId")
    private Collection<Articulos> articulosCollection;

    public Catalogos() {
    }

    public Catalogos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<CodigosDescuento> getCodigosDescuentoCollection() {
        return codigosDescuentoCollection;
    }

    public void setCodigosDescuentoCollection(Collection<CodigosDescuento> codigosDescuentoCollection) {
        this.codigosDescuentoCollection = codigosDescuentoCollection;
    }

    @XmlTransient
    public Collection<Articulos> getArticulosCollection() {
        return articulosCollection;
    }

    public void setArticulosCollection(Collection<Articulos> articulosCollection) {
        this.articulosCollection = articulosCollection;
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
        if (!(object instanceof Catalogos)) {
            return false;
        }
        Catalogos other = (Catalogos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Catalogos[ id=" + id + " ]";
    }
    
}
