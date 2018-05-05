package test2;

import java.io.Serializable;
import java.util.ArrayList;

public class Case_commune extends Case implements Serializable{
	
	public Case_commune(Partie partie,int width,int height,int num,Domaine domaine)
	{
		super(partie,num,domaine);
		if(num == 42)	button.setBounds(700 - (width+15/2), 50 + (num - 22)*(height + 5), width+15, height+15);		
		else	button.setBounds(700 - width, 50 + (num - 22)*(height + 5), width, height);		
		button.setIcon(resizeImage("./Icons/white.png", button));
	}
}