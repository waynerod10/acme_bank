/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Aks
 */
public class CustomerDTO  implements Serializable{
    private String cId;
    private String firstName;
    private String lastName;
    private String password;
    private Date dob;
    private String address;
    private String currJob;
    private double salaryPY;
    private String prefContact;

    public CustomerDTO(String cId, String firstName, String lastName, Date dob, String address, String currJob, double salaryPY, String prefContact) {
        this.cId = cId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.currJob = currJob;
        this.salaryPY = salaryPY;
        this.prefContact = prefContact;
    }

    
    public String getcId() {
        return cId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getCurrJob() {
        return currJob;
    }

    public double getSalaryPY() {
        return salaryPY;
    }

    public String getPrefContact() {
        return prefContact;
    }
    
    
}
