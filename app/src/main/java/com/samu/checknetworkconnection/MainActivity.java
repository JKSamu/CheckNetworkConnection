package com.samu.checknetworkconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button=(Button)findViewById(R.id.button);
    }

    public void buttonAction(View view) {

        //instantiate an object
        ConnectivityManager cm=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        //get all networks information
        NetworkInfo networkInfo[]=cm.getAllNetworkInfo();


        int i;
        //checking internet connectivity
        for(i=0;i<networkInfo.length;++i){
            if(networkInfo[i].getState()==NetworkInfo.State.CONNECTED){
                Toast.makeText(getApplicationContext(),"Internet Connected",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                break;
            }
        }
        if(i==networkInfo.length){
            Toast.makeText(getApplicationContext(),"Internet Not Connected,pls connect with internet ",Toast.LENGTH_LONG).show();
        }
    }}
