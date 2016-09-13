/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.DaneKlienta;
import entities.Klient;
import entities.Zainteresowania;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.DaneKlientaFacade;
import models.KlientFacade;

@Named(value = "zainteresowaniaController")
@SessionScoped
public class ZainteresowaniaController implements Serializable {

    @EJB
    private KlientFacade klientFacade;

    @EJB
    private DaneKlientaFacade daneKlientaFacade;

    private Klient klient = new Klient();

    private Collection<Klient> znajomi = new ArrayList<>();

    public ZainteresowaniaController() {
    }

    public Collection<Klient> getZnajomi() {
        return znajomi;
    }

    public void setZnajomi(Collection<Klient> znajomi) {
        this.znajomi = znajomi;
    }

    public void znajdzOsobySpelniajaceZainteresowania() {
        klient = (Klient) SessionManager.getObjectFromSession("klient");

        if (klient.getKlientZainteresowaniaIdFk() != null) {
            Zainteresowania zainteresowania = klient.getKlientZainteresowaniaIdFk();
            List<DaneKlienta> dk = daneKlientaFacade.getDaneKlientByZainteresowania(zainteresowania);
            for (DaneKlienta dka : dk) {
                if(dka != null)
                    this.znajomi.add(klientFacade.getKlientByDaneKlientaId(dka));
            }
        } else {
            this.znajomi = this.klientFacade.findAll();
        }
    }
    
    public void showProfile(int id){
        SessionManager.redirect2("/customer/profile/profile.xhtml?profileId=" + id);
    }
}
