package com.example.ghifary.presensiapp.RecyclerView;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemRiwayat implements Parcelable {
    private int id;
    private String judul, details;

    public ItemRiwayat(JSONObject riwayat) {
        try{
            int id = object.getInt("id");
            String title = object.getString("title");
        }
    }


    public String getJudul() {
        return judul;
    }

    public String getDetails() {
        return details;
    }

    public ItemRiwayat(String details, String judul) {
        this.details = details;
        this.judul = judul;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
