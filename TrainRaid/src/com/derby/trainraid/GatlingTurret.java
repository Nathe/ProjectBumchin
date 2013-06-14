package com.derby.trainraid;

public class GatlingTurret extends Turret
{
	public GatlingTurret (float x, float y, Entity currentTarget) 
	{
		super(100, 2, x, y, 20, 10, currentTarget);
	}
}
