package test2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.swing.JOptionPane;

public class Partie implements Serializable{
	private int num_seq;
	private Joueur j1;
	private Joueur j2;
	private int tour_de_role;
	private transient Fenetre_Plateau fenetre;
	private TreeMap<Domaine,ArrayList<Question>> questions;
	private boolean tour_fini = true;
	private boolean duel_gagne = false;
	private boolean partie_finie = false;
	
	public Partie(String nom_fichier_questions,int nbr_parties,Joueur j1,Joueur j2)
	{
		num_seq = nbr_parties+1;
		this.j1 = j1;
		this.j2 = j2;
		Charger_questions(nom_fichier_questions);
		try {
			fenetre = new Fenetre_Plateau(this, j1, j2, Designer_commencant());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j1.setnum_case(1);
		j2.setnum_case(1);
		Jeu.Sauvegarder_partie(this);		
	}
	
	public void Charger_questions(String nom_fichier)
	{
		BufferedReader file_questions_lire;
		try {
			questions = new TreeMap<Domaine,ArrayList<Question>>();
			file_questions_lire = new BufferedReader(new FileReader(nom_fichier));
			ArrayList<Question> science = new ArrayList<Question>();
			ArrayList<Question> histoire = new ArrayList<Question>();
			ArrayList<Question> geographie = new ArrayList<Question>();
			ArrayList<Question> sport = new ArrayList<Question>();
			ArrayList<Question> musique = new ArrayList<Question>();
			ArrayList<Question> cinema = new ArrayList<Question>();
			ArrayList<Question> culture_generale = new ArrayList<Question>();
			String ligne,domaine,quest,rep,propo1,propo2,propo3;
			StringTokenizer morceaux;
			Question question;
			while((ligne = file_questions_lire.readLine()) != null)
			{
				morceaux = new StringTokenizer(ligne,";");
				domaine = morceaux.nextToken();
				quest = morceaux.nextToken();
				rep = morceaux.nextToken();
				propo1 = morceaux.nextToken();
				propo2 = morceaux.nextToken();
				propo3 = morceaux.nextToken();
				String[] propos = {propo1,propo2,propo3};
				question = new Question(domaine, quest, rep, propos);
				if(domaine.equals("<Science>"))		science.add(question);
				if(domaine.equals("<Histoire>"))	histoire.add(question);
				if(domaine.equals("<Geographie>"))	geographie.add(question);
				if(domaine.equals("<Sport>"))		sport.add(question);
				if(domaine.equals("<Musique>"))		musique.add(question);
				if(domaine.equals("<Cinema>"))		cinema.add(question);
				if(domaine.equals("<CultureGenerale>"))		culture_generale.add(question);	
			}
			questions.put(Domaine.Science,science);
			questions.put(Domaine.Histoire,histoire);
			questions.put(Domaine.Géographie,geographie);
			questions.put(Domaine.Sport,sport);
			questions.put(Domaine.Musique,musique);
			questions.put(Domaine.Cinema,cinema);
			questions.put(Domaine.Culture_generale,culture_generale);
			file_questions_lire.close();
		}
		catch (FileNotFoundException e){ e.printStackTrace(); }
		catch (IOException e){ e.printStackTrace(); }
	}
	
	public int Designer_commencant()
	{
		tour_de_role = new Random().nextInt(2)+1;
		return tour_de_role;
	}
	
	public void Arret()
	{
		partie_finie = true;
		JOptionPane.showMessageDialog(null, "\t\tFélicitation "+getjoueur(getTour_de_role()).getnom()+" !\nVous avez gagné cette partie contre "+getjoueur(getTour_de_role()%2+1).getnom()+" et avec un score de : "+getjoueur(getTour_de_role()).getScore());
		int i = JOptionPane.showConfirmDialog(null, "Est-ce-que vous voulez sauvegarder cette partie ?", "Sauvegarde_partie", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION)	Jeu.Sauvegarder_partie(this);
		fenetre.fenetre.hide();
	}
	
	public Question getquestion(Domaine domaine)
	{
		ArrayList<Question> quest = questions.get(domaine);	
		if(quest.size()==0)	return null;
		else	return quest.remove(new Random().nextInt(quest.size()));
	}
	
	public Case getcase(int joueur_ordre,int i){ return fenetre.getcase(joueur_ordre, i); }
	public void setCase(int joueur_ordre,int num){ fenetre.setcase(joueur_ordre, num); }

	public int getTour_de_role() { return tour_de_role; }
	public void setTour_de_role(int tour_de_role)
	{
		this.tour_de_role=tour_de_role;
		fenetre.setTour_de_role(tour_de_role);
	}

	public Joueur getjoueur(int i){ return (i==1)?j1:j2; }

	public void setscore(int joueur,int score){ fenetre.setscore(joueur, score); }

	public void setTour_fini(boolean tour_fini){ this.tour_fini = tour_fini; }

	public Fenetre_Plateau getfenetre(){ return fenetre; }

	public void lancer_duel(int challenger)
	{
		JOptionPane.showMessageDialog(null, "Un duel est lancé !! Preparez vous");
		try {
			new Fenetre_duel(this, challenger);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void challenge_perdu(int challenger)
	{
		setCase(getTour_de_role(), getjoueur(challenger).getnum_case());
		setTour_de_role(getTour_de_role()%2+1);
		setTour_fini(true);
	}
	
	public void challenge_gagne(int challenger)
	{
		setCase(getTour_de_role(), getjoueur(challenger%2+1).getnum_case());
		duel_gagne = true;
		setTour_de_role(getTour_de_role());
		setTour_fini(true);
	}
	
	public boolean isDuel_gagne(){ return duel_gagne; }
	public void setDuel_gagne(boolean duel_gagne){ this.duel_gagne = duel_gagne; }
	
	public boolean isTour_fini(){ return tour_fini; }

	public int getNum_seq(){ return num_seq; }

	public void setFenetre(Fenetre_Plateau fenetre){ this.fenetre = fenetre; }

	public boolean isPartie_finie() { return partie_finie; }
}