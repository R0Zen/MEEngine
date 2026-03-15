package org.ross.mee;

import org.ross.mee.graphics.Graphics;
import org.ross.mee.graphics.Window;
import org.ross.mee.input.Input;
import org.ross.mee.input.Keyboard;
import org.ross.mee.time.Delta;

public class Engine 
{
	public static String window_title = "MEEngine";
	public static int window_width = 1280;
	public static int window_height = 720;
	public static int render_width = 1280;
	public static int render_height = 720;
	public static boolean input_mouse_grabed = false;
	public static boolean input_mouse_hidden = false;
	public static boolean VSync = true;
	
	
	public Engine(App app)
	{
		app.Init();
		Window.Init(window_title, 1280, 720);
		Graphics.Init(1280, 720, 70);
		while (Window.isActive())
		{
			Delta.Update();
			if (Input.getKeyboard().isKeyPressed(Keyboard.KEY_ESCAPE)){break;}
			Graphics.Clear();
			app.Process();
			app.Draw();
			Window.SwapBuffers();
			Input.PollEvents();
		}
		app.Clean();
		Window.Terminate();
	}
}
