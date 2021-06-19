package com.example.dbimport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NumCountAdapt extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<NumCountTable> nc;
    public NumCountAdapt(Context context, ArrayList<NumCountTable> data) {
        mContext = context;
        nc = data;
        mLayoutInflater = LayoutInflater.from(mContext);

    }
    @Override
    public int getCount() {
        return nc.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public NumCountTable getItem(int position) {
        return nc.get(position);
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.activity_list_view_numcount, null);

        //TextView num = (TextView)view.findViewById(R.id.movieName);
        //TextView numcount = (TextView)view.findViewById(R.id.grade);

        //num.setText(nc.);
        //numcount.setText(nc.get(position).getGrade());

        return view;
    }

}
