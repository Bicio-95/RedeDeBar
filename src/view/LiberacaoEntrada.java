package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ctrl.ClienteDTO;
import ctrl.ControleCliente;
import ctrl.Genero;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import utils.Utils;

public class LiberacaoEntrada extends JFrame {

	private JPanel contentPane;
	private JTextField textNmSocio;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;

	/**
	 * Create the frame.
	 * @param controle 
	 */
	public LiberacaoEntrada(ControleCliente c) {
		ControleCliente controle = c;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNmSocio = new JLabel("N\u00FAmero de s\u00F3cio");
		lblNmSocio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmSocio.setBounds(25, 13, 137, 16);
		contentPane.add(lblNmSocio);
		
		textNmSocio = new JTextField();
		textNmSocio.setBounds(174, 11, 116, 22);
		contentPane.add(textNmSocio);
		textNmSocio.setColumns(10);
		textNmSocio.setEditable(false);
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(25, 42, 56, 16);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldNome.setBounds(93, 40, 327, 22);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(25, 71, 69, 16);
		contentPane.add(lblCpf);
		
		MaskFormatter maskCpf = null;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textFieldCPF = new JFormattedTextField(maskCpf);
		textFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCPF.setBounds(93, 69, 116, 22);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdade.setBounds(221, 71, 56, 16);
		contentPane.add(lblIdade);
		
		JComboBox comboBoxIdade = new JComboBox(iniciarComboBoxIdade());
		comboBoxIdade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxIdade.setBounds(269, 69, 56, 22);
		contentPane.add(comboBoxIdade);
		
		JLabel lblGenero = new JLabel("S:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGenero.setBounds(330, 71, 56, 16);
		contentPane.add(lblGenero);
		
		JComboBox comboGenero = new JComboBox();
		comboGenero.addItem("Masculino");
		comboGenero.addItem("Feminino");
		comboGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboGenero.setBounds(350, 69, 76, 22);
		contentPane.add(comboGenero);
		
		JButton btnLiberarEntrada = new JButton("Liberar Entrada");
		btnLiberarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				if (Utils.naoContemNumero(nome)){
					String cpf = textFieldCPF.getText();
					int idade = comboBoxIdade.getSelectedIndex();
					Genero g = Genero.masculinoOuFemino((String) comboGenero.getSelectedItem()) ;
					ClienteDTO cliente = new ClienteDTO(nome, cpf, idade, g, controle.getClientesCadastrados().size());
					controle.liberaAcessoCliente(cliente);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Este campo só  recebe caracteres" ,"Informação!",JOptionPane.INFORMATION_MESSAGE); 
				}
			}
		});
		btnLiberarEntrada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLiberarEntrada.setBounds(115, 104, 218, 57);
		contentPane.add(btnLiberarEntrada);
		
		JButton btnCadastrarScioE = new JButton("Cadastrar s\u00F3cio e Liberar Entrada");
		btnCadastrarScioE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				if (Utils.naoContemNumero(nome)){
					String cpf = textFieldCPF.getText();
					int idade = comboBoxIdade.getSelectedIndex();
					Genero g = Genero.masculinoOuFemino((String) comboGenero.getSelectedItem()) ;
					int totalClientesCadastrados = controle.getClientesCadastrados().size();
					ClienteDTO cliente = new ClienteDTO(nome, cpf, idade, g, totalClientesCadastrados);
					controle.cadastraCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente Cadastrado" ,"Sucesso!",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else{
					JOptionPane.showMessageDialog(null, "Este campo só caracteres" ,"Informação!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCadastrarScioE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrarScioE.setBounds(25, 172, 395, 57);
		contentPane.add(btnCadastrarScioE);

		JButton btnBuscarScio = new JButton("Buscar s\u00F3cio");
		btnBuscarScio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDTO c = controle.buscaClienteCadastrado(textFieldCPF.getText());
				if (c != null){
					textFieldCPF.setText(c.getCpf());
					textFieldNome.setText(c.getNome());
					textNmSocio.setText(String.valueOf(c.getNrSocio()));
					comboBoxIdade.setSelectedItem(c.getIdade());
					comboGenero.setSelectedIndex(c.getGenero() == Genero.M ? 0 : 1);
				}
			}
		});
		btnBuscarScio.setBounds(302, 10, 118, 25);
		contentPane.add(btnBuscarScio);
		
	}

	private Vector iniciarComboBoxIdade() {
		int idade = 0;
		Vector vetor = new Vector();
		while (idade <= 100){
			vetor.add(idade);
			idade++;
		}
		return vetor;
	}
}
