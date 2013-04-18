package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CreditCardAccount;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-12T10:21:52")
@StaticMetamodel(CreditChangeRequest.class)
public class CreditChangeRequest_ { 

    public static volatile SingularAttribute<CreditChangeRequest, Long> id;
    public static volatile SingularAttribute<CreditChangeRequest, CreditCardAccount> creditAccount;
    public static volatile SingularAttribute<CreditChangeRequest, Double> newCreditLimit;
    public static volatile SingularAttribute<CreditChangeRequest, Date> timeRequested;

}