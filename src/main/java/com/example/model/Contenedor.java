package com.example.model;

import com.example.interfaces.Keyable;
import com.example.interfaces.Operable;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<T extends Keyable> implements Operable<T> {
// Catalogo tiene parametro de tipo <T>
// Mientras que Operable tiene argumento de tipo <T>
    List<T> contenedor;

    public Contenedor() {
        super();
        contenedor = new ArrayList<>();
    }

    @Override
    public boolean add(T item) {
        return contenedor.add(item);
    }
// Metodo addAll

    @Override
    public boolean remove(T item) {
        return contenedor.remove(item);
    }

    public boolean remove(String key) {
        return contenedor.remove(key);
    }

    @Override
    public boolean contains(T item) {
        return contenedor.contains(item);
    }

    @Override
    public T get(int index) {
        return contenedor.get(index);
    }

    @Override
    public int getPosition(T item) {
        return contenedor.indexOf(item);
    }

    public boolean getKeyPosition(String key) {
        for (int i = 0; i < contenedor.size(); i++)
            if (contenedor.get(i).getKey().equals(key))
                return true;
        return false;
    }

    @Override
    public void sort() {
        contenedor.sort(null);
    }

    @Override
    public List<T> getAll() {
        return contenedor;
    }

    @Override
    public boolean addAll(List<? extends T> items) {
        return contenedor.addAll(items);
    }

    @Override
    public boolean isEmpty() {
        return contenedor.isEmpty();
    }


}
