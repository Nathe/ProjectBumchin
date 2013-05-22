package com.derby.trainraid;

import java.util.List;

public class TowerSelect
{
	int tower;
	public TowerSelect()
	{
	}
	
	//check user selection checks the x and y coordinates of the users screen press and checks to see if it is within the
	//x and y ranges of the list of build points.
	public BuildPoints CheckUserSelection(List<BuildPoints> buildPoints, float x , float y)
	{
		BuildPoints point = null;
		
		for(int i = 0; i < buildPoints.size(); i++)
		{
			if((x >= buildPoints.get(i).getXMin() && x <= buildPoints.get(i).getXMax()) && (y >= buildPoints.get(i).getYMin() && y <= buildPoints.get(i).getYMax()))
			{				
				point = buildPoints.get(i);
				
				if(x >= buildPoints.get(0).getXMin() && x <= buildPoints.get(0).getXMax() && (y >= buildPoints.get(0).getYMin() && y <= buildPoints.get(0).getYMax()))
				{
					tower = 2;
				}
				else if(x >= buildPoints.get(1).getXMin() && x <= buildPoints.get(1).getXMax() && (y >= buildPoints.get(1).getYMin() && y <= buildPoints.get(1).getYMax()))
				{
					tower = 3;
				}
				else if(x >= buildPoints.get(2).getXMin() && x <= buildPoints.get(2).getXMax() && (y >= buildPoints.get(2).getYMin() && y <= buildPoints.get(2).getYMax()))
				{
					tower = 4;
				}
			}
		}
		return point;
	}
	
	public void towerMenu()
	{
		//code for menu selection system.
		
	}
	
	public int getTower()
	{
		return tower;
	}
	
	
}
