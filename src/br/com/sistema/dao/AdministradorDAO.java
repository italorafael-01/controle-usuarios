package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sistema.factory.ConnectionFactory;
import br.com.sistema.model.Administrador;

public class AdministradorDAO {

	private Connection connection;

	public AdministradorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Administrador adm) {
		String sql = "INSERT INTO administrador (nome, login, senha) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, adm.getNome());
			stmt.setString(2, adm.getLogin());
			stmt.setString(3, adm.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Long id, Administrador adm) {
		String sql = "UPDATE administrador SET nome = ?, login = ?, senha = ? WHERE id = " + id;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, adm.getNome());
			stmt.setString(2, adm.getLogin());
			stmt.setString(3, adm.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}