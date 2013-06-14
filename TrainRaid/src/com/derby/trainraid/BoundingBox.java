package com.derby.trainraid;

import android.graphics.Rect;

public class BoundingBox {

	private Rect _boundingBox;
	
	public BoundingBox()
	{
	}
	
	public BoundingBox(Entity entity)
	{
		_boundingBox = new Rect((int)entity.GetX(), (int)entity.GetY(), (int)entity.GetX() + entity.getWidth(), (int)entity.GetY() + entity.getHeight());
	}
	
	public Rect getBoundingBox()
	{
		return _boundingBox;
	}
	
	public void setBoundingBoxPos(float x, float y, int height, int width)
	{
		_boundingBox.set((int)x, (int)y, (int)x + width, (int)y + height);
	}
	
	public void setBoundingBox(Entity entity, int width, int height)
	{
		_boundingBox = new Rect ((int)entity.GetX(), (int)entity.GetY(), (int)entity.GetX() + width, (int)entity.GetY() + height);
	}
	
}
