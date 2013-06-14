package com.derby.trainraid;

public abstract class Turret extends AttackEntity
{
	public Turret(int hitPoints, int fileLoc, float x, float y, int shotSpeed, int damagePerShot, Entity currentTarget) {
		super(hitPoints, fileLoc, x, y, shotSpeed, damagePerShot, currentTarget);
		// TODO Auto-generated constructor stub
	}
	
	private int _cost;
	private int _maxUpgrades;
	private int _upgradeCost;
	
	void setCost(int newCost)
	{
		_cost = newCost;
	}
	
	int getCost()
	{
		return _cost;
	}
	
	void setMaxUpgrades(int maxUpgrades)
	{
		_maxUpgrades = maxUpgrades;
	}
	
	int getMaxUpgrades()
	{
		return _maxUpgrades;
	}
	
	void setUpgradeCost(int upgradeCost)
	{
		_upgradeCost = upgradeCost;
	}
	
	int getUpgradeCost()
	{
		return _upgradeCost;
	}
}