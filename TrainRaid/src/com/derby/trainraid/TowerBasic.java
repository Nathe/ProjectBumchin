package com.derby.trainraid;

public class TowerBasic extends Tower 
{

	public TowerBasic(int hitPoints, int fileLoc, int x, int y, int width, int height, AttackEntity currentTarget) 
	{
		super(hitPoints, fileLoc, x, y, width, height, 10, currentTarget);
	}
	
	String preferedTarget;
	static Entity currentTarget = null;
	int cost;
	int maxUpgrades;
	int upgradeCost;
	int damagePerShot = 100;

	
	void setCost(int newCost)
	{
		cost = 100;
	}
	void setMaxUpgrades(int newMaxUpgrades)
	{
		maxUpgrades = 5;
	}
	void setUpgradeCost(int newCost)
	{
		upgradeCost = 150;
	}
	void setPreferedTarget(String target)
	{
		preferedTarget = "Enemy1";
	}
	
	void setPreferedTargetCoordinates()
	{
		//TargetX = Renderer.getTargetX(1);
		//TargetY = _projectilesList.get(1).getY();
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
	
	@Override
	Projectile Shoot(int bulletHeight, int bulletWidth)
	{	
		super.timeSinceShot = 0;
		Projectile p = new Projectile(20, 6, this.GetX(), this.GetY(), damagePerShot, 20, currentTarget.GetX()+currentTarget.getWidth(), currentTarget.GetY());
		return p;
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
	
}
