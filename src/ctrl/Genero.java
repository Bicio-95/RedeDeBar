package ctrl;

public enum Genero {
	
	M("M", "Masculino"), F("F", "Feminino");
	
	private String nome;
	private String descricao;
	
	Genero(String nome, String descricao){
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public static Genero masculinoOuFemino(String descricao){
		if (descricao.equals("Masculino")){
			return Genero.M;
		} else if (descricao.equals("Feminino")){
			return Genero.F;
		}
		return null;
	}
}
