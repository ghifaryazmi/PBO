package com.example.ghifary.presensiapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.PermissionChecker;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;
import static android.support.v4.content.PermissionChecker.checkSelfPermission;


public class Absensi extends Fragment {
    private static final int requestcode =1;
    private ImageView imageView;
    private Button buttonCamera;
    public Absensi() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_absensi, container, false);
        imageView = (ImageView) view.findViewById(R.id.image_photo);
        Button capturedImageButton = (Button) view.findViewById(R.id.button_camera);
        capturedImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCapturedIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCapturedIntent, requestcode);
            }
        });
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Absensi");
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        return view;
    }

    public void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);
        if (this.requestcode==requestcode && resultcode == RESULT_OK){
            Bitmap bitmap =(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }


}

