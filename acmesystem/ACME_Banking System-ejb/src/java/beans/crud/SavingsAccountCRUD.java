/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.crud;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class SavingsAccountCRUD extends AbstractAccountCRUD {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
