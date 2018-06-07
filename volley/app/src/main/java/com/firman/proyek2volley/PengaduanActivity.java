package com.firman.proyek2volley;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.firman.proyek2volley.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class PengaduanActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private Button upload,pilih;
    private EditText nama, deskripsi;
    private ImageView imageView;
    private RadioGroup rgJenis, rgPilih;
    private TextView tvPilih;
    private RadioButton rbBudaya, rbPariwisata, rbKegiatan, rbWisataAlam, rbWisataBuatan,
    rbTravel,rbKuliner,rbHotel,rbRestoran;
    private final int IMG_REQUEST = 1;
    private Bitmap bitmap;
    private final String url = Server.URL + "pengaduan.php";
    private final String urlNama = Server.URL + "pengaduan-nama.php";
    private String jenis = "";
    private int success;
    private String id,strNama;
    public final static String TAG_ID = "id";
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        upload = (Button) findViewById(R.id.btnUpload);
        pilih = (Button) findViewById(R.id.btnPilih);
        nama = (EditText) findViewById(R.id.etName);
        deskripsi = (EditText) findViewById(R.id.etDesc);
        imageView = (ImageView) findViewById(R.id.imageView);
        tvPilih = (TextView) findViewById(R.id.tvPilih);
        rgJenis = (RadioGroup) findViewById(R.id.rgJenis);
        rgPilih = (RadioGroup) findViewById(R.id.rgPilih);
        rbBudaya = (RadioButton) findViewById(R.id.rbBudaya);
        rbPariwisata = (RadioButton) findViewById(R.id.rbPariwisata);
        rbKegiatan = (RadioButton) findViewById(R.id.rbKegiatan);
        rbWisataAlam = (RadioButton) findViewById(R.id.rbWisataAlam);
        rbWisataBuatan = (RadioButton) findViewById(R.id.rbWisataBuatan);
        rbTravel = (RadioButton) findViewById(R.id.rbTravel);
        rbKuliner = (RadioButton) findViewById(R.id.rbKuliner);
        rbHotel = (RadioButton) findViewById(R.id.rbHotel);
        rbRestoran = (RadioButton) findViewById(R.id.rbRestoran);

        id = getIntent().getStringExtra(TAG_ID);

//        getName();

        Toasty.Config.getInstance().apply();

        rgJenis.setOnCheckedChangeListener(this);
        rgPilih.setOnCheckedChangeListener(this);

        upload.setOnClickListener(this);
        pilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPilih:
                pilihImage();
                break;

            case R.id.btnUpload:
                uploadImage();
                break;

        }
    }

    private void pilihImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!=null){
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private void getName(){
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlNama, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    strNama = jsonObject.getString("name");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//
//            @Override
//            protected Map<String, String> getParams() {
//                // Posting parameters to login url
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("id_user", id);
//
//                return params;
//            }
//
//        };
//        AppController.getInstance().addToRequestQueue(stringRequest);
//    }

    private void uploadImage(){
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Tunggu...");
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hideDialog();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    success = jsonObject.getInt("success");
                    if (success==1) {
                        //String Response = jsonObject.getString("response");
                        Toasty.success(PengaduanActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT,true).show();
                        //bitmap = null;
                        imageView.setImageResource(0);
                        imageView.setVisibility(View.GONE);
                        nama.setText("");
                        deskripsi.setText("");
                    }else{
                        Toasty.error(PengaduanActivity.this,jsonObject.getString("message"),Toast.LENGTH_SHORT,true).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toasty.error(PengaduanActivity.this,"Gagal Mengirim Data",Toast.LENGTH_LONG,true).show();
                hideDialog();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("jenis",jenis);
                params.put("nama", nama.getText().toString().trim());
                params.put("deskripsi",deskripsi.getText().toString().trim());
                params.put("gambar", nama.getText().toString().trim()+".jpg");
                params.put("image",imgToString(bitmap));

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    private String imgToString(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes, Base64.DEFAULT);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbBudaya){
            tvPilih.setVisibility(View.GONE);
            rgPilih.setVisibility(View.GONE);
            jenis = "Budaya";
        }
        if (checkedId == R.id.rbPariwisata){
            tvPilih.setVisibility(View.VISIBLE);
            rgPilih.setVisibility(View.VISIBLE);
        }
        if (checkedId == R.id.rbKegiatan){
            tvPilih.setVisibility(View.GONE);
            rgPilih.setVisibility(View.GONE);
            jenis = "Kegiatan";
        }
        if (checkedId == R.id.rbWisataAlam){
            jenis = "Wisata Alam";
        }
        if (checkedId == R.id.rbWisataBuatan){
            jenis = "Wisata Buatan";
        }
        if (checkedId == R.id.rbTravel){
            jenis = "Travel";
        }
        if (checkedId == R.id.rbKuliner){
            jenis = "Kuliner";
        }
        if (checkedId == R.id.rbHotel){
            jenis = "Hotel";
        }
        if (checkedId == R.id.rbRestoran){
            jenis = "Restoran";
        }
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

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
