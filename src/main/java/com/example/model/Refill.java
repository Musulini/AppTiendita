package com.example.model;

import com.example.dao.RefillDao;
import com.example.interfaces.Operable;

import java.time.LocalDate;

public class Refill {
	private String codigo;
	private String name;
	private LocalDate fecha;
	private String quantity;

	public Refill(String codigo, String name, LocalDate fecha, String quantity) {
		this.codigo = codigo;
		this.name = name;
		this.fecha = fecha;
		this.quantity = quantity;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getName() {
		return name;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
