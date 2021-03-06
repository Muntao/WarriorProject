/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import models.KontoFacade;
import entities.Konto;

@Named(value = "KontoController")
@SessionScoped
public class KontoController implements Serializable {

    @EJB
    private KontoFacade kontoFacade;

    private Konto konto = new Konto();

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }
    
    public KontoController() {
    }

    public List<Konto> findAllUsers() {
        return this.kontoFacade.findAll();
    }
//
//    public String add() {
//        Date d = new Date();
//        this.user.setUzytkownikDataRejestracji(d);
//        this.user.setUzytkownikOstatnieLogowanie(d);
//
//        if (this.uzytkownikFacade.findByUzytkownikLoginOrEmail(user) == null) {
//            this.uzytkownikFacade.create(this.user);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dodano użytkownika!"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Taki użytkownik już istnieje!"));
//        }
//        return "uzytkownik";
//    }
//
//    public String edit(Uzytkownik u) {
//        this.user = u;
//        return "edytuj";
//    }
//
//    public String edit() {
//        if (this.uzytkownikFacade.findByUzytkownikLoginOrEmail(user) == null) {
//            this.uzytkownikFacade.edit(this.user);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edytowano użytkownika!"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Taki użytkownik już istnieje!"));
//        }
//        return "uzytkownik";
//    }
//
//    public String remove(Uzytkownik user) {
//        List<Kurs> uks = this.uzytkownikKursyFacade.findByUzytkownikIdFk(user);
//        if (!uks.isEmpty()) {
//            for (Kurs k : uks) {
//                this.uzytkownikKursyFacade.remove(this.uzytkownikKursyFacade.findByUzytkownikAndKursId(user, k));
//            }
//        }
//        this.uzytkownikFacade.remove(user);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usunięto użytkownika!"));
//        return "uzytkownik";
//    }
//
//    public Object findById(Object key) {
//        return this.uzytkownikFacade.find(key);
//    }
//
//    public String courseList(Uzytkownik u) {
//        this.user = u;
//        return "kursy";
//    }
//
//    public List<Kurs> courseList() {
//        List<Kurs> courses = new ArrayList();
//        List<Kurs> freeCourses = this.kursFacade.findFreeCourses();
//        List<Kurs> paidCourses = this.uzytkownikKursyFacade.findByUzytkownikIdFk(user);
//        if (freeCourses != null) {
//            courses.addAll(freeCourses);
//        }
//        if (paidCourses != null) {
//            courses.addAll(paidCourses);
//        }
//
//        return courses;
//    }
//
//    public List<Kurs> courseListNoAccess() {
//        List<Kurs> courses = new ArrayList();
//        List<Kurs> paidCoursesAll = this.findPremiumKursy();
//        List<Kurs> paidCoursesAccess = this.uzytkownikKursyFacade.findByUzytkownikIdFk(user);
//        courses.addAll(paidCoursesAll);
//        for (Kurs paidCoursesAcces : paidCoursesAccess) {
//            courses.remove(paidCoursesAcces);
//        }
//        return courses;
//    }
//
//    public String deleteKurs(Kurs k) {
//        this.uzytkownikKursyFacade.remove(this.uzytkownikKursyFacade.findByUzytkownikAndKursId(this.user, k));
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usunięto kurs!"));
//        return "uzytkownik";
//    }
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
//
//    }
//
//    public String addCourseUser(Kurs k) {
//        UzytkownikKursy uk = new UzytkownikKursy();
//        Date today = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(today);
//        cal.add(Calendar.MONTH, 1);
//        Date plusMonth = cal.getTime();
//
//        uk.setUzytkownikKursyDataPoczatek(today);
//        uk.setUzytkownikKursyDataKoniec(plusMonth);
//        uk.setUzytkownikKursyUzytkownikIdFk(sessionCon.getU());
//        uk.setUzytkownikKursyKursIdFk(k);
//
//        if (this.uzytkownikKursyFacade.findByUzytkownikAndKursId(this.user, this.kurs) != null) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ten element został już dodany!"));
//            return "dodajKursDoUzytkownika";
//        } else if (!today.before(plusMonth)) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Błąd daty!"));
//            return "dodajKursDoUzytkownika";
//        } else {
//            this.uzytkownikKursyFacade.create(uk);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dodano kurs!"));
//            return "kursy";
//        }
//
//    }
//
//    public String addNewUser() {
//        this.user = new Uzytkownik();
//        return "dodaj";
//    }
//
//    private static Map<String, Object> permList;
//
//    static {
//        permList = new LinkedHashMap<String, Object>();
//        permList.put("Uzytkownik", 0);
//        permList.put("Admin", 1);
//    }
//
//    public Map<String, Object> getPermList() {
//        return permList;
//    }
//
//    public String dodajKursDoUzytkownika() {
//        kurs = new Kurs();
//        return "dodajKursDoUzytkownika";
//    }
//
//    public int getUzytkownikCount() {
//        return this.uzytkownikFacade.findAll().size();
//    }

}
