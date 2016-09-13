/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Znajomi;
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
public class ZnajomiFacade extends AbstractFacade<Znajomi> {

    @PersistenceContext(unitName = "WarriorProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZnajomiFacade() {
        super(Znajomi.class);
    }

    public List<Znajomi> getMyFriend(Integer klientId) {
        Query q = em.createNamedQuery("Znajomi.findByZnajomiKlientId").setParameter("klientId", klientId);
        System.out.println(q);
        List<Znajomi> resultList = q.getResultList();
        return resultList;
    }

}
