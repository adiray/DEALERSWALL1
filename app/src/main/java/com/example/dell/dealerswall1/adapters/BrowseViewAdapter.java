package com.example.dell.dealerswall1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.dealerswall1.R;
import com.example.dell.dealerswall1.View_item;
import com.example.dell.dealerswall1.utility.Response;

import java.util.ArrayList;

/**
 * Created by DELL on 12/15/2017.
 */

public class BrowseViewAdapter extends RecyclerView.Adapter<BrowseViewVh> {

    public BrowseViewAdapter(ArrayList<Response> dataSource, Context context) {
        this.dataSource = dataSource;
        this.context = context;
    }

    ArrayList<Response> dataSource;
    Context context;


    @Override
    public BrowseViewVh onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_recycler_element, parent, false);
        return new BrowseViewVh(v);


    }

    @Override
    public void onBindViewHolder(BrowseViewVh holder,int position) {


        holder.vh_price.setText(dataSource.get(position).getPRODUCTPRICE());
        holder.vh_name.setText(dataSource.get(position).getPRODUCTNAME());
        Glide.with(context).load(dataSource.get(position).getPRODUCTIMAGEREFERENCE()).apply(RequestOptions.noTransformation()).into(holder.vh_image);
       // final String data = dataSource.get(position).getPRODUCTIMAGEREFERENCE();
        //add the click listener to the image view

        holder.vh_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,View_item.class);
               // intent.putExtra("imageReference", data);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
