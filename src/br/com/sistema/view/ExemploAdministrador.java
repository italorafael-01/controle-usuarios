package br.com.sistema.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.sistema.dao.AdministradorDAO;
import br.com.sistema.model.Administrador;
import javax.swing.JPasswordField;

public class ExemploAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JPasswordField jPasswordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExemploAdministrador frame = new ExemploAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ExemploAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 299);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ADICIONAR ADMINISTRADOR");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 234, 30);
		contentPane.add(lblNewLabel_1);

		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(60, 100, 160, 20);
		contentPane.add(jPasswordField);

		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 40, 50, 20);
		contentPane.add(lblNewLabel);

		jTextField1 = new JTextField();
		jTextField1.setBounds(60, 40, 160, 20);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);

		JLabel lblLogin = new JLabel("LOGIN:");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(10, 70, 50, 20);
		contentPane.add(lblLogin);

		jTextField2 = new JTextField();
		jTextField2.setColumns(10);
		jTextField2.setBounds(60, 70, 160, 20);
		contentPane.add(jTextField2);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(10, 100, 50, 20);
		contentPane.add(lblSenha);

		JButton jButton1 = new JButton("LIMPAR");
		jButton1.setForeground(Color.GRAY);
		jButton1.setFont(new Font("Tahoma", Font.BOLD, 10));
		jButton1.setBackground(Color.LIGHT_GRAY);
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField1.setText("");
				jTextField2.setText("");
				jPasswordField.setText("");
			}
		});
		jButton1.setBounds(10, 135, 100, 25);
		contentPane.add(jButton1);

		JButton jButton2 = new JButton("SALVAR");
		jButton2.setForeground(Color.GRAY);
		jButton2.setFont(new Font("Tahoma", Font.BOLD, 10));
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = new String(jPasswordField.getPassword());
				Administrador adm = new Administrador();
				adm.setNome(jTextField1.getText());
				adm.setUsername(jTextField2.getText());
				adm.setSenha(senha);

				if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHER TODOS OS CAMPOS");
				} else {
					AdministradorDAO dao = new AdministradorDAO();
					dao.adicionar(adm);
					JOptionPane.showMessageDialog(null, "Adm " + jTextField1.getText() + " cadastrado com sucesso!");
				}

				jTextField1.setText("");
				jTextField2.setText("");
				jPasswordField.setText("");
			}
		});
		jButton2.setBackground(Color.LIGHT_GRAY);
		jButton2.setBounds(120, 135, 100, 25);
		contentPane.add(jButton2);

		JButton jButton3 = new JButton("VOLTAR");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jButton3.setForeground(Color.GRAY);
		jButton3.setFont(new Font("Tahoma", Font.BOLD, 10));
		jButton3.setBackground(Color.LIGHT_GRAY);
		jButton3.setBounds(120, 171, 100, 25);
		contentPane.add(jButton3);
	}
}
