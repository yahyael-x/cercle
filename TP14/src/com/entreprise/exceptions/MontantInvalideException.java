package com.entreprise.exceptions;

public class MontantInvalideException extends Exception{
	private double valeur;
	
	public MontantInvalideException(String champ, double valeur){
		super(champ + "invalid: "+ valeur);
		this.valeur = valeur;
	}
	
	public double getValaur() {
		return valeur;
	}
}