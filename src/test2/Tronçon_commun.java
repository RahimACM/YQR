package test2;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Tronçon_commun implements Serializable{
	private transient Case_commune[] cases;

	public Tronçon_commun(Partie partie)
	{
		cases = new Case_commune[21];
		Random random = new Random();
		for(int i=0;i<cases.length;i++)
		{
			Domaine domaine = Domaine.values()[random.nextInt(7)];
			cases[i] = new Case_commune(partie,50,25,22+i, domaine);
		}
	}
	
	public void Afficher(Fenetre_Plateau fenetre)
	{
		for(int i=0;i<cases.length;i++)	cases[i].Afficher(fenetre);
	}

	public void setEnabled() {	for(int i=0;i<cases.length;i++)	cases[i].setEnabled();	}
	public void setDisabled(){ 	for(int i=0;i<cases.length;i++)	cases[i].setDisabled();	}
	public void setEnabled(int i)	{	if((i>=22) && (i<=42))	cases[i-22].setEnabled();	}
	public void setDisabled(int i) 	{	if((i>=22) && (i<=42))	cases[i-22].setDisabled();	}

	public void Colorer(int i,Color couleur){	if((i>=22) && (i<=42))	cases[i-22].Colorer(couleur);	}
	public void Supprimer_couleur(int i){	if((i>=22) && (i<=42))	cases[i-22].Supprimer_couleur();	}

	public Case getcase(int num){ return cases[num-22]; }
}