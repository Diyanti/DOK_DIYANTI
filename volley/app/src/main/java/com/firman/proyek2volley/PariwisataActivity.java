package com.firman.proyek2volley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

import com.firman.proyek2volley.Activity.HotelActivity;
import com.firman.proyek2volley.Activity.KulinerActivity;
import com.firman.proyek2volley.Activity.RestoranActivity;
import com.firman.proyek2volley.Activity.TravelActivity;
import com.firman.proyek2volley.Activity.WisataAlamActivity;
import com.firman.proyek2volley.Activity.WisataBuatanActivity;

public class PariwisataActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView wisataAlam = (CardView) findViewById(R.id.menuWisataAlam);
        CardView wisataBuatan = (CardView) findViewById(R.id.menuWisataBuatan);
        CardView travel = (CardView) findViewById(R.id.menuTravel);
        CardView kuliner = (CardView) findViewById(R.id.menuKuliner);
        CardView hotel = (CardView) findViewById(R.id.menuHotel);
        CardView restoran = (CardView) findViewById(R.id.menuResto);

        wisataAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PariwisataActivity.this,WisataAlamActivity.class));
            }
        });

        wisataBuatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PariwisataActivity.this,WisataBuatanActivity.class));
            }
        });
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PariwisataActivity.this,TravelActivity.class));
            }
        });
        kuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PariwisataActivity.this,KulinerActivity.class));
            }
        });
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PariwisataActivity.this,HotelActivity.class));
            }
        });
        restoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PariwisataActivity.this,RestoranActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
