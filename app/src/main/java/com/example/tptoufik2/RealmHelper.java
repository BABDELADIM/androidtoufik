package com.example.tptoufik2;


import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm ;

    public RealmHelper() {
        // this.realm = realm;
        realm = Realm.getDefaultInstance();
    }

    public void AjouterEmpl(String name,Float salary){
        int id;
        realm.beginTransaction();
        Number currentIdNum = realm.where(Employee.class).max("id") ;
        if(currentIdNum==null)
            id=1;
        else
            id = (int)currentIdNum.longValue()+1;
        Employee emp = realm.createObject(Employee.class,id);

        emp.setName(name);
        emp.setSalary(salary);
        realm.commitTransaction();
    }
    public void ModifierEmpl(int id,String name,Float salary){

        realm.beginTransaction();
        Employee emp = realm.where(Employee.class).equalTo("id",id).findFirst();
        emp.setName(name);
        emp.setSalary(salary);
        realm.commitTransaction();
    }
    public void SupprimerEmpl(int id){
        realm.beginTransaction();
        Employee empNum = realm.where(Employee.class).equalTo("id",id).findFirst();
        empNum.deleteFromRealm();
        realm.commitTransaction();
    }
    public Employee getEmployee(int id){
        return realm.where(Employee.class).equalTo("id",id).findFirst();
    }
    public RealmResults<Employee> getEmployee() {
        return realm.where(Employee.class).findAll();
    }

}