package com.application.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

    private static final String TAG = DateTimeUtil.class.getSimpleName();


    public static long convertDatetToTimeStamp(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'", Locale.ENGLISH);
        Date convertedDate;
        try {
            convertedDate = sdf.parse(dateString);

            return convertedDate.getTime();

        } catch (ParseException e) {

            Log.e(TAG, e.getMessage());

        }

        return 0;
    }
}
