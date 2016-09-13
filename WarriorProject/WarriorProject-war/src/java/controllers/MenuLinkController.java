/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Klient;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author layfl
 */
@Named(value = "menuLinkController")
@Dependent
public class MenuLinkController {

    public MenuLinkController() {
    }

    public String getMyProfileLink() {
        String menu = "/customer/profile/profile.xhtml?profileId=";
        Integer id = ((Klient) SessionManager.getObjectFromSession("klient")).getKlientId();

        return menu + id;
    }
    
        public String getMyPictureLink() {
        String menu = "/customer/photos/photos.xhtml?profileId=";
        Integer id = ((Klient) SessionManager.getObjectFromSession("klient")).getKlientId();

        return menu + id;
    }

}
