package com.entreprise.exceptions;

public class EquipeCompleteException extends RuntimeException{
	private int capacite;
	
	public EquipeCompleteException(int capacite) {
		super("équipe complet ( capacite=" + capacite + ")");
		this.capacite = capacite;
	}
	
	public int getCapacite() {
		return capacite;
	}
}