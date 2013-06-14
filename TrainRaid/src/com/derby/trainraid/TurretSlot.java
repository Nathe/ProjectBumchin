package com.derby.trainraid;

public class TurretSlot extends Touchable{
	
	private boolean _occupied = false;
		
	
	public TurretSlot(int xMin, int xMax, int yMin, int yMax)
	{
		super(xMin, xMax, yMin, yMax);
	}
	
	public boolean getOccupied()
	{
		return _occupied;
	}
	
	public void setOccupied(boolean occupied)
	{
		_occupied = occupied;
	}
}
