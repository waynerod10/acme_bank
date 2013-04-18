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
import model.Employee;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class EmployeeCRUD extends AbstractCRUDService<Employee> {

      @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeCRUD() {
        super(Employee.class);
    }
    
    public Employee findByEmpNum(String empNum) {
        List<Employee> es =  em.createNamedQuery("Employee.findByENum", Employee.class)
                .setParameter("enum", empNum)
                .getResultList();
        if(es.isEmpty()) {
            return null;
        }
        else {
            return es.get(0);
        }
    }
    
//    public List<Account> findAccounts(Employee e) {
//        TypedQuery<Account> q = em.createNamedQuery("Account.findByEmployee",Account.class).setParameter("enum", e);
//        List<Account> alist = q.getResultList();
//        return alist;
//    }
}
