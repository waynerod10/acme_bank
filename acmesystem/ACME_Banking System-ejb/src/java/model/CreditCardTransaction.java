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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aks
 */

@Entity
@Table(name="CREDITCARDTRANSACTION")
public class CreditCardTransaction implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    protected Long id;
    
    @JoinColumn(name="CCNum", referencedColumnName = "CCNum")
    @ManyToOne
    private CreditCardAccount ccAccount;
    
    private String description;
    
    private double amount;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeTransacted;
    
    @Column(nullable=false)
    private double CreditLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditCardAccount getCcAccount() {
        return ccAccount;
    }

    public void setCcAccount(CreditCardAccount ccAccount) {
        this.ccAccount = ccAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimeTransacted() {
        return timeTransacted;
    }

    public void setTimeTransacted(Date timeTransacted) {
        this.timeTransacted = timeTransacted;
    }

    public double getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(double CreditLimit) {
        this.CreditLimit = CreditLimit;
    }
    
    public void setCreditLimit()
    {
        //Automatically set Credit Limit in the transaction
        setCreditLimit(ccAccount.getCreditLmit());
    }
    
}
