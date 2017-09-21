package monster.view;

import javax.swing.JOptionPane;

public class MonsterDisplay
{
	//Allows you to have popups that display text
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	//Allows you to get a response in a popup display
	public String getResponse(String questionAsked)
	{
		String response = "";

		response += JOptionPane.showInputDialog(null, questionAsked);

		return response;
	}
}
