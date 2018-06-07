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
import com.firman.proyek2volley.Detail.KulinerDetail;
import com.firman.proyek2volley.Getset.Kuliner;
import com.firman.proyek2volley.R;

import java.util.ArrayList;
import java.util.List;

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.KulinerViewHolder> implements Filterable {

    private Context mCtx;
    private List<Kuliner> kulinerList;
    private List<Kuliner> kulinerListFiltered;

    public KulinerAdapter(Context mCtx, List<Kuliner> kulinerList) {
        this.mCtx = mCtx;
        this.kulinerList = kulinerList;
        this.kulinerListFiltered = kulinerList;
    }

    @Override
    public KulinerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card, parent,false);
        return new KulinerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final KulinerViewHolder holder, int position) {
        final Kuliner kuliner = kulinerList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(kuliner.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(kuliner.getNama());
        holder.tvDeskripsi.setText(kuliner.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,KulinerDetail.class);
                i.putExtra("kuliner_image",kulinerList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("kuliner_title",kulinerList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("kuliner_desc",kulinerList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kulinerList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    kulinerList = kulinerListFiltered;
                } else {
                    List<Kuliner> filteredList = new ArrayList<>();
                    for (Kuliner row : kulinerListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    kulinerList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = kulinerList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                kulinerList = (ArrayList<Kuliner>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class KulinerViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi;
        ImageView imageView;

        public KulinerViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.post_title);
            tvDeskripsi = itemView.findViewById(R.id.post_desc);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}