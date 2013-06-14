package com.derby.trainraid;

public abstract class MenuItem extends Touchable
{
	private TurretSlot _towerSlot;
	
	public MenuItem(TurretSlot towerSlot, float xMin, float xMax, float yMin, float yMax) 
	{
		super(xMin, xMax, yMin, yMax);
		_towerSlot = towerSlot;
	}
	
	TurretSlot getTurretSlot()
	{
		return _towerSlot;
	}
	
	abstract void OnPress(Entity target, Renderer renderer);
}
