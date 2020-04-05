package org;

import java.util.LinkedList;

public class Item {
	public int capacidade;
	public LinkedList<Gene> genes = new LinkedList<>();

	public Item(int capacidade) {
		super();
		this.capacidade = capacidade;
	}

	public int verificaValidade() {
		int peso_atual = 0;
		for (int i = 0; i < genes.size(); i++) {
			peso_atual += genes.get(i).peso;
			if (peso_atual > capacidade)
				return -1;
		}
		return peso_atual;
	}
}
