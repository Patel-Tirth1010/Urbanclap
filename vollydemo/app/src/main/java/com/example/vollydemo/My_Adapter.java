package com.example.vollydemo;

//import android.annotation.SuppressLint;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.widget.TextClock;
import android.widget.TextView;

//import java.util.ArrayList;
import java.util.List;

public class My_Adapter extends ArrayAdapter<Retrieve> {

    Context context;
    List<Retrieve> emparraylist;
    public My_Adapter(@NonNull Context context,List<Retrieve> emparraylist) {
        super(context,R.layout.custom_layout,emparraylist);
        this.context=context;
        this.emparraylist=emparraylist;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,null,true);

        TextView empname = view.findViewById(R.id.emp_name);
        TextView id = view.findViewById(R.id.id);

        empname.setText(emparraylist.get(position).getFname());
        id.setText(emparraylist.get(position).getId());
        return view;
    }
}
