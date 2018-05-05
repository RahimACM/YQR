package test2;

import java.io.Serializable;

public class Case_individuelle extends Case implements Serializable{

	public Case_individuelle(Partie partie,int ordre, int width,int height,int num,Domaine domaine)
	{
		super(partie,num,domaine);
		if(ordre==1)
		{
			if(num == 1)	button.setBounds(700 - width - 15*width/2, 50 +4*(height+5), width, height);
			if(num == 2)	button.setBounds(700 - width - 7*width, 50 +3*(height+5), width, height);		
			if(num == 3)	button.setBounds(700 - width - 6*width, 50 +3*(height+5), width, height);
			if(num == 4)	button.setBounds(700 - width - 5*width, 50 +4*(height+5), width, height);
			if(num == 5)	button.setBounds(700 - width - 5*width, 50 +5*(height+5), width, height);
			if(num == 6)	button.setBounds(700 - width - 11*width/2, 50 +6*(height+5), width, height);
			if(num == 7)	button.setBounds(700 - width - (6*width + width/3), 50 +13*(height+5)/2, width, height);
			if(num == 8)	button.setBounds(700 - width - (7*width + width/6), 50 +13*(height+5)/2, width, height);
			if(num == 9)	button.setBounds(700 - width - 8*width, 50 +13*(height+5)/2, width, height);
			if(num == 10)	button.setBounds(700 - width - (8*width + 2*width/3), 50 +6*(height+5), width, height);
			if(num == 11)	button.setBounds(700 - width - 9*width , 50 +5*(height+5), width, height);
			if(num == 12)	button.setBounds(700 - width - 9*width , 50 +4*(height+5), width, height);
			if(num == 13)	button.setBounds(700 - width - (8*width + 2*width/3), 50 +3*(height+5), width, height);
			if(num == 14)	button.setBounds(700 - width - 8*width, 50 +2*(height+5), width, height);
			if(num == 15)	button.setBounds(700 - width - 7*width, 50 +height+5, width, height);
			if(num == 16)	button.setBounds(700 - width - 6*width, 50 , width, height);
			if(num == 17)	button.setBounds(700 - width - 5*width, 50 , width, height);
			if(num == 18)	button.setBounds(700 - width - 4*width, 50 , width, height);
			if(num == 19)	button.setBounds(700 - width - 3*width, 50 , width, height);
			if(num == 20)	button.setBounds(700 - width - 2*width, 50 , width, height);
			if(num == 21)	button.setBounds(700 - width - width, 50  , width, height);
		}
		else
		{
			if(num == 1)	button.setBounds(700 - width + 15*width/2, 50 +4*(height+5), width, height);
			if(num == 2)	button.setBounds(700 - width + 7*width, 50 +3*(height+5), width, height);		
			if(num == 3)	button.setBounds(700 - width + 6*width, 50 +3*(height+5), width, height);
			if(num == 4)	button.setBounds(700 - width + 5*width, 50 +4*(height+5), width, height);
			if(num == 5)	button.setBounds(700 - width + 5*width, 50 +5*(height+5), width, height);
			if(num == 6)	button.setBounds(700 - width + 11*width/2, 50 +6*(height+5), width, height);
			if(num == 7)	button.setBounds(700 - width + (6*width + width/3), 50 +13*(height+5)/2, width, height);
			if(num == 8)	button.setBounds(700 - width + (7*width + width/6), 50 +13*(height+5)/2, width, height);
			if(num == 9)	button.setBounds(700 - width + 8*width, 50 +13*(height+5)/2, width, height);
			if(num == 10)	button.setBounds(700 - width + (8*width + 2*width/3), 50 +6*(height+5), width, height);
			if(num == 11)	button.setBounds(700 - width + 9*width , 50 +5*(height+5), width, height);
			if(num == 12)	button.setBounds(700 - width + 9*width , 50 +4*(height+5), width, height);
			if(num == 13)	button.setBounds(700 - width + (8*width + 2*width/3), 50 +3*(height+5), width, height);
			if(num == 14)	button.setBounds(700 - width + 8*width, 50 +2*(height+5), width, height);
			if(num == 15)	button.setBounds(700 - width + 7*width, 50 +height+5, width, height);
			if(num == 16)	button.setBounds(700 - width + 6*width, 50 , width, height);
			if(num == 17)	button.setBounds(700 - width + 5*width, 50 , width, height);
			if(num == 18)	button.setBounds(700 - width + 4*width, 50 , width, height);
			if(num == 19)	button.setBounds(700 - width + 3*width, 50 , width, height);
			if(num == 20)	button.setBounds(700 - width + 2*width, 50 , width, height);
			if(num == 21)	button.setBounds(700 - width + width, 50  , width, height);
		}
		if(domaine == Domaine.Science)			button.setIcon(resizeImage("./Icons/blue.png", button));
		if(domaine == Domaine.Histoire)			button.setIcon(resizeImage("./Icons/brown.png", button));
		if(domaine == Domaine.Géographie)		button.setIcon(resizeImage("./Icons/gray.png", button));
		if(domaine == Domaine.Sport)			button.setIcon(resizeImage("./Icons/green.png", button));
		if(domaine == Domaine.Musique)			button.setIcon(resizeImage("./Icons/orange.png", button));
		if(domaine == Domaine.Cinema)			button.setIcon(resizeImage("./Icons/red.png", button));
		if(domaine == Domaine.Culture_generale)	button.setIcon(resizeImage("./Icons/yellow.png", button));
	}
}