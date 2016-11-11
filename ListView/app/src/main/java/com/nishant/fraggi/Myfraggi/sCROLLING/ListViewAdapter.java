package com.nishant.fraggi.Myfraggi.sCROLLING;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nishant.fraggi.R;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {

    ArrayList<Students> listStudents=new ArrayList<>();
    LayoutInflater inflater;

    public ListViewAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setdata(ArrayList<Students> listStudents)
    {
        this.listStudents.clear();
        this.listStudents.addAll(listStudents);
    }
    @Override
    public int getCount() {
        return listStudents.size();
    }

    @Override
    public Students  getItem(int position) {
        return listStudents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;
        if (null==convertView){
        holder=new Viewholder();
            convertView=inflater.inflate(R.layout.row_student_data,parent,false);
            holder.textViewName= (TextView) convertView.findViewById(R.id.textViewName);
            holder.textViewRoll= (TextView) convertView.findViewById(R.id.textViewRoll);
            holder.textViewStandard= (TextView) convertView.findViewById(R.id.textViewStandard);
        convertView.setTag(holder);
        }
        else {
            holder= (Viewholder) convertView.getTag();
        }
        Students students=getItem(position);
        holder.textViewName.setText(students.getName());
        holder.textViewRoll.setText(students.getRoll());
        holder.textViewStandard.setText(students.getStandard());
        return convertView;
    }
 public class Viewholder{
     TextView textViewName;
     TextView textViewRoll;
     TextView textViewStandard;
 }

}
