package com.entreprise.rh;

import com.entreprise.compta.Payable;
import com.entreprise.exceptions.MontantInvalideException;

public abstract class Employe implements Payable, Comparable<Employe>{
	protected String matricule, nom;
	protected String agence = "Casblance";
	private static int nbEmploye = 0;
	
	public Employe(String nom) {
		this.nom = nom;
		nbEmploye++;
	}
	
	public Employe(String nom, String agence, String matricule) {
		this.nom = nom;
		this.matricule = "E" + nbEmploye;
		this.agence = agence;
		nbEmploye++;
	}
	
	public abstract String getPoste();
	
	public abstract double getSalaire();
	
	@Override
	public double getMontantAPayer() {
		return this.getSalaire();
	}
	
	public int compareTo(Employe autre) {
		return Double.compare(getSalaire(), autre.getSalaire());
	}
	
	public boolean estMieuxQue(Employe autre) {
		return this.compareTo(autre) > 0;
	}
	
	public static int getNbEmploye() {
		return nbEmploye;
	}
	
	@Override
	public String toString() {
		return "matricule="+matricule+", nom="+nom+", agence="+agence;
	}

	public void augmenter(double taux) throws MontantInvalideException {
		// TODO Auto-generated method stub
		
	}
}