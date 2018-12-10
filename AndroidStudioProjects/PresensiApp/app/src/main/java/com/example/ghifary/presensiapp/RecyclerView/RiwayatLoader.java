package com.example.ghifary.presensiapp.RecyclerView;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.ghifary.presensiapp.BuildConfig;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class RiwayatLoader extends AsyncTaskLoader<ArrayList<ItemRiwayat>> {
    private ArrayList<ItemRiwayat> mData;
    private boolean mHasResult = false;
    private String judul;
    public RiwayatLoader(final Context context, String judul) {
        super(context);
        onContentChanged();
        this.judul = judul;
    }

    @Override
    protected void onStartLoading(){
        if (takeContentChanged())
            forceLoad();
        else if (mHasResult)
            deliverResult(mData);
    }

    @Override
    public void deliverResult(final ArrayList<ItemRiwayat> data){
        mData = data;
        mHasResult = true;
        super.deliverResult(data);
    }

    @Override
    public void onReset(){
        super.onReset();
        onStopLoading();
        if (mHasResult){
            onReleaseResources(mData);
            mData=null;
            mHasResult=false;
        }
    }

    String API_KEY = BuildConfig.ApiKey;
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=";

    private void onReleaseResources(ArrayList<ItemRiwayat> mData) {
    }

    @Override
    public ArrayList<ItemRiwayat> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();
        final ArrayList<ItemRiwayat> itemRiwayats = new ArrayList<>();
        String url = BASE_URL + API_KEY + "&language=en-US";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseOnject = new JSONObject(result);
                    JSONArray list = responseOnject.getJSONArray("results");
                    for (int i=0; i<list.length(); i++){
                        JSONObject riwayat = list.getJSONObject(i);
                        ItemRiwayat itemRiwayat = new ItemRiwayat(riwayat);
                        itemRiwayats.add(itemRiwayat);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return itemRiwayats;
    }
}
