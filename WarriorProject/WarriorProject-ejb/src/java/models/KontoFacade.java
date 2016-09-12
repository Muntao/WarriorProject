/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Konto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class KontoFacade extends AbstractFacade<Konto> {

    @PersistenceContext(unitName = "WarriorProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KontoFacade() {
        super(Konto.class);
    }

    public Konto findByKontoLoginAndHaslo(Konto konto) {
        Query q = em.createNamedQuery("Konto.findByKontoLoginAndHaslo")
                .setParameter("kontoLogin", konto.getKontoLogin())
                .setParameter("kontoHaslo", konto.getKontoHaslo());
        List<Konto> result = q.getResultList();
        if (result.size() > 0) {
            return result.get(0);
        } 
        return null;        
    }
    
    public Konto findByKontoLogin(Konto konto) {
        Query q = em.createNamedQuery("Konto.findByKontoLogin")
                .setParameter("kontoLogin", konto.getKontoLogin());
        List<Konto> result = q.getResultList();
        if (result.size() > 0) {
            return result.get(0);
        } 
        return null;        
    }
}
