package com.example.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Component @Lazy

public class Inventory<T> {
    private ArrayList<T> inventory;
    //add, get(i), get(list), clear, size, newInventory
    public Inventory(){inventory = new ArrayList<>();}
    public void add (T t){ inventory.add(t);}
    public T get(int i){
        Function<Integer, T> f = p -> inventory.get(p);
        return f.apply(i);

    }
    public ArrayList<T> get() {
        return inventory;
    }
    public void clear(){inventory.clear();}
    public int size(){return inventory.size();}
    public void newInventory(){inventory = new ArrayList<>();}
}
