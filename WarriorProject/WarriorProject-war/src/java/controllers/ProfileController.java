/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Klient;
import entities.KlientZdjecie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import models.KlientFacade;
import models.KlientZdjecieFacade;
import models.KontoFacade;
import models.ZdjecieFacade;

/**
 *
 * @author layfl
 */
@Named(value = "profileController")
@ManagedBean
public class ProfileController {

    @ManagedProperty("#{param.profileId}")
    private String profileId;

    private Klient klient;

    @EJB
    private KontoFacade kontoFacade;
    @EJB
    private KlientFacade klientFacade;
    @EJB
    private KlientZdjecieFacade klientZdjecieFacade;
    @EJB
    private ZdjecieFacade zdjecieFacade;

    public ProfileController() {
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public void loadProfile() {
        klient = klientFacade.getKlientById(Integer.valueOf(profileId));
    }

    public List<String> getImagesPath() {
        ArrayList<String> imagePaths = new ArrayList<>();
        List<KlientZdjecie> klientZdjecieList = klientZdjecieFacade.getKlientById(klient.getKlientId());

        for (KlientZdjecie klientZdjecie : klientZdjecieList) {
            imagePaths.add(klientZdjecie.getKlientZdjecieZdjecieIdFk().getZdjecieSciezka());
        }

        return imagePaths;
    }

}
