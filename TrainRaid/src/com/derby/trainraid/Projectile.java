package com.derby.trainraid;

public class Projectile extends Entity
{
	private int speedX;
	private int damage;
	private int range;
	private double angle = 0;
	
	public Projectile(int hitPoints, int bitmapid, float x, float y, int damage, float targetX, float targetY) 
	{
		super(hitPoints, bitmapid, x, y);
		this.damage = damage;
		angle = CalcAngle(x, y, targetX, targetY);
	}
	
	public void update(int height, int width)
	{
		move(height, width);
	}
	
	public void setSpeedX(int speedX)
	{
		this.speedX = speedX;
	}
	
	public void setAngle(double angle)
	{
		return;
	}
	
	public void move(int height, int width)
	{
		// Speed of the bullet
		speedX = 20 ;
		
		float x = this.GetX();
		float y = this.GetY();
		
		this.SetX(x+=speedX * Math.sin(angle));
		this.SetY(y+=speedX * Math.cos(angle));
		
		this.UpdateBoundingBox(height, width);		
	}
	
	public double CalcAngle(float x, float y, float targetX, float targetY)
	{
		double targetDistanceX = targetX - x;
		double targetDistanceY = targetY - y;
		
		double angle = (Math.atan2(targetDistanceX, targetDistanceY));
		
		return angle;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public void IncrementRange()
	{
		range++;
	}
	
	public int GetRange()
	{
		return range;
	}	
}
