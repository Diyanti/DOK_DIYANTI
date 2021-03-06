package com.firman.proyek2volley.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firman.proyek2volley.Adapter.WisataAlamAdapter;
import com.firman.proyek2volley.R;
import com.firman.proyek2volley.Server;
import com.firman.proyek2volley.Getset.WisataAlam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class WisataAlamActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private String url = Server.URL + "wisata-alam.php";

    WisataAlamAdapter mAdapter;
    SearchView searchView;
    SwipeRefreshLayout swipe;
    List<WisataAlam> wisataList;
    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toasty.Config.getInstance().apply();
        //inisialisasi wisataList
        wisataList = new ArrayList<>();

        mAdapter = new WisataAlamAdapter(WisataAlamActivity.this,wisataList);
        recyclerView.setAdapter(mAdapter);
        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           ambilData();
                       }
                   }
        );

    }

    private void ambilData() {
        wisataList.clear();
        mAdapter.notifyDataSetChanged();
        swipe.setRefreshing(true);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                wisataList.add(new WisataAlam(
                                        product.getInt("id_pariwisata"),
                                        product.getString("nama"),
                                        product.getString("deskripsi"),Server.URL+"../image/wisata-alam/"+
                                        product.getString("gambar")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
//                            WisataAlamAdapter adapter = new WisataAlamAdapter(BudayaActivity.this, wisataList);
//                            recyclerView.setAdapter(adapter);
//                            sortArrayList();
                            mAdapter.notifyDataSetChanged();
                            swipe.setRefreshing(false);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toasty.error(WisataAlamActivity.this, "Gagal Mengambil Data", Toast.LENGTH_LONG,true).show();
                        swipe.setRefreshing(false);
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public void onRefresh() {
        ambilData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                mAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
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
