package com.tmbs.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tmbs.utils.Colors;

public class SQLClient {
	
	
	private ConnectionMySQL sql = ConnectionMySQL.craeteConnectionMySQL();
	private Connection conn = sql.connection(sql.LOCALHOSTS, sql.SQL_PORT_DEFAULT, sql.SQL_USER_DEFAULT, "root");
	private String dbName;
	
	public SQLClient() {}
	
	Logger logger  = Logger.getLogger(ConnectionMySQL.class.getName());
	
	/**
	* Crea una base de datos si no existe.
	*
	* @param dbName El nombre de la base de datos a crear.
	* 
	* @throws SQLException si ocurre un error al crear la tabla.
	*/
	public void createDB(String dbName) {
		sendQuery("CREATE DATABASE IF NOT EXISTS " + dbName + ";");
		this.dbName = dbName;
	}
	

	/**
	* Selecciona una base de datos.
	*
	* @param dbName El nombre de la base de datos a crear.
	* 
	* @throws SQLException si ocurre un error al seleccionar la tabla.
	*/
	public void selectDB() {
		sendQuery("USE " + this.dbName + ";");	
	}

	/**
	* Crea una tabla en la base de datos especificada.
	*
	* @param dbName el nombre de la base de datos donde se creará la tabla.
	* @param tableName el nombre de la tabla que se creará.
	* @param tablaColum los nombres de las columnas de la tabla que se creará.
	*
	* @throws SQLException si ocurre un error al crear la tabla.
	*/
	public void createTable(String tableName, String tablaColum) {
		sendQuery("CREATE TABLE IF NOT EXISTS " + tableName + " " + tablaColum + ";");
	}

	/**
	* Inserta datos en la tabla especificada.
	* 
	* @param tableName el nombre de la tabla donde se insertarán los datos.
	* @param columns los nombres de las columnas donde se insertarán los datos.
	* @param values los valores que se insertarán en las columnas especificadas.
	*
	* @throws SQLException si ocurre un error al insertar los datos en la tabla.
	*/
	public void insertData( String tableName, String columns, String values){
		sendQuery("INSERT INTO " + tableName +" "+columns +" VALUES " + values + ";");
		
	}
	
	/**
	* Elimina la base de datos.
	*
	* @throws SQLException si ocurre un error al eliminar la BBDD.
	*/
	public void deleteDBifExists(String nameBD ) {
		sendQuery("DROP DATABASE IF EXISTS "+ nameBD);
	}

	/**
	* Obtiene los valores de la tabla especificada y los imprime.
    *
	* @param tableName el nombre de la tabla cuyos valores se desean obtener.
	* @param columns los nombres de las columnas cuyos valores se desean obtener.
	*
	* @throws SQLException si ocurre un error al obtener los valores de la tabla.
	*/
	public void getValues(String tableName) {
		try {
			
            Statement st = conn.createStatement();
			printTable(st.executeQuery("SELECT * FROM " + tableName) , tableName );
			
		} catch (SQLException ex) {
			logger.log(Level.WARNING,"Error obtener los datos de la tabla ", ex);
			
		}
	}


	/**
	* Cierra la conexión a la base de datos.
	*
	* @throws SQLException si ocurre un error al cerrar la conexión.
	*/
	public void closeConnection() {
		if(conn!=null) {
			try {			
				System.out.println("\n"+ Colors.txtCyan("CONECXION CERRADA"));
				conn.close();
				
			} catch (SQLException ex) {
				logger.log(Level.SEVERE,Colors.ANSI_WHITE+"NO SE PUDO CERRAR LA CONECXION\n" + Colors.ANSI_RESET, ex);
			}
		}	
	}
	
	/**
	 * Ejecuta una consulta SQL.
	 *
	 * @param query La consulta SQL a ejecutar.
	 */
	public void sendQuery(String query) {
		try {
			
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			query=query.length()<100?query:"Successful sentence";
			System.out.println("Query succes:"+ Colors.txtGreen("OK")+ " - " + query);
			
		} catch (SQLException ex) {
			System.out.println( Colors.ANSI_YELLOW);
			logger.log(Level.WARNING,Colors.ANSI_WHITE+"REVISA LA QUERY\n"+ query + Colors.ANSI_RESET , ex);
		}	
	}
	
	/**
	 * Imprime una tabla en la consola.
	 *
	 * @param resultSet El conjunto de resultados de la consulta SQL.
	 * @param tableName El nombre de la tabla.
	 * @param columns Las columnas de la tabla a imprimir.
	 * @throws SQLException Si ocurre un error al imprimir la tabla.
	 */
	private void printTable(ResultSet resultSet ,String tableName ) throws SQLException {
		
	    int col = resultSet.getMetaData().getColumnCount();

	    // Print Tabe-header
	    System.out.println( Colors.txtYellow("\n\tTABLA " + tableName.toUpperCase()) +"\n" + Colors.SEPARADOR);

	    // Print Tabe-body
	    while (resultSet.next()) {
	    	
	    	for (int i = 1; i <= col ; i++) {
	    	System.out.print( resultSet.getMetaData().getColumnName(i) +" "+ Colors.ANSI_CYAN + resultSet.getObject(i)+"  " + Colors.ANSI_RESET );
			}
	    	
	        System.out.println("");
	    }
	    // Print Tabe-footer
	    System.out.println(Colors.SEPARADOR);
	}
	
	// Getter de dbName
	public String getBD() {
		return dbName;
	}
	

}
