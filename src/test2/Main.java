package test2;

import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
	{
/*		ObjectOutputStream out1 = null;
		try {
			out1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Joueurs.dat"))));
			out1.writeObject(new ArrayList<Joueur>());
			out1.close();
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream out2 = null;
		try {
			out2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Parties.dat"))));
			out2.writeObject(new ArrayList<Partie>());
			out2.close();
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	new Jeu("Questions.txt","Joueurs.dat","Parties.dat");
		//Jeu jeu = new Jeu("Questions-Reponses_TP2.txt","Joueurs.dat","Parties.dat");
		//new Fenetre_Plateau(null,null,null,1);
/*		String[] propos = {"cdsccccccccccccccccccccccccccccc","dsssssssssssssssssssssssssssssssssssssssssssssssssssssssss","aacccccccccccccccccccccccccccccccccccccccccccc"};
		new Fenetre_question(new Question("<culture>", "question dcdddddddddddddddddddddddddddddddddddddddddddddddddd", "reponse ddddddddddddddddsssssssssssssssssccccc", propos));
	*/}
}