package org.ross.mee.graphics;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

import org.joml.Matrix4f;

public class Graphics 
{
	private static Matrix4f projection = new Matrix4f();
	
	public static void Init(int width, int height, float fov)
	{
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_STENCIL_TEST);
		glDepthFunc(GL_LEQUAL);
		glEnable(GL_BLEND);
		glEnable(GL_FRAMEBUFFER_SRGB); 
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0, 0, width, height);
		projection.perspective((float)Math.toRadians(fov), (float)width/height, 0.1f, 100f);
	}
	
	public static void Clear()
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0f,0f,0f,1f);
	}
	
	public static void Clear(Color color)
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(color.r,color.g,color.b,color.a);
	}
}
