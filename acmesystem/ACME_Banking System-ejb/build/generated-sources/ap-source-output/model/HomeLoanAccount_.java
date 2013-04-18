package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-12T10:21:52")
@StaticMetamodel(HomeLoanAccount.class)
public class HomeLoanAccount_ extends Account_ {

    public static volatile SingularAttribute<HomeLoanAccount, Double> amountBorrowed;
    public static volatile SingularAttribute<HomeLoanAccount, Double> amountRepayed;

}