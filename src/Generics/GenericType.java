package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType<T> {

    /*
    E --> Element, used in Collection
    K --> Key
    V --> Value   Map (K,V)
    N --> Number
    T --> Type
     */

    private T type;

    // getter & setter
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    // main method
    public static void main(String[] args) {

        // TASK: create 2 different object by using same class with Generic
        GenericType<String> obj1 = new GenericType<>(); // as of Java 7 we do not write GenericType<String>
        obj1.setType("Generic Type");

        // GenericType<String> obj2 = new GenericType<>();
        // obj2.setType(65);  // required type is String so we can not use Integer in it

        // NOTE: Solving Cast Problem
        GenericType<Integer> obj3 = new GenericType<>();
        obj3.setType(65);
        int a = obj3.getType(); // Generic solves Cast Problem

        // NOTE:  Solving ClassCastException Problem
        List<String> list = new ArrayList<>();
        list.add("Name1");
        list.add("Name2");
        // list.add(12);  // CTE -> prevents ClassCastException

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Name1");
        // map.put("2","Name2");  // --> CTE



    }


}
