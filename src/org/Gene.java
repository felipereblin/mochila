package org;

public class Gene {
	public String id;
	public int peso;
	public int ponto;

	public Gene(String id, int peso, int ponto) {
		super();
		this.id = id;
		this.peso = peso;
		this.ponto = ponto;
	}

	public Gene() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getPonto() {
		return ponto;
	}

	public void setPonto(int ponto) {
		this.ponto = ponto;
	}

}