/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.KlientZdjecie;
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
public class KlientZdjecieFacade extends AbstractFacade<KlientZdjecie> {

    @PersistenceContext(unitName = "WarriorProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KlientZdjecieFacade() {
        super(KlientZdjecie.class);
    }

    public List<KlientZdjecie> getKlientById(Integer klientId) {
        Query q = em.createNamedQuery("KlientZdjecie.findByKlientId").setParameter("klientId", klientId);
        System.out.println("\n\n" + q + "\n\n");
        List<KlientZdjecie> resultList = q.getResultList();
        return resultList;
    }

}
