package models;

import entities.DaneKlienta;
import entities.Klient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        Query q = em.createNamedQuery("Klient.findByKontoId").setParameter("klientKontoIdFk", klientKontoIdFk);
        List<Klient> resultList = q.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    public Klient getKlientById(Integer klientId) {
        Query q = em.createNamedQuery("Klient.findByKlientId").setParameter("klientId", klientId);
        List<Klient> resultList = q.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
    
    public Klient getKlientByDaneKlientaId(DaneKlienta daneKlienta) {
        Query q = em.createNamedQuery("Klient.findByDaneKlientaId").setParameter("daneKlientaIdFk", daneKlienta);
        List<Klient> resultList = q.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

}
