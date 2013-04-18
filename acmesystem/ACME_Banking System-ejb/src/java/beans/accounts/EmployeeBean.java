/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accounts;

import dto.employeeDTO;
import beans.accounts.exceptions.EmployeeException;
import beans.crud.EmployeeCRUD;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.Employee;

/**
 *
 * @author wayne
 */
@Stateless
@LocalBean
public class EmployeeBean {

    @EJB
    private EmployeeCRUD eCRUD;

    public void createEmployee(Employee emp) throws EmployeeException {
        try {
            eCRUD.create(emp);
        } catch (Exception e) {
            throw new EmployeeException("Duplicate Employee ID");
        }

    }

    public String validate(String empNo, String password) throws EmployeeException {
        Employee e = eCRUD.findByEmpNum(empNo);
        if (e == null) {
            throw new EmployeeException("Error");
        }

        if (empNo.equalsIgnoreCase(e.getEmpNum()) && password.equals(e.getPassword())) {
            return "Logged in..";
        } else {
            return "Error";
        }
    }

    public List<employeeDTO> getAllEmployees() {

        List<Employee> emps = null;
        List<employeeDTO> ret_emps = new ArrayList<employeeDTO>();

        emps = eCRUD.findAll();

        if (emps == null || emps.isEmpty()) {
            return null;
        }

        for (Employee emp : emps) {
            employeeDTO tmp = new employeeDTO();
            tmp.setEmpNum(emp.getEmpNum());
            tmp.setLastName(emp.getLastName());
            tmp.setFirstName(emp.getFirstName());
            tmp.setAddress(emp.getAddress());
            tmp.setDob(emp.getDob());
            ret_emps.add(tmp);
        }
        return ret_emps;
    }
    
}
