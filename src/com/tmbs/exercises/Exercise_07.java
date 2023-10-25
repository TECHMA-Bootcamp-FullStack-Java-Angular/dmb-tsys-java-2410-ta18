package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_07 {
	
public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ08");
		
		dbc.createDB("EJ08");
		
		dbc.selectDB();
		
		dbc.createTable("cientificos", "(\r\n"
				+ "    DNI VARCHAR(8),\r\n"
				+ "    nomApels NVARCHAR(255),\r\n"
				+ "    PRIMARY KEY (DNI)\r\n"
				+ ")");
		
		dbc.createTable("proyecto", "(\r\n"
				+ "    id CHAR(4),\r\n"
				+ "    nombre NVARCHAR(255) NOT NULL,\r\n"
				+ "    horas INT,\r\n"
				+ "    PRIMARY KEY (id)\r\n"
				+ ")");
		
		dbc.createTable("asignado_a", "(\r\n"
				+ "    cientifico VARCHAR(8),\r\n"
				+ "    proyecto CHAR(4),\r\n"
				+ "    PRIMARY KEY (cientifico , proyecto),\r\n"
				+ "    FOREIGN KEY (cientifico)\r\n"
				+ "        REFERENCES cientificos (DNI)\r\n"
				+ "        ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
				+ "    FOREIGN KEY (proyecto)\r\n"
				+ "        REFERENCES proyecto (id)\r\n"
				+ "        ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ")");
		
		 dbc.insertData( "cientificos","(DNI, nomApels)","('12345678', 'Juan P�rez'),\r\n"
		 		+ "  ('87654321', 'Mar�a L�pez'),\r\n"
		 		+ "  ('23456789', 'Pedro Ram�rez'),\r\n"
		 		+ "  ('98765432', 'Luisa Mart�nez'),\r\n"
		 		+ "  ('34567890', 'Ana S�nchez')");
		 
		 dbc.insertData( "proyecto","(id, nombre, horas)"," ('P1', 'Proyecto A', 100),\r\n"
		 		+ "  ('P2', 'Proyecto B', 150),\r\n"
		 		+ "  ('P3', 'Proyecto C', 200),\r\n"
		 		+ "  ('P4', 'Proyecto D', 120),\r\n"
		 		+ "  ('P5', 'Proyecto E', 180)");
		 
		 dbc.insertData( "asignado_a","(cientifico, proyecto)"," ('12345678', 'P1'),\r\n"
		 		+ "  ('87654321', 'P2'),\r\n"
		 		+ "  ('23456789', 'P3'),\r\n"
		 		+ "  ('98765432', 'P4'),\r\n"
		 		+ "  ('34567890', 'P5')");
		  
		 dbc.getValues("cientificos");
		 dbc.getValues("proyecto");
		 dbc.getValues("asignado_a");
		 
		 dbc.closeConnection();
		 
	}

}
