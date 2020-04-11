package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BagSolver {

	public void startProblem(List<Gene> itens, List<String> populations, int maxWeight) {
		boolean continueRun = true;
		int count = 1;

		List<Gene> itensMochila = computeFitness(populations, itens, maxWeight);
		List<Gene> best = getBestPopulation(itensMochila);
		List<Gene> newPopulation = generateNewPopulation(best);

		
		while (continueRun) {

			itensMochila = computeFitness(maxWeight, newPopulation, itens);
			best = getBestPopulation(itensMochila);
			newPopulation = generateNewPopulation(best);

			continueRun = continueRunning(count, best.get(0), itens);
			count++;
		}
	}


	public List<Gene> computeFitness(List<String> populations, List<Gene> itens, int maxWeight) {
		List<Gene> itensMochila = new ArrayList<Gene>();
		int pontos;
		int peso;

		for (String population : populations) {
			pontos = 0;
			peso = 0;

			int i = 0;
			for (char c : population.toCharArray()) {
				if (c == '1') {
					peso = peso + itens.get(i).getPeso();
					pontos = pontos + itens.get(i).getPonto();
				}
				i++;
			}

			if (peso <= maxWeight) {
				Gene gene = new Gene();
				gene.setId(population);
				gene.setPeso(peso);
				gene.setPonto(pontos);
				itensMochila.add(gene);
			}
		}
		return itensMochila;
	}
	
	public List<Gene> computeFitness(int maxWeight, List<Gene> populations, List<Gene> itens) {
		List<Gene> itensMochila = new ArrayList<Gene>();
		int pontos;
		int peso;

		for (Gene population : populations) {
			pontos = 0;
			peso = 0;

			int i = 0;
			for (char c : population.getId().toCharArray()) {
				if (c == '1') {
					peso = peso + itens.get(i).getPeso();
					pontos = pontos + itens.get(i).getPonto();
				}
				i++;
			}

			if (peso <= maxWeight) {
				Gene gene = new Gene();
				gene.setId(population.getId());
				gene.setPeso(peso);
				gene.setPonto(pontos);
				itensMochila.add(gene);
			}
		}
		return itensMochila;
	}


	private List<Gene> getBestPopulation(List<Gene> itensMochila) {
		List<Gene> bestPopulation = new ArrayList<Gene>();
		int best = 0;
		Gene position1 = new Gene();
		int secondBest = 0;
		Gene position2 = new Gene();
		for (Gene item : itensMochila) {
			if (best != 0 && best < item.getPonto()) {
				secondBest = best;
				position2 = position1;
			}
			if (best < item.getPonto()) {
				best = item.getPonto();
				position1 = item;
			} else if (secondBest < item.getPonto()) {
				secondBest = item.getPonto();
				position2 = item;
			}
		}

		bestPopulation.add(position1);
		bestPopulation.add(position2);

		return bestPopulation;
	}

	private List<Gene> generateNewPopulation(List<Gene> best) {
		List<Gene> newPopulation = new ArrayList<Gene>();
		newPopulation.addAll(best);

		String gene1 = "";
		String  gene2 = "";

		for (int i = 0; i < 6; i++) {
			gene1 = gene1 + best.get(new Random().nextInt(2)).getId().charAt(i);
		}

		for (int i = 0; i < 6; i++) {
			gene2 = gene2 + best.get(new Random().nextInt(2)).getId().charAt(i);

		}

		newPopulation.add(new Gene(gene1));
		newPopulation.add(new Gene(gene2));
		return newPopulation;
	}
	
	private boolean continueRunning(int count, Gene gene, List<Gene> itens) {
		
		if(count == 100 || gene.getPonto() >= 40) {
			
			System.out.println("O sistema rodou " + count + " vezes e a melhor pontuação foi de " + gene.getPonto());
			System.out.println("##################################################################");
			System.out.println("População: " + gene.getId());
			System.out.println("Pontos: " + gene.getPonto());
			System.out.println("Peso: " + gene.getPeso());
			System.out.println("Itens: " + showItens(gene, itens));
			System.out.println("##################################################################");
			return false;
		}
		
		return true;
	}


	private String showItens(Gene gene, List<Gene> itens) {
		String itensSelecionados = "| ";
		int i = 0;
		
		for (char c : gene.getId().toCharArray()) {
			if (c == '1') {
				itensSelecionados = itensSelecionados + itens.get(i).getId() + " | ";
			}
			i++;
		}
		return itensSelecionados;
	}

}
