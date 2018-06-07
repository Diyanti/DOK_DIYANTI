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
import com.firman.proyek2volley.Detail.HotelDetail;
import com.firman.proyek2volley.Getset.Hotel;
import com.firman.proyek2volley.R;

import java.util.ArrayList;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> implements Filterable {

    private Context mCtx;
    private List<Hotel> hotelList;
    private List<Hotel> hotelListFiltered;

    public HotelAdapter(Context mCtx, List<Hotel> hotelList) {
        this.mCtx = mCtx;
        this.hotelList = hotelList;
        this.hotelListFiltered = hotelList;
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card, parent,false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HotelViewHolder holder, int position) {
        final Hotel hotel = hotelList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(hotel.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(hotel.getNama());
        holder.tvDeskripsi.setText(hotel.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,HotelDetail.class);
                i.putExtra("hotel_image",hotelList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("hotel_title",hotelList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("hotel_desc",hotelList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    hotelList = hotelListFiltered;
                } else {
                    List<Hotel> filteredList = new ArrayList<>();
                    for (Hotel row : hotelListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    hotelList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = hotelList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                hotelList = (ArrayList<Hotel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi;
        ImageView imageView;

        public HotelViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.post_title);
            tvDeskripsi = itemView.findViewById(R.id.post_desc);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}
