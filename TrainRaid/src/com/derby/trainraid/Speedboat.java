package com.derby.trainraid;

public class Speedboat extends Enemy
{
	int damagePerShot = 25;
	
	public Speedboat(int x, int y, Entity target)
	{
		super(500, 0, x, y, 20, target);
		
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

