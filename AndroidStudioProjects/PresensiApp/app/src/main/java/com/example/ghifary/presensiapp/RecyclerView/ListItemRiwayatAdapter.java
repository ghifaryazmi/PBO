package com.example.ghifary.presensiapp.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ghifary.presensiapp.R;

import java.util.ArrayList;

public class ListItemRiwayatAdapter extends RecyclerView.Adapter<ListItemRiwayatAdapter.CategoryViewHolder> {
    private Context context;

    public static final String KEY_NAME = "judul";
    public static final String KEY_URL = "details";

    public ListItemRiwayatAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<ItemRiwayat> getListriwayat() {
        return listriwayat;
    }

    public void setListriwayat(ArrayList<ItemRiwayat> listriwayat) {
        this.listriwayat = listriwayat;
    }

    private ArrayList<ItemRiwayat> listriwayat;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);

        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        final ItemRiwayat listRiwayat = listriwayat.get(position);
        categoryViewHolder.tvJudul.setText(listRiwayat.getJudul());
        categoryViewHolder.tvDetails.setText(getListriwayat().get(position).getDetails());


    }

    @Override
    public int getItemCount() {
        return getListriwayat().size();
    }

     class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul;
        TextView tvDetails;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvDetails= itemView.findViewById(R.id.tv_details);
        }
    }
}
