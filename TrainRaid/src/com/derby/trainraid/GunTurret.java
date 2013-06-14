package com.derby.trainraid;

public class GunTurret extends Turret 
{
	public GunTurret (float x, float y, Entity currentTarget) 
	{
		super(100, 2, x, y, 20, 10, currentTarget);
	}
}
