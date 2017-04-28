package com.solutionsguyana.munchies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by cybersolutions on 4/24/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private List<MyData> my_data;


    public CustomAdapter(Context context, List<MyData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);



        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.description.setText(my_data.get(position).getDescription());
        Glide.with(context).load(my_data.get(position).getImage_link()).into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, " " + my_data.get(position).getDescription(), Toast.LENGTH_LONG).show();
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Toast.makeText(context, "You touched " + my_data.get(position).getImage_link(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView description;
        public ImageView imageView;
        public RelativeLayout cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            cardView = (RelativeLayout) itemView.findViewById(R.id.cardView);
        }
    }
}