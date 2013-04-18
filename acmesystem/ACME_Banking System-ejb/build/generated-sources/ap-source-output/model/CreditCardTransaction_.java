package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CreditCardAccount;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-12T10:21:52")
@StaticMetamodel(CreditCardTransaction.class)
public class CreditCardTransaction_ { 

    public static volatile SingularAttribute<CreditCardTransaction, Long> id;
    public static volatile SingularAttribute<CreditCardTransaction, Double> amount;
    public static volatile SingularAttribute<CreditCardTransaction, CreditCardAccount> ccAccount;
    public static volatile SingularAttribute<CreditCardTransaction, String> description;
    public static volatile SingularAttribute<CreditCardTransaction, Date> timeTransacted;
    public static volatile SingularAttribute<CreditCardTransaction, Double> CreditLimit;

}