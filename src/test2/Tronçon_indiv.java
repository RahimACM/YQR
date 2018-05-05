package test2;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Tronçon_indiv implements Serializable{
	private transient Case_individuelle[] cases;

	public Tronçon_indiv(int ordre,Partie partie)
	{
		cases = new Case_individuelle[21];
		Random random = new Random();
		for(int i=0;i<cases.length;i++)
		{
			Domaine domaine = Domaine.values()[random.nextInt(7)];
			cases[i] = new Case_individuelle(partie,ordre,50,30,i+1,domaine);
		}
	}
	
	public void Afficher(Fenetre_Plateau fenetre)
	{
		for(int i=0;i<cases.length;i++)	cases[i].Afficher(fenetre);
	}
	
	public void setEnabled() {	for(int i=0;i<cases.length;i++)	cases[i].setEnabled();	}
	public void setDisabled(){ 	for(int i=0;i<cases.length;i++)	cases[i].setDisabled();	}
	public void setEnabled(int i)	{	if((i>=1) && (i<=21))	cases[i-1].setEnabled();	}
	public void setDisabled(int i) 	{	if((i>=1) && (i<=21))	cases[i-1].setDisabled();	}

	public void Colorer(int i,Color couleur){	if((i>=1) && (i<=21))	cases[i-1].Colorer(couleur);	}
	public void Supprimer_couleur(int i){	if((i>=1) && (i<=21))	cases[i-1].Supprimer_couleur();	}

	public Case getcase(int num){ return cases[num-1]; }
}