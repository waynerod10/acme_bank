/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.crud;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.CreditCardAccount;
import model.CreditCardTransaction;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class CreditCardTransactionCRUD extends AbstractCRUDService<CreditCardTransaction> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CreditCardTransactionCRUD() {
        super(CreditCardTransaction.class);
    }

    public long getTransactionsByAccountAndLimit(CreditCardAccount cca) {
        Query q1 = em.createQuery("SELECT COUNT(cct) from CreditCardTransaction cct "
                + "WHERE cct.ccAccount = :ccaccount "
                + "AND cct.CreditLimit = :limit");
        q1.setParameter("limit", cca.getCreditLmit());
        q1.setParameter("ccaccount", cca);
        long count = ((Long) q1.getSingleResult()).longValue();
        return count;
    }
}
