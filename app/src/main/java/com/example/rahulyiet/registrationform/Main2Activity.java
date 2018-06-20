package com.example.rahulyiet.registrationform;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

       TextView name,age,cls;
       String userName,userAge,userClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.name1);
        age=findViewById(R.id.age1);
        cls=findViewById(R.id.cls1);
//      get shared prefererence
        SharedPreferences sp = getSharedPreferences("details",MODE_PRIVATE);
  //     create editor
        userName= sp.getString("name","none");
        userAge = sp.getString("age","none");
        userClass =sp.getString("cls","none");

        name.setText(userName);
        age.setText(userAge);
        cls.setText(userClass);
    }
}
