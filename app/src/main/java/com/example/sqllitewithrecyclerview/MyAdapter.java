package com.example.sqllitewithrecyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myclass>
{

    Context context;
    ArrayList<GetterSetter> al;

    public MyAdapter(Context context,ArrayList<GetterSetter> al){
        this.context= context;
        this.al= al;
    }

    @NonNull
    @Override
    public Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate((R.layout.rowfile),parent,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myclass holder, int position)
    {
        GetterSetter gl=al.get(position);
        holder.tv_name.setText(gl.getName());
        holder.tv_number.setText(gl.getNumber());

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class Myclass extends RecyclerView.ViewHolder
    {

        TextView tv_name,tv_number;

        public Myclass(View itemView)
        {
            super(itemView);

            tv_name=itemView.findViewById(R.id.tv_name);
            tv_number=itemView.findViewById(R.id.tv_number);

        }
    }
}

