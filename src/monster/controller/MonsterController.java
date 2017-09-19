package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Tom", 2, 4, 3.0, false);
		System.out.println(realMonster);
		System.out.println("Matthew is hungry, so he is going to eat an eye.");
		realMonster.setEyeCount(1);
		System.out.println(realMonster);

		interactWithTheMonster(realMonster);
	}

	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + " wants to kow what to eat next.");
		System.out.println(currentMonster.getName() + " suggests you eat arms. They have " + currentMonster.getArmCount() + " arms.");
		System.out.println("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();

		if (consumed <= currentMonster.getArmCount() && consumed >= 0)
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Ok, now " + currentMonster.getName() + " has " + currentMonster.getArmCount() + " arms left.");
		}
		else
		{
			if (consumed > -1)
			{
				System.out.println(currentMonster.getName() + " says they don't have that many arms.");
			}
			else
			{
				System.out.println(currentMonster.getName() + " says that is an invalid amount.");
			}
		}

		System.out.println(currentMonster.getName() + " suggest you eat tentacles next. They have " + currentMonster.getTentacleAmount() + " tentacles");
		System.out.println("How many do you want to eat? (you can eat parts of tentacles too)");
		double consumedTentacles = myScanner.nextDouble();

		if (consumedTentacles > currentMonster.getTentacleAmount())
		{
			System.out.println(currentMonster.getName() + " says they don't have that many tentacles.");
		}
		else if (consumedTentacles < 0)
		{
			System.out.println(currentMonster.getName() + " says that is an invalid amount.");
		}
		else if (consumedTentacles == 0)
		{
			System.out.println(currentMonster.getName() + " thinks your not very hungry");
		}
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - consumedTentacles);
			System.out.println("Ok, now " + currentMonster.getName() + " has " + currentMonster.getTentacleAmount() + " arms left.");
		}
		
		popup.displayText("Hey look at me! :)");
		String answer = popup.getResponse("How many meals are you eating today?");
		System.out.println(answer);
		popup.displayText(answer);
	}
}
