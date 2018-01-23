package com.zmm.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zmm.retrofittest.model.User;
import com.zmm.retrofittest.service.ReService;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String url = "http://giousa.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_retrofit_get, R.id.btn_retrofit_get_model, R.id.btn_retrofit_post,
            R.id.btn_retrofit_post_model, R.id.btn_retrofit_post_headers,
            R.id.btn_retrofit_post_body})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_retrofit_get:
                retrofitGET();

                break;
            case R.id.btn_retrofit_get_model:
                retrofitGetModel();

                break;
            case R.id.btn_retrofit_post:
                retrofitPOST();

                break;
            case R.id.btn_retrofit_post_model:
                retrofitPostModel();

                break;

            case R.id.btn_retrofit_post_body:
                retrofitPostBody();

                break;

            case R.id.btn_retrofit_post_headers:
                retrofitPostHeaders();
                break;

        }
    }


    private void retrofitGET() {

        new Retrofit
                .Builder()
                .baseUrl(url)
                .build()
                .create(ReService.class)
                .listRespons()
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            System.out.println("response = " + response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println("failure");
                    }
                });
    }

    private void retrofitPOST() {

        new Retrofit.Builder()
                .baseUrl(url)
                .build()
                .create(ReService.class)
                .postResponse("99", "Retrofit 测试")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            System.out.println("Post response = " + response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println("Post failure");
                    }
                });


    }

    private void retrofitGetModel() {

        new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ReService.class)
                .resUser()
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        System.out.println("User = " + response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        System.out.println("--failure--");
                    }
                });


    }

    private void retrofitPostModel() {
        new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ReService.class)
                .postUser("giousa","1234")
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        System.out.println("Post user = "+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        System.out.println("post failure");
                    }
                });
    }



    //TODO 有问题
    private void retrofitPostBody() {

        User user = new User("teacher", "0909");
        new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ReService.class)
                .bodyUser(user)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        System.out.println("Post user = "+response.body().toString());

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        System.out.println("post failure");

                    }
                });
    }


    private void retrofitPostHeaders() {
        new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ReService.class)
                .headersUser("student","7878")
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        System.out.println("Post user = "+response.body().toString());

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        System.out.println("post failure");

                    }
                });
    }


}
