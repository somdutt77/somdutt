package com.example.api.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.api.API.RetrofitClient;
import com.example.api.API.SocketConnection;
import com.example.api.Model.Login.LoginExample;
import com.example.api.R;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email;
    EditText password;
    Button login;
    String url = "http://34.231.88.85:8001/api/users/login";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == login) {
            Users();

        }

    }


//    private void callPUTDataMethod(String userName, String job) {
//
//        // below line is for displaying our progress bar.
//        loadingPB.setVisibility(View.VISIBLE);
//
//        // on below line we are creating a retrofit
//        // builder and passing our base url
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//
//                // as we are sending data in json format so
//                // we have to add Gson converter factory
//                .addConverterFactory(GsonConverterFactory.create())
//
//                // at last we are building our retrofit builder.
//                .build();
//
//        // below the line is to create an instance for our retrofit api class.
//        API retrofitAPI = retrofit.create(API.class);
//
//        // passing data from our text fields to our modal class.
//        Loginrequest modal = new Loginrequest(email.getText().toString(), password.getText().toString());
//
//        // calling a method to create an update and passing our modal class.
//        Call<Loginrequest> call = retrofitAPI.LOGINapI(modal);
//
//        // on below line we are executing our method.
//        call.enqueue(new Callback<DataModal>() {
//            @Override
//            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
//                // this method is called when we get response from our api.
//                Toast.makeText(MainActivity.this, "Data updated to API", Toast.LENGTH_SHORT).show();
//
//                // below line is for hiding our progress bar.
//                loadingPB.setVisibility(View.GONE);
//
//                // on below line we are setting empty
//                // text to our both edit text.
//                jobEdt.setText("");
//                userNameEdt.setText("");
//
//                // we are getting a response from our body and
//                // passing it to our modal class.
//                DataModal responseFromAPI = response.body();
//
//                // on below line we are getting our data from modal class
//                // and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();
//
//                // below line we are setting our string to our text view.
//                responseTV.setText(responseString);
//            }
//
//            @Override
//            public void onFailure(Call<DataModal> call, Throwable t) {
//
//                // setting text to our text view when
//                // we get error response from API.
//                responseTV.setText("Error found is : " + t.getMessage());
//            }
//        });
//    }


    private void Users() {
//        String userEmail = email.getText().toString();
//        String userName = name.getText().toString();
//        if (userEmail.isEmpty()) {
//            email.requestFocus();
//            email.setError("Please Enter Your Email");
//            return;
//        }
//        if (userName.isEmpty()) {
//            name.requestFocus();
//            name.setError("Please Enter Your Password");
//            return;
//        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
//            name.requestFocus();
//            name.setError("Please Enter Your Correct Email");
//            return;
//        }
//        if (name.length() < 8) {
//            name.requestFocus();
//            name.setError("");
//            return;
//        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email.getText().toString());
        jsonObject.addProperty("password", password.getText().toString());
        Call<LoginExample> loginExampleCall = RetrofitClient.getInstance().getApi().LOGINapI(jsonObject);
        loginExampleCall.enqueue(new Callback<LoginExample>() {
            @Override
            public void onResponse(Call<LoginExample> call, Response<LoginExample> response) {

                if (response.code() == 200) {
                    Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "sssssssss", Toast.LENGTH_SHORT).show();
                } else {
                    String responceData = SocketConnection.convertStreamToString(response.errorBody().byteStream());
                    try {
                        JSONObject jsonObject = new JSONObject(responceData);
                        String message = jsonObject.optString("message");
                        String error = jsonObject.optString("error");
                        Toast.makeText(MainActivity.this, error + "", Toast.LENGTH_SHORT).show();

                        if (!(message.equalsIgnoreCase(""))) {
//                            registerHandler.onError(message);
                            Toast.makeText(MainActivity.this, error + "", Toast.LENGTH_SHORT).show();

                            Log.d("checkingvalue", message.toString());
                        } else {
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<LoginExample> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage() + "", Toast.LENGTH_SHORT).show();
                Log.d("checkinglog", t.getMessage() + "");


            }
        });


//        Call<ModelApi> call = RetrofitClient.getInstance().getApi().call(email.toString(), name.toString());
//        call.enqueue(new Callback<ModelApi>() {
//            @Override
//            public void onResponse(Call<ModelApi> call, Response<ModelApi> response) {
//                ModelApi modelApi = response.body();
//                if (modelApi.isSuccessful()) {
//                    Intent intent = new Intent(MainActivity.this, FirstActivity.class);
//                    startActivity(intent);
//                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelApi> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}

