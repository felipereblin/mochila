package org;

import java.util.LinkedList;

public class Individuo implements Comparable<Individuo> {
	public int qtd_cromossomos;
	public double aptidao;
	public LinkedList<Gene> genes = new LinkedList<>();
	public LinkedList<Item> cromossomos = new LinkedList<>();

	public Individuo(int qtd_cromossomos) {
		super();
		this.qtd_cromossomos = qtd_cromossomos;
	}

	@Override
	public int compareTo(Individuo individuo) {
		if (aptidao > individuo.aptidao)
			return -1;
		if (aptidao < individuo.aptidao)
			return 1;
		return 0;
	}

	public String toString() {
		return "Aptidão: " + aptidao;
	}
}
