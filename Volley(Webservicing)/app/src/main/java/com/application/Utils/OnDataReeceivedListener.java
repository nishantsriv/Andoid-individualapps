package com.application.Utils;

import com.android.volley.VolleyError;

import java.util.List;

public interface
OnDataReeceivedListener<T> {

    void onDataReceived(List<T> object);

    void onError(VolleyError volleyError);
}
