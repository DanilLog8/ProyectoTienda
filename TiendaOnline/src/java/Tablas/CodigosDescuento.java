/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablas;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "codigos_descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigosDescuento.findAll", query = "SELECT c FROM CodigosDescuento c"),
    @NamedQuery(name = "CodigosDescuento.findById", query = "SELECT c FROM CodigosDescuento c WHERE c.id = :id"),
    @NamedQuery(name = "CodigosDescuento.findByCodigo", query = "SELECT c FROM CodigosDescuento c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CodigosDescuento.findByPorcentajeDescuento", query = "SELECT c FROM CodigosDescuento c WHERE c.porcentajeDescuento = :porcentajeDescuento")})
public class CodigosDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_descuento")
    private BigDecimal porcentajeDescuento;
    @JoinColumn(name = "catalogo_id", referencedColumnName = "id")
    @ManyToOne
    private Catalogos catalogoId;

    public CodigosDescuento() {
    }

    public CodigosDescuento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Catalogos getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Catalogos catalogoId) {
        this.catalogoId = catalogoId;
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
        if (!(object instanceof CodigosDescuento)) {
            return false;
        }
        CodigosDescuento other = (CodigosDescuento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.CodigosDescuento[ id=" + id + " ]";
    }
    
}
