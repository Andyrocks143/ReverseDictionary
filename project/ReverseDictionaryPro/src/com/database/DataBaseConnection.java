package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	private Connection con;
	private static String connectionString = "jdbc:mysql://localhost:3308/";
	private static DataBaseConnection databaseConnection;
	static DataBaseConnection dbConnection = DataBaseConnection.getInstance();

	/**
	 * @param args
	 */

	public static DataBaseConnection getInstance() {
		if (databaseConnection == null) {
			databaseConnection = new DataBaseConnection();
		}
		return databaseConnection;
	}

	public Connection makeConnectionDB() throws Exception {
		String dbPass = "root";
		String dbName = "srs";
		String dbUser = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(getConnectionString() + dbName,
					dbUser, dbPass);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

	public static String getConnectionString() {
		return connectionString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
