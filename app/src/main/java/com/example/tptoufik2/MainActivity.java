package com.example.tptoufik2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Button btnAjouter,btnLister;
    EditText txtName,txtSalaire;
    RealmHelper reHelper;
    private MyApplication Context;
    List<Employee> listEmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context = (MyApplication)this.getApplicationContext();

        btnAjouter = findViewById(R.id.btnAjouter);
        btnLister = findViewById(R.id.btnListAll);
        txtName = findViewById(R.id.txtName);
        txtSalaire = findViewById(R.id.txtSalaire);

        reHelper = new RealmHelper();
        listEmp = new ArrayList<>();

    }

    public void listerOnClick(View view) {
//        String name = txtName.getText().toString();
//        Float salary = Float.parseFloat(txtSalaire.getText().toString());
        //  RealmResults<Employee>  res =  reHelper.getEmployee();
        //   listEmp.addAll(res);
//        String result="";
//        listEmp.addAll(reHelper.getEmployee());
//        for (Employee e:listEmp) {
//            System.out.println(e.name+" "+e.salary);
//            result+=e.name+" "+e.salary+"\n";
//        }
//
//        Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity.this,Lister.class);
        startActivity(i);

    }

    public void ajouetOnClick(View view) {
        String name = txtName.getText().toString();
        Float salary = Float.parseFloat(txtSalaire.getText().toString());
        reHelper.AjouterEmpl(name,salary);
        //  reHelper.AjouterEmpl(txtName.getText().toString(),Float.parseFloat(txtSalaire.getText().toString()));

        Toast.makeText(MainActivity.this,"message ajouter",Toast.LENGTH_LONG).show();
    }
}