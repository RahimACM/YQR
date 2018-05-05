package test2;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Plateau implements Serializable{
	private Tronçon_indiv tronçon_indiv1;
	private Tronçon_indiv tronçon_indiv2;
	private Tronçon_commun tronçon_commun;
	
	public Plateau(Partie partie)
	{
		tronçon_indiv1 = new Tronçon_indiv(1,partie);
		tronçon_indiv2 = new Tronçon_indiv(2,partie);
		tronçon_commun = new Tronçon_commun(partie);
	}
	
	public void Afficher(Fenetre_Plateau fenetre)
	{
		tronçon_indiv1.Afficher(fenetre);
		tronçon_indiv2.Afficher(fenetre);
		tronçon_commun.Afficher(fenetre);
	}
	
	public void setEnabled() {	tronçon_indiv1.setEnabled(); tronçon_indiv2.setEnabled(); tronçon_commun.setEnabled();	}
	public void setDisabled(){ 	tronçon_indiv1.setDisabled(); tronçon_indiv2.setDisabled(); tronçon_commun.setDisabled();	}
	public void setEnabled(int ordre ,int i)
	{
		if(i>=22)	tronçon_commun.setEnabled(i);
		else
		{
			if(ordre == 1)	tronçon_indiv1.setEnabled(i);
			else if(ordre == 2)	tronçon_indiv2.setEnabled(i);
		}
	}
	public void setDisabled(int ordre ,int i)
	{
		if(i>=22)	tronçon_commun.setDisabled(i);
		else
		{
			if(ordre == 1)	tronçon_indiv1.setDisabled(i);
			else if(ordre == 2)	tronçon_indiv2.setDisabled(i);
		}
	}
	
	public void Colorer(int ordre ,int i,Color couleur)
	{
		if(i>=22)	tronçon_commun.Colorer(i, couleur);
		else
		{
			if(ordre == 1)	tronçon_indiv1.Colorer(i, couleur);
			else if(ordre == 2)	tronçon_indiv2.Colorer(i, couleur);
		}
	}

	public void Supprimer_couleur(int ordre ,int i)
	{
		if(i>=22)	tronçon_commun.Supprimer_couleur(i);
		else
		{
			if(ordre == 1)	tronçon_indiv1.Supprimer_couleur(i);
			else if(ordre == 2)	tronçon_indiv2.Supprimer_couleur(i);
		}
	}
	
	public Case getcase(int ordre,int num)
	{
		if(num>=22)	return tronçon_commun.getcase(num);
		else
		{
			if(ordre==1)	return tronçon_indiv1.getcase(num);
			else 	return tronçon_indiv2.getcase(num);
		}
	}
}