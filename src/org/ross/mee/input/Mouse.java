package org.ross.mee.input;

import static org.lwjgl.glfw.GLFW.*;
import java.util.ArrayList;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.ross.mee.Engine;
import org.ross.mee.graphics.Window;

public class Mouse 
{
	public static final int BUTTON_LEFT=GLFW_MOUSE_BUTTON_LEFT;
	public static final int BUTTON_RIGHT=GLFW_MOUSE_BUTTON_RIGHT;
	public static final int BUTTON_MIDDLE=GLFW_MOUSE_BUTTON_MIDDLE;
	private int last_key;
	private int last_action;
	private float mouse_x, mouse_y;
	private ArrayList<InputEvent> mouse_events;
	private boolean hide_mouse=Engine.input_mouse_hidden;
	private boolean grab_mouse=Engine.input_mouse_grabed;
	
	
	public Mouse()
	{
		last_key=-1;
		last_action=-1;
		mouse_x=-1;
		mouse_y=-1;
		
		if (hide_mouse)
		{
			glfwSetInputMode(Window.getID(), GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
		}
		else if (grab_mouse)
		{
			glfwSetInputMode(Window.getID(), GLFW_CURSOR, GLFW_CURSOR_DISABLED);
		} 
		mouse_events = new ArrayList<InputEvent>();
		glfwSetMouseButtonCallback(Window.getID(), new GLFWMouseButtonCallbackI()
		{
			public void invoke(long window, int key, int action, int mode) 
			{
				last_key=key;
				last_action=action;
			}
		});
		
	}
	
	public void registerEvent(InputEvent event)
	{
		mouse_events.add(event);
	}
	
	public void removeEvent(String name)
	{
		for (int i=0; i<mouse_events.size(); i++)
		{
			if (mouse_events.get(i).getTriggerName()==name)
			{
				mouse_events.remove(i);
			}
		}
	}
	
	public void removeEvent(InputEvent event)
	{
		for (int i=0; i<mouse_events.size(); i++)
		{
			if (mouse_events.get(i)==event)
			{
				mouse_events.remove(i);
			}
		}
	}
	
	public void Process()
	{
		double[] x = new double[1];
		double[] y = new double[1];
		glfwGetCursorPos(Window.getID(), x, y);
		mouse_x=(float) x[0];
		mouse_y=(float) y[0];
		for (int i=0; i<mouse_events.size(); i++)
		{
			if (last_action==GLFW_PRESS)
			{
				mouse_events.get(i).onKeyPressed(last_key);
			}
			if (last_action==GLFW_RELEASE)
			{
				mouse_events.get(i).onKeyReleased(last_key);
			}
		}
		last_key=-1;
		last_action=-1;
		
	}
	

	public boolean isMouseButtonDown(int button)
	{
		if (glfwGetMouseButton(Window.getID(), button)==GLFW_PRESS)
		{
			return true;
		}
		return false;
	}

	public float getMouseY()
	{
		return mouse_y;
	}
	

	public float getMouseX()
	{
		return mouse_x;
	}
}
