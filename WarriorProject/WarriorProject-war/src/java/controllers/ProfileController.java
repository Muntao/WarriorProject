/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Klient;
import entities.KlientZdjecie;
import entities.Znajomi;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import models.KlientFacade;
import models.KlientZdjecieFacade;
import models.ZnajomiFacade;

@Named(value = "profileController")
@ManagedBean
public class ProfileController {

    @ManagedProperty("#{param.profileId}")
    private String profileId;

    private Klient klient;

    @EJB
    private KlientFacade klientFacade;
    @EJB
    private KlientZdjecieFacade klientZdjecieFacade;
    @EJB
    private ZnajomiFacade znajomiFacade;

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
        System.out.println("\n\n ###################################PROFILEID: " + profileId + "\n\n ");
        if (profileId != null) {
            ArrayList<String> imagePaths = new ArrayList<>();
            List<KlientZdjecie> klientZdjecieList = klientZdjecieFacade.getKlientById(Integer.valueOf(profileId));

            for (KlientZdjecie klientZdjecie : klientZdjecieList) {
                imagePaths.add(klientZdjecie.getKlientZdjecieZdjecieIdFk().getZdjecieSciezka());
            }

            System.out.println("========###### " + imagePaths.size());

            return imagePaths;
        } else {
            return new ArrayList<String>();
        }
    }

    public void addToFriend() {
        System.out.println("################# JACKE NUUUB!!!!!!!!!!!!!!!!!!!");
        if (profileId == null) {
            System.out.println("################# addToFriendNULL!!!!!!!!!!!!!!!!!!!");
            return;
        }
        Klient klient1 = klientFacade.getKlientById(Integer.valueOf(profileId));
        Klient klient2 = klientFacade.getKlientById(((Klient) SessionManager.getObjectFromSession("klient")).getKlientId());

        System.out.println("DODAJE ZNAJOMYCH: " + klient1.getKlientId() + " and " + klient2.getKlientId());
        Znajomi znajomi = new Znajomi();

        znajomi.setZnajomiKlient2IdFk(klient1);
        znajomi.setZnajomiKlientIdFk(klient2);

        znajomiFacade.create(znajomi);
    }

    public boolean hasImages() {

        if (profileId == null) {
            return false;
        }
        List<KlientZdjecie> images = klientZdjecieFacade.getKlientById(Integer.valueOf(profileId));
        if (images == null || images.size() <= 0) {
            return false;
        }
        return true;
    }

    public String isMyFriend() {
        if (profileId == null) {
            return "a";
        } else {
            int friendId = Integer.valueOf(profileId);
            int myId = ((Klient) SessionManager.getObjectFromSession("klient")).getKlientId();

            List<Znajomi> friendList = znajomiFacade.getMyFriend(myId);
            for (Znajomi z : friendList) {
                if (z.getZnajomiKlientIdFk().getKlientId() == friendId || z.getZnajomiKlient2IdFk().getKlientId() == friendId) {
                    return "b";
                }
            }
            return "a";
        }
    }

}
