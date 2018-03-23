package br.usjt.desenvolvimentoweb.model;

public class Olimpiada {
	private int idOlimpiada;
	private int ano;
	private Estacao tipo;
	private int[] ouro, prata, bronze;
	
	public Olimpiada(int idOlimpiada, int ano, int[] ouro, int[] prata, int[] bronze) {
		super();
		this.idOlimpiada = idOlimpiada;
		this.ano = ano;
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;
	}


	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int[] getOuro() {
		return ouro;
	}

	public void setOuro(int[] ouro) {
		this.ouro = ouro;
	}

	public int[] getPrata() {
		return prata;
	}

	public void setPrata(int[] prata) {
		this.prata = prata;
	}

	public int[] getBronze() {
		return bronze;
	}

	public void setBronze(int [] bronze) {
		this.bronze = bronze;
	}
	
	
	public int getIdOlimpiada() {
		return idOlimpiada;
	}

	public void setIdOlimpiada(int idOlimpiada) {
		this.idOlimpiada = idOlimpiada;
	}
	

	public Estacao getTipo() {
		return tipo;
	}


	public void setTipo(Estacao tipo) {
		this.tipo = tipo;
	}


	public int soma(int[] medalhas) {
		int total = 0;
		for(int i = 0; i < medalhas.length - 1; i++) {
			total += medalhas[i];
		}
		return total;
	}
	
}
