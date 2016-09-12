/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.DaneKlienta;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import models.DaneKlientaFacade;

/**
 *
 * @author JacekM
 */
@Named(value = "daneKlientaController")
@SessionScoped
public class DaneKlientaController implements Serializable, AbstractController<DaneKlienta>{

     @EJB
    private DaneKlientaFacade daneKlientaFacade;

    @Inject
    private SessionController sessionCon;

    private DaneKlienta daneKlienta = new DaneKlienta();

    public DaneKlientaController() {
    }

    public DaneKlienta getDaneKlienta() {
        return daneKlienta;
    }

    public void setDaneKlienta(DaneKlienta daneKlienta) {
        this.daneKlienta = daneKlienta;
    }

    @Override
    public List<DaneKlienta> findAll() {
        return this.daneKlientaFacade.findAll();
    }

    @Override
    public DaneKlienta findById(DaneKlienta t) throws Exception {
        return this.daneKlientaFacade.find(t);
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
    public String edit(DaneKlienta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String detail(DaneKlienta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(DaneKlienta t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
