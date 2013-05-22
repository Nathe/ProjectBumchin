package com.derby.trainraid;

import android.media.MediaPlayer;
import android.app.Activity;

public class TrainCab extends Activity
{
	int MaxTowerNumber;
	int NumberOfTowers = 0;
	String ImageLocation;
	
	void setCabIcon(String CabImage)
	{
		ImageLocation = CabImage;
	}
	
	void maxNumberOfTowers(int Max)
	{
		MaxTowerNumber = Max;
	}
	
	void addTower()
	{
		if(NumberOfTowers < MaxTowerNumber)
		{
			//Tower newTower = new Tower(0, 0, 0, 0, 0, 0);
			
			//newTower.setCost(50);
			//newTower.setMaxUpgrades(10);
			//newTower.setUpgradeCost(70);
			
			NumberOfTowers++;
			
			// Creation of sound
		    MediaPlayer mpAddTower;

	        setContentView(R.layout.activity_game);
		       
	        mpAddTower = new MediaPlayer();
	        mpAddTower = MediaPlayer.create(getBaseContext(), R.raw.test);
	        mpAddTower.start();
		}
		else
		{
			System.out.println("You have built the maximum amount of towers so no more may be built currently!");
		}
	}
	
	int getNumberOfTowers()
	{
		return NumberOfTowers;
	}
}
