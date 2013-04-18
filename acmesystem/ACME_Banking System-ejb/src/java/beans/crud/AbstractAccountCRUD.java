/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.crud;

import beans.crud.AbstractCRUDService;
import javax.persistence.NoResultException;
import model.Account;

/**
 *
 * @author Aks
 */
public abstract class AbstractAccountCRUD extends AbstractCRUDService<Account> {

    public AbstractAccountCRUD() {
        super(Account.class);
    }

    public Account findByAccNum(String accNum) throws NoResultException {
        return getEntityManager().createNamedQuery("Account.findByAccNum", Account.class)
                .setParameter("accNum", accNum)
                .getSingleResult();
    }
}
