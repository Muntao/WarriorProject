/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JacekM
 */
@Entity
@Table(name = "zainteresowania")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zainteresowania.findAll", query = "SELECT z FROM Zainteresowania z"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaId", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaId = :zainteresowaniaId"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaNazwa", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaNazwa = :zainteresowaniaNazwa"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaZainteresowaniaOpisIdFk", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaZainteresowaniaOpisIdFk = :zainteresowaniaZainteresowaniaOpisIdFk")})
public class Zainteresowania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zainteresowania_id")
    private Integer zainteresowaniaId;
    @Size(max = 100)
    @Column(name = "zainteresowania_nazwa")
    private String zainteresowaniaNazwa;
    @Column(name = "zainteresowania_zainteresowania_opis_id_fk")
    private Integer zainteresowaniaZainteresowaniaOpisIdFk;
    @JoinColumn(name = "zainteresowania_id", referencedColumnName = "zainteresowania_opis_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ZainteresowaniaOpis zainteresowaniaOpis;
    @OneToMany(mappedBy = "klientZainteresowaniaIdFk")
    private Collection<Klient> klientCollection;

    public Zainteresowania() {
    }

    public Zainteresowania(Integer zainteresowaniaId) {
        this.zainteresowaniaId = zainteresowaniaId;
    }

    public Integer getZainteresowaniaId() {
        return zainteresowaniaId;
    }

    public void setZainteresowaniaId(Integer zainteresowaniaId) {
        this.zainteresowaniaId = zainteresowaniaId;
    }

    public String getZainteresowaniaNazwa() {
        return zainteresowaniaNazwa;
    }

    public void setZainteresowaniaNazwa(String zainteresowaniaNazwa) {
        this.zainteresowaniaNazwa = zainteresowaniaNazwa;
    }

    public Integer getZainteresowaniaZainteresowaniaOpisIdFk() {
        return zainteresowaniaZainteresowaniaOpisIdFk;
    }

    public void setZainteresowaniaZainteresowaniaOpisIdFk(Integer zainteresowaniaZainteresowaniaOpisIdFk) {
        this.zainteresowaniaZainteresowaniaOpisIdFk = zainteresowaniaZainteresowaniaOpisIdFk;
    }

    public ZainteresowaniaOpis getZainteresowaniaOpis() {
        return zainteresowaniaOpis;
    }

    public void setZainteresowaniaOpis(ZainteresowaniaOpis zainteresowaniaOpis) {
        this.zainteresowaniaOpis = zainteresowaniaOpis;
    }

    @XmlTransient
    public Collection<Klient> getKlientCollection() {
        return klientCollection;
    }

    public void setKlientCollection(Collection<Klient> klientCollection) {
        this.klientCollection = klientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zainteresowaniaId != null ? zainteresowaniaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zainteresowania)) {
            return false;
        }
        Zainteresowania other = (Zainteresowania) object;
        if ((this.zainteresowaniaId == null && other.zainteresowaniaId != null) || (this.zainteresowaniaId != null && !this.zainteresowaniaId.equals(other.zainteresowaniaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Zainteresowania[ zainteresowaniaId=" + zainteresowaniaId + " ]";
    }
    
}
