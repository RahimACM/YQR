package test2;

import java.io.Serializable;

public class Question implements Serializable{
	private Domaine domaine;
	private String question;
	private String reponse;
	private String[] propos = new String[3];
	
	public Question(String domaine,String question,String reponse,String[] propos)
	{
		if(domaine.equals("<Science>"))		this.domaine = Domaine.Science;
		if(domaine.equals("<Histoire>"))	this.domaine = Domaine.Histoire;
		if(domaine.equals("<Geographie>"))	this.domaine = Domaine.Géographie;
		if(domaine.equals("<Sport>"))		this.domaine = Domaine.Sport;
		if(domaine.equals("<Musique>"))		this.domaine = Domaine.Musique;
		if(domaine.equals("<Cinema>"))		this.domaine = Domaine.Cinema;
		if(domaine.equals("<CultureGenerale>"))		this.domaine = Domaine.Culture_generale;	
		this.question = question;
		this.reponse = reponse;
		for(int i=0;i<(this.propos).length;i++)	(this.propos)[i] = propos[i];
	}
	
	public Domaine getdomaine(){ return domaine; }
	public String getquestion(){ return question; }
	public String getreponse(){ return reponse; }
	public String[] getpropos(){ return propos; }
}