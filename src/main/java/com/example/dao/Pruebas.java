package com.example.dao;

import com.example.model.Producto;

import java.util.List;

public class Pruebas {
    public static void main(String[] args) {
        List<Producto> productoList = IOXUtility.loadDataX("productos");

        productoList.forEach(System.out::println);
    }
}
