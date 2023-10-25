package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_03 {
	
	public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ03");
		
		dbc.createDB("EJ03");
		
		dbc.selectDB();
		
		dbc.createTable("almacen", "(\r\n"
				+ "	codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "    lugar VARCHAR(100) NOT NULL,\r\n"
				+ "    capacidad INT NOT NULL\r\n"
				+ ")");
		
		dbc.createTable("caja", "(\r\n"
				+ "	num_referencia CHAR(8) PRIMARY KEY,\r\n"
				+ "    contenido VARCHAR(100) NOT NULL,\r\n"
				+ "    valor INT NOT NULL,\r\n"
				+ "    almacen INT NOT NULL,\r\n"
				+ "    FOREIGN KEY (almacen) REFERENCES almacen(codigo)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")");
			
		 dbc.insertData( "almacen", "(lugar, capacidad)" , 
				 "('Almac�n 1', 5000),\r\n"
		 		+ "    ('Almac�n 2', 7500),\r\n"
		 		+ "    ('Almac�n 3', 6000),\r\n"
		 		+ "    ('Almac�n 4', 3000),\r\n"
		 		+ "    ('Almac�n 5', 9000)");
		 
		 dbc.insertData( "caja", "(num_referencia, contenido, valor, almacen)" , " ('Caja Y', 'Contenido de caja Y', 1000, 1),\r\n"
		 		+ "    ('Caja A', 'Contenido de caja A', 1500, 2),\r\n"
		 		+ "    ('Caja B', 'Contenido de caja B', 8000, 1),\r\n"
		 		+ "    ('Caja C', 'Contenido de caja C', 1200, 3),\r\n"
		 		+ "    ('Caja D', 'Contenido de caja D', 2000, 2),\r\n"
		 		+ "    ('Caja E', 'Contenido de caja E', 6000, 4),\r\n"
		 		+ "    ('Caja F', 'Contenido de caja F', 9000, 3),\r\n"
		 		+ "    ('Caja G', 'Contenido de caja G', 7500, 5);");
		 
		 dbc.getValues("almacen");
		 dbc.getValues("caja");
		 
		 dbc.closeConnection();
		 
	}
	
}
