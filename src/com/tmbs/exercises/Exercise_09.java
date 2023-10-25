package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_09 {
	
	public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ09");
		
		dbc.createDB("EJ09");
		
		dbc.selectDB();
		
		dbc.createTable("facultad", "(\r\n"
				+ "	codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "    nombre VARCHAR(100) NOT NULL\r\n"
				+ ")");
		
		dbc.createTable("investigador", "(\r\n"
				+ "	dni VARCHAR(8) PRIMARY KEY,\r\n"
				+ "    nombre_apellidos VARCHAR(255) NOT NULL,\r\n"
				+ "    facultad INT NOT NULL,\r\n"
				+ "    FOREIGN KEY (facultad) REFERENCES facultad(codigo),\r\n"
				+ "    Odni_profesor CHAR(9) NOT NULL REFERENCES profesores\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")");
		
		dbc.createTable("equipo", "(\r\n"
				+ "	num_serie CHAR(4) PRIMARY KEY,\r\n"
				+ "    nombre VARCHAR(100) NOT NULL,\r\n"
				+ "    facultad INT NOT NULL,\r\n"
				+ "    FOREIGN KEY (facultad) REFERENCES facultad(codigo),\r\n"
				+ "    dni_profesor CHAR(9) NOT NULL REFERENCES profesores\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")");
		
		dbc.createTable("reserva", "(\r\n"
				+ "	dni_investigador VARCHAR(8) NOT NULL,\r\n"
				+ "    num_equipo CHAR(4) NOT NULL,\r\n"
				+ "    comienzo DATETIME NOT NULL,\r\n"
				+ "    fin DATETIME NOT NULL,\r\n"
				+ "    PRIMARY KEY (dni_investigador, num_equipo),\r\n"
				+ "    FOREIGN KEY (dni_investigador) REFERENCES investigador(dni),\r\n"
				+ "    FOREIGN KEY (num_equipo) REFERENCES equipo(num_serie),\r\n"
				+ "    dni_profesor CHAR(9) NOT NULL REFERENCES profesores\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")");
		
		 dbc.insertData( "facultad","(nombre)"," ('Facultad de Ciencias'),\r\n"
		 		+ "  ('Facultad de Ingenier�a'),\r\n"
		 		+ "  ('Facultad de Medicina'),\r\n"
		 		+ "  ('Facultad de Artes'),\r\n"
		 		+ "  ('Facultad de Derecho')");
		 
		 dbc.insertData( "investigador","(dni, nombre_apellidos, facultad, Odni_profesor)","('12345678', 'Juan P�rez', 1, 'P12345678'),\r\n"
		 		+ "  ('87654321', 'Mar�a L�pez', 2, 'P87654321'),\r\n"
		 		+ "  ('23456789', 'Pedro Ram�rez', 3, 'P23456789'),\r\n"
		 		+ "  ('98765432', 'Luisa Mart�nez', 4, 'P98765432'),\r\n"
		 		+ "  ('34567890', 'Ana S�nchez', 5, 'P34567890')");
		 
		 dbc.insertData( "equipo","(num_serie, nombre, facultad, dni_profesor)","('E101', 'Equipo 1', 1, 'P12345678'),\r\n"
		 		+ "  ('E102', 'Equipo 2', 2, 'P87654321'),\r\n"
		 		+ "  ('E103', 'Equipo 3', 3, 'P23456789'),\r\n"
		 		+ "  ('E104', 'Equipo 4', 4, 'P98765432'),\r\n"
		 		+ "  ('E105', 'Equipo 5', 5, 'P34567890')");
		 
		 dbc.insertData( "reserva","(dni_investigador, num_equipo, comienzo, fin, dni_profesor)"," ('12345678', 'E101', '2023-10-25 09:00:00', '2023-10-25 12:00:00', 'P12345678'),\r\n"
		 		+ "  ('87654321', 'E102', '2023-10-25 10:00:00', '2023-11-25 13:00:00', 'P87654321'),\r\n"
		 		+ "  ('23456789', 'E103', '2023-10-25 11:00:00', '2023-11-25 14:00:00', 'P23456789'),\r\n"
		 		+ "  ('98765432', 'E104', '2023-10-25 12:00:00', '2023-11-25 15:00:00', 'P98765432'),\r\n"
		 		+ "  ('34567890', 'E105', '2023-10-25 13:00:00', '2023-11-25 16:00:00', 'P34567890');");
		 
		 dbc.getValues("facultad");
		 dbc.getValues("investigador");
		 dbc.getValues("equipo");
		 dbc.getValues("reserva");
		 
		 dbc.closeConnection();
		 
	}	

}
