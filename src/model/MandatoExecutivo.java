package model;

public class MandatoExecutivo extends Mandato {

	public static final double PESO_PROMESSAS_CAMPANHA = 4;

	private int promessasCampanha;
	private int promessasCumpridas;

	
	public MandatoExecutivo(int anoInicial, int anoFinal, int promessasCampanha, int promessasCumpridas) {
		super(anoInicial, anoFinal);
		this.promessasCampanha = promessasCampanha;
		this.promessasCumpridas = promessasCumpridas;
	}

	@Override
	public double avaliar() {
		double avaliacaoPromessasCampanha = (promessasCumpridas / (double) promessasCampanha) * PESO_PROMESSAS_CAMPANHA;
		
		setAvaliacao(avaliacaoPromessasCampanha + avaliarDenuncias() + contabilizarAvaliacaoEleitores());
		return getAvaliacao();
	}

	public int getPromessasCampanha() {
		return promessasCampanha;
	}

	public void setPromessasCampanha(int promessasCampanha) {
		this.promessasCampanha = promessasCampanha;
	}

	public int getPromessasCumpridas() {
		return promessasCumpridas;
	}

	public void setPromessasCumpridas(int promessasCumpridas) {
		this.promessasCumpridas = promessasCumpridas;
	}
	
	@Override
	public String toString() {
		return "[Executivo] " + super.toString();
	}

}
