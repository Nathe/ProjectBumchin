package com.derby.trainraid;

public class Battleship extends Enemy 
{
	Entity currentTarget = null;
	int damagePerShot = 10;
	
	public Battleship(int x, int y, Entity target)
	{
		super(2000, 7, x, y, 5, target);
		currentTarget = target;
		
	}
	
	void setCurrentTarget(Entity target)
	{
		currentTarget = target;
	}
	
	void setDamagePerShot(int damage)
	{
		damagePerShot = damage;
	}
	
	Entity getCurrentTarget()
	{
		return currentTarget;
	}
	
	int getDamagePerShot()
	{
		return damagePerShot;
	}
	
	@Override
	Projectile Shoot(int bulletHeight, int bulletWidth)
	{	
		timeSinceShot = 0;
		Projectile p = new Projectile(20, 6, this.GetX(), this.GetY(), damagePerShot, 20, GetTargetMiddle().x, GetTargetMiddle().y);
		return p;
	}
}