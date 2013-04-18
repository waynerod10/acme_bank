/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.crud;

import model.SavingsAccountTransaction;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class SavingsAccountTrnsactionCRUD extends AbstractCRUDService<SavingsAccountTransaction> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SavingsAccountTrnsactionCRUD() {
        super(SavingsAccountTransaction.class);
    }

    public int getDepositsByAccount(String accNum) {
        Query q1 = em.createQuery("SELECT COUNT(sat) from SavingsAccountTransaction sat "
                + "WHERE sat.accNum = :accNum "
                + "AND sat.amount > :limit");
        q1.setParameter("limit", 0.0);
        q1.setParameter("accNum", accNum);
        int count = ((Long) q1.getSingleResult()).intValue();
        return count;
    }
}
