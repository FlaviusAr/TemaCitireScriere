package com.example.temasp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname;
    Button button,button2,button3;
    SharedPreferences sp;
    String lastnameStr, firstnameStr;
    TextView lastnameTxtView,firstnameTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.editfirstnameTxt);
        lastname = findViewById(R.id.editlastnameTxt);
        button = findViewById(R.id.salvareButton);
        button2 = (Button) findViewById(R.id.fisierButton);
        button3 = (Button) findViewById(R.id.roomButton);
        lastnameTxtView=findViewById(R.id.lastnameTextview);
        firstnameTxtView=findViewById(R.id.firstnameTextview);
        loadData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastnameStr = lastname.getText().toString();
                firstnameStr = firstname.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("lastname", lastnameStr);
                editor.putString("firstname", firstnameStr);
                editor.apply();
                Toast.makeText(MainActivity.this, "Informatie salvata", Toast.LENGTH_LONG).show();
                String lastname=sp.getString("lastname","");
                String firstname=sp.getString("firstname","");

                lastnameTxtView.setText(lastname);
                firstnameTxtView.setText(firstname);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FisierActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RoomActivity.class);
                startActivity(intent);
            }
        });
    }
    public void loadData(){
        sp = getSharedPreferences("MyUser", Context.MODE_PRIVATE);

        String lastname1=sp.getString("lastname","");
        String firstname1=sp.getString("firstname","");
        lastnameTxtView.setText(lastname1);
        firstnameTxtView.setText(firstname1);
    }
}