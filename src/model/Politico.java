package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Politico {
	public static final double PESO_MANDATO_RECENTE = 2;
	public static final double PASSO_MANDATO_RECENTE = 0.5;

	private String nome;
	private double avaliacaoGeral;
	private Partido partido;
	private List<Mandato> mandatos;

	public Politico(String nome, Partido partido) {
		super();
		this.nome = nome;
		this.partido = partido;
		partido.getPoliticos().add(this);
		this.mandatos = new ArrayList<>();
	}

	public void avaliarMandatos() {
		Collections.sort(mandatos, (a, b) -> b.getAnoInicial() - a.getAnoInicial());
		mandatos.forEach(m -> m.avaliar());

		double pesoMandato = PESO_MANDATO_RECENTE, somaAvaliacoes = 0, somaPesos = 0;

		for (int i = 0; i < mandatos.size(); i++) {
			somaAvaliacoes += mandatos.get(i).getAvaliacao() * pesoMandato;
			somaPesos += pesoMandato;
			if (pesoMandato > 1)
				pesoMandato -= PASSO_MANDATO_RECENTE;

		}

		setAvaliacaoGeral(somaAvaliacoes / somaPesos);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAvaliacaoGeral() {
		return avaliacaoGeral;
	}

	public void setAvaliacaoGeral(double avaliacaoGeral) {
		this.avaliacaoGeral = avaliacaoGeral;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public List<Mandato> getMandatos() {
		return new ArrayList<>(this.mandatos);
	}

	public void adicionarMandato(Mandato mandato) {
		if (!mandatos.isEmpty() && mandatos.get(mandatos.size() - 1).getAnoFinal() > mandato.getAnoInicial()) {
			System.err.println("O período do novo mandato não pode sobrepor o período de um mandato anterior.");
			return;
		}

		this.mandatos.add(mandato);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome.toUpperCase());
		sb.append(" - ");
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		sb.append(nf.format(avaliacaoGeral));
		sb.append("\n");

		mandatos.forEach(m -> {
			sb.append("\t");
			sb.append(m.toString());
			sb.append("\n");
		});
		return sb.toString();
	}
}
