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
import com.firman.proyek2volley.Detail.TravelDetail;
import com.firman.proyek2volley.Getset.Travel;
import com.firman.proyek2volley.R;

import java.util.ArrayList;
import java.util.List;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.TravelViewHolder> implements Filterable {

    private Context mCtx;
    private List<Travel> travelList;
    private List<Travel> travelListFiltered;

    public TravelAdapter(Context mCtx, List<Travel> travelList) {
        this.mCtx = mCtx;
        this.travelList = travelList;
        this.travelListFiltered = travelList;
    }

    @Override
    public TravelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card, parent,false);
        return new TravelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TravelViewHolder holder, int position) {
        final Travel travel = travelList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(travel.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(travel.getNama());
        holder.tvDeskripsi.setText(travel.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,TravelDetail.class);
                i.putExtra("travel_image",travelList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("travel_title",travelList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("travel_desc",travelList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return travelList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    travelList = travelListFiltered;
                } else {
                    List<Travel> filteredList = new ArrayList<>();
                    for (Travel row : travelListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    travelList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = travelList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                travelList = (ArrayList<Travel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class TravelViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi;
        ImageView imageView;

        public TravelViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.post_title);
            tvDeskripsi = itemView.findViewById(R.id.post_desc);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}
