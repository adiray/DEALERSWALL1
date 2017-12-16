package com.example.dell.dealerswall1.utility;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL on 12/15/2017.
 */

public interface RetrofitClient {


    @GET("PRODUCTS")
    Call<ArrayList<Response>> getallProducts();


    @GET("PRODUCTS?where=FEATURED%3Dtrue")
    Call<ArrayList<Response>> getallFeaturedProducts();


}
