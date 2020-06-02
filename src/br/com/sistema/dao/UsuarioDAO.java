package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.factory.ConnectionFactory;
import br.com.sistema.model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Usuario usu) {
		String sql = "INSERT INTO usuario (nome, telefone, saldo_negativo, saldo_positivo) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usu.getNome());
			stmt.setString(2, usu.getTelefone());
			stmt.setBigDecimal(3, usu.getSaldoNegativo());
			stmt.setBigDecimal(4, usu.getSaldoPositivo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Long id, Usuario usu) {
		String sql = "UPDATE usuario SET nome = ?, telefone = ?, saldo_negativo = ?, saldo_positivo = ? WHERE id = "
				+ id;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usu.getNome());
			stmt.setString(2, usu.getTelefone());
			stmt.setBigDecimal(3, usu.getSaldoNegativo());
			stmt.setBigDecimal(4, usu.getSaldoPositivo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Usuario usu) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, usu.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> listar() {
		String sql = "SELECT * FROM usuario ORDER BY nome";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();

			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setId(rs.getLong("id"));
				usu.setNome(rs.getString("nome"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setSaldoNegativo(rs.getBigDecimal("saldo_negativo"));
				usu.setSaldoPositivo(rs.getBigDecimal("saldo_positivo"));
				usuarios.add(usu);
			}

			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> buscar(Long id) {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();

			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setId(rs.getLong("id"));
				usu.setNome(rs.getString("nome"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setSaldoNegativo(rs.getBigDecimal("saldo_negativo"));
				usu.setSaldoPositivo(rs.getBigDecimal("saldo_positivo"));
				usuarios.add(usu);
			}

			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
