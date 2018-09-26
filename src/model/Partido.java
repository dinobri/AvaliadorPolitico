package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Partido {
	private String nome;
	private List<Politico> politicos;
	private double avaliacaoGeral;
	
	
	public Partido(String nome) {
		this.nome = nome;
		this.politicos = new ArrayList<>();
		this.avaliacaoGeral = 0;
	}

	public void avaliar() {
		avaliacaoGeral = politicos.stream().mapToDouble(p -> p.getAvaliacaoGeral()).average().getAsDouble();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Politico> getPoliticos() {
		return politicos;
	}

	public void setPoliticos(List<Politico> politicos) {
		this.politicos = politicos;
	}

	public double getAvaliacaoGeral() {
		return avaliacaoGeral;
	}

	public void setAvaliacaoGeral(double avaliacaoGeral) {
		this.avaliacaoGeral = avaliacaoGeral;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append("\t\t Avaliação: ");
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		sb.append(nf.format(avaliacaoGeral));
		return sb.toString();
	}
}
