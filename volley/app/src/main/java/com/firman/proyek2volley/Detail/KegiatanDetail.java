package com.firman.proyek2volley.Detail;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firman.proyek2volley.R;

public class KegiatanDetail extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatan_detail);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String strImage = getIntent().getExtras().getString("kegiatan_image");
        String strTitle = getIntent().getExtras().getString("kegiatan_title");
        String strTanggal = getIntent().getExtras().getString("kegiatan_tanggal");
        String strTempat = getIntent().getExtras().getString("kegiatan_tempat");
        String strDesc = getIntent().getExtras().getString("kegiatan_desc");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

        ImageView image = (ImageView) findViewById(R.id.detail_image);
        TextView title = (TextView) findViewById(R.id.detail_title);
        TextView desc = (TextView) findViewById(R.id.detail_desc);
        TextView loc = (TextView) findViewById(R.id.detail_loc);

        title.setText(strTitle);
        loc.setText(strTempat+", "+strTanggal);
        desc.setText(strDesc);

        collapsingToolbarLayout.setTitle(strTitle);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(strImage).apply(requestOptions).into(image);
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
