package edu.nju.data.util.HQL_Helper.Impl;

import edu.nju.data.util.HQL_Helper.Enums.WherePara;
import edu.nju.data.util.HQL_Helper.Interfaces.WhereHQLInterface;
import org.springframework.stereotype.Repository;

/**
 * Created by ss14 on 2016/7/15.
 */
@Repository
public class WhereMaker_Question implements WhereHQLInterface {

    String wherePart="";

    @Override
    public String getWhereHql(WherePara wherePara) {
        if(wherePara ==null){
            return wherePart;
        }
        switch (wherePara){

            case userID:
                wherePart=" where author.id = ?1";
                break;

            case userName:
                wherePart=" where author.userName = ?1";
                break;

            case questionID:
                wherePart=" where id = ?1";
                break;

            default:
                System.out.println("WhereMaker_Question err");
        }
        return wherePart;
    }

}
