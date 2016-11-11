package com.nishant.fraggi.Myfraggi.sCROLLING;

import java.util.ArrayList;

/**
 * Created by shahbaz on 05-10-2016.
 */
public class DataHelper {
    public static ArrayList<Students> getstudentsdata()
    {
        ArrayList<Students> liststudents =new ArrayList<>();
        liststudents.add(new Students("Name1","Roll1","Standard1"));
        liststudents.add(new Students("Name2","Roll2","Standard2"));
        liststudents.add(new Students("Name3","Roll3","Standard3"));
        liststudents.add(new Students("Name4","Roll4","Standard4"));
        liststudents.add(new Students("Name5","Roll5","Standard5"));
        liststudents.add(new Students("Name6","Roll6","Standard6"));
        liststudents.add(new Students("Name7","Roll7","Standard7"));
        liststudents.add(new Students("Name8","Roll8","Standard8"));
        liststudents.add(new Students("Name9","Roll9","Standard9"));
        liststudents.add(new Students("Name10","Roll10","Standard10"));
        liststudents.add(new Students("Name11","Roll11","Standard11"));
        liststudents.add(new Students("Name12","Roll12","Standard12"));
        liststudents.add(new Students("Name13","Roll13","Standard13"));
        liststudents.add(new Students("Name14","Roll14","Standard14"));
        liststudents.add(new Students("Name15","Roll15","Standard15"));

        return liststudents;
    }
}
