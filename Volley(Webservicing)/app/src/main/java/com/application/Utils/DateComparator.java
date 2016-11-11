package com.application.Utils;

import com.application.network.model.BaseModel;

import java.util.Comparator;


public class DateComparator implements Comparator<BaseModel> {


    @Override
    public int compare(BaseModel lhs, BaseModel rhs) {

        long date1 = DateTimeUtil.convertDatetToTimeStamp(lhs.getUpdatedAt());

        long date2 = DateTimeUtil.convertDatetToTimeStamp(rhs.getUpdatedAt());

        if (date1 > date2) {

            return 1;
        } else if (date1 < date2) {

            return -1;
        }


        return 0;
    }
}
