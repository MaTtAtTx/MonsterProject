package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{
	// Includes popups from MonsterDisplay in the code
	private MonsterDisplay popup;

	public MonsterController()
	{
		popup = new MonsterDisplay();
	}

	public void start()
	{
		boolean finished = true;
		int count = 0;
//		while(count < 100)
//		{
//			popup.displayText("I am so neat! My number is " + count + ".");
//			count++;
//		}

//		for (int loop = 0; loop < 15; loop += 1)
//		{
//			popup.displayText("I am looping " + (loop + 1) + " times out of 15");
//		}

		MarshmallowMonster sample = new MarshmallowMonster();
		// System.out.println(sample);
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Tom", 2, 4, 3.0, false);

		// System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		// System.out.println("Matthew is hungry, so he is going to eat an eye.");
		popup.displayText("Matthew is hungry, so he is going to eat an eye.");
		realMonster.setEyeCount(1);
		// System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		interactWithTheMonster(realMonster);
	}

	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		// System.out.println(currentMonster.getName() + " wants to know what to eat next.");
		popup.displayText(currentMonster.getName() + " wants to know what to eat next.");
		// System.out.println(currentMonster.getName() + " suggests you eat arms. They have " +
		// currentMonster.getArmCount() + " arms.");
		popup.displayText(currentMonster.getName() + " suggests you eat arms. They have " + currentMonster.getArmCount() + " arms.");
		// System.out.println("How many do you want to eat?");
		
		int specialInt = 0;
		String unconverted = popup.getResponse("How many do you want to eat?");
		while(!isValidInteger(unconverted))
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many arms??");
		}
		
//		if (isValidInteger(unconverted))
//		{
		specialInt = Integer.parseInt(unconverted);
//		}

		Scanner myScanner = new Scanner(System.in);
		int consumed = 0;
		consumed = specialInt;

		if (consumed <= currentMonster.getArmCount() && consumed >= 0)
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			// System.out.println("Ok, now " + currentMonster.getName() + " has " + currentMonster.getArmCount()
			// + " arms left.");
			popup.displayText("Ok, now " + currentMonster.getName() + " has " + currentMonster.getArmCount() + " arms left.");
		}
		else
		{
			if (consumed > -1)
			{
				// System.out.println(currentMonster.getName() + " says they don't have that many arms.");
				popup.displayText(currentMonster.getName() + " says they don't have that many arms.");
			}
			else
			{
				// System.out.println(currentMonster.getName() + " says that is an invalid amount.");
				popup.displayText(currentMonster.getName() + " says that is an invalid amount.");
			}
		}

		// System.out.println(currentMonster.getName() + " suggest you eat tentacles next. They have " +
		// currentMonster.getTentacleAmount() + " tentacles");
		popup.displayText(currentMonster.getName() + " suggest you eat tentacles next. They have " + currentMonster.getTentacleAmount() + " tentacles");
		// System.out.println("How many do you want to eat? (you can eat parts of tentacles too)");
		
		String unconverted2 = popup.getResponse("How many do you want to eat? (you can eat parts of tentacles too)");
		while(!isValidDouble(unconverted2))
		{
			unconverted2 = popup.getResponse("You have to type a double! How many tentacles do you want to eat??");
		}
		double consumedTentacles = Double.parseDouble(unconverted2);
		
//		double consumedTentacles = myScanner.nextDouble();

		if (consumedTentacles > currentMonster.getTentacleAmount())
		{
			// System.out.println(currentMonster.getName() + " says they don't have that many tentacles.");
			popup.displayText(currentMonster.getName() + " says they don't have that many tentacles.");
		}
		else if (consumedTentacles < 0)
		{
			// System.out.println(currentMonster.getName() + " says that is an invalid amount.");
			popup.displayText(currentMonster.getName() + " says that is an invalid amount.");
		}
		else if (consumedTentacles == 0)
		{
			// System.out.println(currentMonster.getName() + " thinks your not very hungry");
			popup.displayText(currentMonster.getName() + " thinks your not very hungry");
		}
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - consumedTentacles);
			// System.out.println("Ok, now " + currentMonster.getName() + " has " +
			// currentMonster.getTentacleAmount() + " arms left.");
			popup.displayText("Ok, now " + currentMonster.getName() + " has " + currentMonster.getTentacleAmount() + " arms left.");
		}

		popup.displayText("Hey look at me! :)");
		String answer = popup.getResponse("How many meals are you eating today?");
		System.out.println(answer);
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
