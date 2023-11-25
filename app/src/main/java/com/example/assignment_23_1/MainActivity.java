package com.example.assignment_23_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String[] itemList = {"View all due tasks ","Add new task"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , itemList);

        ListView listView =(ListView) findViewById(R.id.listV);
        listView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent( MainActivity.this, viewAllActivity.class  );
                    startActivity(intent);
                }
                else if(position == 1  ){
                    Intent intent = new Intent( MainActivity.this, addNewActivity.class  );
                    startActivity(intent);

                }

            }
        };
        listView.setOnItemClickListener(itemClickListener);

    }


}