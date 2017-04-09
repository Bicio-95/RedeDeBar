package utils;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Utils {
	public static int verificaPorcentagem(int total, int qtdParaVerificar){
		if(total > 0){
			double porcentagem;
			porcentagem = (qtdParaVerificar * 100) / total;
			return (int) Math.ceil((double)porcentagem);
		} 
		return 0;
	}
	public static MaskFormatter formataCPF(){
		MaskFormatter cpf = null;
		try {
			cpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpf;
	}
	public static boolean naoContemNumero(String nome) {
		char[] c = nome.toCharArray();
		for (char d : c) {
			if(!Character.isDigit(d)){
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
