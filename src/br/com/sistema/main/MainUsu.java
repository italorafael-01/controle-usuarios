package br.com.sistema.main;

import java.math.BigDecimal;

import br.com.sistema.dao.UsuarioDAO;
import br.com.sistema.model.Administrador;
import br.com.sistema.model.Usuario;

public class MainUsu {

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usu1 = new Usuario();
		Administrador adm1 = new Administrador();

		adm1.setId(2L);
		usu1.setNome("Rian Silva");
		usu1.setTelefone("(99) 99999-9999");
		usu1.setSaldoNegativo(new BigDecimal("100"));
		usu1.setSaldoPositivo(new BigDecimal("200"));
		usu1.setAdministrador(adm1);
		dao.adicionar(usu1);
	}

}
