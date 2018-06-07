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
import com.firman.proyek2volley.Detail.WisataAlamDetail;
import com.firman.proyek2volley.R;
import com.firman.proyek2volley.Getset.WisataAlam;

import java.util.ArrayList;
import java.util.List;

public class WisataAlamAdapter extends RecyclerView.Adapter<WisataAlamAdapter.WisataAlamViewHolder> implements Filterable {
    private Context mCtx;
    private List<WisataAlam> wisataList;
    private List<WisataAlam> wisataListFiltered;

    public WisataAlamAdapter(Context mCtx, List<WisataAlam> wisataList) {
        this.mCtx = mCtx;
        this.wisataList = wisataList;
        this.wisataListFiltered = wisataList;
    }

    @Override
    public WisataAlamAdapter.WisataAlamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card, parent,false);
        return new WisataAlamAdapter.WisataAlamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final WisataAlamAdapter.WisataAlamViewHolder holder, int position) {
        final WisataAlam wisata = wisataList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(wisata.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(wisata.getNama());
        holder.tvDeskripsi.setText(wisata.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,WisataAlamDetail.class);
                i.putExtra("wisata_image", wisataList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("wisata_title", wisataList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("wisata_desc", wisataList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wisataList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    wisataList = wisataListFiltered;
                } else {
                    List<WisataAlam> filteredList = new ArrayList<>();
                    for (WisataAlam row : wisataListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    wisataList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = wisataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                wisataList = (ArrayList<WisataAlam>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class WisataAlamViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi;
        ImageView imageView;

        public WisataAlamViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.post_title);
            tvDeskripsi = itemView.findViewById(R.id.post_desc);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}
