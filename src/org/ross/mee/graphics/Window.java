package org.ross.mee.graphics;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import org.ross.mee.Engine;

public class Window 
{
	private static long window_id;

	public static void Init(String title, int width, int height)
	{
		glfwInit();
		window_id = glfwCreateWindow(width, height, title, 0, 0);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwMakeContextCurrent(window_id);
		if (Engine.VSync)
		{
			glfwSwapInterval(1);
		}
		else
		{
			glfwSwapInterval(0);
		}
		GL.createCapabilities();
		glfwShowWindow(window_id);
	}
	
	public static long getID()
	{
		return window_id;
	}
	
	public static boolean isActive()
	{
		if (glfwWindowShouldClose(window_id))
		{
			return false;
		}
		return true;
	}
	
	public static void SwapBuffers()
	{
		glfwSwapBuffers(window_id);
	}
	
	public static void Terminate()
	{
		glfwTerminate();
	}
}
