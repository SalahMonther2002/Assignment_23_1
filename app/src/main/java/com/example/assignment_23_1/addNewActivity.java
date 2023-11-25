package com.example.assignment_23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import com.google.gson.Gson;


public class addNewActivity extends AppCompatActivity {

    protected static ArrayList<Task> taskList = new ArrayList<>();

    protected static final String DIS = "DIS";
    private Button btnAdd ;
    private EditText disText;

    private TextView txt4;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        setupViews();
        setupSharedPrefs();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = disText.getText().toString();
                 if ( str.isEmpty() ){
                        txt4.setText(" Wrong!! ");
                    }
                 else {

                     taskList.add(new Task(disText.getText().toString()));

                     Gson gson = new Gson();
                     String tasksString = gson.toJson(taskList);

                     editor.putString(DIS, tasksString);
                     editor.commit();

                     txt4.setText(" successful ");
                 }

            }
        });

    }

    private void setupViews() {
        disText = findViewById(R.id.txt3);
        btnAdd = findViewById(R.id.btn1);
        txt4 = findViewById(R.id.txt4);
    }


    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }


}