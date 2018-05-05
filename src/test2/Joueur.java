package test2;

import java.io.Serializable;

public class Joueur implements Serializable,Comparable<Joueur>{
	private String nom;
	private Domaine[] domaines = new Domaine[3];
	private int num_case;
	private int score;
	
	public String getnom(){ return nom; }
	public Domaine[] getdomaines(){ return domaines; }
	public void setnom(String nom){ this.nom = nom; }
	public void setdomaines(Domaine[] domaines)
	{
		for(int i=0;i<domaines.length;i++)	this.domaines[i] = domaines[i]; 
	}
	public int getnum_case(){ return num_case; }
	public void setnum_case(int num){ num_case = num ; }

	public int getScore() {	return score; }
	public void setScore(int score) { this.score = score; }
	
	public int compareTo(Joueur o)
	{
		if(score == o.getScore())	return 0;
		else return (score > o.getScore())?-1:1;
	}
}