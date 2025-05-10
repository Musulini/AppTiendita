package com.example.dao;

import com.example.model.Refill;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RefillDao {


	public static List<Refill> loadRefills(String path) {
		File file = new File(path);
		List<Refill> entries = new ArrayList<>();

		if (file.exists()) {
			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
					String[] parts = scanner.nextLine().split(", ");
					if (parts.length == 4) {
						String codigo = parts[0].trim();
						String nombre = parts[1].trim();
						LocalDate fecha = LocalDate.parse(parts[2].trim());
						String quantity = parts[3].trim();
						entries.add(new Refill(codigo, nombre, fecha, quantity));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return entries;
	}

	public static void saveRefill(String path, Refill entry) {
		File file = new File(path);
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file, true), StandardCharsets.UTF_8))) {
			writer.write(entry.getCodigo() + "," + entry.getFecha() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

