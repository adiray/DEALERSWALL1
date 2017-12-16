package com.example.dell.dealerswall1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.dealerswall1.R;

import java.util.ArrayList;

/**
 * Created by DELL on 12/15/2017.
 */

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewVh> {


    public ItemViewAdapter(Context viewItemContext, ArrayList<String> rawLinks) {
        this.ViewItemContext = viewItemContext;
        this.rawLinks = rawLinks;
    }

    Context ViewItemContext;
    ArrayList<String> rawLinks = new ArrayList<>();


    @Override
    public ItemViewVh onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemviewsingleitem, parent, false);
        return new ItemViewVh(v);
    }

    @Override
    public void onBindViewHolder(ItemViewVh holder, int position) {

        Glide.with(ViewItemContext).load(rawLinks.get(position)).apply(RequestOptions.noTransformation()).into(holder.itemViewImage);


    }

    @Override
    public int getItemCount() {
        return rawLinks.size();
    }
}
