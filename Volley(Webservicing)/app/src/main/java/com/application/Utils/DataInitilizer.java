package com.application.Utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.application.Application;
import com.application.network.GsonRequest;
import com.twittercrashlytics.R;
import com.application.network.model.Comment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DataInitilizer implements Response.Listener<Comment[]>, Response.ErrorListener {


    private final static String TAG = DataInitilizer.class.getSimpleName();


    private Context context;

    private OnDataReeceivedListener onDataReeceivedListener;


    public DataInitilizer(Context context) {

        this.context = context;
    }

    public void setOnDataReeceivedListener(OnDataReeceivedListener onDataReeceivedListener) {
        this.onDataReeceivedListener = onDataReeceivedListener;
    }


    public void getCommentsList(String commentsUrl) {

        if (AppUtil.isNetworkAvailable(context)) {
            GsonRequest<Comment[]> myReq = new GsonRequest<Comment[]>(commentsUrl,
                    Comment[].class,
                    null,
                    this,
                    this);

            Application.getInstance().addToRequestQueue(myReq, TAG);
        } else {

            Toast.makeText(context, context.getString(R.string.no_network), Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public void onResponse(Comment[] response) {

        List<Comment> listIssues = Arrays.asList(response);

        Collections.sort(listIssues, new DateComparator());

        onDataReeceivedListener.onDataReceived(listIssues);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

        onDataReeceivedListener.onError(error);

    }
}
