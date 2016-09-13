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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author layfl
 */
@Entity
@Table(name = "zainteresowania")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zainteresowania.findAll", query = "SELECT z FROM Zainteresowania z"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaId", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaId = :zainteresowaniaId"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaWzrostMin", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaWzrostMin = :zainteresowaniaWzrostMin"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaWzrostMax", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaWzrostMax = :zainteresowaniaWzrostMax"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaWagaMin", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaWagaMin = :zainteresowaniaWagaMin"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaWagaMax", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaWagaMax = :zainteresowaniaWagaMax"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaPlec", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaPlec = :zainteresowaniaPlec"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaStan", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaStan = :zainteresowaniaStan"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaWiekMin", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaWiekMin = :zainteresowaniaWiekMin"),
    @NamedQuery(name = "Zainteresowania.findByZainteresowaniaWiekMax", query = "SELECT z FROM Zainteresowania z WHERE z.zainteresowaniaWiekMax = :zainteresowaniaWiekMax")})
public class Zainteresowania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zainteresowania_id")
    private Integer zainteresowaniaId;
    @Column(name = "zainteresowania_wzrost_min")
    private Integer zainteresowaniaWzrostMin;
    @Column(name = "zainteresowania_wzrost_max")
    private Integer zainteresowaniaWzrostMax;
    @Column(name = "zainteresowania_waga_min")
    private Integer zainteresowaniaWagaMin;
    @Column(name = "zainteresowania_waga_max")
    private Integer zainteresowaniaWagaMax;
    @Size(max = 50)
    @Column(name = "zainteresowania_plec")
    private String zainteresowaniaPlec;
    @Size(max = 50)
    @Column(name = "zainteresowania_stan")
    private String zainteresowaniaStan;
    @Column(name = "zainteresowania_wiek_min")
    private Integer zainteresowaniaWiekMin;
    @Column(name = "zainteresowania_wiek_max")
    private Integer zainteresowaniaWiekMax;

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

    public Integer getZainteresowaniaWzrostMin() {
        return zainteresowaniaWzrostMin;
    }

    public void setZainteresowaniaWzrostMin(Integer zainteresowaniaWzrostMin) {
        this.zainteresowaniaWzrostMin = zainteresowaniaWzrostMin;
    }

    public Integer getZainteresowaniaWzrostMax() {
        return zainteresowaniaWzrostMax;
    }

    public void setZainteresowaniaWzrostMax(Integer zainteresowaniaWzrostMax) {
        this.zainteresowaniaWzrostMax = zainteresowaniaWzrostMax;
    }

    public Integer getZainteresowaniaWagaMin() {
        return zainteresowaniaWagaMin;
    }

    public void setZainteresowaniaWagaMin(Integer zainteresowaniaWagaMin) {
        this.zainteresowaniaWagaMin = zainteresowaniaWagaMin;
    }

    public Integer getZainteresowaniaWagaMax() {
        return zainteresowaniaWagaMax;
    }

    public void setZainteresowaniaWagaMax(Integer zainteresowaniaWagaMax) {
        this.zainteresowaniaWagaMax = zainteresowaniaWagaMax;
    }

    public String getZainteresowaniaPlec() {
        return zainteresowaniaPlec;
    }

    public void setZainteresowaniaPlec(String zainteresowaniaPlec) {
        this.zainteresowaniaPlec = zainteresowaniaPlec;
    }

    public String getZainteresowaniaStan() {
        return zainteresowaniaStan;
    }

    public void setZainteresowaniaStan(String zainteresowaniaStan) {
        this.zainteresowaniaStan = zainteresowaniaStan;
    }

    public Integer getZainteresowaniaWiekMin() {
        return zainteresowaniaWiekMin;
    }

    public void setZainteresowaniaWiekMin(Integer zainteresowaniaWiekMin) {
        this.zainteresowaniaWiekMin = zainteresowaniaWiekMin;
    }

    public Integer getZainteresowaniaWiekMax() {
        return zainteresowaniaWiekMax;
    }

    public void setZainteresowaniaWiekMax(Integer zainteresowaniaWiekMax) {
        this.zainteresowaniaWiekMax = zainteresowaniaWiekMax;
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
