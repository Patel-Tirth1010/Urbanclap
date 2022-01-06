package com.example.vollydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText fname,lname,email,address,city,state,pincode,password,ph_no;
    Button reg,retrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            fname= findViewById(R.id.fname);
            lname= findViewById(R.id.lname);
            ph_no= findViewById(R.id.ph_no);
            email= findViewById(R.id.email);
            password= findViewById(R.id.password);
            address= findViewById(R.id.address);
            city= findViewById(R.id.city);
            state= findViewById(R.id.state);
            pincode= findViewById(R.id.pincord);
            reg= findViewById(R.id.register);
            retrieve = findViewById(R.id.retireve);
            reg.setOnClickListener(v -> insertdata());

    }

    private void insertdata() {
        String FName = fname.getText().toString().trim();
        String LName = lname.getText().toString().trim();
        String Ph_no = ph_no.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String City = city.getText().toString().trim();
        String State = state.getText().toString().trim();
        String Pincode= pincode.getText().toString().trim();
        String Password = password.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST, "https://urbanclap1.000webhostapp.com/insert.php", response -> {

            if(response.equalsIgnoreCase("Data Inserted"))
                Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();

        },
                error -> Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show()
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("fname",FName);
                params.put("lname",LName);
                params.put("ph_no",Ph_no);
                params.put("address",Address);
                params.put("city",City);
                params.put("pincode",Pincode);
                params.put("state",State);
                params.put("password",Password);
                params.put("email",Email);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

    public void retrievedata(View view)
    {
        startActivity(new Intent(getApplicationContext(),showdata2.class));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}