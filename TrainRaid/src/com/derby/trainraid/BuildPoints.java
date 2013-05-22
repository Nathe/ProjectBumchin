package com.derby.trainraid;

public class BuildPoints {
	
	int xMin;
	int xMax;
	int yMin;
	int yMax;
	boolean occupied = false;
		
	
	public BuildPoints(int xMin, int xMax, int yMin, int yMax)
	{
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}
	
	public int getXMin()
	{
		return this.xMin;
	}
	
	public int getXMax()
	{
		return this.xMax;
	}
	
	public int getYMin()
	{
		return this.yMin;
	}
	
	public int getYMax()
	{
		return this.yMax;
	}
	
	public boolean getOccupied()
	{
		return this.occupied;
	}
	
	public void setOccupied(boolean occupied)
	{
		this.occupied = occupied;
	}
}
