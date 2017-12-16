package com.example.dell.dealerswall1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.dealerswall1.R;

/**
 * Created by DELL on 12/15/2017.
 */

public class ItemViewVh extends RecyclerView.ViewHolder {

    ImageView itemViewImage;




    public ItemViewVh(View itemView) {
        super(itemView);
        itemViewImage = itemView.findViewById(R.id.itemviewsingleimage);

    }
}
