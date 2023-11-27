package com.example.arrayadpter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity<Onlick> extends AppCompatActivity {

    ListView simplelistview;

    String Series[]={"breakingbad","sherlock holmes","chernobyl","friends","lost","gangs of london","banshee","black mirror"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplelistview=(ListView) findViewById(R.id.simplelistview);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.newitem,R.id.textView,Series);
        simplelistview.setAdapter(arrayAdapter);
        simplelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }


}

