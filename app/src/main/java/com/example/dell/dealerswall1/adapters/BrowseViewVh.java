package com.example.dell.dealerswall1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.dealerswall1.R;

/**
 * Created by DELL on 12/15/2017.
 */

public class BrowseViewVh extends RecyclerView.ViewHolder {


    TextView vh_price, vh_name;
    ImageView vh_image;



    public BrowseViewVh(View itemView) {
        super(itemView);
        vh_image = itemView.findViewById(R.id.single_item_image);
        vh_name= itemView.findViewById(R.id.single_item_name);
        vh_price = itemView.findViewById(R.id.single_item_price);


    }


}
