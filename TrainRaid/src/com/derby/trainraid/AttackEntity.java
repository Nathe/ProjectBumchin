package com.derby.trainraid;


import android.graphics.Point;


public abstract class AttackEntity extends Entity
{
	public AttackEntity(int hitPoints, int fileLoc, float x, float y, int shotSpeed, int damagePerShot, Entity currentTarget) 
	{
		super(hitPoints, fileLoc, x, y);
		_damagePerShot = damagePerShot;
		_shotSpeed = shotSpeed;
		_currentTarget = currentTarget;
	}
	
	Entity _currentTarget;
	private int _damagePerShot;
	private int _shotSpeed;
	private int _timeSinceShot;
	
	public Point GetTargetMiddle()
	{
		Point result = new Point();
		result.x = (int)_currentTarget.GetX() + (_currentTarget.getWidth() / 2);
		result.y = (int)_currentTarget.GetY() + (_currentTarget.getHeight() / 2);
		return result;
	}

	Entity getCurrentTarget()
	{
		return _currentTarget;
	}
	
	void setCurrentTarget(Entity target)
	{
		_currentTarget = target;
	}
	
	int getDamagePerShot()
	{
		return _damagePerShot;
	}
	
	void setDamagePerShot(int damage)
	{
		_damagePerShot = damage;
	}
	
	int getShotSpeed()
	{
		return _shotSpeed;
	}
	
	void setShotSpeed(int speed)
	{
		_shotSpeed = speed;
	}
		
	public int getTimeSinceShot()
	{
		return _timeSinceShot;
	}
	
	public void IncrementTimeSinceShot()
	{
		_timeSinceShot++;
	}
	
	Projectile Shoot(int bulletHeight, int bulletWidth)
	{
		_timeSinceShot = 0;
		Projectile p = new Projectile(20, 6, super.GetX(), super.GetY(), _damagePerShot, _currentTarget.GetX()+_currentTarget.getWidth(), _currentTarget.GetY());
		return p;
	}
	
}
