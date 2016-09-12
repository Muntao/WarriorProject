/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Klient;
import entities.Konto;
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
public class KlientFacade extends AbstractFacade<Klient> {

    @PersistenceContext(unitName = "WarriorProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KlientFacade() {
        super(Klient.class);
    }

    public Klient getKlientByKontoId(Integer klientKontoIdFk) {
        System.out.println("k=== " + klientKontoIdFk);
        Query q = em.createNamedQuery("Klient.findByKontoId").setParameter("klientKontoIdFk", klientKontoIdFk);
        System.out.println(q.toString());
        List<Klient> resultList = q.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

}
