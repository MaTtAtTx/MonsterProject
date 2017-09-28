package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;

public class MonsterController
{
	// Includes popups from MonsterDisplay in the code
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;

	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}

	public void start()
	{
		boolean finished = true;
		int count = 0;
		// while(count < 100)
		// {
		// popup.displayText("I am so neat! My number is " + count + ".");
		// count++;
		// }

		// for (int loop = 0; loop < 15; loop += 1)
		// {
		// popup.displayText("I am looping " + (loop + 1) + " times out of 15");
		// }

		MarshmallowMonster sample = new MarshmallowMonster();
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Tom", 2, 4, 3.0, false);

		popup.displayText(realMonster.toString());
		popup.displayText("Matthew is hungry, so he is going to eat an eye.");
		realMonster.setEyeCount(1);
		popup.displayText(realMonster.toString());
		
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();
		
		interactWithTheMonster(realMonster);
	}
	
	private void testList()
	{
		for(int index = 0; index < monsterList.size(); index++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String newName = popup.getResponse("What should my new name be???");
			currentMonster.setName(newName);
			popup.displayText(currentMonster.getName());
		}
		
		for(MarshmallowMonster current : monsterList)
		{
			popup.displayText(current.getName());
			String newName = popup.getResponse("What should my new new name be?");
			current.setName(newName);
			popup.displayText(current.getName());		}
	}

	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		popup.displayText(currentMonster.getName() + " wants to know what to eat next.");
		popup.displayText(currentMonster.getName() + " suggests you eat arms. They have " + currentMonster.getArmCount() + " arms.");

		int specialInt = 0;
		String unconverted = popup.getResponse("How many do you want to eat?");
		while (!isValidInteger(unconverted))
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many arms??");
		}
		specialInt = Integer.parseInt(unconverted);

		Scanner myScanner = new Scanner(System.in);
		int consumed = 0;
		consumed = specialInt;

		if (consumed <= currentMonster.getArmCount() && consumed >= 0)
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			popup.displayText("Ok, now " + currentMonster.getName() + " has " + currentMonster.getArmCount() + " arms left.");
		}
		else
		{
			if (consumed > -1)
			{
				popup.displayText(currentMonster.getName() + " says they don't have that many arms.");
			}
			else
			{
				popup.displayText(currentMonster.getName() + " says that is an invalid amount.");
			}
		}

		popup.displayText(currentMonster.getName() + " suggest you eat tentacles next. They have " + currentMonster.getTentacleAmount() + " tentacles");

		String unconverted2 = popup.getResponse("How many do you want to eat? (you can eat parts of tentacles too)");
		while (!isValidDouble(unconverted2))
		{
			unconverted2 = popup.getResponse("You have to type a double! How many tentacles do you want to eat??");
		}
		double consumedTentacles = Double.parseDouble(unconverted2);

		if (consumedTentacles > currentMonster.getTentacleAmount())
		{
			popup.displayText(currentMonster.getName() + " says they don't have that many tentacles.");
		}
		else if (consumedTentacles < 0)
		{
			popup.displayText(currentMonster.getName() + " says that is an invalid amount.");
		}
		else if (consumedTentacles == 0)
		{
			popup.displayText(currentMonster.getName() + " thinks your not very hungry");
		}
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - consumedTentacles);
			popup.displayText("Ok, now " + currentMonster.getName() + " has " + currentMonster.getTentacleAmount() + " arms left.");
		}

		popup.displayText("Hey look at me! :)");
		String answer = popup.getResponse("How many meals are you eating today?");
		popup.displayText(answer);
	}

	// Helper methods
	private boolean isValidInteger(String sampleInt)
	{
		boolean valid = false;

		try
		{
			Integer.parseInt(sampleInt);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only integer values are valid: " + sampleInt + " is not.");
		}

		return valid;
	}

	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;

		// Try and catch test a primitive (this one double) is actually a double and if it's not it catches
		// it instead of crashing your program
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only double values are valid: " + sampleDouble + " is not.");
		}

		return valid;
	}

	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;

		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only boolean values are valid: " + sampleBoolean + " is not.");
		}

		return valid;
	}
}
