package model;

public class AvaliacaoEleitor {
	private String cpf;
	private double avaliacao;

	public AvaliacaoEleitor(String cpf, double avaliacao) {
		this.cpf = cpf;
		this.avaliacao = avaliacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

}
