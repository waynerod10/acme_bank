package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CreditCardTransaction;
import model.CreditChangeRequest;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-12T10:21:52")
@StaticMetamodel(CreditCardAccount.class)
public class CreditCardAccount_ extends Account_ {

    public static volatile ListAttribute<CreditCardAccount, CreditCardTransaction> creditCardTransactionList;
    public static volatile SingularAttribute<CreditCardAccount, CreditChangeRequest> creditChangeRequest;
    public static volatile SingularAttribute<CreditCardAccount, Double> credit;
    public static volatile SingularAttribute<CreditCardAccount, String> CCNum;
    public static volatile SingularAttribute<CreditCardAccount, Double> creditLmit;

}