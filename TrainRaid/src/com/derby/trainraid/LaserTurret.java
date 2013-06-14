package com.derby.trainraid;

public class LaserTurret extends Turret
{
	public LaserTurret (float x, float y, Entity currentTarget) 
	{
		super(100, 2, x, y, 20, 10, currentTarget);
	}
}