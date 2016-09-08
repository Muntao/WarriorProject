/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JacekM
 */
@Entity
@Table(name = "zainteresowania_opis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZainteresowaniaOpis.findAll", query = "SELECT z FROM ZainteresowaniaOpis z"),
    @NamedQuery(name = "ZainteresowaniaOpis.findByZainteresowaniaOpisId", query = "SELECT z FROM ZainteresowaniaOpis z WHERE z.zainteresowaniaOpisId = :zainteresowaniaOpisId"),
    @NamedQuery(name = "ZainteresowaniaOpis.findByZainteresowaniaOpisOpis", query = "SELECT z FROM ZainteresowaniaOpis z WHERE z.zainteresowaniaOpisOpis = :zainteresowaniaOpisOpis")})
public class ZainteresowaniaOpis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zainteresowania_opis_id")
    private Integer zainteresowaniaOpisId;
    @Size(max = 1000)
    @Column(name = "zainteresowania_opis_opis")
    private String zainteresowaniaOpisOpis;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "zainteresowaniaOpis")
    private Zainteresowania zainteresowania;

    public ZainteresowaniaOpis() {
    }

    public ZainteresowaniaOpis(Integer zainteresowaniaOpisId) {
        this.zainteresowaniaOpisId = zainteresowaniaOpisId;
    }

    public Integer getZainteresowaniaOpisId() {
        return zainteresowaniaOpisId;
    }

    public void setZainteresowaniaOpisId(Integer zainteresowaniaOpisId) {
        this.zainteresowaniaOpisId = zainteresowaniaOpisId;
    }

    public String getZainteresowaniaOpisOpis() {
        return zainteresowaniaOpisOpis;
    }

    public void setZainteresowaniaOpisOpis(String zainteresowaniaOpisOpis) {
        this.zainteresowaniaOpisOpis = zainteresowaniaOpisOpis;
    }

    public Zainteresowania getZainteresowania() {
        return zainteresowania;
    }

    public void setZainteresowania(Zainteresowania zainteresowania) {
        this.zainteresowania = zainteresowania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zainteresowaniaOpisId != null ? zainteresowaniaOpisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZainteresowaniaOpis)) {
            return false;
        }
        ZainteresowaniaOpis other = (ZainteresowaniaOpis) object;
        if ((this.zainteresowaniaOpisId == null && other.zainteresowaniaOpisId != null) || (this.zainteresowaniaOpisId != null && !this.zainteresowaniaOpisId.equals(other.zainteresowaniaOpisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ZainteresowaniaOpis[ zainteresowaniaOpisId=" + zainteresowaniaOpisId + " ]";
    }
    
}
