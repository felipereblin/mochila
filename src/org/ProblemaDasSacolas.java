package org;

import java.util.LinkedList;
import java.util.Random;

public class ProblemaDasSacolas {

	public int qtd_sacolas;
	public int qtd_itens;

	public int[] pesos_possiveis;
	public int capacidades;

	Random rand = new Random();

	public LinkedList<Item> sacolas = new LinkedList<>();
	public LinkedList<Gene> itens = new LinkedList<>();

	public ProblemaDasSacolas(int qtd_sacolas, int qtd_itens, int[] pesos_possiveis, int capacidades) {
		super();
		this.qtd_sacolas = qtd_sacolas;
		this.qtd_itens = qtd_itens;
		this.pesos_possiveis = pesos_possiveis;
		this.capacidades = capacidades;
		inicializar();
	}

	private void inicializar() {
		LinkedList<Integer> capacidades_temp = new LinkedList<>();
		for (int i = 0; i < capacidades; i++)
			capacidades_temp.add(capacidades);
		for (int i = 0; i < qtd_sacolas; i++)
			sacolas.add(new Item(capacidades_temp.remove(rand.nextInt(capacidades - i))));
		for (int i = 0; i < qtd_itens; i++) {
			itens.add(new Gene(i, pesos_possiveis[rand.nextInt(pesos_possiveis.length)]));
		}
	}

	public static void main(String[] args) {

		int[] pesos_possiveis = { 15, 3, 2, 5, 9, 20 };
		int capacidades = 30;
		int qtd_sacolas = 1;
		int qtd_itens = 6;

		Random rand = new Random();
		System.out.println(rand.nextInt(10));
		ProblemaDasSacolas problema = new ProblemaDasSacolas(qtd_sacolas, qtd_itens, pesos_possiveis, capacidades);
		System.out.println(problema.itens);

		for (int i = 0; i < problema.qtd_sacolas; i++) {
			System.out.println(problema.sacolas.get(i).capacidade);
		}
	}
}