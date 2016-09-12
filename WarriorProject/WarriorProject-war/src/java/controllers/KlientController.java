/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Klient;
import entities.Konto;
import entities.Adres;
import entities.DaneKlienta;
import entities.Zainteresowania;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import models.AdresFacade;
import models.DaneKlientaFacade;
import models.KlientFacade;
import models.KontoFacade;
import models.ZainteresowaniaFacade;

/**
 *
 * @author Muntao
 */
@Named(value = "klientController")
@SessionScoped
public class KlientController implements Serializable {

    @EJB
    private KlientFacade klientFacade;
    @EJB
    private KontoFacade kontoFacade;
    @EJB
    private AdresFacade adresFacade;
    @EJB
    private DaneKlientaFacade daneKlientaFacade;
    @EJB
    private ZainteresowaniaFacade zainteresowaniaFacade;

    @Inject
    private SessionController sessionCon;

    private Klient user = new Klient();
    private Konto konto = new Konto();
    private Adres adres = new Adres();
    private DaneKlienta daneKlienta = new DaneKlienta();
    private Zainteresowania zainteresowania = new Zainteresowania();

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public DaneKlienta getDaneKlienta() {
        return daneKlienta;
    }

    public void setDaneKlienta(DaneKlienta daneKlienta) {
        this.daneKlienta = daneKlienta;
    }

    public Zainteresowania getZainteresowania() {
        return zainteresowania;
    }

    public void setZainteresowania(Zainteresowania zainteresowania) {
        this.zainteresowania = zainteresowania;
    }

    
    
    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
    public Klient getUser() {
        return user;
    }

    public void setUser(Klient user) {
        this.user = user;
    }

    public KlientController() {
    }

    public List<Klient> findAllUsers() {
        return this.klientFacade.findAll();
    }

    public String add() {

//        if (this.klientFacade.findByUzytkownikLoginOrEmail(user) == null) {
            this.kontoFacade.create(this.konto);
            this.user.setKlientKontoIdFk(this.konto);
            this.klientFacade.create(this.user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dodano użytkownika!"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Taki użytkownik już istnieje!"));
//        }
        return "users";
    }

    public String edit(Klient u) {
        this.user = u;
        return "usersEdit";
    }
    
    public String detail(Klient u) {
        this.user = u;
        this.konto = user.getKlientKontoIdFk();
        this.adres = user.getKlientAdresIdFk();
        this.zainteresowania = user.getKlientZainteresowaniaIdFk();
        this.daneKlienta = user.getKlientDaneKlientaIdFk();
        return "usersDetail";
    }

    public String edit() {
//        if (this.uzytkownikFacade.findByUzytkownikLoginOrEmail(user) == null) {
            this.kontoFacade.edit(this.konto);
            this.user.setKlientKontoIdFk(this.konto);
            this.klientFacade.edit(this.user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edytowano użytkownika!"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Taki użytkownik już istnieje!"));
//        }
        return "usersEdit";
    }

    public String remove(Klient user) {
        this.klientFacade.remove(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usunięto użytkownika!"));
        return "users";
    }

    public Object findById(Object key) {
        return this.klientFacade.find(key);
    }
    
    public String addNewUser() {
        this.user = new Klient();
        this.konto = new Konto();
        return "usersAdd";
    }
}
