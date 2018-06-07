package com.firman.proyek2volley.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firman.proyek2volley.Getset.Budaya;
import com.firman.proyek2volley.Detail.BudayaDetail;
import com.firman.proyek2volley.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Firmanvsly on 25/03/2018.
 */

public class BudayaAdapter extends RecyclerView.Adapter<BudayaAdapter.BudayaViewHolder> implements Filterable {

    private Context mCtx;
    private List<Budaya> budayaList;
    private List<Budaya> budayaListFiltered;

    public BudayaAdapter(Context mCtx, List<Budaya> budayaList) {
        this.mCtx = mCtx;
        this.budayaList = budayaList;
        this.budayaListFiltered = budayaList;
    }

    @Override
    public BudayaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card, parent,false);
        return new BudayaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BudayaViewHolder holder, int position) {
        final Budaya budaya = budayaList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(budaya.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(budaya.getNama());
        holder.tvDeskripsi.setText(budaya.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,BudayaDetail.class);
                i.putExtra("budaya_image",budayaList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("budaya_title",budayaList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("budaya_desc",budayaList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return budayaList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    budayaList = budayaListFiltered;
                } else {
                    List<Budaya> filteredList = new ArrayList<>();
                    for (Budaya row : budayaListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    budayaList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = budayaList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                budayaList = (ArrayList<Budaya>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class BudayaViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi;
        ImageView imageView;

        public BudayaViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.post_title);
            tvDeskripsi = itemView.findViewById(R.id.post_desc);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}
