package test2;

import javax.swing.UIManager;

public class Theme {
	public static void setTheme()throws Exception{
		try 
	    {
	      UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel");
	    } 
	    catch (Exception exp) 
	    {
	      exp.printStackTrace();
	    }   
	}
	
}
