package test2;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Case{
	private Partie partie;
	protected JButton button;
	private JLabel num_label;
	private int num;
	private Domaine domaine;
	
	public Case(Partie partie,int num,Domaine domaine)
	{
		this.partie = partie;
		this.num = num;
		button = new JButton();
		button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        if(num == 42)	num_label = new JLabel("        "+((Integer)num).toString());
        else	num_label = new JLabel("      "+((Integer)num).toString());
		button.add(num_label);
		this.domaine = domaine;
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num == 42)	partie.Arret();
				else
				{
					if(partie.isTour_fini())
						try {
							new Fenetre_question(partie,partie.getquestion(domaine));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					else
					{
						if((partie.getjoueur(partie.getTour_de_role()%2+1).getnum_case() == num) && num>=22)	partie.lancer_duel(partie.getTour_de_role());
						else
						{
							partie.setCase(partie.getTour_de_role(), num);
							if(partie.isDuel_gagne())
							{
								partie.setDuel_gagne(false);
								partie.setTour_de_role(partie.getTour_de_role());
							}
							else	partie.setTour_de_role(partie.getTour_de_role()%2+1);
							partie.setTour_fini(true);
						}
					}
				}
			}
		});
	}
		
	public void Afficher(Fenetre_Plateau fenetre){ fenetre.fenetre.add(button); }

	public int getnum(){ return num; }

	public ImageIcon resizeImage(String image, JComponent cpn)
	{
		ImageIcon imageIcon = new ImageIcon(image);
		Image newimg = imageIcon.getImage().getScaledInstance(cpn.getWidth()-20, cpn.getHeight(),  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		return imageIcon;
	}

	public void setEnabled() {	button.setEnabled(true);	}
	public void setDisabled(){	button.setEnabled(false);	}

	public void Colorer(Color couleur)
	{
		button.setContentAreaFilled(true);
		button.setBackground(couleur);
	}
	public void Supprimer_couleur()
	{
		button.setContentAreaFilled(false);
	}
}