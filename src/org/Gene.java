package org;

public class Gene {
	public int id;
	public int peso;

	public Gene(int id, int peso) {
		super();
		this.id = id;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "(Item: " + id + ", Peso: " + peso + ")";
	}
}