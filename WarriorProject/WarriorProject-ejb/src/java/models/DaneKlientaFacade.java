/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.DaneKlienta;
import entities.Klient;
import entities.Zainteresowania;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JacekM
 */
@Stateless
public class DaneKlientaFacade extends AbstractFacade<DaneKlienta> {

    @PersistenceContext(unitName = "WarriorProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DaneKlientaFacade() {
        super(DaneKlienta.class);
    }
    
    public List<DaneKlienta> getDaneKlientByZainteresowania(Zainteresowania z) {
        Query q = em.createNamedQuery("DaneKlienta.findByZainteresowania")
                .setParameter("zainteresowania_wzrost_min", z.getZainteresowaniaWzrostMin())
                .setParameter("zainteresowania_wzrost_max", z.getZainteresowaniaWzrostMax())
                .setParameter("zainteresowania_waga_min", z.getZainteresowaniaWagaMin())
                .setParameter("zainteresowania_waga_max", z.getZainteresowaniaWagaMax())
                .setParameter("zainteresowania_plec", z.getZainteresowaniaPlec())
                .setParameter("zainteresowania_stan", z.getZainteresowaniaStan());
        List<DaneKlienta> resultList = q.getResultList();
        return resultList;
        
    }
    
    
}
