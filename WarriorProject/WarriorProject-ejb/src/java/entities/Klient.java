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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "klient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klient.findAll", query = "SELECT k FROM Klient k"),
    @NamedQuery(name = "Klient.findByKlientId", query = "SELECT k FROM Klient k WHERE k.klientId = :klientId"),
    @NamedQuery(name = "Klient.findByKlientImie", query = "SELECT k FROM Klient k WHERE k.klientImie = :klientImie"),
    @NamedQuery(name = "Klient.findByKlientNazwisko", query = "SELECT k FROM Klient k WHERE k.klientNazwisko = :klientNazwisko")})
public class Klient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "klient_id")
    private Integer klientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "klient_imie")
    private String klientImie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "klient_nazwisko")
    private String klientNazwisko;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "znajomiKlientIdFk")
    private Collection<Znajomi> znajomiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "znajomiKlient2IdFk")
    private Collection<Znajomi> znajomiCollection1;
    @JoinColumn(name = "klient_adres_id_fk", referencedColumnName = "adres_id")
    @ManyToOne(optional = false)
    private Adres klientAdresIdFk;
    @JoinColumn(name = "klient_konto_id_fk", referencedColumnName = "konto_id")
    @ManyToOne(optional = false)
    private Konto klientKontoIdFk;
    @JoinColumn(name = "klient_dane_klienta_id_fk", referencedColumnName = "dane_klienta_id")
    @ManyToOne
    private DaneKlienta klientDaneKlientaIdFk;
    @JoinColumn(name = "klient_zainteresowania_id_fk", referencedColumnName = "zainteresowania_id")
    @ManyToOne
    private Zainteresowania klientZainteresowaniaIdFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientZdjecieKlientIdFk")
    private Collection<KlientZdjecie> klientZdjecieCollection;

    public Klient() {
    }

    public Klient(Integer klientId) {
        this.klientId = klientId;
    }

    public Klient(Integer klientId, String klientImie, String klientNazwisko) {
        this.klientId = klientId;
        this.klientImie = klientImie;
        this.klientNazwisko = klientNazwisko;
    }

    public Integer getKlientId() {
        return klientId;
    }

    public void setKlientId(Integer klientId) {
        this.klientId = klientId;
    }

    public String getKlientImie() {
        return klientImie;
    }

    public void setKlientImie(String klientImie) {
        this.klientImie = klientImie;
    }

    public String getKlientNazwisko() {
        return klientNazwisko;
    }

    public void setKlientNazwisko(String klientNazwisko) {
        this.klientNazwisko = klientNazwisko;
    }

    @XmlTransient
    public Collection<Znajomi> getZnajomiCollection() {
        return znajomiCollection;
    }

    public void setZnajomiCollection(Collection<Znajomi> znajomiCollection) {
        this.znajomiCollection = znajomiCollection;
    }

    @XmlTransient
    public Collection<Znajomi> getZnajomiCollection1() {
        return znajomiCollection1;
    }

    public void setZnajomiCollection1(Collection<Znajomi> znajomiCollection1) {
        this.znajomiCollection1 = znajomiCollection1;
    }

    public Adres getKlientAdresIdFk() {
        return klientAdresIdFk;
    }

    public void setKlientAdresIdFk(Adres klientAdresIdFk) {
        this.klientAdresIdFk = klientAdresIdFk;
    }

    public Konto getKlientKontoIdFk() {
        return klientKontoIdFk;
    }

    public void setKlientKontoIdFk(Konto klientKontoIdFk) {
        this.klientKontoIdFk = klientKontoIdFk;
    }

    public DaneKlienta getKlientDaneKlientaIdFk() {
        return klientDaneKlientaIdFk;
    }

    public void setKlientDaneKlientaIdFk(DaneKlienta klientDaneKlientaIdFk) {
        this.klientDaneKlientaIdFk = klientDaneKlientaIdFk;
    }

    public Zainteresowania getKlientZainteresowaniaIdFk() {
        return klientZainteresowaniaIdFk;
    }

    public void setKlientZainteresowaniaIdFk(Zainteresowania klientZainteresowaniaIdFk) {
        this.klientZainteresowaniaIdFk = klientZainteresowaniaIdFk;
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
        hash += (klientId != null ? klientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klient)) {
            return false;
        }
        Klient other = (Klient) object;
        if ((this.klientId == null && other.klientId != null) || (this.klientId != null && !this.klientId.equals(other.klientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Klient[ klientId=" + klientId + " ]";
    }
    
}
