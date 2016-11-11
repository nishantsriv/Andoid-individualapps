package com.nishant.parclable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shahbaz on 01-11-2016.
 */
public class KidsInfo implements Parcelable{
    public String name;
    public String standard;

    public KidsInfo() {

    }

    protected KidsInfo(Parcel in) {
        name = in.readString();
        standard = in.readString();
    }

    public static final Creator<KidsInfo> CREATOR = new Creator<KidsInfo>() {
        @Override
        public KidsInfo createFromParcel(Parcel in) {
            return new KidsInfo(in);
        }

        @Override
        public KidsInfo[] newArray(int size) {
            return new KidsInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(standard);
    }
}
