package TP2;
import TP2.Point;
public class Program {

	public static void main(String[] args) {
		Point o=new Point(2,3);
		
		Cercle c1=new Cercle();
		Cercle c2=new Cercle(o,4);
		Cercle c3=new Cercle(-1,5,2.5,"bleu");
		
		c1.deplacer(3,-1);
		
		c1.mon_etat();
		c2.mon_etat();
		c3.mon_etat();
		System.out.println("perimetre de c2: "+c2.getPerimetre());
		System.out.println("surface de c2: "+c2.getSurface());
		System.out.println("o est dans c3? "+c2.estPlusGrandQue(c3));
		System.out.println("nombre de cercle cree: "+Cercle.getNbCercle());
		

	}

}
