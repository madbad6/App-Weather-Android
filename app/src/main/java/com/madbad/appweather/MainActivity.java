package com.madbad.appweather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user_field;
    private Button main_button;
    private TextView result_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_field = (EditText) findViewById(R.id.user_field);
        main_button = (Button) findViewById(R.id.main_button);
        result_info = (TextView) findViewById(R.id.result_info);

        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_field.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this,R.string.no_user_input,Toast.LENGTH_SHORT).show();
                } else {
                    String city = user_field.getText().toString();
                    String key = "a844cf757c53c4d959bdbae12fd77693";
                    String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+key+"&units=metric&lang=ru";

                    new GetData().execute(url);
                }
            }
        });
    }

    private class GetData extends AsyncTask<String,String,String> {

        protected void onPreExecute(){

        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}