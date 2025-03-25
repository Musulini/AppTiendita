package com.example.dao;

import com.example.model.Producto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOXUtility {

    public static List<Producto> loadData(String path) {
        File file = new File(path);
        if (file.exists()) {
            try {
                Scanner entrada = new Scanner(file);
                List<Producto> data = new ArrayList<>();
                while (entrada.hasNextLine()) {
                    String line = entrada.nextLine();
                    data.add(getProducto(line));
                }
            return data;
            }catch (FileNotFoundException e){
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static List<Producto> loadDataX(String path) {
        InputStream inputStream = IOXUtility.class.getClassLoader().getResourceAsStream(path);
        if (inputStream!=null) {
             Scanner entrada = new Scanner(inputStream);
             List<Producto> data = new ArrayList<>();
             while (entrada.hasNext()) {
                 String line = entrada.nextLine();
                 data.add(getProducto(line));
             }
             entrada.close();
             return data;
        }
        System.out.println("No se encontro el archivo");

        return null;
    }

    public static void writeData(String path, List<Producto> productos) throws Exception {
        File file = new File(path);
        PrintWriter writer = new PrintWriter(file);
        for (Producto producto : productos) {
            String salida = producto.getKey()+", " +
                    producto.getNombre() + ", " +
                    producto.getMarca() +  ", " +
                    producto.getDescripcion() + ", " +
                    producto.getCategoria() + ", " +
                    producto.getUnidadMedida() +  ", " +
                    producto.getContenido() +  ", " +
                    producto.getPresentacion() + ", " +
                    producto.isActivo() + ", " +
                    producto.getImagenUrl() +  ", ";
            writer.println(salida);
            writer.flush();
        }
        writer.close();
    }

    private static Producto getProducto(String line) {
        Producto producto = new Producto();
        String[] items = line.split(",");
        for(int i = 0; i < items.length; i++){
            producto.setCodigpBarras(items[0]);
            producto.setNombre(items[1]);
            producto.setMarca(items[2]);
            producto.setDescripcion(items[3]);
            producto.setCategoria(items[4]);
            producto.setUnidadMedida(items[5]);
            producto.setContenido(items[6]);
            producto.setPresentacion(items[7]);
            producto.setActivo(Boolean.parseBoolean(items[8]));
            producto.setImagenUrl(items[9]);
        }
        return  producto;
    }
}
