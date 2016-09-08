/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author JacekM
 */
@Entity
@Table(name = "zdjecie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zdjecie.findAll", query = "SELECT z FROM Zdjecie z"),
    @NamedQuery(name = "Zdjecie.findByZdjecieId", query = "SELECT z FROM Zdjecie z WHERE z.zdjecieId = :zdjecieId"),
    @NamedQuery(name = "Zdjecie.findByZdjecieSciezka", query = "SELECT z FROM Zdjecie z WHERE z.zdjecieSciezka = :zdjecieSciezka"),
    @NamedQuery(name = "Zdjecie.findByZdjecieTag", query = "SELECT z FROM Zdjecie z WHERE z.zdjecieTag = :zdjecieTag"),
    @NamedQuery(name = "Zdjecie.findByZdjecieOcenaSuma", query = "SELECT z FROM Zdjecie z WHERE z.zdjecieOcenaSuma = :zdjecieOcenaSuma"),
    @NamedQuery(name = "Zdjecie.findByZdjecieOcenaIlosc", query = "SELECT z FROM Zdjecie z WHERE z.zdjecieOcenaIlosc = :zdjecieOcenaIlosc"),
    @NamedQuery(name = "Zdjecie.findByZdjecieProfilowe", query = "SELECT z FROM Zdjecie z WHERE z.zdjecieProfilowe = :zdjecieProfilowe")})
public class Zdjecie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zdjecie_id")
    private Integer zdjecieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "zdjecie_sciezka")
    private String zdjecieSciezka;
    @Size(max = 200)
    @Column(name = "zdjecie_tag")
    private String zdjecieTag;
    @Column(name = "zdjecie_ocena_suma")
    private Integer zdjecieOcenaSuma;
    @Column(name = "zdjecie_ocena_ilosc")
    private Integer zdjecieOcenaIlosc;
    @Size(max = 45)
    @Column(name = "zdjecie_profilowe")
    private String zdjecieProfilowe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientZdjecieZdjecieIdFk")
    private Collection<KlientZdjecie> klientZdjecieCollection;

    public Zdjecie() {
    }

    public Zdjecie(Integer zdjecieId) {
        this.zdjecieId = zdjecieId;
    }

    public Zdjecie(Integer zdjecieId, String zdjecieSciezka) {
        this.zdjecieId = zdjecieId;
        this.zdjecieSciezka = zdjecieSciezka;
    }

    public Integer getZdjecieId() {
        return zdjecieId;
    }

    public void setZdjecieId(Integer zdjecieId) {
        this.zdjecieId = zdjecieId;
    }

    public String getZdjecieSciezka() {
        return zdjecieSciezka;
    }

    public void setZdjecieSciezka(String zdjecieSciezka) {
        this.zdjecieSciezka = zdjecieSciezka;
    }

    public String getZdjecieTag() {
        return zdjecieTag;
    }

    public void setZdjecieTag(String zdjecieTag) {
        this.zdjecieTag = zdjecieTag;
    }

    public Integer getZdjecieOcenaSuma() {
        return zdjecieOcenaSuma;
    }

    public void setZdjecieOcenaSuma(Integer zdjecieOcenaSuma) {
        this.zdjecieOcenaSuma = zdjecieOcenaSuma;
    }

    public Integer getZdjecieOcenaIlosc() {
        return zdjecieOcenaIlosc;
    }

    public void setZdjecieOcenaIlosc(Integer zdjecieOcenaIlosc) {
        this.zdjecieOcenaIlosc = zdjecieOcenaIlosc;
    }

    public String getZdjecieProfilowe() {
        return zdjecieProfilowe;
    }

    public void setZdjecieProfilowe(String zdjecieProfilowe) {
        this.zdjecieProfilowe = zdjecieProfilowe;
    }

    @XmlTransient
    public Collection<KlientZdjecie> getKlientZdjecieCollection() {
        return klientZdjecieCollection;
    }

    public void setKlientZdjecieCollection(Collection<KlientZdjecie> klientZdjecieCollection) {
        this.klientZdjecieCollection = klientZdjecieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zdjecieId != null ? zdjecieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zdjecie)) {
            return false;
        }
        Zdjecie other = (Zdjecie) object;
        if ((this.zdjecieId == null && other.zdjecieId != null) || (this.zdjecieId != null && !this.zdjecieId.equals(other.zdjecieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Zdjecie[ zdjecieId=" + zdjecieId + " ]";
    }
    
}
