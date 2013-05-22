package com.derby.trainraid;

public abstract class Enemy extends AttackEntity
{
	
    public Enemy(int hitPoints, int fileLoc, int x, int y, int shotSpeed, Entity currentTarget) 
    {
		super(hitPoints, fileLoc, x, y, shotSpeed, currentTarget);
		// TODO Auto-generated constructor stub
	}
  
}

