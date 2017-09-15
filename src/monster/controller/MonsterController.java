package monster.controller;

import monster.model.MarshmallowMonster;

public class MonsterController
{
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Tom", 3, 4, 3.0, false);
		System.out.println(realMonster);
		
	}

}	
