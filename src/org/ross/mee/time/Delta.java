package org.ross.mee.time;

public class Delta 
{
	private static long last_frametime_nano = getTimeNano();
	private static int current_framerate, current_framecount;
	private static long NANO = 1000000000;
	
	public static long getTimeNano()
	{
		return System.nanoTime();
	}
	
	public static long getTimeMillis()
	{
		return System.currentTimeMillis();
	}
	
	public static int getFramerate()
	{
		return current_framerate;
	}
	
	public static void Update()
	{
		if (getTimeNano()-last_frametime_nano>NANO)
		{
			current_framerate=current_framecount;
			current_framecount=0;
			last_frametime_nano+=NANO;
		}
		current_framecount++;
	}
}
