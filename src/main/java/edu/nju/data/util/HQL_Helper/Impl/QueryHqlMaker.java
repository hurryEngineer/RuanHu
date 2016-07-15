package edu.nju.data.util.HQL_Helper.Impl;

import edu.nju.data.util.HQL_Helper.Enums.FromPara;
import edu.nju.data.util.HQL_Helper.Enums.OrderByMethod;
import edu.nju.data.util.HQL_Helper.Enums.OrderByPara;
import edu.nju.data.util.HQL_Helper.Enums.WherePara;
import edu.nju.data.util.HQL_Helper.Interfaces.QueryHQLInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ss14 on 2016/7/15.
 */

@Repository
public class QueryHqlMaker implements QueryHQLInterface {

    @Autowired
    WhereMaker_Answer whereMaker_Answer;
    @Autowired
    WhereMaker_Question whereMaker_Question;
    @Autowired
    WhereMaker_Comment whereMaker_Comment;


    private String fromPart="";
    private String wherePart="";
    private String orderPart="";

    private void setFromPart(FromPara tableName){
        switch (tableName){

            case Quesstion:
                fromPart= " from Question";
                break;
            case Answer:
                fromPart =" from Answer";
                break;
            case Comment:
                fromPart = " from Comment";
                break;
        }
    }
    private void setWherePart(FromPara tableName, WherePara wherePara){
        if(wherePara == null){
            wherePart="";
            return ;
        }

        switch (tableName){

            case Quesstion:

                wherePart = whereMaker_Question.getWhereHql(wherePara);
                break;

            case Answer:

                wherePart = whereMaker_Answer.getWhereHql(wherePara);
                break;

            case Comment:

                wherePart = whereMaker_Comment.getWhereHql(wherePara);

                break;
        }

    }
    private void setOrderPart(OrderByPara orderByPara, OrderByMethod orderByMethod){
        orderPart = getOrderByPara(orderByPara)+getOrderByMethod(orderByMethod);
    }



    private String getOrderByPara(OrderByPara orderByPara){
        String orderPara=" order by ";
        switch(orderByPara){

            case createdAt:
                orderPara+="createdAt";
                break;
            case lastUpdatedAt:
                orderPara+="lastUpdatedAt";
                break;
            case viewCount:
                orderPara+="viewCount";
                break;
            case voteCount:
                orderPara+="voteCount";
                break;
            case answerCount:
                orderPara+="answerCount";
                break;
        }
        return orderPara;
    }
    private String getOrderByMethod(OrderByMethod orderByMethod){
        String orderMethod= " ";
        if(orderByMethod==OrderByMethod.ASC){
            orderMethod+="asc";
        }else{
            orderMethod+="desc";
        }
        return orderMethod;
    }



    @Override
    public String getHQLby(FromPara tableName,WherePara wherePara) {
        setFromPart(tableName);
        setWherePart(tableName,wherePara);
        return fromPart+wherePart;
    }

    @Override
    public String getHQLby(FromPara tableName, WherePara wherePara, OrderByPara orderByPara, OrderByMethod orderByMethod) {
        setFromPart(tableName);
        setWherePart(tableName,wherePara);
        setOrderPart(orderByPara,orderByMethod);
        return fromPart+wherePart +orderPart;
    }

}
