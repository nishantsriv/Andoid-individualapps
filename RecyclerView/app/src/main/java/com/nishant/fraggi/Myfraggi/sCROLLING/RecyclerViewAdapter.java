package com.nishant.fraggi.Myfraggi.sCROLLING;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nishant.fraggi.R;

import java.util.ArrayList;

/**
 * Created by shahbaz on 10-10-2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StudentViewHolder>
{
    LayoutInflater inflater;
    ArrayList<Students> liststudents;

    public void setData(ArrayList<Students> liststudents){
        this.liststudents.addAll(liststudents);
        notifyDataSetChanged();
    }

    public RecyclerViewAdapter(Context context) {
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        liststudents=new ArrayList<>();
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view=inflater.inflate(R.layout.row_student_data,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Students students=liststudents.get(position);
        holder.textViewName.setText(students.getName());
        holder.textViewRoll.setText(students.getRoll());
        holder.textViewStandard.setText(students.getStandard());

    }

    @Override
    public int getItemCount() {
        return liststudents.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewRoll;
        TextView textViewStandard;
        public StudentViewHolder(View itemView) {
            super(itemView);

            textViewName= (TextView) itemView.findViewById(R.id.textViewName);
            textViewRoll= (TextView) itemView.findViewById(R.id.textViewRoll);
            textViewStandard= (TextView) itemView.findViewById(R.id.textViewStandard);
        }
    }
}
