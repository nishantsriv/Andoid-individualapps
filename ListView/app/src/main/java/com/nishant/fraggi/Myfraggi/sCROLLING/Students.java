package com.nishant.fraggi.Myfraggi.sCROLLING;

/**
 * Created by shahbaz on 05-10-2016.
 */
public class Students {
    private String name;
    private String roll;
    private String standard;

    public Students() {
    }

    public Students(String name, String roll, String standard) {

        this.name = name;
        this.roll = roll;
        this.standard = standard;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

}
