package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ctrl.ClienteDTO;
import ctrl.ControleCliente;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class LiberacaoSaida extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCPF;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LiberacaoSaida frame = new LiberacaoSaida();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LiberacaoSaida(ControleCliente c) {
		ControleCliente controle = c;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(12, 28, 43, 16);
		contentPane.add(lblCpf);
		
		MaskFormatter maskCpf = null;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textFieldCPF = new JFormattedTextField(maskCpf);
		textFieldCPF.setBounds(67, 26, 169, 22);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JButton btnLiberarSada = new JButton("Liberar sa\u00EDda");
		btnLiberarSada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCPF.getText();
				controle.liberaSaidaCliente(cpf);
			}
		});
		btnLiberarSada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLiberarSada.setBounds(248, 25, 138, 25);
		contentPane.add(btnLiberarSada);
	}

}
