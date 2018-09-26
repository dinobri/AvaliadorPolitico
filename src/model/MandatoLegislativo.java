package model;

public class MandatoLegislativo extends Mandato {

	public static final double PESO_PRESENCA = 2;
	public static final double PESO_PROJETOS = 2;

	private double presenca;
	private int projetosPropostos;
	private int projetosAprovados;

	public MandatoLegislativo(int anoInicial, int anoFinal, double presenca, int projetosPropostos,
			int projetosAprovados) {
		super(anoInicial, anoFinal);
		this.presenca = presenca;
		this.projetosPropostos = projetosPropostos;
		this.projetosAprovados = projetosAprovados;
	}

	@Override
	public double avaliar() {
		double avaliacaoProjetos = (projetosAprovados / (double) projetosPropostos) * PESO_PROJETOS;
		double avaliacaoPresenca = presenca * PESO_PRESENCA;
		
		setAvaliacao(avaliacaoProjetos + avaliacaoPresenca + avaliarDenuncias() + contabilizarAvaliacaoEleitores());
		return getAvaliacao();
	}

	public double getPresenca() {
		return presenca;
	}

	public void setPresenca(double presenca) {
		this.presenca = presenca;
	}

	public int getProjetosPropostos() {
		return projetosPropostos;
	}

	public void setProjetosPropostos(int projetosPropostos) {
		this.projetosPropostos = projetosPropostos;
	}

	public int getProjetosAprovados() {
		return projetosAprovados;
	}

	public void setProjetosAprovados(int projetosAprovados) {
		this.projetosAprovados = projetosAprovados;
	}
	
	@Override
	public String toString() {
		return "[Legislativo] " + super.toString();
	}

}
