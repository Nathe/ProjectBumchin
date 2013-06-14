package com.derby.trainraid;

public class Battleship extends Enemy 
{
	
	public Battleship(int x, int y, Entity target)
	{
		super(2000, 7, x, y, 5, 25, target);
	}
}