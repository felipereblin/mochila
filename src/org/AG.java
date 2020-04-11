package org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AG {
	public static void main(String[] args) {

		Gene gene1 = new Gene("Saco de dormir", 15, 15);
		Gene gene2 = new Gene("Corda", 3, 7);
		Gene gene3 = new Gene("Canivete", 2, 10);
		Gene gene4 = new Gene("Tocha", 5, 5);
		Gene gene5 = new Gene("Garrafa", 9, 8);
		Gene gene6 = new Gene("Comida", 20, 17);

		List<Gene> itens = new ArrayList<Gene>();

		itens.add(gene1);
		itens.add(gene2);
		itens.add(gene3);
		itens.add(gene4);
		itens.add(gene5);
		itens.add(gene6);

		List<String> populations = new ArrayList<String>();
		populations.add("100110");
		populations.add("001110");
		populations.add("010100");
		populations.add("011001");

		int maxWeight = 30;

		BagSolver bagSolver = new BagSolver();
		bagSolver.startProblem(itens, populations, maxWeight);
	}
}