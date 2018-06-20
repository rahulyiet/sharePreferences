package com.example.rahulyiet.registrationform;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Output;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      EditText name,age,cls;
      Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age=findViewById(R.id.age);
        cls = findViewById(R.id.cls);
        button=findViewById(R.id.button);



        button .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Required Filed");
                    return;
                }

                if(TextUtils.isEmpty(age.getText().toString())){
                    age.setError("Required Filed");
                    return;
                }

                if(TextUtils.isEmpty(cls.getText().toString())){
                    cls.setError("Required Filed");
                    return;
                }

                String userName, userAge, userClass = null;
                userName = name.getText().toString();
                userAge = age.getText().toString();
                userClass = cls.getText().toString();

                //for entering data into sharedpreference

//             Shared pref start here
                SharedPreferences sp = getSharedPreferences("details", MODE_PRIVATE);
                //get the editor
                SharedPreferences.Editor editor = sp.edit();
                //add your values
                editor.putString("name", userName);
                editor.putString("age", userAge);
                editor.putString("cls", userClass);



                //close editor
                editor.commit();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("subnit confirmation");
                builder.setMessage("Are you sure want to continue");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }

                });

                builder.show();

            }
        });
        }

    }