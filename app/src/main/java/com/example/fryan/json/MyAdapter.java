package com.example.fryan.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


    private List<ListItem> listItems;
    private Context context;


    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         View v = LayoutInflater.from(parent.getContext())
         .inflate(R.layout.list_items, parent,false);



        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

     ListItem listItem = listItems.get(position);
     holder.textViewHead.setText(listItem.getHead());
     holder.textViewDesc.setText(listItem.getDesc());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        public TextView textViewHead, textViewDesc;




        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead  = (TextView) itemView.findViewById(R.id.Tv_Head_id);
            textViewDesc  = (TextView) itemView.findViewById(R.id.Tv_Desc);

        }
    }
}
