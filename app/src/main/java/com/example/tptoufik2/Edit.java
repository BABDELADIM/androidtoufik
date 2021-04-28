package com.example.tptoufik2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;


public class Edit extends AppCompatActivity {
RealmHelper reHelper;
EditText txtName, txtSalary;
Button btnMod,btnSupp;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnMod = findViewById(R.id.btnModifier);
        btnSupp = findViewById(R.id.btnSupprimer);
        txtName = findViewById(R.id.txtName2);
        txtSalary = findViewById(R.id.txtSalaire2);
        reHelper = new RealmHelper();

        id = getIntent().getIntExtra("idkk",-1);
        Employee emp = reHelper.getEmployee(id);
        txtName.setText(emp.name);
        txtSalary.setText(emp.salary.toString());
    }

    public void supprimerOnClick(View view) {
        reHelper.SupprimerEmpl(id);
        Lister.adapter.notifyDataSetChanged();
        Toast.makeText(Edit.this,"supprime bien ",Toast.LENGTH_LONG).show();
    }

    public void modifierOnClick(View view) {
        String name =txtName.getText().toString();
        float salary = Float.parseFloat(txtSalary.getText().toString());
        reHelper.ModifierEmpl(id,name,salary);
        Lister.adapter.notifyDataSetChanged();

    }
}