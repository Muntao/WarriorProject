/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.DaneKlienta;
import entities.Zainteresowania;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import models.DaneKlientaFacade;
import models.ZainteresowaniaFacade;

/**
 *
 * @author JacekM
 */
@Named(value = "zainteresowaniaController")
@SessionScoped
public class ZainteresowaniaController implements Serializable, AbstractController<Zainteresowania>{

    @EJB
    private ZainteresowaniaFacade zainteresowaniaFacade;

    private Zainteresowania zainteresowania = new Zainteresowania();

    public ZainteresowaniaController() {
    }

    public Zainteresowania getZainteresowania() {
        return zainteresowania;
    }

    public void setZainteresowania(Zainteresowania zainteresowania) {
        this.zainteresowania = zainteresowania;
    }

    @Override
    public List<Zainteresowania> findAll() {
        return this.zainteresowaniaFacade.findAll();
    }

    @Override
    public Zainteresowania findById(Zainteresowania t) throws Exception {
        return this.zainteresowaniaFacade.find(t);
    }

    @Override
    public String add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(Zainteresowania t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String detail(Zainteresowania t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(Zainteresowania t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
