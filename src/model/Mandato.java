package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Mandato {
	public static final double PESO_DENUNCIA = 2;
	public static final double PESO_ELEITORES = 4;

	private int anoInicial;
	private int anoFinal;
	private int denuncias;
	private List<AvaliacaoEleitor> avaliacoesEleitores;
	private double avaliacao;

	public Mandato(int anoInicial, int anoFinal) {
		this.avaliacoesEleitores = new ArrayList<>();
		this.anoInicial = anoInicial;
		this.anoFinal = anoFinal;
	}

	public abstract double avaliar();

	protected double avaliarDenuncias() {
		double avaliacaoDenuncia = denuncias * 0.5;
		return avaliacaoDenuncia > PESO_DENUNCIA ? PESO_DENUNCIA : PESO_DENUNCIA - avaliacaoDenuncia;
	}

	protected double contabilizarAvaliacaoEleitores() {
		if (getAvaliacoesEleitores().isEmpty())
			return 7 / PESO_ELEITORES;

		double avaliacaoEleitores = getAvaliacoesEleitores().stream().mapToDouble(a -> a.getAvaliacao())
				.summaryStatistics().getAverage();
		avaliacaoEleitores *= PESO_ELEITORES;

		return avaliacaoEleitores / 10;
	}

	public void incluirAvaliacaoEleitor(String cpf, double avaliacao) {
		if (this.avaliacoesEleitores.stream().anyMatch(ae -> ae.getCpf().equals(cpf))) {
			System.err.println("Já existe uma avaliação com este CPF ("+ cpf +").");
			return;
		}

		if (avaliacao < 0 || avaliacao > 10) {
			System.err.println("A avaliação de um mandato deve ser uma nota de 0 a 10.");
			return;
		}

		avaliacoesEleitores.add(new AvaliacaoEleitor(cpf, avaliacao));
	}
	
	public void adicionarDenuncia() {
		this.denuncias++;
	}

	public int getAnoInicial() {
		return anoInicial;
	}

	public void setAnoInicial(int anoInicial) {
		this.anoInicial = anoInicial;
	}

	public int getAnoFinal() {
		return anoFinal;
	}

	public void setAnoFinal(int anoFinal) {
		this.anoFinal = anoFinal;
	}

	public int getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(int denuncias) {
		this.denuncias = denuncias;
	}

	public List<AvaliacaoEleitor> getAvaliacoesEleitores() {
		return avaliacoesEleitores;
	}

	public void setAvaliacoesEleitores(List<AvaliacaoEleitor> avaliacoesEleitores) {
		this.avaliacoesEleitores = avaliacoesEleitores;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Período: ");
		sb.append(anoInicial);
		sb.append(" à ");
		sb.append(anoFinal);

		sb.append(".\t");
		sb.append("Avaliação: ");
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		sb.append(nf.format(avaliacao));

		sb.append(". ");

		return sb.toString();
	}

}