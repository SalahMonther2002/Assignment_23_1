package com.example.assignment_23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
/*

Based on my careful reading and understanding of the requirements, I have implemented the following idea
in the solution, and I hope it will be in the desired form: The first and third requirement,
focus on the word due, and therefore any task in which the special status has been changed will be deleted
and not displayed in the due task list. This is the logic (i.e. a task that has been completed.
Its work should not be displayed in the tasks that we want to do).
----> In my opinion, any task whose work has been completed has no need to remain <----

So the main thing to take care of when building the application in general: is that it is as easy to use for the
user as possible, and that it does not require a lot of concentration from the user.

I have added the feature of changing the task status upon completion in the same activity that displays the
due tasks, with the aim of user convenience when using the app.
 */

public class viewAllActivity extends AppCompatActivity {

    private ListView listView;
    private EditText txt6;
    private Button btn2;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;



    int numOfTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_all);

        setupViews();
        setupSharedPrefs();
        checkPrefs();


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txt6.getText().toString();
                 numOfTask = Integer.parseInt(str);
                if(numOfTask > 0 & numOfTask <= addNewActivity.taskList.size()) {

                    addNewActivity.taskList.remove((numOfTask - 1));

                    Gson gson = new Gson();
                    String tasksString = gson.toJson(addNewActivity.taskList);

                    editor.putString(addNewActivity.DIS, tasksString);
                    editor.commit();

                    ArrayAdapter<Task> listAdapter = new ArrayAdapter<> ( getApplicationContext(), android.R.layout.simple_list_item_1, addNewActivity.taskList );
                    listView.setAdapter(listAdapter);

                }

            }


        });
    }

    private void checkPrefs() {

        Gson gson = new Gson();

        String str = prefs.getString(addNewActivity.DIS, "");

        if( !str.equals("") ){


            addNewActivity.taskList = gson.fromJson(str, new TypeToken<ArrayList<Task>>(){}.getType());

            ArrayAdapter<Task> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addNewActivity.taskList  );
            listView.setAdapter(listAdapter);

        }


    }
    private void setupSharedPrefs() {

        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }
    private void setupViews() {
        listView =(ListView) findViewById(R.id.listV2);

        txt6 = findViewById(R.id.txt6);
        btn2 = findViewById(R.id.btn2);
    }


}