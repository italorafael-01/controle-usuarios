package br.com.sistema.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.dao.UsuarioDAO;
import br.com.sistema.model.Usuario;

public class MainUsu {

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usu1 = new Usuario();
		Usuario usu2 = new Usuario();
		Usuario usu3 = new Usuario();
		Usuario usu4 = new Usuario();

		// AdicionarUsuário
		// usu1.setNome("Joab Fonte");
		// usu1.setTelefone("(99) 99999-9999");
		// usu1.setSaldoNegativo(new BigDecimal("100"));
		// usu1.setSaldoPositivo(new BigDecimal("200"));
		// dao.adicionar(usu1);

		// usu2.setNome("Richard Silva");
		// usu2.setTelefone("(99) 99999-9999");
		// usu2.setSaldoNegativo(new BigDecimal("100"));
		// usu2.setSaldoPositivo(new BigDecimal("200"));
		// dao.adicionar(usu2);

		// usu3.setNome("Jhone Robson");
		// usu3.setTelefone("(99) 99999-9999");
		// usu3.setSaldoNegativo(new BigDecimal("100"));
		// usu3.setSaldoPositivo(new BigDecimal("200"));
		// dao.adicionar(usu3);

		// AterarUsuário
		// long id1 = 3;
		// usu4.setNome("Rian Silva");
		// usu4.setTelefone("(99) 99999-9999");
		// usu4.setSaldoNegativo(new BigDecimal("100"));
		// usu4.setSaldoPositivo(new BigDecimal("200"));
		// dao.alterar(id1, usu4);

		// RemoverUsuário
		// usu3.setId(3L);
		// dao.remover(usu3);

		// ListarUsuário
		List<Usuario> usuarios1 = dao.listar();
		for (Usuario usuario : usuarios1) {
			System.out.println("Id: " + usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Saldo Negativo: R$" + usuario.getSaldoNegativo());
			System.out.println("Saldo Positivo: R$" + usuario.getSaldoPositivo());
			System.out.println("Saldo Total: R$" + (usuario.getSaldoPositivo().subtract(usuario.getSaldoNegativo())));
			System.out.println();
		}

		// BuscarUsuário
		// long id2 = 1;

		// List<Usuario> usuarios2 = dao.buscar(id2);
		// for (Usuario usuario : usuarios2) {
		// System.out.println("Id: " + usuario.getId());
		// System.out.println("Nome: " + usuario.getNome());
		// System.out.println("Telefone: " + usuario.getTelefone());
		// System.out.println("Saldo Negativo: R$" + usuario.getSaldoNegativo());
		// System.out.println("Saldo Positivo: R$" + usuario.getSaldoPositivo());
		// System.out.println("Saldo Total: R$" + (usuario.getSaldoPositivo().subtract(usuario.getSaldoNegativo())));
		// }
	}

}
