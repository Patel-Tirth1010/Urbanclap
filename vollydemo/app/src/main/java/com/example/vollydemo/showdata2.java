package com.example.vollydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
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

import java.util.ArrayList;

public class showdata2 extends AppCompatActivity {

    ListView listView;
    My_Adapter my_adapter;
    String url = "https://urbanclap1.000webhostapp.com/retrieve.php";
    public static ArrayList<Retrieve> emparraylist = new ArrayList<>();
    Retrieve retrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata2);

        listView=  findViewById(R.id.listview);

        my_adapter = new My_Adapter(this,emparraylist);
        listView.setAdapter(my_adapter);
        retrievedata();
    }

    private void retrievedata() {

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                emparraylist.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("customer");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {

                            Log.e( "json", "onResponse: array executed");

                            JSONObject object;
                            object = jsonArray.getJSONObject(i);
                            String cid = object.getString("cust_id");
                            String fname = object.getString("fname");
                            String lname = object.getString("lname");
                            String ph_no = object.getString("ph_no");
                            String email = object.getString("email");
                            String address = object.getString("address");
                            String city = object.getString("city");
                            String state = object.getString("state");
                            String pincode = object.getString("pincode");
                            String password = object.getString("password");
//                            , lname, ph_no, email, address, city, state, pincode, password

                            retrieve = new Retrieve(cid,fname, lname, ph_no, email, address, city, state, pincode, password);
                            emparraylist.add(retrieve);
                            my_adapter.notifyDataSetChanged();

                        }
                    }
                } catch (JSONException je) {
                    je.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }


}

