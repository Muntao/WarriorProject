/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Klient;
import entities.Konto;
import entities.Pracownik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import models.KontoFacade;


/**
 *
 * @author Jacek
 */
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private Konto konto = new Konto();
    private List<Konto> kontaList = new ArrayList<>();

    @EJB
    private KontoFacade kontoEJB;
    
     private Pracownik pracownik;

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public boolean checkLogged() {
        return SessionManager.getObjectFromSession("logged") != null;
    }

    public String checkPermission() {
        String permissions = (String) SessionManager.getObjectFromSession("permission");
        if (permissions != null) {
            return permissions;
        }
        return "";
    }

    public String login() {
        try {
            if (konto != null && konto.getKontoLogin() != null && konto.getKontoHaslo() != null) {
                konto = kontoEJB.findByKontoLoginAndHaslo(konto);
                if (konto != null) {
                    if (checkLogged() == false) {
                        this.konto = kontoEJB.refresh(this.konto);
                        SessionManager.addToSession("id_konta", konto.getKontoId());
                        SessionManager.addToSession("logged", true);
                        SessionManager.addToSession("permission", konto.getKontoUprawnienia());
                        if(konto.getKlientCollection() != null)
                            SessionManager.addToSession("klient", konto.getKlientCollection().iterator().next());
                    }
                    return "/index?faces-redirect=true";
                }
            }
        } catch (Exception ex) {
            Logger.getLogger("EXCEPTIONS").log(Level.WARNING, "Błędne dane logowania dla użytkownika=" + konto.getKontoLogin());
        }

        SessionManager.addToSession("LOGIN_ERROR", "Błędny login lub hasło");
        return "/index?faces-redirect=true";
    }

    public String checkParam(String param) {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();

        return params.get(param);
    }

    public String logout() {
        if (SessionManager.getObjectFromSession("logged") != null) {
            SessionManager.destroySession();
        }
        return "";
    }

    public Klient getKlientAccount() {
        if (this.konto.getKlientCollection() == null) {
            return null;
        }
        this.konto = kontoEJB.refresh(this.konto);
        for (Klient klient : this.konto.getKlientCollection()) {
            if (klient != null) {
                Logger.getLogger("INFO").log(Level.INFO, "CLIENT FROM ACCOUNT: {0}", klient.getKlientImie());
                return klient;
            }
        }
        return null;
    }
    
    public void loadPracownikAccount() {
        
        this.konto = kontoEJB.find(SessionManager.getObjectFromSession("id_konta"));
        this.pracownik = konto.getPracownikCollection().iterator().next();
    }

    public Pracownik getPracownikAccount() {
        if (this.konto.getPracownikCollection() == null) {
            return null;
        }
        this.konto = kontoEJB.refresh(this.konto);
        for (Pracownik pracownik : this.konto.getPracownikCollection()) {
            if (pracownik != null) {
                return pracownik;
            }
        }
        return null;
    }

    public List<Konto> findAll() {
        kontaList = kontoEJB.findAll();
        return kontaList;
    }

    public Konto findById() throws Exception {
        konto = kontoEJB.find(this.konto.getKontoId());
        return konto;
    }

    public String addNew() {
        kontoEJB.create(this.konto);
        return "/index?faces-redirect=true";
    }
    
    public void redirect(String url){
        SessionManager.redirect(url);
    }
}
