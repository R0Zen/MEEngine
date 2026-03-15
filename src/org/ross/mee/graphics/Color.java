package org.ross.mee.graphics;

public class Color 
{
	public static final Color White = new Color("FFFFFF");
	public static final Color Gray = new Color("808080");
	public static final Color Black = new Color("000000");
	public static final Color Red = new Color("FF0000");
	public static final Color Green = new Color("00FF00");
	public static final Color Blue = new Color("0000FF");
	public static final Color Yellow = new Color("FFFF00");
	public static final Color Cyan = new Color("00FFFF");
	public static final Color Orange = new Color("FFA500");
	public static final Color Magenta = new Color("FF00FF");
	public float r,g,b,a;
	
	public Color(String hex)
	{
		if (!hex.startsWith("0x"))
		{
			hex="0x"+hex;
		}
		if (hex.length()==8) // 24bit RGB
		{
			long color = Long.decode(hex);
			r = ((color >> 16)&0xFF)/255f;
			g = ((color >> 8)&0xFF)/255f;
			b = (color &0xFF)/255f;
			a = 1.0f;
		}
		else // 32bit RGBA
		{
			long color = Long.decode(hex);
			r = ((color >> 24)&0xFF)/255f;
			g = ((color >> 16)&0xFF)/255f;
			b = ((color >> 8)&0xFF)/255f;
			a = (color &0xFF)/255f;
		}
	}
	
	public Color(float r, float g, float b, float a)
	{
		this.r=r;
		this.g=g;
		this.b=b;
		this.a=a;
	}
		
	public Color(float r, float g, float b)
	{
		this.r=r;
		this.g=g;
		this.b=b;
		this.a=1.0f;
	}
	
	public Color(int r, int g, int b, int a)
	{
		this.r=1.0f/255f*r;
		this.g=1.0f/255f*g;
		this.b=1.0f/255f*b;
		this.a=1.0f/255f*a;
	}
	
	public Color(int r, int g, int b)
	{
		this.r=1.0f/255f*r;
		this.g=1.0f/255f*g;
		this.b=1.0f/255f*b;
		this.a=1.0f;
	}
	
	public String toString() 
	{
		return "Red:"+r+" Green:"+g+" Blue:"+b+" Alpha:"+a;
	}
}
