package com.example.tptoufik2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lister extends AppCompatActivity implements AdapterView.OnItemClickListener {

    RealmHelper reHelper;

    List<Employee> listEmp;
    ListView list;
    static ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);

        list = findViewById(R.id.lister);
        reHelper = new RealmHelper();
        listEmp = new ArrayList<>();
        listEmp.addAll(reHelper.getEmployee());
        list.setOnItemClickListener(this);
        adapter = new ArrayAdapter<Employee>(getApplicationContext(),android.R.layout.simple_list_item_1,listEmp);
        list.setAdapter(adapter);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(Lister.this,Edit.class);
        Employee e = listEmp.get(position) ;
        i.putExtra("idkk",e.id);

        startActivity(i);

    }
}