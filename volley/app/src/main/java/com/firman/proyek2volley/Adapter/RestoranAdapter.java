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
import com.firman.proyek2volley.Detail.RestoranDetail;
import com.firman.proyek2volley.Getset.Restoran;
import com.firman.proyek2volley.R;

import java.util.ArrayList;
import java.util.List;

public class RestoranAdapter extends RecyclerView.Adapter<RestoranAdapter.RestoranViewHolder> implements Filterable {

    private Context mCtx;
    private List<Restoran> restoranList;
    private List<Restoran> restoranListFiltered;

    public RestoranAdapter(Context mCtx, List<Restoran> restoranList) {
        this.mCtx = mCtx;
        this.restoranList = restoranList;
        this.restoranListFiltered = restoranList;
    }

    @Override
    public RestoranViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card, parent,false);
        return new RestoranViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RestoranViewHolder holder, int position) {
        final Restoran restoran = restoranList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(restoran.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(restoran.getNama());
        holder.tvDeskripsi.setText(restoran.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,RestoranDetail.class);
                i.putExtra("restoran_image",restoranList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("restoran_title",restoranList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("restoran_desc",restoranList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restoranList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    restoranList = restoranListFiltered;
                } else {
                    List<Restoran> filteredList = new ArrayList<>();
                    for (Restoran row : restoranListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    restoranList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = restoranList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                restoranList = (ArrayList<Restoran>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class RestoranViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi;
        ImageView imageView;

        public RestoranViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.post_title);
            tvDeskripsi = itemView.findViewById(R.id.post_desc);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}
