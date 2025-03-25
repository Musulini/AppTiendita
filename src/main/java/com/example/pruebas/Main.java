package com.example.pruebas;

import com.example.interfaces.Operable;
import com.example.model.Contenedor;
import com.example.model.Producto;

import java.util.List;

import static com.example.dao.IOXUtility.loadData;

public class Main {

    public static void main(String[] args) {
        List<Producto> lista = loadData("productos");
        Operable<Producto> catalogo = new Contenedor<>();
        lista.forEach(System.out::println);
    }
}
