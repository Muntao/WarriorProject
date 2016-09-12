package backbeans;

import entities.Adres;
import entities.DaneKlienta;
import entities.Konto;
import entities.Klient;
import entities.Zainteresowania;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import models.AdresFacade;
import models.KontoFacade;
import models.KlientFacade;

@Named(value = "rejestracjaBean")
@RequestScoped
public class RejestracjaBean {

    @EJB
    private KontoFacade kontoFacade;
    private KlientFacade klientFacade;
    private AdresFacade adresFacade;

    private Konto konto = new Konto();
    private Klient klient = new Klient();
    private Adres adres = new Adres();

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    
    private String haslo;

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public String register() {
        if (this.kontoFacade.findByKontoLogin(konto) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Istnieje już takie konto!"));
            klient = new Klient();
            konto = new Konto();
            return "rejestracja";
        }
        if (haslo.equals(konto.getKontoHaslo())) {
            this.kontoFacade.create(konto);

            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Zostałeś poprawnie zarejestrowany!"));
            return "zaloguj";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rejestracja nie powiodła się!"));
            klient = new Klient();
            konto = new Konto();
            return "rejestracja";
        }
    }

    public RejestracjaBean() {
    }
}
