package com.entreprise.compta;

public class Facture implements Payable{
	private String numero;
	private String fournisseur;
	private double montant;
	
	public Facture(String numero, String fournisseur, double montant) {
		this.fournisseur = fournisseur;
		this.montant = montant;
		this.numero = numero;
	}
	
	@Override
	public double getMontantAPayer() {
		return montant;
	}
	
	public String toString() {
		return "F-"+numero+"(Bureau Plus) : "+montant; 
	}
}