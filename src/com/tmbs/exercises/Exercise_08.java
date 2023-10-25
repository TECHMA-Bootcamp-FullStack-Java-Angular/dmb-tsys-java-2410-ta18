package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_08 {
	
public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ08");
		
		dbc.createDB("EJ08");
		
		dbc.selectDB();
		
		dbc.createTable("productos", "(\r\n"
				+ "    codigo INT PRIMARY KEY,\r\n"
				+ "    nombre VARCHAR(100) NOT NULL,\r\n"
				+ "    precio INT NOT NULL\r\n"
				+ ")");
		
		dbc.createTable("cajeros", "(\r\n"
				+ "    codigo INT PRIMARY KEY,\r\n"
				+ "    nom_apels VARCHAR(255) NOT NULL\r\n"
				+ ")");
		
		dbc.createTable("maquinas_registradoras", "(\r\n"
				+ "    codigo INT PRIMARY KEY,\r\n"
				+ "    piso INT NOT NULL\r\n"
				+ ")");
		
		dbc.createTable("venta", "(\r\n"
				+ "    cajero INT REFERENCES cajeros,\r\n"
				+ "    maquina INT REFERENCES maquinas_registradoras,\r\n"
				+ "    producto INT REFERENCES productos,\r\n"
				+ "    PRIMARY KEY (cajero , maquina , producto)\r\n"
				+ ")");
		
		 dbc.insertData( "productos","(codigo, nombre, precio)","(1, 'Producto A', 10),\r\n"
		 		+ "  (2, 'Producto B', 15),\r\n"
		 		+ "  (3, 'Producto C', 20),\r\n"
		 		+ "  (4, 'Producto D', 25),\r\n"
		 		+ "  (5, 'Producto E', 30)");
		 
		 dbc.insertData( "cajeros","(codigo, nom_apels)"," (101, 'Juan Pérez'),\r\n"
		 		+ "  (102, 'María López'),\r\n"
		 		+ "  (103, 'Pedro Ramírez'),\r\n"
		 		+ "  (104, 'Luisa Martínez'),\r\n"
		 		+ "  (105, 'Ana Sánchez')");
		 
		 dbc.insertData( "maquinas_registradoras" ,"(codigo, piso)"," (501, 1),\r\n"
		 		+ "  (502, 1),\r\n"
		 		+ "  (503, 2),\r\n"
		 		+ "  (504, 2),\r\n"
		 		+ "  (505, 3);");
		 
		 dbc.insertData( "venta" ,"(cajero, maquina, producto)"," (101, 501, 1),\r\n"
		 		+ "  (102, 502, 2),\r\n"
		 		+ "  (103, 503, 3),\r\n"
		 		+ "  (104, 504, 4),\r\n"
		 		+ "  (105, 505, 5)");
		 
		 dbc.getValues("venta");
		 dbc.getValues("cajeros");
		 dbc.getValues("maquinas_registradoras");
		 dbc.getValues("venta");
		 
		 dbc.closeConnection();
		 
	}	

}
