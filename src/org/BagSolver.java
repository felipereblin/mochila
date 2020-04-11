package org;

import java.util.ArrayList;
import java.util.List;

public class BagSolver {

	public void startProblem(List<Gene> itens, List<String> populations, int maxWeight) {
		List<Gene> itensMochila = computeFitness(populations, itens, maxWeight);
		List<Gene> best = getBestPopulation(itensMochila);
		List<Gene> newPopulation = generateNewPopulation(best);
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

	private List<Gene> getBestPopulation(List<Gene> itensMochila) {
		List<Gene> bestPopulation = new ArrayList<Gene>();
		int best = 0;
		Gene position1 = new Gene();
		int secondBest = 0;
		Gene position2 = new Gene();
		for (Gene item : itensMochila) {
			if(best != 0 && best < item.getPonto()) {
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
		return null;
	}

}
