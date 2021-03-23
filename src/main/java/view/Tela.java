package view;

import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import controller.PessoaController;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfPessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfPessoa = new JTextField();
		tfPessoa.setBounds(89, 46, 400, 20);
		contentPane.add(tfPessoa);
		tfPessoa.setColumns(10);
		
		JLabel lblPessoa = new JLabel("Pessoa");
		lblPessoa.setBounds(10, 49, 69, 14);
		contentPane.add(lblPessoa);
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(99);
		formatter.setAllowsInvalid(false);
		
		JFormattedTextField tfPosicao = new JFormattedTextField(formatter);
		tfPosicao.setBounds(89, 96, 60, 20);
		contentPane.add(tfPosicao);
		
		JLabel lblPosicao = new JLabel("Posição");
		lblPosicao.setBounds(10, 99, 46, 14);
		contentPane.add(lblPosicao);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 143, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(139, 143, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(274, 143, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(400, 143, 89, 23);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 201, 479, 212);
		contentPane.add(scrollPane);
		
		JTextArea taLista = new JTextArea();
		scrollPane.setViewportView(taLista);
		
		PessoaController pessoaController = new PessoaController(tfPessoa, tfPosicao, taLista);
		btnAdicionar.addActionListener(pessoaController);
		btnConsultar.addActionListener(pessoaController);
		btnExcluir.addActionListener(pessoaController);
		btnListar.addActionListener(pessoaController);
	}
}
