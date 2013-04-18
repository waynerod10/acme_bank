package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Customer;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-12T10:21:52")
@StaticMetamodel(Account.class)
public abstract class Account_ { 

    public static volatile SingularAttribute<Account, Long> id;
    public static volatile SingularAttribute<Account, Customer> cId;
    public static volatile SingularAttribute<Account, String> AccNum;

}