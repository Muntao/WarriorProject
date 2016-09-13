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
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import models.DaneKlientaFacade;
import models.KlientFacade;

@Named(value = "zainteresowaniaController")
@SessionScoped
public class ZainteresowaniaController implements Serializable {

    private EntityManager em;

    @EJB
    private KlientFacade klientFacade;
    
    @EJB
    private DaneKlientaFacade daneKlientaFacade;

    private Klient klient = new Klient();

    private Collection<Klient> znajomi = new ArrayList<>();

    public ZainteresowaniaController() {
    }

    public void ZnajdzOsobySpelniajaceZainteresowania() {
        klient = (Klient) SessionManager.getObjectFromSession("klient");
        Zainteresowania zainteresowania = klient.getKlientZainteresowaniaIdFk();

        List<DaneKlienta> dk = daneKlientaFacade.getDaneKlientByZainteresowania(zainteresowania);
        
        for(DaneKlienta dka : dk){            
            znajomi.add(klientFacade.getKlientByDaneKlientaId(dka));
        }       
    }

}
