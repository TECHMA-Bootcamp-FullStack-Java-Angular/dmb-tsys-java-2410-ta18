package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_05 {
	
	public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ05");
		
		dbc.createDB("EJ05");
		
		dbc.selectDB();
		
		dbc.createTable("despachos", "(\r\n"
				+ "	numero INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "    capacidad INT NOT NULL\r\n"
				+ ")");
		
		dbc.createTable("director", "(\r\n"
				+ "	dni VARCHAR(8) PRIMARY KEY,\r\n"
				+ "    nombre_apellidos VARCHAR(255) NOT NULL,\r\n"
				+ "    despacho INT NOT NULL,\r\n"
				+ "    dni_jefe VARCHAR(8) NULL,\r\n"
				+ "    FOREIGN KEY (despacho) REFERENCES despachos(numero),\r\n"
				+ "    FOREIGN KEY (dni_jefe) REFERENCES director(dni)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")");
		
		 dbc.insertData( "despachos","(capacidad)","(10), (8), (12), (15), (20)");
		 
		 dbc.insertData( "director", "(dni, nombre_apellidos, despacho)", "('12345678', 'Juan P�rez', 1),\r\n"
		 		+ "('87654321', 'Mar�a L�pez', 2),\r\n"
		 		+ "('23456789', 'Pedro Ram�rez', 1),\r\n"
		 		+ "('98765432', 'Luisa Mart�nez', 3),\r\n"
		 		+ "('34567890', 'Ana S�nchez', 4)");
		 
		 dbc.getValues("despachos");
		 dbc.getValues("director");
		 
		 dbc.closeConnection();
		 
	}

}
