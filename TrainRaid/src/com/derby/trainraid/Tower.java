package com.derby.trainraid;

public abstract class Tower extends AttackEntity{
	public Tower(int hitPoints, int fileLoc, int x, int y, int width, int height, int shotSpeed, Entity currentTarget) {
		super(hitPoints, fileLoc, x, y, shotSpeed, currentTarget);
		// TODO Auto-generated constructor stub
	}

	int cost;
	int maxUpgrades;
	int upgradeCost;
	int TargetX;
	int TargetY;

	
	void setCost(int newCost)
	{
		cost = newCost;
	}
	void setMaxUpgrades(int newMaxUpgrades)
	{
		maxUpgrades = newMaxUpgrades;
	}
	void setUpgradeCost(int newCost)
	{
		upgradeCost = newCost;
	}
	
	void setPreferedTarget(String target)
	{
		preferedTarget = target;
	}
	void setCurrentTarget(Entity target)
	{
		currentTarget = target;
	}
	void setDamagePerShot(int damage)
	{
		damagePerShot = damage;
	}

	
	String getPreferedTarget()
	{
		return preferedTarget;
	}
	Entity getCurrentTarget()
	{
		return currentTarget;
	}
	int getDamagePerShot()
	{
		return damagePerShot;
	}
	
	void ChangeTarget(Entity newTarget)
	{
		currentTarget = newTarget;
	}
	
	int getCost()
	{
		return cost;
	}
	int getMaxUpgrades()
	{
		return maxUpgrades;
	}
	int getUpgradeCost()
	{
		return upgradeCost;
	}
	
	void upgrade()
	{
		//some code goes here!
		setCost(50);
		setUpgradeCost(150);
		setDamagePerShot(100);
		setShotSpeed(150);
		
		/*//Creation of Sound!
	    MediaPlayer mpUpgrade;
	       
	    setContentView(R.layout.activity_game);
	       
	    mpUpgrade = new MediaPlayer();
	    mpUpgrade = MediaPlayer.create(getBaseContext(), R.raw.test);
	    mpUpgrade.start();*/
	}
	
	abstract Projectile Shoot(int bulletHeight, int bulletWidth) ;
	
}