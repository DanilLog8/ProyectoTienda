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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Danil
 */
@Entity
@Table(name = "tallas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tallas.findAll", query = "SELECT t FROM Tallas t"),
    @NamedQuery(name = "Tallas.findById", query = "SELECT t FROM Tallas t WHERE t.id = :id"),
    @NamedQuery(name = "Tallas.findByNombre", query = "SELECT t FROM Tallas t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tallas.findByDescripcion", query = "SELECT t FROM Tallas t WHERE t.descripcion = :descripcion")})
public class Tallas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalla")
    private Collection<ArticuloTalla> articuloTallaCollection;

    public Tallas() {
    }

    public Tallas(Integer id) {
        this.id = id;
    }

    public Tallas(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<ArticuloTalla> getArticuloTallaCollection() {
        return articuloTallaCollection;
    }

    public void setArticuloTallaCollection(Collection<ArticuloTalla> articuloTallaCollection) {
        this.articuloTallaCollection = articuloTallaCollection;
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
        if (!(object instanceof Tallas)) {
            return false;
        }
        Tallas other = (Tallas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tallas[ id=" + id + " ]";
    }
    
}
