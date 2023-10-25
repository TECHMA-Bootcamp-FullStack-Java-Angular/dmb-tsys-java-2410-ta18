package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_01 {
	
	public static void run() {
		
		SQLClient dbc = new SQLClient();

		dbc.deleteDBifExists("EJ01");
		
		dbc.createDB("EJ01");
		
		dbc.selectDB();

		dbc.createTable("fabricante", 
				"(codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "    nombre VARCHAR(100) NOT NULL)");
		
		dbc.createTable( "articulo", 
				"(codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "    nombre VARCHAR(100) NOT NULL,\r\n"
				+ "    precio INT NOT NULL,  \r\n"
				+ "    fabricante INT NOT NULL,\r\n"
				+ "    FOREIGN KEY (fabricante) REFERENCES fabricante(codigo)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE)");
		
		dbc.insertData( "fabricante", 
				"(nombre)" , "('Fabricante 1'),\r\n"
						+ "('Fabricante 2'),\r\n"
						+ "('Fabricante 3'),\r\n"
						+ "('Fabricante 4'),\r\n"
						+ "('Fabricante 5')");
		
		dbc.insertData( "articulo", 
				"(nombre, precio, fabricante)" ,
				 "('Articulo 1', 100, 1),\r\n"
				 + "('Articulo 2', 150, 2),\r\n"
				 + "('Articulo 3', 200, 3),\r\n"
				 + "('Articulo 4', 120, 4),\r\n"
				 + "('Articulo 5', 90, 5)");
		
		dbc.getValues("fabricante");
		
		dbc.getValues("articulo");
		
		dbc.closeConnection();
	}
}
