package Tabelas;



public class Campeonatos {
	private int codigo;
	private String nome;
	private String data_inicio;
	private String data_fim;
	private int numero_participantes;
	
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setData_Inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public String getData_Inicio() {
		return this.data_inicio;
	}
	
	public void setData_Fim(String data_fim) {
		this.data_fim = data_fim;
	}
	
	public String getData_Fim() {
		return this.data_fim;
	}
	
	public void setNumero_Participantes(int numero_participantes) {
		this.numero_participantes = numero_participantes;
		
	}
	
	public int getNumero_Participantes() {
		return this.numero_participantes;
	}
}
