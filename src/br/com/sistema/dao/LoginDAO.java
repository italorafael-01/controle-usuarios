package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistema.factory.ConnectionFactory;

public class LoginDAO {

	private Connection connection;

	public LoginDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public boolean logar(String login, String senha) {
		String sql = "SELECT * FROM administrador WHERE login = ? AND senha = ?";
		boolean validar = false;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				validar = true;
			}
			
			stmt.close();
			return validar;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}