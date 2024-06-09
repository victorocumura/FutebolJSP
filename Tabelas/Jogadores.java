package Tabelas;

public class Jogadores {
	private int codigo;
	private String nome;
	private String posicao;
	private String pais;
	private Clubes clubes;
	
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
	
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public String getPosicao() {
		return this.posicao;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	public void setClubes(Clubes clubes) {
		this.clubes = clubes;
	}
	
	public Clubes getClubes() {
		return this.clubes;
	}
	
	
}

