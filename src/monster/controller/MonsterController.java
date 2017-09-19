package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController
{
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
		System.out.println(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount() + " arms.");
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
	}
}
