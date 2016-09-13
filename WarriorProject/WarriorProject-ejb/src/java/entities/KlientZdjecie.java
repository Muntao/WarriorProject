/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JacekM
 */
@Entity
@Table(name = "klient_zdjecie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KlientZdjecie.findAll", query = "SELECT k FROM KlientZdjecie k"),
    @NamedQuery(name = "KlientZdjecie.findByKlientZdjecieId", query = "SELECT k FROM KlientZdjecie k WHERE k.klientZdjecieId = :klientZdjecieId"),
    @NamedQuery(name = "KlientZdjecie.findByKlientId", query = "SELECT k FROM KlientZdjecie k WHERE k.klientZdjecieKlientIdFk.klientId = :klientId")})
public class KlientZdjecie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "klient_zdjecie_id")
    private Integer klientZdjecieId;
    @JoinColumn(name = "klient_zdjecie_klient_id_fk", referencedColumnName = "klient_id")
    @ManyToOne(optional = false)
    private Klient klientZdjecieKlientIdFk;
    @JoinColumn(name = "klient_zdjecie_zdjecie_id_fk", referencedColumnName = "zdjecie_id")
    @ManyToOne(optional = false)
    private Zdjecie klientZdjecieZdjecieIdFk;

    public KlientZdjecie() {
    }

    public KlientZdjecie(Integer klientZdjecieId) {
        this.klientZdjecieId = klientZdjecieId;
    }

    public Integer getKlientZdjecieId() {
        return klientZdjecieId;
    }

    public void setKlientZdjecieId(Integer klientZdjecieId) {
        this.klientZdjecieId = klientZdjecieId;
    }

    public Klient getKlientZdjecieKlientIdFk() {
        return klientZdjecieKlientIdFk;
    }

    public void setKlientZdjecieKlientIdFk(Klient klientZdjecieKlientIdFk) {
        this.klientZdjecieKlientIdFk = klientZdjecieKlientIdFk;
    }

    public Zdjecie getKlientZdjecieZdjecieIdFk() {
        return klientZdjecieZdjecieIdFk;
    }

    public void setKlientZdjecieZdjecieIdFk(Zdjecie klientZdjecieZdjecieIdFk) {
        this.klientZdjecieZdjecieIdFk = klientZdjecieZdjecieIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klientZdjecieId != null ? klientZdjecieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlientZdjecie)) {
            return false;
        }
        KlientZdjecie other = (KlientZdjecie) object;
        if ((this.klientZdjecieId == null && other.klientZdjecieId != null) || (this.klientZdjecieId != null && !this.klientZdjecieId.equals(other.klientZdjecieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.KlientZdjecie[ klientZdjecieId=" + klientZdjecieId + " ]";
    }
    
}
