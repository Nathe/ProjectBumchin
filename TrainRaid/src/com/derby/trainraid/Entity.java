package com.derby.trainraid;

import android.graphics.Rect;

public class Entity{ //extends Activity{

	private int hitPoints;
	private int _bitmapid;
	private float _x;
	private float _y;
	private BoundingBox boundingBox;
	private boolean hidden = false;
	private int maxHitPoints;
	private int _width;
	private int _height;
	
	//Constructor for creating a basic entity. Takes four parameters,
	//The hit points you want to assign, bitmap, X location and Y location.
	public Entity(int hitPoints, int bitmapid, float x, float y)
	{
		SetHitPoints(hitPoints);
		SetBitmapID(bitmapid);
		_x = x;
		_y = y;
    	maxHitPoints = hitPoints;
    	_width = Bitmaps.list.get(_bitmapid).getWidth();
    	_height = Bitmaps.list.get(_bitmapid).getHeight();
		boundingBox = new BoundingBox(this);
	}
	
	//Private Methods (you don't want ANYTHING outside of this class to
	//set the attributes).
	private void SetHitPoints(int newHitPoints)
	{
		hitPoints = newHitPoints ;
	}
	
	private void SetBitmapID(int bitmapid)
	{
		_bitmapid = bitmapid ;
	}
	
	//Public Methods
	public float GetX()
	{
		return _x;
	}
	
	public void SetX(float x)
	{
		boundingBox.setBoundingBoxPos(x, boundingBox.getBoundingBox().top, boundingBox.getBoundingBox().bottom - boundingBox.getBoundingBox().top, boundingBox.getBoundingBox().right - boundingBox.getBoundingBox().left);
		_x = x;
	}
	
	public float GetY()
	{
		return _y;
	}
	
	public void SetY(float y)
	{
		boundingBox.setBoundingBoxPos(boundingBox.getBoundingBox().left, y, boundingBox.getBoundingBox().bottom - boundingBox.getBoundingBox().top, boundingBox.getBoundingBox().right - boundingBox.getBoundingBox().left);
		_y = y;
	}
	
	public int GetHitPoints()
	{
		return hitPoints;
	}
	
    public int getMaxHitPoints()
    {
    	return maxHitPoints;
    }
	
	public int GetBitmapID()
	{
		return _bitmapid;
	}	
	
	//Add hit points.
	public int Heal(int heal)
	{
		hitPoints += heal;
		return hitPoints;
	}
	
	//deduct hit points.
	public int Damage(int damage)
	{
		hitPoints -= damage;
		return hitPoints;
	}
	
	public Rect getBoundingBox()
	{
		return boundingBox.getBoundingBox();
	}
	
	public boolean CheckIntersect(Entity entity)
	{
		return boundingBox.getBoundingBox().intersect(entity.getBoundingBox());
	}
	
	public void UpdateBoundingBox(int height, int width)
	{
		boundingBox.setBoundingBoxPos((int)_x, (int)_y, height, width);
	}
	
	public boolean getHidden()
	{
		return hidden;
	}
	public void Hide()
	{
		hidden = true;
	}
	
	public int getWidth()
	{
		return _width;
	}
	
	public int getHeight()
	{
		return _height;
	}
}
