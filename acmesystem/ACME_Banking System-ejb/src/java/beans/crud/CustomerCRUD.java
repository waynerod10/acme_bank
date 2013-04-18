/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Account;
import model.Customer;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class CustomerCRUD extends AbstractCRUDService<Customer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerCRUD() {
        super(Customer.class);
    }

    public Customer findByCustNum(String custNum) {
        List<Customer> result = em.createNamedQuery("Customer.findByCID", Customer.class)
                .setParameter("cid", custNum)
                .getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public List<Account> findAccounts(Customer c) {
        TypedQuery<Account> q = em.createNamedQuery("Account.findByCustomer", Account.class).setParameter("customer", c);
        List<Account> alist = q.getResultList();
        return alist;
    }
}
