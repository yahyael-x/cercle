package TP2;

public class Point {
	public double abscisse;
	public double ordonnee;
	public String couleur="noir";
	
	public Point() {
		this.abscisse=abscisse;
		this.ordonnee=ordonnee;
	}
	public Point(double abscisse,double ordonnee) {
		this.abscisse=abscisse;
		this.ordonnee=ordonnee;
		this.couleur="noir";
	}
	public void mon_etat() {
		System.out.println("abscisse:"+abscisse+"ordonnee:"+ordonnee+"couleur:"+couleur);
	}
	public double distance(Point p) {
		return Math.sqrt((abscisse-p.abscisse)*(abscisse-p.abscisse)+(ordonnee-p.ordonnee)*(ordonnee-p.ordonnee));
	}
}
