package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_04 {
	
	public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ04");
		
		dbc.createDB("EJ04");
		
		dbc.selectDB();
		
		dbc.createTable("peliculas", "(\r\n"
				+ "    codigo INT PRIMARY KEY,\r\n"
				+ "    nombre NVARCHAR(100) NOT NULL,\r\n"
				+ "    calificacion_edad INT NOT NULL\r\n"
				+ ")");
		
		dbc.createTable("salas", "(\r\n"
				+ "    codigo INT PRIMARY KEY,\r\n"
				+ "    nombre NVARCHAR(100),\r\n"
				+ "    pelicula INT REFERENCES peliculas\r\n"
				+ ")");
		
		
		 dbc.insertData( "peliculas", "(codigo, nombre, calificacion_edad)" , 
				 " (1, 'El asesino del BoopCamp', 12),\r\n"
				 + "  (2, 'La pesadilla del codigo maldito', 18),\r\n"
				 + "  (3, 'El Codigo Contrataca', 7),\r\n"
				 + "  (4, 'Code Wars', 18),\r\n"
				 + "  (5, 'Java is comming', 12)");
		 
		 dbc.insertData( "salas", "(codigo, nombre, pelicula) " , "  (101, 'Sala A', 1),\r\n"
		 		+ "  (102, 'Sala B', 2),\r\n"
		 		+ "  (103, 'Sala C', 3),\r\n"
		 		+ "  (104, 'Sala D', 4),\r\n"
		 		+ "  (105, 'Sala E', 5);");
		 
		 
		 dbc.getValues("peliculas");
		 dbc.getValues("salas");
		 
		 
		 dbc.closeConnection();
		 
	}
	

}
