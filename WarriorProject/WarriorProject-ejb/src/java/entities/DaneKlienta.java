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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JacekM
 */
@Entity
@Table(name = "dane_klienta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaneKlienta.findAll", query = "SELECT d FROM DaneKlienta d"),
    @NamedQuery(name = "DaneKlienta.findByDaneKlientaId", query = "SELECT d FROM DaneKlienta d WHERE d.daneKlientaId = :daneKlientaId"),
    @NamedQuery(name = "DaneKlienta.findByDaneKlientaWzrost", query = "SELECT d FROM DaneKlienta d WHERE d.daneKlientaWzrost = :daneKlientaWzrost"),
    @NamedQuery(name = "DaneKlienta.findByDaneKlientaWaga", query = "SELECT d FROM DaneKlienta d WHERE d.daneKlientaWaga = :daneKlientaWaga"),
    @NamedQuery(name = "DaneKlienta.findByDaneKlientaPlec", query = "SELECT d FROM DaneKlienta d WHERE d.daneKlientaPlec = :daneKlientaPlec"),
    @NamedQuery(name = "DaneKlienta.findByDaneKlientaDataUr", query = "SELECT d FROM DaneKlienta d WHERE d.daneKlientaDataUr = :daneKlientaDataUr"),
    @NamedQuery(name = "DaneKlienta.findByDaneKlientaStan", query = "SELECT d FROM DaneKlienta d WHERE d.daneKlientaStan = :daneKlientaStan")})
public class DaneKlienta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dane_klienta_id")
    private Integer daneKlientaId;
    @Column(name = "dane_klienta_wzrost")
    private Integer daneKlientaWzrost;
    @Column(name = "dane_klienta_waga")
    private Integer daneKlientaWaga;
    @Size(max = 45)
    @Column(name = "dane_klienta_plec")
    private String daneKlientaPlec;
    @Size(max = 45)
    @Column(name = "dane_klienta_data_ur")
    private String daneKlientaDataUr;
    @Size(max = 45)
    @Column(name = "dane_klienta_stan")
    private String daneKlientaStan;
    @OneToMany(mappedBy = "klientDaneKlientaIdFk")
    private Collection<Klient> klientCollection;

    public DaneKlienta() {
    }

    public DaneKlienta(Integer daneKlientaId) {
        this.daneKlientaId = daneKlientaId;
    }

    public Integer getDaneKlientaId() {
        return daneKlientaId;
    }

    public void setDaneKlientaId(Integer daneKlientaId) {
        this.daneKlientaId = daneKlientaId;
    }

    public Integer getDaneKlientaWzrost() {
        return daneKlientaWzrost;
    }

    public void setDaneKlientaWzrost(Integer daneKlientaWzrost) {
        this.daneKlientaWzrost = daneKlientaWzrost;
    }

    public Integer getDaneKlientaWaga() {
        return daneKlientaWaga;
    }

    public void setDaneKlientaWaga(Integer daneKlientaWaga) {
        this.daneKlientaWaga = daneKlientaWaga;
    }

    public String getDaneKlientaPlec() {
        return daneKlientaPlec;
    }

    public void setDaneKlientaPlec(String daneKlientaPlec) {
        this.daneKlientaPlec = daneKlientaPlec;
    }

    public String getDaneKlientaDataUr() {
        return daneKlientaDataUr;
    }

    public void setDaneKlientaDataUr(String daneKlientaDataUr) {
        this.daneKlientaDataUr = daneKlientaDataUr;
    }

    public String getDaneKlientaStan() {
        return daneKlientaStan;
    }

    public void setDaneKlientaStan(String daneKlientaStan) {
        this.daneKlientaStan = daneKlientaStan;
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
        hash += (daneKlientaId != null ? daneKlientaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaneKlienta)) {
            return false;
        }
        DaneKlienta other = (DaneKlienta) object;
        if ((this.daneKlientaId == null && other.daneKlientaId != null) || (this.daneKlientaId != null && !this.daneKlientaId.equals(other.daneKlientaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DaneKlienta[ daneKlientaId=" + daneKlientaId + " ]";
    }
    
}
