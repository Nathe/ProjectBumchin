package com.derby.trainraid;

import android.view.MotionEvent;

abstract class Touchable 
{
	private float _xMin;
	private float _xMax;
	private float _yMin;
	private float _yMax;
	
	public Touchable(float xMin, float xMax, float yMin, float yMax)
	{
		_xMin = xMin;
		_xMax = xMax;
		_yMin = yMin;
		_yMax = yMax;
	}
	
	public float getXMin()
	{
		return _xMin;
	}
	
	public float getXMax()
	{
		return _xMax;
	}
	
	public float getYMin()
	{
		return _yMin;
	}
	
	public float getYMax()
	{
		return _yMax;
	}
		
	public boolean checkTouched(MotionEvent touch)
	{
		boolean result = false;
		
		if (touch.getX() <= _xMax && touch.getX() >= _xMin)
		{
			result = true;
		}
		
		System.out.println("checktouched ran, result = " + result);
		
		return result;
	}
}
