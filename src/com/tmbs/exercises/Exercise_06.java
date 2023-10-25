package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_06 {

	public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ07");
		
		dbc.createDB("EJ07");
		
		dbc.selectDB();
		
		dbc.createTable("piezas", "(\r\n"
				+ " codigo INT AUTO_INCREMENT,\r\n"
				+ " nombre NVARCHAR(100) NOT NULL,\r\n"
				+ " PRIMARY KEY (codigo))");
		
		dbc.createTable("proveedores", "("
				+ "    id CHAR(4),\r\n"
				+ "    nombre NCHAR(100) NOT NULL,\r\n"
				+ "    PRIMARY KEY (id)\r\n"
				+ ")");
		
		dbc.createTable("suministra", "("
				+ "    codigoPieza INT,\r\n"
				+ "    idProveedor CHAR(4),\r\n"
				+ "    precio INT,\r\n"
				+ "    PRIMARY KEY (codigoPieza , idProveedor),\r\n"
				+ "    FOREIGN KEY (codigoPieza)\r\n"
				+ "    REFERENCES piezas (codigo)\r\n"
				+ "    ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
				+ "    FOREIGN KEY (idProveedor)\r\n"
				+ "    REFERENCES proveedores (id)\r\n"
				+ "    ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ")");
		
		 dbc.insertData( "piezas","(nombre)","('Tonillo'),\r\n"
		 		+ "  ('Arandela'),\r\n"
		 		+ "  ('Brida'),\r\n"
		 		+ "  ('Tuerca'),\r\n"
		 		+ "  ('Pasador')");
		 
		 dbc.insertData( "proveedores","(id, nombre)","('P1', 'Proveedor 1'),\r\n"
		 		+ "  ('P2', 'Proveedor 2'),\r\n"
		 		+ "  ('P3', 'Proveedor 3'),\r\n"
		 		+ "  ('P4', 'Proveedor 4'),\r\n"
		 		+ "  ('P5', 'Proveedor 5')");
		 
		 dbc.insertData( "suministra","(codigoPieza, idProveedor, precio)","(1, 'P1', 100),\r\n"
		 		+ "  (2, 'P2', 150),\r\n"
		 		+ "  (3, 'P3', 200),\r\n"
		 		+ "  (4, 'P4', 120),\r\n"
		 		+ "  (5, 'P5', 180)");
		  
		 dbc.getValues("piezas");
		 dbc.getValues("proveedores");
		 dbc.getValues("suministra");
		 
		 dbc.closeConnection();
		 
	}	

}
