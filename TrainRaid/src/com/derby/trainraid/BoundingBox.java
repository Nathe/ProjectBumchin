package com.derby.trainraid;

import android.graphics.Rect;

public class BoundingBox {

	private Rect _boundingBox;
	
	public BoundingBox()
	{
	}
	
	public BoundingBox(Entity entity)
	{
		_boundingBox = new Rect(entity.GetX(), entity.GetY(), entity.GetX() + entity.getWidth(), entity.GetY() + entity.getHeight());
	}
	
	public Rect getBoundingBox()
	{
		return _boundingBox;
	}
	
	public void setBoundingBoxPos(int x, int y, int height, int width)
	{
		_boundingBox.set(x, y, x + width, y + height);
	}
	
	public void setBoundingBox(Entity entity, int width, int height)
	{
		_boundingBox = new Rect (entity.GetX(), entity.GetY(), entity.GetX() + width, entity.GetY() + height);
	}
	
}
