package com.zmm.retrofittest.service;

import com.zmm.retrofittest.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/1/23
 * Time:上午11:46
 */

public interface ReService {

    @GET("info/")
    Call<ResponseBody> listRespons();

    @GET("info/")
    Call<User> resUser();

    @FormUrlEncoded
    @POST("info/")
    Call<ResponseBody> postResponse(
            @Field("id") String id,
            @Field("msg") String msg
    );

    @FormUrlEncoded
    @POST("info/")
    Call<User> postUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("info/")
    Call<User> bodyUser(@Body User user);


    @FormUrlEncoded
    @Headers({
            "Accept: hello",
            "User-Agent: Retrofit-Sample-App",
            "Cache-Control: max-age=640000"
    })
    @POST("info/")
    Call<User> headersUser(
            @Field("username") String username,
            @Field("password") String password
    );

}
