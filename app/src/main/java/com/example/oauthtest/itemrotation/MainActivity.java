package com.example.oauthtest.itemrotation;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            fortniteshop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fortniteshopf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //changes the fragment of contentframe
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }
    private final OkHttpClient client = new OkHttpClient();
    //okhttp get request with all img urls from api
    public void fortniteshop() throws Exception {
        Log.i("json","start");
        Request request = new Request.Builder()
                .url("https://fnbr.co/api/shop").removeHeader("tags").addHeader("x-api-key","apikeyhere")
                .build();
        Log.i("urlf",""+request.toString());
        Log.i("headerf",""+request.headers());

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.i("INTENTINTENTINTENTINTE","fail");
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                Log.i("json","start1");
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                    Log.i("json","start2");
                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }
                    String in = response.body().string();
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"+in);


                    try {


                        JSONObject jObj1 = new JSONObject(in);
                        String temp = jObj1.getJSONObject("data").getString("daily");
                        JSONArray jarray = new JSONArray(temp);
                        temp=jarray.getString(1);
                        jObj1= new JSONObject(temp);
                        temp = jObj1.getString("images");
                        jObj1 = new JSONObject(temp);
                        temp = jObj1.getString("gallery");
                        System.out.println("forttest"+temp);
                        int secondloopparam= 0;

                        for (int i = 0; i < 5; i++) {


                            try {
                                temp=jarray.getString(secondloopparam);
                                jObj1= new JSONObject(temp);
                                temp = jObj1.getString("images");
                                jObj1 = new JSONObject(temp);
                                if(jObj1.getString("gallery")=="false"){
                                    temp = jObj1.getString("icon");
                                }
                                else {
                                    temp = jObj1.getString("gallery");
                                }


                                //String videoId = jObj6.getString("videoId");
                                SharedPreferences mPrefs = getSharedPreferences("fortnite", 0);
                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                String loopintt = String.valueOf(secondloopparam);

                                mEditor.putString("shoppic"+loopintt,temp);

                                mEditor.apply();
                                mEditor.commit();
                                Log.i("loopjson1","video"+temp);
                                secondloopparam=secondloopparam+1;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }








                        }






                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
    }
    public void fortniteshopf() throws Exception {
        Log.i("json","start");
        Request request = new Request.Builder()
                .url("https://fnbr.co/api/shop").removeHeader("tags").addHeader("x-api-key","apikeyhere")
                .build();
        Log.i("urlf",""+request.toString());
        Log.i("headerf",""+request.headers());

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.i("INTENTINTENTINTENTINTE","fail");
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                Log.i("json","start1");
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                    Log.i("json","start2");
                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }
                    String in = response.body().string();
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"+in);


                    try {


                        JSONObject jObj1 = new JSONObject(in);
                        String temp = jObj1.getJSONObject("data").getString("featured");
                        JSONArray jarray = new JSONArray(temp);
                        temp=jarray.getString(1);
                        jObj1= new JSONObject(temp);
                        temp = jObj1.getString("images");
                        jObj1 = new JSONObject(temp);
                        temp = jObj1.getString("gallery");
                        System.out.println("forttest"+temp);
                        int secondloopparam= 0;

                        for (int i = 0; i < 5; i++) {


                            try {
                                temp=jarray.getString(secondloopparam);
                                jObj1= new JSONObject(temp);
                                temp = jObj1.getString("images");
                                jObj1 = new JSONObject(temp);
                                if(jObj1.getString("gallery")=="false"){
                                    temp = jObj1.getString("icon");
                                }
                                else {
                                    temp = jObj1.getString("gallery");
                                }


                                //String videoId = jObj6.getString("videoId");
                                SharedPreferences mPrefs = getSharedPreferences("fortnite", 0);
                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                String loopintt = String.valueOf(secondloopparam+4);

                                mEditor.putString("shoppic"+loopintt,temp);

                                mEditor.apply();
                                mEditor.commit();
                                Log.i("loopjson1","video"+temp);
                                secondloopparam=secondloopparam+1;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }








                        }






                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
    }
}
