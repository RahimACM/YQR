package test2;

import java.io.*;
import java.util.*;

public class Jeu{
	public static ArrayList<Joueur> joueurs;
	public static ArrayList<Partie> parties;
	public static String nom_fichier_questions;
	public static String nom_fichier_joueurs;
	public static String nom_fichier_parties;
	
	public Jeu(String nom_fichier1, String nom_fichier2 ,String nom_fichier3)
	{
		nom_fichier_questions = nom_fichier1;
		nom_fichier_joueurs = nom_fichier2;
		nom_fichier_parties = nom_fichier3;
		joueurs = new ArrayList<Joueur>();
		parties = new ArrayList<Partie>();
		ObjectInputStream file_Games_lire = null;
		ObjectInputStream file_players_lire = null;
		try{
			file_Games_lire = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(nom_fichier_parties))));
			parties = (ArrayList<Partie>) file_Games_lire.readObject();
			file_Games_lire.close();
		}
		catch(FileNotFoundException ex){  ex.printStackTrace(); }
		catch (ClassNotFoundException ex){ ex.printStackTrace(); }
		catch (IOException ex){ ex.printStackTrace(); }
		
		try{
			file_players_lire = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(nom_fichier_joueurs))));
			joueurs = (ArrayList<Joueur>) file_players_lire.readObject();
	   	 	file_players_lire.close();	 	
		}
		catch(FileNotFoundException ex){  ex.printStackTrace(); }
		catch(IOException ex){ ex.printStackTrace(); }
		catch(ClassNotFoundException ex) { ex.printStackTrace(); }
			
		try {
			new Acceuil();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Joueur rechercher_joueur(String joueur)
	{
		Iterator<Joueur> it = joueurs.iterator();
		Joueur joueur_courant = null;
		boolean trouv = false;
		while(it.hasNext() && !trouv)
		{
			joueur_courant = it.next();
			if((joueur_courant.getnom()).equals(joueur)) trouv = true;
		}
		if(trouv)	return joueur_courant;
		else return null;
	}
	
	public static void Sauvegarder_joueur(Joueur j)
	{
		Joueur joueur = rechercher_joueur(j.getnom());
		if(joueur != null)	joueurs.remove(joueur);
		
		joueurs.add(j);
		ObjectOutputStream file;
		try{
			file = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(nom_fichier_joueurs))));
			file.writeObject(joueurs);
			file.close();
		}
		catch(FileNotFoundException ex){ ex.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
	}
	
	public static int Nbr_parties(){ if(parties == null) return 0; else return parties.size(); }
	
	public static void Sauvegarder_partie(Partie partie)
	{
		parties.add(partie);
		ObjectOutputStream file_games;
		try{
			file_games = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(nom_fichier_parties))));
			file_games.writeObject(parties);
			file_games.close();
		}
		catch(FileNotFoundException ex){ ex.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		Sauvegarder_joueur(partie.getjoueur(1));
		Sauvegarder_joueur(partie.getjoueur(2));
	}
	
	public static Joueur[] getscores()
	{
		Joueur[] players = new Joueur[joueurs.size()];
		for(int i = 0;i<joueurs.size();i++)	players[i] = joueurs.get(i);
		Arrays.sort(players);
		return players;
	}
}