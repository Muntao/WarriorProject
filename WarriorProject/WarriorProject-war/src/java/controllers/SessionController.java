/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Konto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import models.KontoFacade;

/**
 *
 * @author Muntao
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    public SessionController() {
    }

    @EJB
    private KontoFacade kontoFacade;

    private Konto konto = new Konto();
    private boolean logged = false;
    private boolean isAdmin = false;

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String login() {
        konto = kontoFacade.findByKontoLoginAndHaslo(konto);
        if (konto != null) {
            if (konto.getKontoUprawnienia().equals(Konto.BANNED)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Twoje konto zostało zbanowane!"));
                logged = false;
                konto = new Konto();
                return "/index?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Zostałeś poprawnie zalogowany!"));
                logged = true;
                if (konto.getKontoUprawnienia().equals(Konto.ADMIN)) {
                    isAdmin = true;
                }
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login lub hasło jest błędne!"));
            konto = new Konto();
            return "login";
        }
        return "/index?faces-redirect=true";

    }

    public String logout() {
        if (logged == true) {
            konto = new Konto();
            logged = false;
            isAdmin = false;
        }
        return "";
    }

}
