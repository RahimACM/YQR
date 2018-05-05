package test2;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Plateau implements Serializable{
	private Tron�on_indiv tron�on_indiv1;
	private Tron�on_indiv tron�on_indiv2;
	private Tron�on_commun tron�on_commun;
	
	public Plateau(Partie partie)
	{
		tron�on_indiv1 = new Tron�on_indiv(1,partie);
		tron�on_indiv2 = new Tron�on_indiv(2,partie);
		tron�on_commun = new Tron�on_commun(partie);
	}
	
	public void Afficher(Fenetre_Plateau fenetre)
	{
		tron�on_indiv1.Afficher(fenetre);
		tron�on_indiv2.Afficher(fenetre);
		tron�on_commun.Afficher(fenetre);
	}
	
	public void setEnabled() {	tron�on_indiv1.setEnabled(); tron�on_indiv2.setEnabled(); tron�on_commun.setEnabled();	}
	public void setDisabled(){ 	tron�on_indiv1.setDisabled(); tron�on_indiv2.setDisabled(); tron�on_commun.setDisabled();	}
	public void setEnabled(int ordre ,int i)
	{
		if(i>=22)	tron�on_commun.setEnabled(i);
		else
		{
			if(ordre == 1)	tron�on_indiv1.setEnabled(i);
			else if(ordre == 2)	tron�on_indiv2.setEnabled(i);
		}
	}
	public void setDisabled(int ordre ,int i)
	{
		if(i>=22)	tron�on_commun.setDisabled(i);
		else
		{
			if(ordre == 1)	tron�on_indiv1.setDisabled(i);
			else if(ordre == 2)	tron�on_indiv2.setDisabled(i);
		}
	}
	
	public void Colorer(int ordre ,int i,Color couleur)
	{
		if(i>=22)	tron�on_commun.Colorer(i, couleur);
		else
		{
			if(ordre == 1)	tron�on_indiv1.Colorer(i, couleur);
			else if(ordre == 2)	tron�on_indiv2.Colorer(i, couleur);
		}
	}

	public void Supprimer_couleur(int ordre ,int i)
	{
		if(i>=22)	tron�on_commun.Supprimer_couleur(i);
		else
		{
			if(ordre == 1)	tron�on_indiv1.Supprimer_couleur(i);
			else if(ordre == 2)	tron�on_indiv2.Supprimer_couleur(i);
		}
	}
	
	public Case getcase(int ordre,int num)
	{
		if(num>=22)	return tron�on_commun.getcase(num);
		else
		{
			if(ordre==1)	return tron�on_indiv1.getcase(num);
			else 	return tron�on_indiv2.getcase(num);
		}
	}
}