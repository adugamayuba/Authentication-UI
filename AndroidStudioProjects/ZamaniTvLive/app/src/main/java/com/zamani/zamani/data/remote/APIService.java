package com.zamani.zamani.data.remote;

import com.zamani.zamani.data.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by adugam on 9/25/18.
 */

public interface APIService {


    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("emailAddress") String email,
                        @Field("password") String password,
                        @Field("fullName") String name);


    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(
            @Field("emailAddress") String email,
            @Field("password") String password);
}
