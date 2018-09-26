package main;

import java.util.ArrayList;
import java.util.List;

import model.MandatoExecutivo;
import model.MandatoLegislativo;
import model.Partido;
import model.Politico;

public class Avaliador {

	private List<Politico> politicos;
	private List<Partido> partidos;

	public Avaliador() {
		cadastrarPartidos();
		cadastrarPoliticos();
	}

	public static void main(String[] args) {

		Avaliador avaliador = new Avaliador();

		avaliador.avaliarPoliticos();
		avaliador.avaliarPartidos();
	}

	public void avaliarPoliticos() {
		System.out.println("=== AVALIANDO POLÍTICOS ===\n");

		politicos.forEach(politico -> {
			politico.avaliarMandatos();
			System.out.println("=> " + politico.toString());
			System.out.println();
		});

		System.out.println();
	}

	public void avaliarPartidos() {
		System.out.println("### AVALIANDO PARTIDOS ###\n");

		partidos.forEach(partido -> {
			partido.avaliar();
			System.out.println("#> " + partido.toString());
			System.out.println();
		});

		System.out.println();
	}

	private void cadastrarPartidos() {
		partidos = new ArrayList<>();
		partidos.add(new Partido("Partido do Código Aberto"));
		partidos.add(new Partido("Partido do Software Corporativo"));
		partidos.add(new Partido("Partido do Programadores Cientistas"));
	}

	private void cadastrarPoliticos() {
		politicos = new ArrayList<>();

		politicos.add(cadastrarAdaLovelace());
		politicos.add(cadastrarLinusTorvalds());
		politicos.add(cadastrarBillGates());
		
		politicos.add(cadastrarMargaretHamilton());
		politicos.add(cadastrarRichardStallman());
		politicos.add(cadastrarJamesGosling());
	}

	private Politico cadastrarAdaLovelace() {
		Politico ada = new Politico("Ada Lovelace", this.partidos.get(2));

		MandatoLegislativo leg1 = new MandatoLegislativo(2011, 2014, 0.9, 8, 8);
		leg1.incluirAvaliacaoEleitor("00186371276", 9);
		leg1.incluirAvaliacaoEleitor("91254112032", 10);
		
		MandatoLegislativo leg2 = new MandatoLegislativo(2015, 2018, 0.93, 43, 37);
		leg2.incluirAvaliacaoEleitor("00186371276", 8);
		leg2.incluirAvaliacaoEleitor("91254112032", 10);

		ada.adicionarMandato(leg1);
		ada.adicionarMandato(leg2);
		return ada;
	}

	private Politico cadastrarMargaretHamilton() {
		Politico ada = new Politico("Margaret Hamilton", this.partidos.get(2));

		MandatoLegislativo leg1 = new MandatoLegislativo(1995, 1998, 1, 12, 4);
		leg1.incluirAvaliacaoEleitor("00186371276", 9);
		leg1.incluirAvaliacaoEleitor("91254112032", 8);

		MandatoExecutivo exec = new MandatoExecutivo(2011, 2014, 22, 17);
		exec.incluirAvaliacaoEleitor("00186371276", 8);
		exec.incluirAvaliacaoEleitor("91254112032", 8);
		
		MandatoLegislativo leg3 = new MandatoLegislativo(2015, 2018, 0.98, 14, 14);
		leg3.incluirAvaliacaoEleitor("00186371276", 8);
		leg3.incluirAvaliacaoEleitor("91254112032", 10);

		ada.adicionarMandato(leg1);
		ada.adicionarMandato(exec);
		ada.adicionarMandato(leg3);
		return ada;
	}

	private Politico cadastrarLinusTorvalds() {
		Politico linus = new Politico("Linus Torvalds", this.partidos.get(0));

		MandatoLegislativo leg = new MandatoLegislativo(2011, 2014, 0.6, 29, 18);
		leg.incluirAvaliacaoEleitor("00186371276", 8);
		leg.incluirAvaliacaoEleitor("91254112032", 8);
				
		MandatoExecutivo exec = new MandatoExecutivo(2015, 2018, 48, 33);
		exec.incluirAvaliacaoEleitor("00186371276", 9);
		exec.incluirAvaliacaoEleitor("91254112032", 6);

		linus.adicionarMandato(leg);
		linus.adicionarMandato(exec);
		return linus;
	}

	private Politico cadastrarRichardStallman() {
		Politico stallman = new Politico("Richard Stallman", this.partidos.get(0));

		MandatoLegislativo leg = new MandatoLegislativo(2011, 2014, 0.8, 35, 27);
		leg.incluirAvaliacaoEleitor("00186371276", 9);
		leg.incluirAvaliacaoEleitor("91254112032", 4);

		stallman.adicionarMandato(leg);
		return stallman;
	}

	private Politico cadastrarBillGates() {
		Politico bill = new Politico("Bill Gates", this.partidos.get(1));

		MandatoExecutivo exec1 = new MandatoExecutivo(2011, 2014, 22, 18);
		exec1.adicionarDenuncia();
		exec1.adicionarDenuncia();
		exec1.incluirAvaliacaoEleitor("00186371276", 7);
		exec1.incluirAvaliacaoEleitor("91254112032", 6);
		
		MandatoExecutivo exec2 = new MandatoExecutivo(2015, 2018, 27, 20);
		exec1.adicionarDenuncia();
		exec1.adicionarDenuncia();
		exec2.incluirAvaliacaoEleitor("00186371276", 8);
		exec2.incluirAvaliacaoEleitor("91254112032", 7);

		bill.adicionarMandato(exec1);
		bill.adicionarMandato(exec2);
		return bill;
	}

	private Politico cadastrarJamesGosling() {
		Politico gosling = new Politico("James Gosling", this.partidos.get(1));

		MandatoLegislativo leg = new MandatoLegislativo(2011, 2014, 1, 8, 7);
		leg.incluirAvaliacaoEleitor("00186371276", 8);
		leg.incluirAvaliacaoEleitor("91254112032", 7);
		
		MandatoExecutivo exec = new MandatoExecutivo(2015, 2018, 32, 28);
		exec.incluirAvaliacaoEleitor("00186371276", 8);
		exec.incluirAvaliacaoEleitor("91254112032", 9);

		gosling.adicionarMandato(leg);
		gosling.adicionarMandato(exec);
		return gosling;
	}

}
