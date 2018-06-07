package com.firman.proyek2volley;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firman.proyek2volley.Activity.BudayaActivity;
import com.firman.proyek2volley.Activity.KegiatanActivity;
import com.firman.proyek2volley.Profile.ProfileActivity;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_USERNAME = "username";
    public final static String TAG_ID = "id";
    public static final String my_shared_preferences = "my_shared_preferences";
    SharedPreferences sharedpreferences;
    String id,username;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

        Toasty.Config.getInstance().apply();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(),R.color.white,getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu_main
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state
                        menuItem.setChecked(true);

                        int idItem = menuItem.getItemId();
                        switch (idItem){
                            case R.id.logout:
                                alertDialog();
                                break;
                            case R.id.profilSaya:
                                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                                intent.putExtra(TAG_ID,id);
                                startActivity(intent);
                                break;
                        }

                        // TODO: handle navigation

                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });

        CardView budaya = (CardView) findViewById(R.id.menuTravel);
        CardView pariwisata = (CardView) findViewById(R.id.MenuPariwisata);
        CardView kegiatan = (CardView) findViewById(R.id.MenuKegiatan);
        CardView pengaduan = (CardView) findViewById(R.id.MenuPengaduan);
        CardView disbudpar = (CardView) findViewById(R.id.MenuDisbudpar);
        CardView aplikasi = (CardView) findViewById(R.id.MenuAplikasi);

        budaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BudayaActivity.class));
            }
        });

        pariwisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PariwisataActivity.class));
            }
        });

        kegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,KegiatanActivity.class));
            }
        });

        pengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PengaduanActivity.class);
                intent.putExtra(TAG_ID,id);
                startActivity(intent);
            }
        });

        disbudpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TentangDisbudpar.class));
            }
        });

        aplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TentangKami.class));
            }
        });
    }

    private void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Anda yakin ingin logout?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        logout();
                    }
                })
                .setNegativeButton("Tidak",null);
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void logout(){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(LoginActivity.session_status, false);
        editor.putString(TAG_USERNAME, null);
        editor.apply();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        finish();
        Toasty.success(this,"Berhasil Logout",Toast.LENGTH_SHORT,true).show();
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
