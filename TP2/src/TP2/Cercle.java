package TP2;
import TP2.Point;

public class Cercle {
	public Point centre;
	public double rayon;
	public String couleur="noir";
	public static int nbCercle=0;
	
	public Cercle() {
		this.centre=new Point(0,0);
		this.rayon=1;
		this.couleur="noir";
		nbCercle++;
	}
	
	public Cercle(Point centre,double rayon) {
		this.centre=centre;
		this.rayon=rayon;
		this.couleur=couleur;
		nbCercle++;
	}
	public Cercle(double x,double y,double rayon,String couleur ) {
		this.centre=new Point(x,y);
		this.rayon=rayon;
		this.couleur=couleur;
		nbCercle++;
	}
	public void mon_etat() {
		System.out.println(" cercle [centre= "+centre.abscisse+" , "+centre.ordonnee+") , rayon= "+rayon+" couleur=  "+couleur);
	}
	public double getPerimetre() {
		return 2*Math.PI;
	}
	public double getSurface() {
		return Math.PI*rayon*rayon;
	}
	public void deplacer(double dx,double dy) {
		centre.abscisse+=dx;
		centre.ordonnee+=dy;
	}
	public void deplacer(Point nouveauCentre) {
		this.centre=nouveauCentre;
	}
	public boolean estPlusGrandQue(Cercle autre) {
		return this.getSurface()>autre.getSurface();
	} 
	public static int getNbCercle() {
		return nbCercle;
	}
}
