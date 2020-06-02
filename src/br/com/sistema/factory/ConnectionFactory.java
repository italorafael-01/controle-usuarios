package br.com.sistema.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sistema?useTimezone=true&serverTimezone=UTC", "root", "123456");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
