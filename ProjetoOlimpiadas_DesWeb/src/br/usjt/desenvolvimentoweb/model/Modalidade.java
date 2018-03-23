package br.usjt.desenvolvimentoweb.model;

import java.util.ArrayList;

public class Modalidade {
	private int idModalidade;
	private String nome;
	private Estacao tipo;
	private ArrayList<Olimpiada> olimpiadas;
	
	public Modalidade() {}
	
	public Modalidade(int idModalidade, String nome, Estacao tipo) {
		super();
		this.idModalidade = idModalidade;
		this.nome = nome;
		this.tipo = tipo;
		olimpiadas = new ArrayList<>();
	}

	public int getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(int idModalidade) {
		this.idModalidade = idModalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estacao getTipo() {
		return tipo;
	}

	public void setTipo(Estacao tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Modalidade [id= " + idModalidade + ", nome= " + nome + ", estação= " + tipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idModalidade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modalidade other = (Modalidade) obj;
		if (idModalidade != other.idModalidade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	
	
	
	
	
}
