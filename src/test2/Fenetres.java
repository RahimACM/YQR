package test2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Fenetres {
	protected JFrame fenetre = new JFrame();

	public Fenetres() throws Exception
	{
		Theme.setTheme();
	}
	
	public ImageIcon resizeImage(int width,int height,String image, JComponent cpn)
	{
		ImageIcon imageIcon = new ImageIcon(image);
		Image newimg = imageIcon.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		return imageIcon;
	}
}


class Acceuil extends Fenetres
{
	JButton nouv_partie_button;
	JButton charg_button;
	JButton scores_button;
	JButton quit_button;
	
	public Acceuil() throws Exception
	{
		super();
		fenetre.setTitle("Acceuil");
		fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./Icons/24.png"));
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setBounds(420, 75, 450, 600);
		fenetre.getContentPane().setLayout(null);
		fenetre.setResizable(false);
		fenetre.setVisible(true);
		
		JLabel image = new JLabel();
		image.setBounds(150,100,150,150);
		image.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
		image.setIcon(resizeImage(image.getWidth(),image.getHeight(),"./Icons/24.png", image));
		fenetre.add(image);
		
		nouv_partie_button = new JButton("Nouvelle partie");
		nouv_partie_button.setBounds(125, 300, 180, 30);
		nouv_partie_button.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
		nouv_partie_button.setIcon(resizeImage(20,nouv_partie_button.getHeight(),"./Icons/26.png", nouv_partie_button));
		fenetre.add(nouv_partie_button);
		
		charg_button = new JButton("Charger");
		charg_button.setBounds(125, 360, 180, 30);
		charg_button.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
		charg_button.setIcon(resizeImage(20,nouv_partie_button.getHeight(),"./Icons/1.png", charg_button));
		fenetre.add(charg_button);
		
		scores_button = new JButton("Meilleurs scores");
		scores_button.setBounds(125, 420, 180, 30);
		scores_button.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
		scores_button.setIcon(resizeImage(20,nouv_partie_button.getHeight(),"./Icons/15.png", scores_button));
		fenetre.add(scores_button);
		
		quit_button = new JButton("Quitter");
		quit_button.setBounds(125, 480, 180, 30);
		quit_button.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
		quit_button.setIcon(resizeImage(20,nouv_partie_button.getHeight(),"./Icons/4.png", quit_button));
		fenetre.add(quit_button);
		
		nouv_partie_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Nouv_partie();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		charg_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Jeu.parties.isEmpty())	JOptionPane.showMessageDialog(null, "Il n'y a aucune partie à reprendre !","",JOptionPane.WARNING_MESSAGE);
				else
				{
					Object[] choix = new Object[Jeu.parties.size()];
					for(int i=0;i<choix.length;i++)	choix[i] = i+1;
					int j = (Integer)JOptionPane.showInputDialog(fenetre, "Choisir le numero de la partie :","Choix de partie",JOptionPane.PLAIN_MESSAGE,null,choix,1);
					Partie partie = Jeu.parties.get(j-1);
					//Partie partie = Jeu.parties.get(Jeu.parties.size()-1);
					try {
						if(partie.isPartie_finie())	JOptionPane.showMessageDialog(null, "La dernière partie enregistrée est finie !!");
						else partie.setFenetre(new Fenetre_Plateau(partie, partie.getjoueur(1), partie.getjoueur(2), 0));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		scores_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Fenetre_score(Jeu.getscores());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		quit_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fenetre.dispose();
			}
		});
	}
}

class Nouv_partie extends Fenetres
{
	JLabel j1_label;
	JButton j1_identifier;
	JButton j1_enregistrer;
	JButton j1_login;
	JTextField nom_j1;
	JButton valider_j1;
	JCheckBox domaine_j1_1;
	JCheckBox domaine_j1_2;
	JCheckBox domaine_j1_3;
	JCheckBox domaine_j1_4;
	JCheckBox domaine_j1_5;
	JCheckBox domaine_j1_6;
	JCheckBox domaine_j1_7;
	JLabel j2_label;
	JButton j2_identifier;
	JButton j2_enregistrer;
	JButton j2_login;
	JTextField nom_j2;
	JButton valider_j2;
	JCheckBox domaine_j2_1;
	JCheckBox domaine_j2_2;
	JCheckBox domaine_j2_3;
	JCheckBox domaine_j2_4;
	JCheckBox domaine_j2_5;
	JCheckBox domaine_j2_6;
	JCheckBox domaine_j2_7;
	JButton lancer;
	
	Joueur j1 = new Joueur();
	Joueur j2 = new Joueur();

	boolean enreg_j1;
	boolean enreg_j2;
	
	public Nouv_partie() throws Exception
	{
		super();
		fenetre.setTitle("Inscription et registrement");
		fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./Icons/24.png"));
		fenetre.setBounds(300,50, 800, 650);
		fenetre.getContentPane().setLayout(null);
		fenetre.setVisible(true);
		
		j1_label = new JLabel();
		j1_label.setBounds(120, 10, 100,50);
		j1_label.setText("Joueur A");
		fenetre.getContentPane().add(j1_label);
		//j1_label.set        la taille d'ecriture !!
		
		j2_label = new JLabel();
		j2_label.setBounds(550, 10, 100,50);
		j2_label.setText("Joueur B");
		fenetre.getContentPane().add(j2_label);
		//j1_label.set        la taille d'ecriture !!
		
		JLabel image1 = new JLabel();
		image1.setBounds(100,50,100,100);
		image1.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
		image1.setIcon(resizeImage(image1.getWidth(),image1.getHeight(),"./Icons/20.png", image1));
		fenetre.add(image1);
		
		JLabel image2 = new JLabel();
		image2.setBounds(500,50,100,100);
		image2.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
		image2.setIcon(resizeImage(image2.getWidth(),image2.getHeight(),"./Icons/20.png", image2));
		fenetre.add(image2);
		image2.setVisible(false);
		
		j1_identifier = new JButton("S'identifier");
		j1_identifier.setBounds(20, 160, 150, 30);
		j1_identifier.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		j1_identifier.setIcon(resizeImage(18,j1_identifier.getHeight()-5,"./Icons/21.png", j1_identifier));
		fenetre.getContentPane().add(j1_identifier);
     	
     	j1_login = new JButton("S'identifier");
		j1_login.setBounds(150, 200, 150, 30);
		j1_login.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		j1_login.setIcon(resizeImage(18,j1_identifier.getHeight()-5,"./Icons/21.png", j1_login));
		fenetre.getContentPane().add(j1_login);
		
     	j1_enregistrer = new JButton("S'enregistrer");
		j1_enregistrer.setBounds(180, 160, 150, 30);
		j1_enregistrer.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		j1_enregistrer.setIcon(resizeImage(20,j1_identifier.getHeight()-5,"./Icons/23.png", j1_enregistrer));
		fenetre.getContentPane().add(j1_enregistrer);
     	
     	j2_identifier = new JButton("S'identifier");
		j2_identifier.setBounds(420, 160, 150, 30);
		j2_identifier.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		j2_identifier.setIcon(resizeImage(20,j1_identifier.getHeight()-5,"./Icons/21.png", j2_identifier));
		fenetre.getContentPane().add(j2_identifier);
     	
     	j2_login = new JButton("S'identifier");
		j2_login.setBounds(550, 200, 150, 30);
		j2_login.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		j2_login.setIcon(resizeImage(20,j1_identifier.getHeight()-5,"./Icons/21.png", j2_login));
		fenetre.getContentPane().add(j2_login);
     	
     	j2_enregistrer = new JButton("S'enregistrer");
		j2_enregistrer.setBounds(580, 160 , 150, 30);
		j2_enregistrer.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		j2_enregistrer.setIcon(resizeImage(20,j1_identifier.getHeight()-5,"./Icons/23.png", j2_enregistrer));
		fenetre.getContentPane().add(j2_enregistrer);
		
		nom_j1 = new JTextField();
		nom_j1.setBounds(20, 200, 120, 30);
		nom_j1.setText("Nom ...");
		nom_j1.setColumns(10);
		fenetre.getContentPane().add(nom_j1);
		
		nom_j2 = new JTextField();
		nom_j2.setBounds(420, 200, 120, 30);
		nom_j2.setText("Nom ...");
		nom_j2.setColumns(10);
		fenetre.getContentPane().add(nom_j2);
		
		domaine_j1_1 = new JCheckBox("Science");
		domaine_j1_1.setBounds(20, 240, 120, 30);
		fenetre.getContentPane().add(domaine_j1_1);

		domaine_j1_2 = new JCheckBox("Histoire");
		domaine_j1_2.setBounds(20, 270, 120, 30);
		fenetre.getContentPane().add(domaine_j1_2);
		
		domaine_j1_3 = new JCheckBox("Géographie");
		domaine_j1_3.setBounds(20, 300, 120, 30);
		fenetre.getContentPane().add(domaine_j1_3);
		
		domaine_j1_4 = new JCheckBox("Sport");
		domaine_j1_4.setBounds(20, 330, 120, 30);
		fenetre.getContentPane().add(domaine_j1_4);
		
		domaine_j1_5 = new JCheckBox("Musique");
		domaine_j1_5.setBounds(20, 360, 120, 30);
		fenetre.getContentPane().add(domaine_j1_5);
		
		domaine_j1_6 = new JCheckBox("Cinéma");
		domaine_j1_6.setBounds(20, 390, 120, 30);
		fenetre.getContentPane().add(domaine_j1_6);
		
		domaine_j1_7 = new JCheckBox("Culture générale");
		domaine_j1_7.setBounds(20, 420, 120, 30);
		fenetre.getContentPane().add(domaine_j1_7);
		
		domaine_j2_1 = new JCheckBox("Science");
		domaine_j2_1.setBounds(420, 240, 120, 30);
		fenetre.getContentPane().add(domaine_j2_1);

		domaine_j2_2 = new JCheckBox("Histoire");
		domaine_j2_2.setBounds(420, 270, 120, 30);
		fenetre.getContentPane().add(domaine_j2_2);
		
		domaine_j2_3 = new JCheckBox("Geographie");
		domaine_j2_3.setBounds(420, 300, 120, 30);
		fenetre.getContentPane().add(domaine_j2_3);
		
		domaine_j2_4 = new JCheckBox("Sport");
		domaine_j2_4.setBounds(420, 330, 120, 30);
		fenetre.getContentPane().add(domaine_j2_4);
		
		domaine_j2_5 = new JCheckBox("Musique");
		domaine_j2_5.setBounds(420, 360, 120, 30);
		fenetre.getContentPane().add(domaine_j2_5);
		
		domaine_j2_6 = new JCheckBox("Cinéma");
		domaine_j2_6.setBounds(420, 390, 120, 30);
		fenetre.getContentPane().add(domaine_j2_6);
		
		domaine_j2_7 = new JCheckBox("Culture générale");
		domaine_j2_7.setBounds(420, 420, 120, 30);
		fenetre.getContentPane().add(domaine_j2_7);

		valider_j1 = new JButton("Enregistrer");
		valider_j1.setBounds(160,420, 150, 30);
		valider_j1.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		valider_j1.setIcon(resizeImage(20,j1_identifier.getHeight()-5,"./Icons/7.png", valider_j1));
		fenetre.getContentPane().add(valider_j1);
		
		valider_j2 = new JButton("Enregistrer");
		valider_j2.setBounds(560,420, 150, 30);
		valider_j2.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		valider_j2.setIcon(resizeImage(20,j1_identifier.getHeight()-5,"./Icons/7.png", valider_j2));
		fenetre.getContentPane().add(valider_j2);
				
		lancer = new JButton("Lancer le jeu");
		lancer.setBounds(325,475, 150, 70);
		lancer.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
		lancer.setIcon(resizeImage(20,j1_identifier.getHeight()-5,"./Icons/11.png",lancer));
		fenetre.getContentPane().add(lancer);

		event changement_etat=new event();
		domaine_j1_1.addItemListener(changement_etat);
		domaine_j1_2.addItemListener(changement_etat);
		domaine_j1_3.addItemListener(changement_etat);
		domaine_j1_4.addItemListener(changement_etat);
		domaine_j1_5.addItemListener(changement_etat);
		domaine_j1_6.addItemListener(changement_etat);
		domaine_j1_7.addItemListener(changement_etat);
		
		domaine_j2_1.addItemListener(changement_etat);
		domaine_j2_2.addItemListener(changement_etat);
		domaine_j2_3.addItemListener(changement_etat);
		domaine_j2_4.addItemListener(changement_etat);
		domaine_j2_5.addItemListener(changement_etat);
		domaine_j2_6.addItemListener(changement_etat);
		domaine_j2_7.addItemListener(changement_etat);				

		
		nom_j1.setVisible(false);
		valider_j1.setVisible(false);
		j1_login.setVisible(false);
		domaine_j1_1.setVisible(false);
		domaine_j1_2.setVisible(false);
		domaine_j1_3.setVisible(false);
		domaine_j1_4.setVisible(false);
		domaine_j1_5.setVisible(false);
		domaine_j1_6.setVisible(false);
		domaine_j1_7.setVisible(false);
		
		j2_label.setVisible(false);
		j2_identifier.setVisible(false);
		j2_enregistrer.setVisible(false);
		j2_login.setVisible(false);
		nom_j2.setVisible(false);
		valider_j2.setVisible(false);
		domaine_j2_1.setVisible(false);
		domaine_j2_2.setVisible(false);
		domaine_j2_3.setVisible(false);
		domaine_j2_4.setVisible(false);
		domaine_j2_5.setVisible(false);
		domaine_j2_6.setVisible(false);
		domaine_j2_7.setVisible(false);
		lancer.setVisible(false);
		
		j1_identifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				j1_identifier.setVisible(false);
				j1_enregistrer.setVisible(false);
				nom_j1.setVisible(true);
				j1_login.setVisible(true);
			}
		});
		
		j1_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nom_j1.getText().isEmpty())
				{
					Joueur joueur = Jeu.rechercher_joueur(nom_j1.getText());
					if(joueur != null)
					{
						JOptionPane.showMessageDialog(null, "On vous remercie pour votre fidélité et voici vos anciens domaines des questions\nvous pouvez soit les modifier ou les laisser et valider .","Message",JOptionPane.QUESTION_MESSAGE);
						j1.setnom(nom_j1.getText());
						nom_j1.setEnabled(false);
						j1_login.setVisible(false);
						domaine_j1_1.setVisible(true);
						domaine_j1_2.setVisible(true);
						domaine_j1_3.setVisible(true);
						domaine_j1_4.setVisible(true);
						domaine_j1_5.setVisible(true);
						domaine_j1_6.setVisible(true);
						domaine_j1_7.setVisible(true);
						Domaine[] domaines = joueur.getdomaines();
						if((domaines[0] == Domaine.Science) || (domaines[1] == Domaine.Science) || (domaines[2] == Domaine.Science))
							domaine_j1_1.setSelected(true);
						if((domaines[0] == Domaine.Histoire) || (domaines[1] == Domaine.Histoire) || (domaines[2] == Domaine.Histoire))
							domaine_j1_2.setSelected(true);
						if((domaines[0] == Domaine.Géographie) || (domaines[1] == Domaine.Géographie) || (domaines[2] == Domaine.Géographie))
							domaine_j1_3.setSelected(true);
						if((domaines[0] == Domaine.Sport) || (domaines[1] == Domaine.Sport) || (domaines[2] == Domaine.Sport))
							domaine_j1_4.setSelected(true);
						if((domaines[0] == Domaine.Musique) || (domaines[1] == Domaine.Musique) || (domaines[2] == Domaine.Musique))
							domaine_j1_5.setSelected(true);
						if((domaines[0] == Domaine.Cinema) || (domaines[1] == Domaine.Cinema) || (domaines[2] == Domaine.Cinema))
							domaine_j1_6.setSelected(true);
						if((domaines[0] == Domaine.Culture_generale) || (domaines[1] == Domaine.Culture_generale) || (domaines[2] == Domaine.Culture_generale))
							domaine_j1_7.setSelected(true);
						valider_j1.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ce nom n'existe pas , veuillez verifier le nom !","Message",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		j1_enregistrer.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enreg_j1 = true;
				j1_identifier.setVisible(false);
				j1_enregistrer.setVisible(false);
				nom_j1.setVisible(true);
				domaine_j1_1.setVisible(true);
				domaine_j1_2.setVisible(true);
				domaine_j1_3.setVisible(true);
				domaine_j1_4.setVisible(true);
				domaine_j1_5.setVisible(true);
				domaine_j1_6.setVisible(true);
				domaine_j1_7.setVisible(true);
				valider_j1.setVisible(true);
			}
		});
		
		valider_j1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nom_j1.getText().isEmpty())
				{
					if(!domaine_j1_1.isEnabled() || !domaine_j1_2.isEnabled() || !domaine_j1_3.isEnabled() || !domaine_j1_4.isEnabled())
					{
						int j = 10;
						if((Jeu.rechercher_joueur(nom_j1.getText()) != null) && (enreg_j1))
						{
							j = JOptionPane.showConfirmDialog(null, "Ce nom existe deja\nVoulez-vous l'ecrasez ?", "", JOptionPane.YES_NO_OPTION);
						}
						if(j == JOptionPane.YES_OPTION || j == 10)
						{
							j1.setnom(nom_j1.getText());
						    Domaine[] domaines = new Domaine[3];
							int i=0;
							if(domaine_j1_1.isSelected()){ domaines[i] = Domaine.Science; i++; }
							if(domaine_j1_2.isSelected()){ domaines[i] = Domaine.Histoire; i++; }
							if(domaine_j1_3.isSelected()){ domaines[i] = Domaine.Géographie; i++; }
							if(domaine_j1_4.isSelected()){ domaines[i] = Domaine.Sport; i++; }
							if(domaine_j1_5.isSelected()){ domaines[i] = Domaine.Musique; i++; }
							if(domaine_j1_6.isSelected()){ domaines[i] = Domaine.Cinema; i++; }
							if(domaine_j1_7.isSelected()){ domaines[i] = Domaine.Culture_generale; i++; }							
							j1.setdomaines(domaines);
							
							image1.setVisible(false);
							j1_label.setVisible(false);
							nom_j1.setVisible(false);
							valider_j1.setVisible(false);
							domaine_j1_1.setVisible(false);
							domaine_j1_2.setVisible(false);
							domaine_j1_3.setVisible(false);
							domaine_j1_4.setVisible(false);
							domaine_j1_5.setVisible(false);
							domaine_j1_6.setVisible(false);
						    domaine_j1_7.setVisible(false);
							
						    image2.setVisible(true);
							j2_label.setVisible(true);
							j2_identifier.setVisible(true);
							j2_enregistrer.setVisible(true);
						}
					}
				}
			}
		});
		
		j2_identifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				j2_identifier.setVisible(false);
				j2_enregistrer.setVisible(false);
				nom_j2.setVisible(true);
				j2_login.setVisible(true);
			}
		});
		
		j2_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nom_j2.getText().isEmpty())
				{
					if(nom_j2.getText().equals(nom_j1.getText()))
						JOptionPane.showMessageDialog(null, "C'est le même nom que le joueur A , Vous devez le changer.","Erreur",JOptionPane.INFORMATION_MESSAGE);
					else
					{
						Joueur joueur = Jeu.rechercher_joueur(nom_j2.getText());
						if(joueur != null)
						{
							JOptionPane.showMessageDialog(null, "On vous remercie pour votre fidélité et voici vos anciens domaines des questions\nvous pouvez soit les modifier ou les laisser et valider .","Message",JOptionPane.QUESTION_MESSAGE);
							j2.setnom(nom_j2.getText());
							nom_j2.setEnabled(false);
							j2_login.setVisible(false);
							domaine_j2_1.setVisible(true);
							domaine_j2_2.setVisible(true);
							domaine_j2_3.setVisible(true);
							domaine_j2_4.setVisible(true);
							domaine_j2_5.setVisible(true);
							domaine_j2_6.setVisible(true);
							domaine_j2_7.setVisible(true);
							Domaine[] domaines = joueur.getdomaines();
							if((domaines[0] == Domaine.Science) || (domaines[1] == Domaine.Science) || (domaines[2] == Domaine.Science))
								domaine_j2_1.setSelected(true);
							if((domaines[0] == Domaine.Histoire) || (domaines[1] == Domaine.Histoire) || (domaines[2] == Domaine.Histoire))
								domaine_j2_2.setSelected(true);
							if((domaines[0] == Domaine.Géographie) || (domaines[1] == Domaine.Géographie) || (domaines[2] == Domaine.Géographie))
								domaine_j2_3.setSelected(true);
							if((domaines[0] == Domaine.Sport) || (domaines[1] == Domaine.Sport) || (domaines[2] == Domaine.Sport))
								domaine_j2_4.setSelected(true);
							if((domaines[0] == Domaine.Musique) || (domaines[1] == Domaine.Musique) || (domaines[2] == Domaine.Musique))
								domaine_j2_5.setSelected(true);
							if((domaines[0] == Domaine.Cinema) || (domaines[1] == Domaine.Cinema) || (domaines[2] == Domaine.Cinema))
								domaine_j2_6.setSelected(true);
							if((domaines[0] == Domaine.Culture_generale) || (domaines[1] == Domaine.Culture_generale) || (domaines[2] == Domaine.Culture_generale))
								domaine_j2_7.setSelected(true);
							valider_j2.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Ce nom n'existe pas , veuillez verifier le nom !","Message",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
		
		j2_enregistrer.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enreg_j2 = true;
				j2_identifier.setVisible(false);
				j2_enregistrer.setVisible(false);
				nom_j2.setVisible(true);
				domaine_j2_1.setVisible(true);
				domaine_j2_2.setVisible(true);
				domaine_j2_3.setVisible(true);
				domaine_j2_4.setVisible(true);
				domaine_j2_5.setVisible(true);
				domaine_j2_6.setVisible(true);
				domaine_j2_7.setVisible(true);
				valider_j2.setVisible(true);
			}
		});
		
		valider_j2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nom_j2.getText().isEmpty())
				{
					if((nom_j2.getText().equals(nom_j1.getText())) && (enreg_j2))
						JOptionPane.showMessageDialog(null, "C'est le même nom que le joueur A , Vous devez le changer.","Erreur",JOptionPane.INFORMATION_MESSAGE);
					else
					{
						if(!domaine_j2_1.isEnabled() || !domaine_j2_2.isEnabled() || !domaine_j2_3.isEnabled() || !domaine_j2_4.isEnabled())
						{
							int j = 10;
							if((Jeu.rechercher_joueur(nom_j2.getText()) != null) && (enreg_j2))
							{
								j = JOptionPane.showConfirmDialog(null, "Ce nom existe deja !!\nVoulez-vous l'ecrasez ?", "", JOptionPane.YES_NO_OPTION);
							}
							if(j == JOptionPane.YES_OPTION || j == 10)
							{
								j2.setnom(nom_j2.getText());
								Domaine[] domaines = new Domaine[3];
								int i=0;
								if(domaine_j2_1.isSelected()){ domaines[i] = Domaine.Science; i++; }
								if(domaine_j2_2.isSelected()){ domaines[i] = Domaine.Histoire; i++; }
								if(domaine_j2_3.isSelected()){ domaines[i] = Domaine.Géographie; i++; }
								if(domaine_j2_4.isSelected()){ domaines[i] = Domaine.Sport; i++; }
								if(domaine_j2_5.isSelected()){ domaines[i] = Domaine.Musique; i++; }
								if(domaine_j2_6.isSelected()){ domaines[i] = Domaine.Cinema; i++; }
								if(domaine_j2_7.isSelected()){ domaines[i] = Domaine.Culture_generale; i++; }							
								j2.setdomaines(domaines);
								
								image2.setVisible(false);
								j2_label.setVisible(false);
								nom_j2.setVisible(false);
								valider_j2.setVisible(false);
								domaine_j2_1.setVisible(false);
								domaine_j2_2.setVisible(false);
								domaine_j2_3.setVisible(false);
								domaine_j2_4.setVisible(false);
								domaine_j2_5.setVisible(false);
								domaine_j2_6.setVisible(false);
								domaine_j2_7.setVisible(false);
								lancer.setVisible(true);
							}
						}
					}
				}
			}
		});

		lancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partie partie = new Partie(Jeu.nom_fichier_questions,Jeu.Nbr_parties(), j1, j2);
				Jeu.Sauvegarder_joueur(j1);
				Jeu.Sauvegarder_joueur(j2);
				fenetre.hide();
			}
		});
	}
	class event implements ItemListener{
		int n1;
		int n2;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			n1 = 0;
			if(domaine_j1_1.isSelected() && n1<3){n1++;}
			if(domaine_j1_2.isSelected() && n1<3){n1++;}
			if(domaine_j1_3.isSelected() && n1<3){n1++;}
			if(domaine_j1_4.isSelected() && n1<3){n1++;}
			if(domaine_j1_5.isSelected() && n1<3){n1++;}
			if(domaine_j1_6.isSelected() && n1<3){n1++;}
			if(domaine_j1_7.isSelected() && n1<3){n1++;}
		    if(n1==3)
		    {
		    	if(!domaine_j1_1.isSelected()){domaine_j1_1.setEnabled(false);}
		    	if(!domaine_j1_2.isSelected()){domaine_j1_2.setEnabled(false);}
		    	if(!domaine_j1_3.isSelected()){domaine_j1_3.setEnabled(false);}
		    	if(!domaine_j1_4.isSelected()){domaine_j1_4.setEnabled(false);}
		    	if(!domaine_j1_5.isSelected()){domaine_j1_5.setEnabled(false);}
		    	if(!domaine_j1_6.isSelected()){domaine_j1_6.setEnabled(false);}
		    	if(!domaine_j1_7.isSelected()){domaine_j1_7.setEnabled(false);}
		    }
		    else
		    {
		    	domaine_j1_1.setEnabled(true);
		    	domaine_j1_2.setEnabled(true);
		    	domaine_j1_3.setEnabled(true);
		    	domaine_j1_4.setEnabled(true);
		    	domaine_j1_5.setEnabled(true);
		    	domaine_j1_6.setEnabled(true);
		    	domaine_j1_7.setEnabled(true);	
		    }	
			n2 = 0;
			if(domaine_j2_1.isSelected() && n2<3){n2++;}
			if(domaine_j2_2.isSelected() && n2<3){n2++;}
			if(domaine_j2_3.isSelected() && n2<3){n2++;}
			if(domaine_j2_4.isSelected() && n2<3){n2++;}
			if(domaine_j2_5.isSelected() && n2<3){n2++;}
			if(domaine_j2_6.isSelected() && n2<3){n2++;}
			if(domaine_j2_7.isSelected() && n2<3){n2++;}
		    if(n2==3)
		    {
		    	if(!domaine_j2_1.isSelected()){domaine_j2_1.setEnabled(false);}
		    	if(!domaine_j2_2.isSelected()){domaine_j2_2.setEnabled(false);}
		    	if(!domaine_j2_3.isSelected()){domaine_j2_3.setEnabled(false);}
		    	if(!domaine_j2_4.isSelected()){domaine_j2_4.setEnabled(false);}
		    	if(!domaine_j2_5.isSelected()){domaine_j2_5.setEnabled(false);}
		    	if(!domaine_j2_6.isSelected()){domaine_j2_6.setEnabled(false);}
		    	if(!domaine_j2_7.isSelected()){domaine_j2_7.setEnabled(false);}
		    }
		    else
		    {
		    	domaine_j2_1.setEnabled(true);
		    	domaine_j2_2.setEnabled(true);
		    	domaine_j2_3.setEnabled(true);
		    	domaine_j2_4.setEnabled(true);
		    	domaine_j2_5.setEnabled(true);
		    	domaine_j2_6.setEnabled(true);
		    	domaine_j2_7.setEnabled(true);	
		    }
		}
	}
}

class Fenetre_Plateau extends Fenetres implements Serializable
{
	Partie partie;
	private Joueur j1;
	private Joueur j2;
	private Plateau plateau;
	private JLabel j1_label;
	private JLabel j2_label;
	private JLabel case1;
	private JLabel case2;
	private JLabel score1;
	private JLabel score2;
	private int tour_de_role;
	JButton sauvegarder;
	JButton pas_sauvegarder;
	
	public Fenetre_Plateau(Partie partie,Joueur j1,Joueur j2,int commençant) throws Exception
	{
		super();
		this.partie = partie;
		this.plateau = new Plateau(partie);
		this.j1 = j1;
		this.j2 = j2;
		fenetre.setTitle("Plateau du jeu");
		fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./Icons/24.png"));
		fenetre.setBounds(0, 0, 1400, 900);
		fenetre.getContentPane().setLayout(null);
		fenetre.setVisible(true);
		
        JLabel num_partie = new JLabel("PARTIE N°"+partie.getNum_seq());
		num_partie.setBounds(100 , 450,200,40);
		num_partie.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		num_partie.setForeground(Color.green);
		fenetre.add(num_partie);
		
		j1_label = new JLabel(j1.getnom());
		j1_label.setBounds(70, 20, 200, 30);
		j1_label.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		fenetre.add(j1_label);

		j2_label = new JLabel(j2.getnom());
		j2_label.setBounds(1190, 20, 200, 30);
		j2_label.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		fenetre.add(j2_label);
		
		JLabel domaine1 = new JLabel("Domaines préférés :");
		domaine1.setBounds(30, 50, 200, 20);
		fenetre.add(domaine1);
		
		JLabel domaine11 = new JLabel("||- "+j1.getdomaines()[0].toString());
		domaine11.setBounds(80, 75, 200, 30);
		fenetre.add(domaine11);
		
		JLabel domaine12 = new JLabel("||- "+j1.getdomaines()[1].toString());
		domaine12.setBounds(80, 100, 200, 30);
		fenetre.add(domaine12);
		
		JLabel domaine13 = new JLabel("||- "+j1.getdomaines()[2].toString());
		domaine13.setBounds(80, 125, 200, 30);
		fenetre.add(domaine13);
		
		JLabel domaine2 = new JLabel("Domaines préférés :");
		domaine2.setBounds(1150, 50, 200, 20);
		fenetre.add(domaine2);
		
		JLabel domaine21 = new JLabel("||- "+j2.getdomaines()[0].toString());
		domaine21.setBounds(1200, 75, 200, 30);
		fenetre.add(domaine21);
		
		JLabel domaine22 = new JLabel("||- "+j2.getdomaines()[1].toString());
		domaine22.setBounds(1200, 100, 200, 30);
		fenetre.add(domaine22);
		
		JLabel domaine23 = new JLabel("||- "+j2.getdomaines()[2].toString());
		domaine23.setBounds(1200, 125, 200, 30);
		fenetre.add(domaine23);
		
		case1 = new JLabel("Case : 1");
		case1.setBounds(70, 150, 200, 30);
		fenetre.add(case1);

		case2 = new JLabel("Case : 1");
		case2.setBounds(1190, 150, 200, 30);
		fenetre.add(case2);
		
		score1 = new JLabel("Score : 0");
		score1.setBounds(70, 180, 200, 30);
		fenetre.add(score1);

		score2 = new JLabel("Score : 0");
		score2.setBounds(1190, 180, 200, 30);
		fenetre.add(score2);
		
		JLabel legende = new JLabel("Legende :");
		legende.setBounds(1100, 375, 100, 30);
		fenetre.add(legende);
		
		JButton pos_joueur_couleur = new JButton("");
		pos_joueur_couleur.setBorder(null);
		pos_joueur_couleur.setBackground(Color.CYAN);
		pos_joueur_couleur.setBounds(1100, 425, 50, 30);
		fenetre.add(pos_joueur_couleur);

		JLabel pos_joueur_label = new JLabel("Position de joueur");
		pos_joueur_label.setBounds(1180, 425, 200, 30);
		fenetre.add(pos_joueur_label);
        
		JButton legende1 = new JButton("");
		legende1.setBorder(null);
        legende1.setBackground(Color.BLUE);
		legende1.setBounds(1100, 470, 50, 30);
		fenetre.add(legende1);
		
		JButton legende2 = new JButton("");
		legende2.setBorder(null);
		legende2.setBackground(new Color((float)0.6,0,0));
		legende2.setBounds(1100, 500, 50, 30);
		fenetre.add(legende2);
                
		JButton legende3 = new JButton("");
		legende3.setBorder(null);
        legende3.setBackground(Color.GRAY);
		legende3.setBounds(1100, 530, 50, 30);
		fenetre.add(legende3);
                
		JButton legende4 = new JButton("");
		legende4.setBorder(null);
        legende4.setBackground(Color.GREEN);
		legende4.setBounds(1100, 560, 50, 30);
		fenetre.add(legende4);
                
		JButton legende5 = new JButton("");
		legende5.setBorder(null);
        legende5.setBackground(Color.ORANGE);
		legende5.setBounds(1100, 590, 50, 30);
		fenetre.add(legende5);
                
		JButton legende6 = new JButton("");
		legende6.setBorder(null);
        legende6.setBackground(Color.RED);
		legende6.setBounds(1100, 620, 50, 30);
		fenetre.add(legende6);
                
		JButton legende7 = new JButton("");
		legende7.setBorder(null);
        legende7.setBackground(Color.YELLOW);
		legende7.setBounds(1100, 650, 50, 30);
		fenetre.add(legende7);
                
		JLabel legende8 = new JLabel("Science");
		legende8.setBounds(1180, 470, 150, 30);
		fenetre.add(legende8);
                
		JLabel legende9 = new JLabel("Histoire");
		legende9.setBounds(1180, 500, 150, 30);
		fenetre.add(legende9);
                
		JLabel legende10 = new JLabel("Géographie");
		legende10.setBounds(1180, 530, 150, 30);
		fenetre.add(legende10);
                
		JLabel legende11 = new JLabel("Sport");
		legende11.setBounds(1180, 560, 150, 30);
		fenetre.add(legende11);
                
		JLabel legende12 = new JLabel("Musique");
		legende12.setBounds(1180, 590, 150, 30);
		fenetre.add(legende12);
                
		JLabel legende13 = new JLabel("Cinéma");
		legende13.setBounds(1180, 620, 150, 30);
		fenetre.add(legende13);
                
		JLabel legende14 = new JLabel("Culture générale");
		legende14.setBounds(1180, 650, 150, 30);
		fenetre.add(legende14);
        
		sauvegarder = new JButton("Quitter et sauvegarder");
		sauvegarder.setBounds(100, 550, 200, 30);
		sauvegarder.setFont(new Font("BROADWAY",Font.PLAIN,13));
		fenetre.add(sauvegarder);
		
		pas_sauvegarder = new JButton("Quitter sans sauvegarder");
		pas_sauvegarder.setBounds(100, 600, 200, 30);
		pas_sauvegarder.setFont(new Font("BROADWAY",Font.PLAIN,13));
		fenetre.add(pas_sauvegarder);
		
		(this.plateau).Afficher(this);
		if(commençant==1)	JOptionPane.showMessageDialog(null,"Le joueur qui va commencer est : "+(this.j1).getnom(), "Début du partie", JOptionPane.INFORMATION_MESSAGE);
		else if(commençant==2)	JOptionPane.showMessageDialog(null,"Le joueur qui va commencer est : "+(this.j2).getnom(), "Début du partie", JOptionPane.INFORMATION_MESSAGE);
		(this.plateau).setDisabled();
		if(commençant == 1)
		{
			tour_de_role = 1;
			j1_label.setForeground(Color.RED);
			(this.plateau).setEnabled(1, 1);
			(this.plateau).Colorer(1, 1, Color.cyan);
		}
		else if (commençant==2)
		{
			tour_de_role = 2;
			j2_label.setForeground(Color.RED);
			(this.plateau).setEnabled(2, 1);
			(this.plateau).Colorer(2, 1, Color.cyan);
		}
		else
		{
			setscore(1, j1.getScore());
			setscore(2, j2.getScore());
			setcase(1,j1.getnum_case());
			setcase(2,j2.getnum_case());
			setTour_de_role(partie.getTour_de_role());
		}
		
		sauvegarder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Est-ce-que vous voulez vraiment quitter et sauvegarder cette partie ?", "Sauvegarde_partie", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION)
				{
					Jeu.Sauvegarder_partie(partie);
					fenetre.dispose();;
				}	
			}
		});
		
		pas_sauvegarder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Est-ce-que vous voulez vraiment quitter sans sauvegarder la partie ?", "Sauvegarde_partie", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION)	fenetre.dispose();;				
			}
		});
	}
	
	public int getTour_de_role() { return tour_de_role; }
	public void setTour_de_role(int tour_de_role)
	{
		this.tour_de_role = tour_de_role;
		if(tour_de_role == 1)
		{
			j1_label.setForeground(Color.RED);
			plateau.setEnabled(1, j1.getnum_case());
			plateau.Colorer(1, j1.getnum_case(), Color.cyan);
			j2_label.setForeground(Color.BLACK);
			if((j1.getnum_case()!=j2.getnum_case()) || (j1.getnum_case() == 1))
			{
				plateau.setDisabled(2, j2.getnum_case());
				plateau.Supprimer_couleur(2, j2.getnum_case());
			}
		}
		else
		{
			j2_label.setForeground(Color.RED);
			plateau.setEnabled(2,j2.getnum_case());
			plateau.Colorer(2, j2.getnum_case(), Color.cyan);
			j1_label.setForeground(Color.BLACK);
			if((j1.getnum_case()!=j2.getnum_case()) || (j1.getnum_case() == 1))
			{
				plateau.setDisabled(1, j1.getnum_case());
				plateau.Supprimer_couleur(1, j1.getnum_case());			
			}
		}
	}
	
	public Joueur getjoueur(int i){ return (i==1)?j1:j2; }
	
	public void setscore(int joueur_ordre,int score)
	{
		if(joueur_ordre == 1) { j1.setScore(score); score1.setText("Score : "+score); }
		else { j2.setScore(score); score2.setText("Score : "+score); }
	}
	
	public Case getcase(int joueur_ordre,int num){ return plateau.getcase(joueur_ordre, num); }
	public void setcase(int joueur_ordre,int num)
	{
		if(joueur_ordre == 1)
		{
			plateau.Supprimer_couleur(1, j1.getnum_case());
			j1.setnum_case(num);
			case1.setText("Case : "+num);
		}
		else
		{
			plateau.Supprimer_couleur(2, j2.getnum_case());
			j2.setnum_case(num);
			case2.setText("Case : "+num);
		}
		plateau.setDisabled();
	}
}

class Fenetre_question extends Fenetres{
	Difficulte niveau_choisi;
	JLabel domaine;
	JLabel question;
	JLabel difficulte;
	JRadioButton facile;
	JRadioButton moyenne;
	JRadioButton difficile;
	JButton choisir_niveau;
	JRadioButton propo1;
	JRadioButton propo2;
	JRadioButton propo3;
	JRadioButton propo4;
	JTextField reponse;
	JButton repondre;
	
	public Fenetre_question(Partie partie, Question question) throws Exception
	{
		super();
		if(question == null)	JOptionPane.showMessageDialog(null, "Désolé ! Les questions de ce domaine sont tous posées", "", JOptionPane.PLAIN_MESSAGE);
		else
		{
			partie.getfenetre().fenetre.setEnabled(false);
			fenetre.setTitle("Question");
			fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./Icons/24.png"));
			fenetre.setBounds(200, 100, 700, 500);
			fenetre.getContentPane().setLayout(null);
			fenetre.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			fenetre.setVisible(true);
			
			JLabel image = new JLabel();
			image.setBounds(300,20,100,100);
			image.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
			image.setIcon(resizeImage(image.getWidth(),image.getHeight(),"./Icons/18.png", image));
			fenetre.add(image);
			
			domaine = new JLabel("Domaine : "+question.getdomaine().toString());
			domaine.setBounds(250, 120, 200, 20);
			domaine.setFont(new Font("Viner Hand ITC",Font.PLAIN,15));
			fenetre.getContentPane().add(domaine);
			
			this.question = new JLabel("Question : "+question.getquestion());
			(this.question).setBounds(30, 138, 900, 30);
			this.question.setFont(new Font("Elephant",Font.PLAIN,15));
			fenetre.getContentPane().add(this.question);
			
			difficulte = new JLabel("Difficulte :");
			difficulte.setBounds(100, 200, 100, 20);
			fenetre.getContentPane().add(difficulte);
	
			facile = new JRadioButton("facile");
			facile.setBounds(180, 200, 80, 20);
			fenetre.getContentPane().add(facile);
			
			moyenne = new JRadioButton("moyenne");
			moyenne.setBounds(320, 200, 80, 20);
			fenetre.getContentPane().add(moyenne);
			
			difficile = new JRadioButton("difficile");
			difficile.setBounds(460, 200, 80, 20);
			fenetre.getContentPane().add(difficile);
			
			choisir_niveau = new JButton("Choisir niveau");
			choisir_niveau.setBounds(280, 230, 165, 30);
			fenetre.add(choisir_niveau);
			
			ArrayList<Integer> pos_propos = new ArrayList<Integer>();
			int i;
			while(pos_propos.size()<4)
			{
				i=new Random().nextInt(4);
				while(pos_propos.contains(i))	i=new Random().nextInt(4);
				pos_propos.add(i);
			}
			propo1 = new JRadioButton(pos_propos.get(0)+1+". "+question.getreponse());
			propo1.setBounds(30,260+(pos_propos.get(0))*30,500,30);
			fenetre.add(propo1);
			
			propo2 = new JRadioButton(pos_propos.get(1)+1+". "+question.getpropos()[0]);
			propo2.setBounds(30,260+(pos_propos.get(1))*30,500,30);
			fenetre.add(propo2);
			
			propo3 = new JRadioButton(pos_propos.get(2)+1+". "+question.getpropos()[1]);
			propo3.setBounds(30,260+(pos_propos.get(2))*30,500,30);
			fenetre.add(propo3);
			
			propo4 = new JRadioButton(pos_propos.get(3)+1+". "+question.getpropos()[2]);
			propo4.setBounds(30,260+(pos_propos.get(3))*30,500,30);
			fenetre.add(propo4);

			reponse = new JTextField();
			reponse.setBounds(30, 260, 500, 30);
			fenetre.add(reponse);
			
			repondre = new JButton("Repondre");
			repondre.setFont(new Font("Viner Hand ITC",Font.PLAIN,13));
			fenetre.add(repondre);
			
			propo1.setVisible(false);
			propo2.setVisible(false);
			propo3.setVisible(false);
			propo4.setVisible(false);
			reponse.setVisible(false);
			repondre.setVisible(false);
			
			facile.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					moyenne.setSelected(false);
					difficile.setSelected(false);
				}
			});
			moyenne.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					facile.setSelected(false);
					difficile.setSelected(false);
				}
			});
			difficile.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					facile.setSelected(false);
					moyenne.setSelected(false);
				}
			});
			
			choisir_niveau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(facile.isSelected() || moyenne.isSelected() || difficile.isSelected())
					{
						facile.setEnabled(false);
						moyenne.setEnabled(false);
						difficile.setEnabled(false);
						choisir_niveau.setVisible(false);
						if(facile.isSelected())
						{
							niveau_choisi=Difficulte.Facile;
							propo1.setVisible(true);
							propo2.setVisible(true);
							int i = new Random().nextInt(2);
							propo1.setText(i+1+". "+question.getreponse());
							propo1.setLocation(30, 260+30*i);
							propo2.setText((i+1)%2+1+". "+question.getpropos()[0]);
							propo2.setLocation(30, 260 + 30*( (i+1)%2 ) );
							repondre.setBounds(300, 330, 150, 40);
						}
						else if(moyenne.isSelected())
						{
							niveau_choisi=Difficulte.Moyenne;
							propo1.setVisible(true);
							propo2.setVisible(true);
							propo3.setVisible(true);
							propo4.setVisible(true);
							repondre.setBounds(300, 390, 150, 40);
						}
						else
						{
							niveau_choisi=Difficulte.Difficile;
							reponse.setVisible(true);
							repondre.setBounds(300, 330, 150, 40);
						}
						repondre.setIcon(resizeImage(18,repondre.getHeight()-5,"./Icons/13.png", repondre));
						repondre.setVisible(true);
					}
				}
			});
			
			propo1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					propo2.setSelected(false);
					propo3.setSelected(false);
					propo4.setSelected(false);
				}
			});
			propo2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					propo1.setSelected(false);
					propo3.setSelected(false);
					propo4.setSelected(false);
				}
			});
			propo3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					propo1.setSelected(false);
					propo2.setSelected(false);
					propo4.setSelected(false);
				}
			});
			propo4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					propo1.setSelected(false);
					propo2.setSelected(false);
					propo3.setSelected(false);
				}
			});
			
			repondre.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(propo1.isSelected() || propo2.isSelected() || propo3.isSelected() || propo4.isSelected() || !reponse.getText().isEmpty())
					{
						if(!propo1.isSelected() && !reponse.getText().equals(question.getreponse()))
						{
							JOptionPane.showMessageDialog(null, "Réponse incorrecte ! la main maintenant est à l'autre joueur");
							partie.getfenetre().fenetre.setEnabled(true);
							fenetre.dispose();
							partie.setTour_de_role(partie.getTour_de_role()%2+1);
						}
						else
						{
							int pnts = calcul_pnts(niveau_choisi, question.getdomaine() , partie.getjoueur(partie.getTour_de_role()));
							JOptionPane.showMessageDialog(null, "\t\tRéponse correcte\net vous avez gagné "+pnts);
							partie.getfenetre().fenetre.setEnabled(true);
							fenetre.dispose();
							partie.setscore(partie.getTour_de_role(), partie.getjoueur(partie.getTour_de_role()).getScore()+pnts);
							JOptionPane.showMessageDialog(null, "maintenant vous devez cliquez sur une case pour l'occuper");
							int pos_actuelle = partie.getjoueur(partie.getTour_de_role()).getnum_case();
							for(int i = pos_actuelle +1;i<=pos_actuelle+pnts;i++)
								partie.getcase(partie.getTour_de_role(), i).setEnabled();
							partie.setTour_fini(false);
						}
					}
				}
			});
		}
	}
	
	public int calcul_pnts(Difficulte difficulte,Domaine domaine,Joueur joueur)
	{
		if(difficulte == Difficulte.Facile)
		{
			if((domaine == joueur.getdomaines()[0]) || (domaine == joueur.getdomaines()[1]) || (domaine == joueur.getdomaines()[2]))
				return 1;
			else return 2;
		}
		else if(difficulte == Difficulte.Moyenne)
		{
			if((domaine == joueur.getdomaines()[0]) || (domaine == joueur.getdomaines()[1]) || (domaine == joueur.getdomaines()[2]))
				return 2;
			else return 3;			
		}
		else
		{
			if((domaine == joueur.getdomaines()[0]) || (domaine == joueur.getdomaines()[1]) || (domaine == joueur.getdomaines()[2]))
				return 4;
			else return 5;
		}
	}
}

class Fenetre_duel extends Fenetres
{
	JLabel joueurA;
	JLabel joueurB;
	JLabel scoreA_lab;
	JLabel scoreB_lab;
	JLabel domaine;
	JLabel question_lab;
	JRadioButton propo1;
	JRadioButton propo2;
	JRadioButton propo3;
	JRadioButton propo4;
	JButton repondre;
	int scoreA=0;
	int scoreB=0;
	int etape = 1;
	public Fenetre_duel(Partie partie,int challenger) throws Exception
	{
		super();
		partie.getfenetre().fenetre.setEnabled(false);
		fenetre.setTitle("Duel");
		fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./Icons/24.png"));
		fenetre.setBounds(200, 100, 1000, 500);
		fenetre.getContentPane().setLayout(null);
		fenetre.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		fenetre.setVisible(true);
		
		joueurA = new JLabel("Occupant : "+partie.getjoueur(challenger%2+1).getnom());
		joueurA.setForeground(Color.RED);
		joueurA.setBounds(50,50,300,30);
		fenetre.add(joueurA);
		
		joueurB = new JLabel("Challenger : "+partie.getjoueur(challenger).getnom());
		joueurB.setBounds(800,50,300,30);
		fenetre.add(joueurB);
		
		scoreA_lab = new JLabel("Points : 0");
		scoreA_lab.setBounds(50, 80, 100, 30);
		fenetre.add(scoreA_lab);
		
		scoreB_lab = new JLabel("Points : 0");
		scoreB_lab.setBounds(800, 80, 100, 30);
		fenetre.add(scoreB_lab);
		
		Question question = partie.getquestion(partie.getjoueur(challenger%2+1).getdomaines()[new Random().nextInt(3)]);
		
		domaine = new JLabel("Domaine : "+question.getdomaine().toString());
		domaine.setBounds(150, 120, 200, 30);
		fenetre.add(domaine);
		
		question_lab = new JLabel("Question : "+question.getquestion());
		question_lab.setBounds(150, 150, 500, 30);
		fenetre.add(question_lab);
		
		ArrayList<Integer> pos_propos = new ArrayList<Integer>();
		int i;
		while(pos_propos.size()<4)
		{
			i=new Random().nextInt(4);
			while(pos_propos.contains(i))	i=new Random().nextInt(4);
			pos_propos.add(i);
		}
		propo1 = new JRadioButton(pos_propos.get(0)+1+". "+question.getreponse());
		propo1.setBounds(150,190+(pos_propos.get(0))*30,500,30);
		fenetre.add(propo1);
		
		propo2 = new JRadioButton(pos_propos.get(1)+1+". "+question.getpropos()[0]);
		propo2.setBounds(150,190+(pos_propos.get(1))*30,500,30);
		fenetre.add(propo2);
		
		propo3 = new JRadioButton(pos_propos.get(2)+1+". "+question.getpropos()[1]);
		propo3.setBounds(150,190+(pos_propos.get(2))*30,500,30);
		fenetre.add(propo3);
		
		propo4 = new JRadioButton(pos_propos.get(3)+1+". "+question.getpropos()[2]);
		propo4.setBounds(150,190+(pos_propos.get(3))*30,500,30);
		fenetre.add(propo4);

		repondre = new JButton("Répondre");
		repondre.setBounds(250, 340, 100, 40);
		fenetre.add(repondre);
		
		propo1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				propo2.setSelected(false);
				propo3.setSelected(false);
				propo4.setSelected(false);
			}
		});
		propo2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				propo1.setSelected(false);
				propo3.setSelected(false);
				propo4.setSelected(false);
			}
		});
		propo3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				propo1.setSelected(false);
				propo2.setSelected(false);
				propo4.setSelected(false);
			}
		});
		propo4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				propo1.setSelected(false);
				propo2.setSelected(false);
				propo3.setSelected(false);
			}
		});
		
		repondre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(propo1.isSelected() || propo2.isSelected() || propo3.isSelected() || propo4.isSelected())
				{
					Question question;
					switch (etape)
					{
						case 1:
							if(propo1.isSelected())
							{
								JOptionPane.showMessageDialog(null, "Réponse correcte !");
								scoreA++;
								scoreA_lab.setText("Points : 1");
							}
							else	JOptionPane.showMessageDialog(null, "Réponse incorrecte !");
							question = partie.getquestion(partie.getjoueur(challenger%2+1).getdomaines()[new Random().nextInt(3)]);
							deplacer_droite_composants(question);
							etape++;
		
							break;
						case 2:
							if(propo1.isSelected())
							{
								JOptionPane.showMessageDialog(null, "Réponse correcte !");
								scoreB++;
								scoreB_lab.setText("Points : 1");
							}
							else	JOptionPane.showMessageDialog(null, "Réponse incorrecte !");
							question = partie.getquestion(partie.getjoueur(challenger%2+1).getdomaines()[new Random().nextInt(3)]);
							deplacer_gauche_composants(question);
							etape++;

							break;
						case 3:
							if(propo1.isSelected())
							{
								JOptionPane.showMessageDialog(null, "Réponse correcte !");
								scoreA++;
								scoreA_lab.setText("Points : "+scoreA);
							}
							else	JOptionPane.showMessageDialog(null, "Réponse incorrecte !");
							question = partie.getquestion(partie.getjoueur(challenger%2+1).getdomaines()[new Random().nextInt(3)]);
							deplacer_droite_composants(question);
							etape++;

							break;
						case 4:
							if(propo1.isSelected())
							{
								JOptionPane.showMessageDialog(null, "Réponse correcte !");
								scoreB++;
								scoreB_lab.setText("Points : "+scoreB);
							}
							else	JOptionPane.showMessageDialog(null, "Réponse incorrecte !");
							if(scoreA-scoreB == 2)
							{
								JOptionPane.showMessageDialog(null, "Challenge perdu");
								fenetre.dispose();
								partie.getfenetre().fenetre.setEnabled(true);
								partie.getfenetre().fenetre.show();
								partie.challenge_perdu(challenger);
							}
							else if(scoreB-scoreA == 2)
							{
								JOptionPane.showMessageDialog(null, "Challenge gagné");
								fenetre.dispose();
								partie.getfenetre().fenetre.setEnabled(true);
								partie.getfenetre().fenetre.show();
								partie.challenge_gagne(challenger);		
							}
							else
							{
								question = partie.getquestion(partie.getjoueur(challenger%2+1).getdomaines()[new Random().nextInt(3)]);
								deplacer_gauche_composants(question);
								etape++;
							}
							
							break;
						case 5:
							if(propo1.isSelected())
							{
								JOptionPane.showMessageDialog(null, "Réponse correcte !");
								scoreA++;
								scoreA_lab.setText("Points : "+scoreA);
							}
							else	JOptionPane.showMessageDialog(null, "Réponse incorrecte !");
							if(scoreA-scoreB == 2)
							{
								JOptionPane.showMessageDialog(null, "Challenge perdu");
								fenetre.dispose();
								partie.getfenetre().fenetre.setEnabled(true);
								partie.getfenetre().fenetre.show();
								partie.challenge_perdu(challenger);
							}
							else if(scoreB>scoreA)
							{
								JOptionPane.showMessageDialog(null, "Challenge gagné");
								fenetre.dispose();
								partie.getfenetre().fenetre.setEnabled(true);
								partie.getfenetre().fenetre.show();
								partie.challenge_gagne(challenger);		
							}
							else
							{
								question = partie.getquestion(partie.getjoueur(challenger%2+1).getdomaines()[new Random().nextInt(3)]);
								deplacer_droite_composants(question);
								etape++;
							}
							
							break;
						case 6:
							if(propo1.isSelected())
							{
								JOptionPane.showMessageDialog(null, "Réponse correcte !");
								scoreB++;
								scoreB_lab.setText("Points : "+scoreB);
							}
							else	JOptionPane.showMessageDialog(null, "Réponse incorrecte !");
							if(scoreA>scoreB)
							{
								JOptionPane.showMessageDialog(null, "Challenge perdu");
								fenetre.dispose();
								partie.getfenetre().fenetre.setEnabled(true);
								partie.getfenetre().fenetre.show();
								partie.challenge_perdu(challenger);
							}
							else if(scoreA<scoreB)
							{
								JOptionPane.showMessageDialog(null, "Challenge gagné !\nmaintenant vous allez jouer deux fois de suite");
								fenetre.dispose();
								partie.getfenetre().fenetre.setEnabled(true);
								partie.getfenetre().fenetre.show();
								partie.challenge_gagne(challenger);		
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Le challenger n'a pas pu battre son adversaire");
								fenetre.dispose();
								partie.getfenetre().fenetre.setEnabled(true);
								partie.getfenetre().fenetre.show();
								partie.challenge_perdu(challenger);
							}

							break;
					}
					propo1.setSelected(false); propo2.setSelected(false); propo3.setSelected(false); propo4.setSelected(false);
				}
			}
		});
	}
	
	public void deplacer_droite_composants(Question question)
	{
		joueurA.setForeground(Color.BLACK);
		joueurB.setForeground(Color.RED);
		domaine.setText("Domaine : "+question.getdomaine().toString());
		domaine.setLocation(550, 120);
		question_lab.setText("Question : "+question.getquestion());
		question_lab.setLocation(550, 150);
		ArrayList<Integer> pos_propos = new ArrayList<Integer>();
		int i;
		while(pos_propos.size()<4)
		{
			i=new Random().nextInt(4);
			while(pos_propos.contains(i))	i=new Random().nextInt(4);
			pos_propos.add(i);
		}
		propo1.setText(pos_propos.get(0)+1+". "+question.getreponse());
		propo1.setLocation(550, 190+30*pos_propos.get(0));
		propo2.setText(pos_propos.get(1)+1+". "+question.getpropos()[0]);
		propo2.setLocation(550, 190+30*pos_propos.get(1));
		propo3.setText(pos_propos.get(2)+1+". "+question.getpropos()[1]);
		propo3.setLocation(550, 190+30*pos_propos.get(2));
		propo4.setText(pos_propos.get(3)+1+". "+question.getpropos()[2]);
		propo4.setLocation(550, 190+30*pos_propos.get(3));
		repondre.setLocation(650, 340);
	}
	public void deplacer_gauche_composants(Question question)
	{
		joueurB.setForeground(Color.BLACK);
		joueurA.setForeground(Color.RED);
		domaine.setText("Domaine : "+question.getdomaine().toString());
		domaine.setLocation(150, 120);
		question_lab.setText("Question : "+question.getquestion());
		question_lab.setLocation(150, 150);
		ArrayList<Integer> pos_propos = new ArrayList<Integer>();
		int i;
		while(pos_propos.size()<4)
		{
			i=new Random().nextInt(4);
			while(pos_propos.contains(i))	i=new Random().nextInt(4);
			pos_propos.add(i);
		}
		propo1.setText(pos_propos.get(0)+1+". "+question.getreponse());
		propo1.setLocation(150, 190+30*pos_propos.get(0));
		propo2.setText(pos_propos.get(1)+1+". "+question.getpropos()[0]);
		propo2.setLocation(150, 190+30*pos_propos.get(1));
		propo3.setText(pos_propos.get(2)+1+". "+question.getpropos()[1]);
		propo3.setLocation(150, 190+30*pos_propos.get(2));
		propo4.setText(pos_propos.get(3)+1+". "+question.getpropos()[2]);
		propo4.setLocation(150, 190+30*pos_propos.get(3));
		repondre.setLocation(250, 340);
	}
}

class Fenetre_score extends Fenetres
{
	public Fenetre_score(Joueur[] resultats) throws Exception
	{
		super();
		fenetre.setTitle("Meilleurs scores");
		fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./Icons/24.png"));
		fenetre.setBounds(600, 100, 400, 500);
		fenetre.getContentPane().setLayout(null);
		fenetre.setVisible(true);
		for(int i=0;i<resultats.length&&i<=12;i++)
		{
			JLabel nom = new JLabel(i+1+". "+resultats[i].getnom());
			nom.setBounds(100, 50+30*i, 100, 30);
			fenetre.add(nom);
			
			JLabel score = new JLabel(""+resultats[i].getScore());
			score.setBounds(300, 50+30*i, 100, 30);
			fenetre.add(score);
		}
	}
}

class Fenetre_combobox extends Fenetres
{
	public Fenetre_combobox() throws Exception
	{
		super();
		fenetre.setTitle("Charger une partie");
		fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage("./Icons/24.png"));
		fenetre.setBounds(600, 400, 400, 200);
		fenetre.getContentPane().setLayout(null);
		fenetre.setVisible(true);
		
//		Com
	}
}