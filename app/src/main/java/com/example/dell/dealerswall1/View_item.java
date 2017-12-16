package com.example.dell.dealerswall1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.dealerswall1.adapters.BrowseViewAdapter;
import com.example.dell.dealerswall1.adapters.ItemViewAdapter;
import com.example.dell.dealerswall1.utility.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class View_item extends AppCompatActivity {

    RecyclerView viewItemRecycler;
    ImageView productImage;

    //declare a toolbar to replace the default toolbar
    Toolbar myviewtb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        productImage = findViewById(R.id.item_view_image);

        //initialize the toolbar
        myviewtb = findViewById(R.id.mytb);
        setSupportActionBar(myviewtb);


        //house keeping for the recycler view
        viewItemRecycler = findViewById(R.id.item_view_recycler);
        viewItemRecycler.setHasFixedSize(true);
        viewItemRecycler.setLayoutManager(new LinearLayoutManager(this, 0, false));


        //initialize the array containing links to the default images
        ArrayList<String> linksarray = new ArrayList<>();

        //fill the array with links to the four default images
        linksarray.add("https://api.backendless.com/54158ACA-8614-7763-FF72-3BFBF61B4600/167C910C-C110-5D40-FF09-C8621E23B700/files/DEFAULT+IMAGES/filler1.png");
        linksarray.add("https://api.backendless.com/54158ACA-8614-7763-FF72-3BFBF61B4600/167C910C-C110-5D40-FF09-C8621E23B700/files/DEFAULT+IMAGES/filler2.png");
        linksarray.add("https://api.backendless.com/54158ACA-8614-7763-FF72-3BFBF61B4600/167C910C-C110-5D40-FF09-C8621E23B700/files/DEFAULT+IMAGES/filler3.png");
        linksarray.add("https://api.backendless.com/54158ACA-8614-7763-FF72-3BFBF61B4600/167C910C-C110-5D40-FF09-C8621E23B700/files/DEFAULT+IMAGES/filler4.png");

        //initialize the link to the main image
       /* String imageref = (String) getIntent().getExtras().get("imageReference");

        if (imageref != null ){
        Glide.with(this).load(imageref).apply(RequestOptions.noTransformation()).into(productImage);
        }
        else {

            Glide.with(this).load(linksarray.get(0)).apply(RequestOptions.noTransformation()).into(productImage);

        }*/


        Glide.with(this).load(linksarray.get(0)).apply(RequestOptions.noTransformation()).into(productImage);

        ItemViewAdapter itemViewAdapter = new ItemViewAdapter(this,linksarray);
        viewItemRecycler.setAdapter(itemViewAdapter);

    }


    //inflate the menu layout file for the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    //specify the actions that happen when each menu item is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.refresh):
                Toast.makeText(this, "refresh selected", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.profile):
                Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
                break;


            case (R.id.account):
                Toast.makeText(this, "Account selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }


}
