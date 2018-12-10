package com.example.ghifary.presensiapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ghifary.presensiapp.RecyclerView.ItemRiwayat;
import com.example.ghifary.presensiapp.RecyclerView.ListItemRiwayatAdapter;
import com.example.ghifary.presensiapp.RecyclerView.ItemRiwayatData;

import java.util.ArrayList;


public class Riwayat extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<ItemRiwayat>> {

    private RecyclerView rvCategory;
    ListView listView;
    EditText editJudul;
    ListItemRiwayatAdapter adapter;
    Context context;



    public Riwayat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_riwayat, container, false);
        context = container.getContext();
        adapter = new ListItemRiwayatAdapter(context);
        adapter.notifyDataSetChanged();

        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategory.setAdapter(adapter);

        getLoaderManager().initLoader(0, null, this);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Riwayat");
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        return view;


    }


    @NonNull
    @Override
    public Loader<ArrayList<ItemRiwayat>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new ;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<ItemRiwayat>> loader, ArrayList<ItemRiwayat> itemRiwayats) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<ItemRiwayat>> loader) {

    }
}
