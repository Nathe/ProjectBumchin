package com.derby.trainraid;

// Trying to fix the github

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

class Renderer extends SurfaceView implements SurfaceHolder.Callback 
{
	Paint paint = new Paint();	
	
	List<TurretSlot> towerSlotList = new ArrayList<TurretSlot>();
	Point convertPoint1 = MilliPointToPoint(375, 870);
	Point convertPoint2 = MilliPointToPoint(429, 1000);	
	TurretSlot point1 = new TurretSlot(convertPoint1.x, convertPoint2.x, convertPoint1.y, convertPoint2.y);
	
	Point convertPoint3 = MilliPointToPoint(430, 870);
	Point convertPoint4 = MilliPointToPoint(485, 1000);
	TurretSlot point2 = new TurretSlot(convertPoint3.x, convertPoint4.x, convertPoint3.y, convertPoint4.y);
	
	Point convertPoint5 = MilliPointToPoint(500, 870);
	Point convertPoint6 = MilliPointToPoint(555, 1000);
	TurretSlot point3 = new TurretSlot(convertPoint5.x, convertPoint6.x, convertPoint5.y, convertPoint6.y);
	
	Point convertPoint7 = MilliPointToPoint(560, 870);
	Point convertPoint8 = MilliPointToPoint(615, 1000);
	TurretSlot point4 = new TurretSlot(convertPoint7.x, convertPoint8.x, convertPoint7.y, convertPoint8.y);
	
	Point convertPoint9 = MilliPointToPoint(716, 870);
	Point convertPoint10 = MilliPointToPoint(771, 1000);
	TurretSlot point5 = new TurretSlot(convertPoint9.x, convertPoint10.x, convertPoint9.y, convertPoint10.y);
	
	Point convertPoint11 = MilliPointToPoint(770, 870);
	Point convertPoint12 = MilliPointToPoint(825, 1000);
	TurretSlot point6 = new TurretSlot(convertPoint11.x, convertPoint12.x, convertPoint11.y, convertPoint12.y);
	
	// Turret Menu System	
	
	Menu menu = new Menu();
	Point turret1Point1 = MilliPointToPoint(375, 770);
	Point turret1Point2 = MilliPointToPoint(429, 900);	
	TurretSlot turret1 = new TurretSlot(turret1Point1.x, turret1Point2.x, turret1Point1.y, turret1Point2.y);
	
	Point turret2Point1 = MilliPointToPoint(475, 770);
	Point turret2Point2 = MilliPointToPoint(529, 900);	
	TurretSlot turret2 = new TurretSlot(turret2Point1.x, turret2Point2.x, turret2Point1.y, turret2Point2.y);
	
	Point turret3Point1 = MilliPointToPoint(575, 770);
	Point turret3Point2 = MilliPointToPoint(629, 900);	
	TurretSlot turret3 = new TurretSlot(turret3Point1.x, turret3Point2.x, turret3Point1.y, turret3Point2.y);
	
	PanelThread _thread;
	List<Entity> _renderList = new ArrayList<Entity>();
	List<AttackEntity> _enemyList = new ArrayList<AttackEntity>();
	List<Projectile> _projectilesList = new ArrayList<Projectile>();
    List<Projectile> _enemyprojectilesList = new ArrayList<Projectile>();
	List<AttackEntity> _turretList = new ArrayList<AttackEntity>(); 
	Level currentLevel = new Level1();

	Bitmap _background1 = BitmapFactory.decodeResource(getResources(), com.derby.trainraid.R.drawable.beachbackground);

	int _background1X = 0;
	int _background2X = _background1.getWidth();
	
	Entity _train;
	Entity _carriage;
	
	int enemyHeight;
	int enemyWidth;
	int bulletHeight;
	int bulletWidth;

	boolean menuVisible = false;
	TurretSlot activeTowerSlot = null;
	
	public Renderer(Context context, List<Entity> renderList)
	{	
		super(context);
		Point trainPos = MilliPointToPoint(650, 872);
		_train = new Entity(100, 1, trainPos.x, trainPos.y);
		Point cabPos = MilliPointToPoint(360, 872);
		_carriage = new Entity(100, 5, cabPos.x, cabPos.y);
		getHolder().addCallback(this);
		towerSlotList.add(point1);
		towerSlotList.add(point2);
		towerSlotList.add(point3);
		towerSlotList.add(point4);
		towerSlotList.add(point5);
		towerSlotList.add(point6);
	}
	
	private void Retrieve()
	{
		// get the array
		AttackEntity[] enemies;
		int maxY = MilliPointToPoint(0, 500).y;
		int minY = MilliPointToPoint(0, 75).y;
		enemies = currentLevel.CheckSpawn(maxY, minY, _train);
		if(enemies != null)
		{
			// parse the array into entities
			int length = enemies.length;
			
			// remember to Get enemy strings
			for(int i = 0; i < length; i++)
			{
				// add them to our array
				_enemyList.add(enemies[i]);
			}
			_renderList.add(_train);
			_renderList.add(_carriage);
		}
	}
	
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	private Point MilliPointToPoint(int milliPointX, int milliPointY)
	{
		Context context = this.getContext();
		Point result = new Point();
		Point size = new Point();
		WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = window.getDefaultDisplay();
		if (android.os.Build.VERSION.SDK_INT >= 13)
		{ 
			System.out.println("Version >= 13");
			display.getSize(size); 
		} 
		else
		{
			size.x = display.getWidth();
			size.y = display.getHeight();
		}
		float x = size.x;
		float y = size.y;
		result.x = (int) ((x / 1000) * milliPointX);
		result.y = (int) ((y / 1000) * milliPointY);
		
		return result;
	}
	
	private void MoveBackground()
	{
		// When background1X reaches negative width paint it at the end of background2X
		if(_background1X < 0 - _background1.getWidth())
		{
			_background1X = _background1.getWidth() + _background2X;
		}
		if(_background2X < 0 - _background1.getWidth())
		{
			_background2X = _background1.getWidth() + _background1X;
		}
		
		_background1X -= 50;
		_background2X -= 50;
		
		// if the negative value of the background = the size of the value loop
	}
	
	private void drawHealthBar(Canvas canvas, Paint paint, float x, float y, int hitPoints, int maxHitPoints)
	{
		paint.setColor(Color.rgb(255, 0, 0));
		paint.setStrokeWidth(10);
		canvas.drawRect(x , y - MilliPointToPoint(0, 20).y, x + MilliPointToPoint(100, 0).x, y - MilliPointToPoint(0, 10).y, paint);
		
		paint.setColor(Color.rgb(0, 255, 0));	
		float healthPercentage = ((float)hitPoints / (float)maxHitPoints) * 100;
		canvas.drawRect(x , y - MilliPointToPoint(0, 20).y, x + MilliPointToPoint((int)healthPercentage, 0).x, y - MilliPointToPoint(0, 10).y, paint);
	}
	
	private void drawUI(Canvas canvas, Paint paint, int trainHitPoints, int trainMaxHitPoints, int money, String levelName)
	{
		// Rectangle behind UI
		paint.setColor(Color.argb(120, 128, 128, 128));
		canvas.drawRect(MilliPointToPoint(0,0).x , MilliPointToPoint(0, 0).y, MilliPointToPoint(1000, 0).x, MilliPointToPoint(0, 75).y, paint);
		
		// Draw level name		
		paint.setColor(Color.rgb(255, 165, 0));
		paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
		paint.setTextSize(20);
		canvas.drawText("Level: " + levelName, MilliPointToPoint(30, 0).x, MilliPointToPoint(0, 50).y, paint);
		
		
		// Drawing train health Bar
		// Red Bar
		paint.setColor(Color.rgb(255, 0, 0));
		paint.setStrokeWidth(10);
		canvas.drawRect(MilliPointToPoint(250,0).x , MilliPointToPoint(0, 20).y, MilliPointToPoint(750, 0).x, MilliPointToPoint(0, 50).y, paint);
		
		//Green Bar
		paint.setColor(Color.rgb(0, 255, 0));	
		float healthPercentage = ((float)trainHitPoints / (float)trainMaxHitPoints) * 100;
		canvas.drawRect(MilliPointToPoint(250,0).x , MilliPointToPoint(0, 20).y, MilliPointToPoint((int)healthPercentage * 5, 0).x + 250, MilliPointToPoint(0, 50).y, paint);
		
		// Draw money value	
		paint.setColor(Color.rgb(255, 165, 0));
		paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
		paint.setTextSize(20);
		canvas.drawText("€" + money, MilliPointToPoint(830, 0).x, MilliPointToPoint(0, 50).y, paint);
	}
		
	@Override
	public void onDraw(Canvas canvas)
	{						
		// Draw enemies
		
		if(_renderList.size() != 0 && _renderList != null)
		{
			// Print Background
			MoveBackground();
			canvas.drawBitmap(_background1, _background1X, 0, paint);  
			canvas.drawBitmap(_background1, _background2X, 0, paint);
			
			// Render enemies
			if(_enemyList.size() !=0)
			{
				for(int i = 0; i < _enemyList.size(); i++) // This loop keeps looping over and over after the level ends
				{
					if (_enemyList.get(i).getHidden() == false)
					{
						canvas.drawBitmap(Bitmaps.list.get(_enemyList.get(i).GetBitmapID()), _enemyList.get(i).GetX(), _enemyList.get(i).GetY(), paint);
						
						drawHealthBar(canvas, paint, _enemyList.get(i).GetX(), _enemyList.get(i).GetY(), _enemyList.get(i).GetHitPoints(), _enemyList.get(i).getMaxHitPoints());
						
						//canvas.drawRect(_enemyList.get(i).getBoundingBox(), paint);
					}
				}
			}
			
			// Render train and other entities
			for(int i = 0; i < _renderList.size(); i++) // This loop keeps looping over and over after the level ends
			{
				canvas.drawBitmap(Bitmaps.list.get(_renderList.get(i).GetBitmapID()), _renderList.get(i).GetX(), _renderList.get(i).GetY(), paint);
			}
			
			// Render projectiles			
			if(_projectilesList.size() !=0)
			{
				for(int i = 0; i < _projectilesList.size(); i++)
				{
					if(_projectilesList.get(i).getHidden() == false)
					{
						canvas.drawBitmap(Bitmaps.list.get(_projectilesList.get(i).GetBitmapID()), _projectilesList.get(i).GetX(), _projectilesList.get(i).GetY(), paint);
					}
					
				}
			}
			
	           // render enemy projectiles
            if(_enemyprojectilesList.size() !=0)
            {
                for(int i = 0; i < _enemyprojectilesList.size(); i++)
                {
                    if(_enemyprojectilesList.get(i).getHidden() == false)
                    {
                        canvas.drawBitmap(Bitmaps.list.get(_enemyprojectilesList.get(i).GetBitmapID()), _enemyprojectilesList.get(i).GetX(), _enemyprojectilesList.get(i).GetY(), paint);
                    }
                }
            }
			
			// Render towers
			for(int i = 0; i < _turretList.size(); i++) // This loop keeps looping over and over after the level ends
			{
				canvas.drawBitmap(Bitmaps.list.get(_turretList.get(i).GetBitmapID()), _turretList.get(i).GetX(), _turretList.get(i).GetY(), paint);
			}
			
			// Render Turret Menu
			if(menuVisible)
			{
				canvas.drawBitmap(Bitmaps.list.get(8), MilliPointToPoint(375, 0).x, MilliPointToPoint(0, 770).y, paint);
			}
		}
		drawUI(canvas, paint, _train.GetHitPoints(), _train.getMaxHitPoints(), 500, currentLevel.GetLevelName());
		
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		
	}
	
	@Override
    public void surfaceCreated(SurfaceHolder holder) 
	{
		setWillNotDraw(false); //Allows us to use invalidate() to call onDraw()
	
		_thread = new PanelThread(getHolder(), this); //Start the thread that
		_thread.setRunning(true);                     //will make calls to 
		_thread.start();                              //onDraw()
    }
	
	@Override
    public boolean onTouchEvent(MotionEvent motionEvent) 
	{
		System.out.println("Press detected");
		
		// Check if the user touched a towerSlot
		for (int i = 0; i < towerSlotList.size(); i++)
		{
			if (towerSlotList.get(i).checkTouched(motionEvent))
			{
				activeTowerSlot = towerSlotList.get(i);
				System.out.println("Tower slot touched: " + towerSlotList.get(i));
			}
		}
		
		if(activeTowerSlot != null)
		{
			if (activeTowerSlot.getOccupied() == false)
			{		
				menuVisible = true;
			}
		}
		else
		{
			if(menuVisible == true)
			{
				for (int i = 0; i < menu.GetSize(); i++)
				{
					if(menu.getMenuItem(i).checkTouched(motionEvent))
					{
						System.out.println("Item pressed: " + menu.getMenuItem(i));
						menu.getMenuItem(i).OnPress(_enemyList.get(0), this);
						menuVisible = false;
						break;
					}
				}
				menuVisible = false;
			}
			else
			{
				menuVisible = false;
			}
		}
		
		
				
		return super.onTouchEvent(motionEvent);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) 
    {
	    try 
	    {
	        _thread.setRunning(false);                //Tells thread to stop
	        _thread.join();                           //Removes thread from mem.
	    } 
		catch (InterruptedException e) {}
    }
	
	class PanelThread extends Thread
	{
		private SurfaceHolder _surfaceHolder;
		private boolean _run = false;
		
		public PanelThread(SurfaceHolder surfaceHolder, Renderer renderer) 
		{
            _surfaceHolder = surfaceHolder;
        }


        public void setRunning(boolean run) 
        {
            _run = run;
        }
  
        @Override
        public void run() 
        {
            Canvas c;
            while (_run) 
            {     
                c = null;
                try 
                {
                    c = _surfaceHolder.lockCanvas(null);
                    synchronized (_surfaceHolder)
                    {
                    //Insert methods to modify positions of items in onDraw()    
                	
	            		while (currentLevel.GetDistTravelled() < currentLevel.GetDist())
	            		{
	            			Retrieve();
	            			currentLevel.AddDistance(1);
	            			
	            			//Tower loop
	            			if(_turretList.size() != 0)
	            			{
	            				for(int i = 0; i < _turretList.size(); i++)
	            				{
	            					if(_enemyList.size() != 0)
	            					{
	            						_turretList.get(i).setCurrentTarget(_enemyList.get(0));
	        							_turretList.get(i).IncrementTimeSinceShot();
	        							
	        							if(_turretList.get(i).getTimeSinceShot() == _turretList.get(i).getShotSpeed())
	        							{
	        								_projectilesList.add(_turretList.get(i).Shoot(bulletHeight, bulletWidth));
	        							}
	            					}			
	            				}
	            			}
	            			
	            			// EnemyProjectile loop
	            			if(_enemyprojectilesList.size() !=0)
	            			{
	            				for(int i = _enemyprojectilesList.size() - 1; i >= 0; i--)
	            				{
	            					_enemyprojectilesList.get(i).update(bulletHeight, bulletWidth);
	            					
	            					if(_enemyprojectilesList.get(i).CheckIntersect(_renderList.get(0)))
	            					{
	            						_renderList.get(0).Damage(_enemyprojectilesList.get(i).getDamage());
	            						_enemyprojectilesList.remove(i);
	            					}
	            					else if(_enemyprojectilesList.get(i).GetX() > MilliPointToPoint(1000,0).x || _enemyprojectilesList.get(i).GetY() > MilliPointToPoint(0,1000).y ||
	            							_enemyprojectilesList.get(i).GetX() < 0 || _enemyprojectilesList.get(i).GetY() < 0)
	            					{
	            						_enemyprojectilesList.remove(i);
	            					}
	            				}
	            			}
	            			
	            			// Projectile loop
	            			if(_projectilesList.size() !=0)
	            			{                        				
	            				for(int i = _projectilesList.size() - 1; i >= 0; i--)
	            				{	
	            					_projectilesList.get(i).update(bulletHeight, bulletWidth);
	            					
	            					if(_enemyList.size() != 0)
	            					{
	                    				boolean deleteProjectile = false;
	                    				
	            						for(int k = _enemyList.size() - 1; k >= 0; k--)
	            						{
			            					if(_projectilesList.get(i).CheckIntersect(_enemyList.get(k)))
			            					{
			            						_enemyList.get(k).Damage(_projectilesList.get(i).getDamage());
		            							deleteProjectile = true;
			            						
			            						if(_enemyList.get(k).GetHitPoints() <= 0)
			            						{
			            							_enemyList.remove(k);
			            						}
			            						break;
			            					}
	            						}
	            						if (deleteProjectile)
	            						{
	            							_projectilesList.remove(i);
	            						}
	            					}
	            					
	            				} 
	            			}
	            			
	            			// Enemy loop
                            if(_enemyList.size() != 0)
                            {
                                for(int i = 0; i < _enemyList.size(); i++)
                                {
                                    if(_enemyList.get(i).GetX() < MilliPointToPoint(500, 0).x)
                                    {
                                        _enemyList.get(i).SetX(_enemyList.get(i).GetX()+ 2);
                                    }
                                    else if(_enemyList.get(i).getTimeSinceShot() >= _enemyList.get(i).getShotSpeed())
                                    {
                                        _enemyprojectilesList.add(_enemyList.get(i).Shoot(bulletHeight, bulletWidth));
                                    }
                                    _enemyList.get(i).IncrementTimeSinceShot();
                                }
                            }	            		               		
	            			
	            			try 
	            			{
	            				Thread.currentThread().sleep(50);
	
	            			} 
	            			catch (InterruptedException e) 
	            			{
	            				e.printStackTrace();
	            			}
	            			postInvalidate();
	            		}
                }
            } 
                finally {
                    if (c != null) {
                        _surfaceHolder.unlockCanvasAndPost(c);       
                    }
                }
            }
        }  
    }	
}


