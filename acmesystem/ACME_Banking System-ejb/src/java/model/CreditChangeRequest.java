/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aks
 */

@Entity
@Table(name="CREDITCHANGEREQUESTS")
public class CreditChangeRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    protected Long id;
    
    @JoinColumn(name="CCNum", referencedColumnName = "CCNum")
    @OneToOne
    private CreditCardAccount creditAccount;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeRequested;
    
    @Column(nullable=false)
    private double newCreditLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditCardAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditCardAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public Date getTimeRequested() {
        return timeRequested;
    }

    public void setTimeRequested(Date timeRequested) {
        this.timeRequested = timeRequested;
    }

    public double getnewCreditLimit() {
        return newCreditLimit;
    }

    public void setnewCreditLimit(double CreditLimit) {
        this.newCreditLimit = CreditLimit;
    }
    
}
