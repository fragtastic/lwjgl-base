package com.github.fragtastic.jrpg;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author mitch
 */
public class TestState extends GameState {

    /**
     * Implicitly calls super().
     */
    public TestState() {
    }

    @Override
    public void setUp() {

    }

    @Override
    public void update() {
        GL11.glRotatef(0.6f, 0, 0, 1);
    }

    @Override
    public void draw() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);

        GL11.glColor4f(0, 1, 0, 1);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(0, 0, 0);
        GL11.glVertex3f(1, 0, 0);
        GL11.glVertex3f(1, 1, 0);
        GL11.glVertex3f(0, 1, 0);
        GL11.glEnd();

        GL11.glColor4f(1, 0, 0, 1);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(-0.5f, -0.5f, 0);
        GL11.glVertex3f(0, -0.5f, 0);
        GL11.glVertex3f(0, 0, 0);
        GL11.glVertex3f(-0.5f, 0, 0);
        GL11.glEnd();
    }

    @Override
    public void switchTo() {
        GL11.glClearColor(0, 0, 0, 0);
        Display.setTitle("Test State");
    }

    @Override
    public void switchFrom() {
    }

    @Override
    public void tearDown() {
    }

}
