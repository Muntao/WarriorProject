/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Znajomi;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}