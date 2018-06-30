package com.example.fryan.json;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 //   private  static final String  URL_DATA ="https://simplifiedcoding.net/demos/marvel/";
    //private  static final String  URL_DATA ="https://api.myjson.com/bins/tet1y";
 //private  static final String  URL_DATA = (" https://api.myjson.com/bins/upyl2");
   // private  static final String  URL_DATA = ("https://api.myjson.com/bins/1c1oae");
// private  static final String  URL_DATA =   ("https://api.myjson.com/bins/136bdi");
    private  static final String  URL_DATA =    ("https://api.myjson.com/bins/1afsye");

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private List<ListItem> listItemList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItemList = new ArrayList<>();
         recyclerView = (RecyclerView) findViewById(R.id.RecycleID);
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager( new LinearLayoutManager(this));
         recyclerView.setAdapter(adapter);

          loadRecycleViewData();



    }

    private void  loadRecycleViewData(){

        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Loading data......");
        progressDialog.show();

        StringRequest  stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(s);

                    JSONArray array= jsonObject.getJSONArray("Heroes");

                     for (int i =0; i< array.length(); i++)
                     {
                          JSONObject o =  array.getJSONObject(i);
                          ListItem item = new ListItem(
                                  o.getString("name"),
                                  o.getString("about"),
                                  o.getString("team"),
                                  o.getString("imageurl")


                         );
                          listItemList.add(item);
                     }

                     adapter = new MyAdapter(listItemList,getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override

            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
