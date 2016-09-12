/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Adres;
import entities.Klient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import models.AdresFacade;
import models.DaneKlientaFacade;
import models.KlientFacade;
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
    private AdresFacade adresFacade;
    @EJB
    private DaneKlientaFacade daneKlientaFacade;
    @EJB
    private ZainteresowaniaFacade zainteresowaniaFacade;

    @Inject
    private SessionController sessionCon;

    private Klient user = new Klient();
    private Adres address = new Adres();
    

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
            this.klientFacade.create(this.user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dodano użytkownika!"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Taki użytkownik już istnieje!"));
//        }
        return "uzytkownik";
    }

    public String edit(Klient u) {
        this.user = u;
        return "edytuj";
    }

    public String edit() {
//        if (this.uzytkownikFacade.findByUzytkownikLoginOrEmail(user) == null) {
            this.klientFacade.edit(this.user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edytowano użytkownika!"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Taki użytkownik już istnieje!"));
//        }
        return "uzytkownik";
    }

    public String remove(Klient user) {
        this.klientFacade.remove(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usunięto użytkownika!"));
        return "uzytkownik";
    }

    public Object findById(Object key) {
        return this.klientFacade.find(key);
    }
//
//
//    public String addCourse() {
//        UzytkownikKursy uk = new UzytkownikKursy();
//        uk.setUzytkownikKursyDataKoniec(endDate);
//        uk.setUzytkownikKursyDataPoczatek(beginDate);
//        uk.setUzytkownikKursyUzytkownikIdFk(this.user);
//        uk.setUzytkownikKursyKursIdFk(this.kurs);
//        if (this.uzytkownikKursyFacade.findByUzytkownikAndKursId(this.user, this.kurs) != null) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ten element został już dodany!"));
//            return "dodajKursDoUzytkownika";
//        } else if (!beginDate.before(endDate)) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Błąd daty!"));
//            return "dodajKursDoUzytkownika";
//        } else {
//            this.uzytkownikKursyFacade.create(uk);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dodano kurs!"));
//            return "kursy";
//        }
//    }
}
