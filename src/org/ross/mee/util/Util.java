package org.ross.mee.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util 
{
	public static String readTextFile(String filename)
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			StringBuilder sb = new StringBuilder();
			while(br.ready())
			{
				sb.append(br.readLine()+"\n");
			}
			br.close();
			return sb.toString();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
