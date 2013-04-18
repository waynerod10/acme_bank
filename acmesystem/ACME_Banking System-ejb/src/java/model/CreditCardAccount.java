package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Aks
 */
@Entity
@PrimaryKeyJoinColumn(name = "ACC_ID",
referencedColumnName = "ID")
@Table(name = "CREDITCARD")
public class CreditCardAccount extends Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "CCNum",nullable=false, unique=true)
    private String CCNum;
    
    @Column(nullable=false)
    private double creditLmit;
    
    private double credit;

    @OneToMany(mappedBy = "ccAccount")
    private List<CreditCardTransaction> creditCardTransactionList;

    @OneToOne(mappedBy = "creditAccount")
    private CreditChangeRequest creditChangeRequest ;
    
    public String getCCNum() {
        return CCNum;
    }

    public void setCCNum(String CCNum) {
        this.CCNum = CCNum;
    }

    public List<CreditCardTransaction> getCreditCardTransactionList() {
        return creditCardTransactionList;
    }

    public void setCreditCardTransactionList(List<CreditCardTransaction> creditCardTransactionList) {
        this.creditCardTransactionList = creditCardTransactionList;
    }

    public double getCreditLmit() {
        return creditLmit;
    }

    public void setCreditLmit(double creditLmit) {
        this.creditLmit = creditLmit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    
}
