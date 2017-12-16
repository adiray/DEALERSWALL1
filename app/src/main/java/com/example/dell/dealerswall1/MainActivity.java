package com.example.dell.dealerswall1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.Menu;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.dealerswall1.adapters.BrowseViewAdapter;
import com.example.dell.dealerswall1.utility.Response;
import com.example.dell.dealerswall1.utility.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    Toolbar mytb;
    RecyclerView browseRecycler;
    RecyclerView.Adapter browseRecyclerAdapter;
    ImageView mainImage;
    TextView mainImagePrice, mainImageName;
    ArrayList<Response> featuredResponseItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //initialize the main image views
        mainImage = findViewById(R.id.featured_item_image);
        mainImagePrice = findViewById(R.id.item_price);
        mainImageName = findViewById(R.id.item_name);


        //initialize the toolbar
        mytb = findViewById(R.id.mytb);
        setSupportActionBar(mytb);

        //initialize the retrofit client builder using the backendless api
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/54158ACA-8614-7763-FF72-3BFBF61B4600/167C910C-C110-5D40-FF09-C8621E23B700/data/")
                .addConverterFactory(GsonConverterFactory.create());


        //use your builder to build a retrofit object
        Retrofit myretrofit = builder.build();

        //create a retrofit client using the retrofit object
        RetrofitClient mywebclient = myretrofit.create(RetrofitClient.class);
        retrofit2.Call<ArrayList<Response>> mycall = mywebclient.getallProducts();
        retrofit2.Call<ArrayList<Response>> myFeaturedItemsCall = mywebclient.getallFeaturedProducts();

        //make the retrofit call for all the products
        mycall.enqueue(new Callback<ArrayList<Response>>() {
            @Override
            public void onResponse(Call<ArrayList<Response>> call, retrofit2.Response<ArrayList<Response>> response) {
                //receive the response
                ArrayList<Response> ResponseItems ;
                ResponseItems = response.body();


                //build out the recycler view
                browseRecycler = findViewById(R.id.browse_recycler_view);
                browseRecycler.setHasFixedSize(true);
                browseRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2, 1, false));

                browseRecyclerAdapter = new BrowseViewAdapter(ResponseItems, MainActivity.this);
                browseRecycler.setAdapter(browseRecyclerAdapter);


            }

            @Override
            public void onFailure(Call<ArrayList<Response>> call, Throwable t) {
                //deal with the errors
                Log.d("Comms failure", "onFailure: call for all the products failed");
            }
        });



        //make the call for the featured item
        myFeaturedItemsCall.enqueue(new Callback<ArrayList<Response>>() {
            @Override
            public void onResponse(Call<ArrayList<Response>> call, retrofit2.Response<ArrayList<Response>> response) {
                featuredResponseItems = response.body();
                Glide.with(MainActivity.this).load(featuredResponseItems.get(0).getPRODUCTIMAGEREFERENCE()).apply(RequestOptions.noTransformation()).into(mainImage);
                mainImagePrice.setText(featuredResponseItems.get(0).getPRODUCTPRICE());
                mainImageName.setText(featuredResponseItems.get(0).getPRODUCTNAME());
            }

            @Override
            public void onFailure(Call<ArrayList<Response>> call, Throwable t) {

            }
        });

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
