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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danil
 */
@Entity
@Table(name = "tarjetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetas.findAll", query = "SELECT t FROM Tarjetas t"),
    @NamedQuery(name = "Tarjetas.findById", query = "SELECT t FROM Tarjetas t WHERE t.id = :id"),
    @NamedQuery(name = "Tarjetas.findByNumeroDeTarjeta", query = "SELECT t FROM Tarjetas t WHERE t.numeroDeTarjeta = :numeroDeTarjeta"),
    @NamedQuery(name = "Tarjetas.findByDinero", query = "SELECT t FROM Tarjetas t WHERE t.dinero = :dinero"),
    @NamedQuery(name = "Tarjetas.findByCvc", query = "SELECT t FROM Tarjetas t WHERE t.cvc = :cvc")})
public class Tarjetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numero_de_tarjeta")
    private String numeroDeTarjeta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dinero")
    private BigDecimal dinero;
    @Size(max = 255)
    @Column(name = "CVC")
    private String cvc;

    public Tarjetas() {
    }

    public Tarjetas(Integer id) {
        this.id = id;
    }

    public Tarjetas(Integer id, String numeroDeTarjeta, BigDecimal dinero) {
        this.id = id;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.dinero = dinero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public BigDecimal getDinero() {
        return dinero;
    }

    public void setDinero(BigDecimal dinero) {
        this.dinero = dinero;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
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
        if (!(object instanceof Tarjetas)) {
            return false;
        }
        Tarjetas other = (Tarjetas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tarjetas[ id=" + id + " ]";
    }
    
}
