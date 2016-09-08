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
@Table(name = "znajomi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Znajomi.findAll", query = "SELECT z FROM Znajomi z"),
    @NamedQuery(name = "Znajomi.findByZnajomiId", query = "SELECT z FROM Znajomi z WHERE z.znajomiId = :znajomiId")})
public class Znajomi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "znajomi_id")
    private Integer znajomiId;
    @JoinColumn(name = "znajomi_klient_id_fk", referencedColumnName = "klient_id")
    @ManyToOne(optional = false)
    private Klient znajomiKlientIdFk;
    @JoinColumn(name = "znajomi_klient2_id_fk", referencedColumnName = "klient_id")
    @ManyToOne(optional = false)
    private Klient znajomiKlient2IdFk;

    public Znajomi() {
    }

    public Znajomi(Integer znajomiId) {
        this.znajomiId = znajomiId;
    }

    public Integer getZnajomiId() {
        return znajomiId;
    }

    public void setZnajomiId(Integer znajomiId) {
        this.znajomiId = znajomiId;
    }

    public Klient getZnajomiKlientIdFk() {
        return znajomiKlientIdFk;
    }

    public void setZnajomiKlientIdFk(Klient znajomiKlientIdFk) {
        this.znajomiKlientIdFk = znajomiKlientIdFk;
    }

    public Klient getZnajomiKlient2IdFk() {
        return znajomiKlient2IdFk;
    }

    public void setZnajomiKlient2IdFk(Klient znajomiKlient2IdFk) {
        this.znajomiKlient2IdFk = znajomiKlient2IdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (znajomiId != null ? znajomiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Znajomi)) {
            return false;
        }
        Znajomi other = (Znajomi) object;
        if ((this.znajomiId == null && other.znajomiId != null) || (this.znajomiId != null && !this.znajomiId.equals(other.znajomiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Znajomi[ znajomiId=" + znajomiId + " ]";
    }
    
}
