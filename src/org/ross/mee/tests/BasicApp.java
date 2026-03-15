package org.ross.mee.tests;

import org.ross.mee.App;
import org.ross.mee.Engine;

public class BasicApp implements App
{
	public static void main(String[] args) 
	{
		new BasicApp();
	}
	
	public BasicApp()
	{
		new Engine(this);
	}

	public void Init() 
	{
		
	}

	public void Process() 
	{
		
	}

	public void Draw() 
	{
		
	}

	public void Clean() 
	{
		
	}
}
