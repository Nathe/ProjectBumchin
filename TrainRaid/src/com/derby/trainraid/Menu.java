package com.derby.trainraid;

import java.util.ArrayList;
import java.util.List;


public class Menu 
{
	private List<MenuItem> _menuItems = new ArrayList<MenuItem>();
	
	public class GunTowerButton extends MenuItem
	{
		public GunTowerButton(TurretSlot turretSlot) 
		{
			super(turretSlot, 375, 770, 429, 900);
		}

		@Override
		void OnPress(Entity target, Renderer renderer) 
		{
			GunTurret _tower = new GunTurret (super.getTurretSlot().getXMin(),super.getTurretSlot().getYMin(), target);
			renderer._turretList.add(_tower);
			super.getTurretSlot().setOccupied(true);
		}
	}
	
	public class LaserTurretButton extends MenuItem
	{
		public LaserTurretButton(TurretSlot turretSlot) 
		{
			super(turretSlot, 475, 770, 529, 900);
		}

		@Override
		void OnPress(Entity target, Renderer renderer) 
		{
			LaserTurret _turret = new LaserTurret (super.getTurretSlot().getXMin(),super.getTurretSlot().getYMin(), target);
			renderer._turretList.add(_turret);
			super.getTurretSlot().setOccupied(true);
		}
	}

	public class GatlingTurretButton extends MenuItem
	{
		public GatlingTurretButton(TurretSlot turretSlot) 
		{
			super(turretSlot, 575, 770, 629, 900);
		}

		@Override
		void OnPress(Entity target, Renderer renderer) 
		{
			GatlingTurret _turret = new GatlingTurret (super.getTurretSlot().getXMin(),super.getTurretSlot().getYMin(), target);
			renderer._turretList.add(_turret);
			super.getTurretSlot().setOccupied(true);
		}
	}
	
	public MenuItem getMenuItem(int index)
	{
		return _menuItems.get(index);
	}
	
	public int GetSize()
	{
		return _menuItems.size();
	}
}


