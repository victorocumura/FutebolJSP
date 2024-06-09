package Tabelas;

public class Jogos {
	private int codigo;
	private String data_jogo;
	private String hora_jogo;
	private String mandante;
	private String visitante;
	private int gols_mandante;
	private int gols_visitante;
	private String local_jogo;
	private Campeonatos campeonatos;
	
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setData_Jogo(String data_jogo) {
		this.data_jogo = data_jogo;
	}
	
	public String getData_Jogo() {
		return this.data_jogo;
	}
	
	public void setHora_Jogo(String hora_jogo) {
		this.hora_jogo = hora_jogo;
	}
	
	public String getHora_Jogo() {
		return this.hora_jogo;
	}
	
	public void setMandante(String mandante) {
		this.mandante = mandante;
	}
	
	public String getMandante() {
		return this.mandante;
	}
	
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	
	public String getVisitante() {
		return this.visitante;
	}
	
	public void setGols_Mandante(int gols_mandante) {
		this.gols_mandante = gols_mandante;
	}
	
	public int getGols_Mandante() {
		return this.gols_mandante;
	}
	
	public void setGols_Visitante(int gols_visitante) {
		this.gols_visitante = gols_visitante;
	}
	
	public int getGols_Visitante() {
		return this.gols_visitante;
	}
	
	public void setLocal_Jogo(String local_jogo) {
		this.local_jogo = local_jogo;
	}
	
	public String getLocal_Jogo() {
		return this.local_jogo;
	}
	
	public void setCampeonatos(Campeonatos campeonatos) {
		this.campeonatos = campeonatos;
	}
	
	public Campeonatos getCampeonatos() {
		return this.campeonatos;
	}
	
}
	



