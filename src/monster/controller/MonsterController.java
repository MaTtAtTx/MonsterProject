package monster.controller;

import java.util.Scanner;

public class MonsterController
{
	public void start()
	{
		funScanner();
	}

	private void funScanner()
	{
		Scanner firstScanner;
		firstScanner = new Scanner(System.in);
		int testAnswer = firstScanner.nextInt();
		System.out.println("Why did you type " + testAnswer + "?");
		System.out.println("Who are you?");
		String test2Answer = firstScanner.nextLine();
		System.out.println("Your name is " + test2Answer + "? That's weird. :)");

	}
}
