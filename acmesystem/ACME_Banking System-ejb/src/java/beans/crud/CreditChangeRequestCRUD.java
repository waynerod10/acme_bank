/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.crud;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CreditCardTransaction;
import model.CreditChangeRequest;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class CreditChangeRequestCRUD extends AbstractCRUDService<CreditChangeRequest> {

      @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CreditChangeRequestCRUD() {
        super(CreditChangeRequest.class);
    }
}
