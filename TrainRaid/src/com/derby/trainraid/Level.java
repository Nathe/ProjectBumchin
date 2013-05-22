package com.derby.trainraid;

public abstract class Level 
{
private String _backgroundPath;
private int _startMoney;
private String[] _enemyType;
private int _enemyTypeNo;
private int _levelDistance;
protected int _distanceTravelled;
private int _trainSpeed;
private String _levelName;


public Level(String loc, int money, int distance, int travelledDistance, String levelName)
{
	_backgroundPath = loc;
	_startMoney = money;
	_levelDistance = distance;
	_distanceTravelled = travelledDistance;
	_levelName = levelName;
}

	abstract AttackEntity[] CheckSpawn(int maxY, int minY, Entity target);

	//set and get methods.

	public String GetBackground()
	{
		return _backgroundPath;
	}

	public int GetMoney()
	{
		return _startMoney;
	}

	public int GetDist()
	{
		return _levelDistance;
	}

	public int GetDistTravelled()
	{
		return _distanceTravelled;
	}

	public int AddDistance(int amount)
	{
		_distanceTravelled = _distanceTravelled + amount;
		return _distanceTravelled;
	}

	public String GetEnemyType(int pos)
	{
		return _enemyType[pos];
	}

	public int GetEnemyTypeNo()
	{
		return _enemyTypeNo = _enemyType.length;
	}

	public void addMoney(int amtToAdd)
	{//adds money to the money variable according to the amount
		_startMoney+=amtToAdd;
	}

	public int getMoney(){//Getter for money
		return _startMoney;
	}

	public void removeMoney(int amtToSub)
	{//removes money from money variable
		_startMoney-=amtToSub;
	}
	
	public String GetLevelName()
	{
		return _levelName;
	}
}
