package com.example.model;

import com.example.interfaces.Keyable;

public class Producto implements Keyable {
    private String codigpBarras;
    private String nombre;
    private String marca;
    private String categoria;
    private String contenido;
    private String presentacion;
    private String unidadMedida;
    private boolean activo;
    private String descripcion;
    private String imagenUrl;

    public Producto(String codigpBarras) {
    }

    public Producto(){

    }

    @Override
    public String getKey() {
        return codigpBarras;
    }

    public String getCodigpBarras() {
        return codigpBarras;
    }


    public void setCodigpBarras(String codigpBarras) {
        this.codigpBarras = codigpBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean estaActivo) {
        this.activo = estaActivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", categoria='" + categoria + '\'' +
                ", contenido='" + contenido + '\'' +
                ", presentacion='" + presentacion + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return false;

        if (obj instanceof Keyable k)
            if (k.getKey().equals(this.getCodigpBarras()))
                return true;
        return false;
    }

}
