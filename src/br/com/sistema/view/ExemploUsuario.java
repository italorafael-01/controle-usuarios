package br.com.sistema.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.sistema.dao.UsuarioDAO;
import br.com.sistema.model.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ExemploUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExemploUsuario frame = new ExemploUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ExemploUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 299);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADICIONAR USU\u00C1RIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 40, 50, 20);
		contentPane.add(lblNewLabel_1);

		jTextField1 = new JTextField();
		jTextField1.setBounds(60, 40, 170, 20);
		contentPane.add(jTextField1);
		jTextField1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("FONE:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(230, 40, 50, 20);
		contentPane.add(lblNewLabel_2);

		try {
			jTextField2 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			jTextField2.setBounds(280, 40, 130, 20);
			contentPane.add(jTextField2);
			jTextField2.setColumns(10);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_3 = new JLabel("SALDO NEGATIVO (R$):");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 70, 140, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("SALDO POSITIVO (R$):");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(10, 100, 140, 20);
		contentPane.add(lblNewLabel_3_1);

		jTextField3 = new JTextField();
		jTextField3.setBounds(150, 70, 80, 20);
		contentPane.add(jTextField3);
		jTextField3.setColumns(10);

		jTextField4 = new JTextField();
		jTextField4.setBounds(150, 100, 80, 20);
		contentPane.add(jTextField4);
		jTextField4.setColumns(10);

		JButton jButton1 = new JButton("LIMPAR");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
			}
		});
		jButton1.setForeground(Color.GRAY);
		jButton1.setFont(new Font("Tahoma", Font.BOLD, 11));
		jButton1.setBackground(Color.LIGHT_GRAY);
		jButton1.setBounds(180, 135, 100, 25);
		contentPane.add(jButton1);

		JButton jButton2 = new JButton("SALVAR");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usu = new Usuario();

				BigDecimal sn = new BigDecimal(jTextField3.getText());
				BigDecimal sp = new BigDecimal(jTextField4.getText());

				usu.setNome(jTextField1.getText());
				usu.setTelefone(jTextField2.getText());
				usu.setSaldoNegativo(sn);
				usu.setSaldoPositivo(sp);

				if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()
						|| jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHER TODOS OS CAMPOS");
				} else {
					UsuarioDAO dao = new UsuarioDAO();
					dao.adicionar(usu);
					JOptionPane.showMessageDialog(null,
							"Usuário " + jTextField1.getText() + " cadastrado com sucesso!");
				}

				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
			}
		});
		jButton2.setFont(new Font("Tahoma", Font.BOLD, 11));
		jButton2.setBackground(Color.LIGHT_GRAY);
		jButton2.setForeground(Color.GRAY);
		jButton2.setBounds(290, 135, 120, 25);
		contentPane.add(jButton2);
	}

}
