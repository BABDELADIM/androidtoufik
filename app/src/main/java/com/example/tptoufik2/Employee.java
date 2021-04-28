package com.example.tptoufik2;



import androidx.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends RealmObject {
    @PrimaryKey
    int id;
    String name;
    Float salary;

    public Employee() {

    }

    @NonNull
    @Override
    public String toString() {
        return "id : "+id+" name "+name+"salary: "+salary;
    }

}
