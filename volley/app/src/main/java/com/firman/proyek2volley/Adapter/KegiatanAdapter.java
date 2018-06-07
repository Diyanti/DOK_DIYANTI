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
import com.firman.proyek2volley.Detail.KegiatanDetail;
import com.firman.proyek2volley.Getset.Kegiatan;
import com.firman.proyek2volley.R;

import java.util.ArrayList;
import java.util.List;

public class KegiatanAdapter extends RecyclerView.Adapter<KegiatanAdapter.KegiatanViewHolder> implements Filterable {

    private Context mCtx;
    private List<Kegiatan> kegiatanList;
    private List<Kegiatan> kegiatanListFiltered;

    public KegiatanAdapter(Context mCtx, List<Kegiatan> kegiatanList) {
        this.mCtx = mCtx;
        this.kegiatanList = kegiatanList;
        this.kegiatanListFiltered = kegiatanList;
    }

    @Override
    public KegiatanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_kegiatan, parent,false);
        return new KegiatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final KegiatanViewHolder holder, int position) {
        final Kegiatan kegiatan = kegiatanList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(kegiatan.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(kegiatan.getNama());
        holder.tvDate.setText(kegiatan.getTanggal());
        holder.tvDeskripsi.setText(kegiatan.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,KegiatanDetail.class);
                i.putExtra("kegiatan_image",kegiatanList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("kegiatan_title",kegiatanList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("kegiatan_tanggal",kegiatanList.get(holder.getAdapterPosition()).getTanggal());
                i.putExtra("kegiatan_tempat",kegiatanList.get(holder.getAdapterPosition()).getTempat());
                i.putExtra("kegiatan_desc",kegiatanList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kegiatanList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    kegiatanList = kegiatanListFiltered;
                } else {
                    List<Kegiatan> filteredList = new ArrayList<>();
                    for (Kegiatan row : kegiatanListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    kegiatanList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = kegiatanList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                kegiatanList = (ArrayList<Kegiatan>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class KegiatanViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi, tvDate;
        ImageView imageView;

        public KegiatanViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.post_title);
            tvDeskripsi = itemView.findViewById(R.id.post_desc);
            tvDate = itemView.findViewById(R.id.post_date);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}
