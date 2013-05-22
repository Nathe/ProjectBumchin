package com.derby.trainraid;

import java.util.Random;

public class Level1 extends Level
{	

	public Level1()
	{
		super("picture.png", 1500, 2500, 0, "The Beach");
	}
	
	@Override
	public AttackEntity[] CheckSpawn(int maxY, int minY, Entity target)
	{
		AttackEntity enemies [] = null;
		Random random = new Random(); // Randomly generate Y axis
		
		switch(_distanceTravelled)
		{
		case(5):
			enemies = new AttackEntity[1];
			for (int i = 0; i < 1; i++)
			{				
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(100):
			enemies = new AttackEntity[4];
			for (int i = 0; i < 2; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
				AttackEntity battleship = new Battleship(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i+2] = battleship;
			}
			break;
		case(200):
			enemies = new AttackEntity[3];
			for (int i = 0; i < 3; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(500):
			enemies = new AttackEntity[5];
			for (int i = 0; i < 5; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(750):
			enemies = new AttackEntity[5];
			for (int i = 0; i < 5; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(1000):
			enemies = new AttackEntity[5];
			for (int i = 0; i < 5; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(1100):
			enemies = new AttackEntity[5];
			for (int i = 0; i < 5; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(1500):
			enemies = new AttackEntity[5];
			for (int i = 0; i < 5; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(1800):
			enemies = new AttackEntity[5];
			for (int i = 0; i < 5; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		case(2000):
			enemies = new AttackEntity[5];
			for (int i = 0; i < 5; i++)
			{
				AttackEntity enemy = new Speedboat(-50, random.nextInt(maxY - minY + 1) + minY, target);
				enemies[i] = enemy;
			}
			break;
		}
		return enemies;
	}
}
