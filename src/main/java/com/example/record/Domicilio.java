package com.example.record;

import com.example.enums.Orientacion;

public record Domicilio(
		String numeroCasa,
		String calle,
		Orientacion orientacion,
		String colonia,
		String codigoPostal,
		String ciudad,
		String estado
		) {
}
