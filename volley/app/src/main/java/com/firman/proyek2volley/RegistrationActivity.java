package com.firman.proyek2volley;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.firman.proyek2volley.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import es.dmoral.toasty.Toasty;

public class RegistrationActivity extends AppCompatActivity {

    ProgressDialog pDialog;
    Button register;
    TextView login;
    EditText name, userName, userPassword, userPassword2, userEmail;
    Intent intent;

    int success;
    ConnectivityManager conMgr;

    private String url = Server.URL + "register.php";

    private static final String TAG = RegistrationActivity.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toasty.error(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG,true).show();
            }
        }

        Toasty.Config.getInstance().apply();

        name = (EditText) findViewById(R.id.etName);
        login = (TextView) findViewById(R.id.tvUserLogin);
        register = (Button) findViewById(R.id.btnRegister);
        userName = (EditText) findViewById(R.id.etUserName);
        userPassword = (EditText) findViewById(R.id.etUserPassword);
        userPassword2 = (EditText) findViewById(R.id.etUserPassword2);
        userEmail = (EditText) findViewById(R.id.etUserEmail);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String nama = name.getText().toString();
                String username = userName.getText().toString();
                String password = userPassword.getText().toString();
                String confirm_password = userPassword2.getText().toString();
                String email = userEmail.getText().toString();

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    userEmail.setError("Email tidak valid");
                    userEmail.requestFocus();
                }else if(password.length()<6){
                    userPassword.setError("Password harus lebih dari 6 karakter");
                    userPassword.requestFocus();
                }else if(confirm_password.length()<6){
                    userPassword2.setError("Password harus lebih dari 6 karakter");
                    userPassword2.requestFocus();
                }else {
                    if (conMgr.getActiveNetworkInfo() != null
                            && conMgr.getActiveNetworkInfo().isAvailable()
                            && conMgr.getActiveNetworkInfo().isConnected()) {
                        checkRegister(nama, username, password, confirm_password, email);
                    } else {
                        Toasty.error(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT,true).show();
                    }
                }
            }
        });

    }

    private void checkRegister(final String nama, final String username, final String password, final String confirm_password,final String email) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Register ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Check for error node in json
                    if (success == 1) {

                        Log.e("Successfully Register!", jObj.toString());

                        Toasty.success(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG,true).show();

                        finish();
                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));

                    } else {
                        Toasty.error(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG,true).show();

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toasty.error(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG,true).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("nama", nama);
                params.put("username", username);
                params.put("password", password);
                params.put("confirm_password", confirm_password);
                params.put("email", email);

                return params;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
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
