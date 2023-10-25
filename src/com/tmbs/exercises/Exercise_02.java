package com.tmbs.exercises;

import com.tmbs.database.SQLClient;

public class Exercise_02 {

	public static void run() {
		
		SQLClient dbc = new SQLClient();
		
		dbc.deleteDBifExists("EJ02");
		
		dbc.createDB("EJ02");
		
		dbc.selectDB();

		dbc.createTable("departamentos", 
				"(codigo INT PRIMARY KEY,\r\n"
				+ " nombre NVARCHAR(100) NOT NULL,\r\n"
				+ " presupuesto INT NOT NULL )");
		
		dbc.createTable("empleados", 
				    "(\r\n"
				    + " dni VARCHAR(8) PRIMARY KEY,\r\n"
				    + " nombre NVARCHAR(100) NOT NULL,\r\n"
				    + " apellidos NVARCHAR(255) NOT NULL,\r\n"
				    + " departamento INT NOT NULL REFERENCES departamentos ,\r\n"
				    + " UNIQUE ( nombre , apellidos , departamento )\r\n"
				    + ")");
		
		dbc.insertData( "departamentos", 
				"(codigo, nombre, presupuesto)" , "(1, 'Departamento 1', 100000),\r\n"
						+ "(2, 'Departamento 2', 75000),\r\n"
						+ "(3, 'Departamento 3', 125000),\r\n"
						+ "(4, 'Departamento 4', 90000),\r\n"
						+ "(5, 'Departamento 5', 80000);\r\n");
		
		dbc.insertData("empleados", "(dni, nombre, apellidos, departamento)", 
				  "('12345678', 'Empleado 1', 'Apellido 1', 1),\r\n"
				+ "('23456789', 'Empleado 2', 'Apellido 2', 2),\r\n"
				+ "('34567890', 'Empleado 3', 'Apellido 3', 3),\r\n"
				+ "('45678901', 'Empleado 4', 'Apellido 4', 4),\r\n"
				+ "('56789012', 'Empleado 5', 'Apellido 5', 5);\r\n");
		
		
		dbc.getValues("departamentos");
		dbc.getValues("empleados");
		
		dbc.closeConnection();
	}
	
	
}
