package com.github.fragtastic.example;

import com.github.fragtastic.lwjgl.framework.GameState;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author mitch
 */
public class TestState2 extends GameState {
    
    private float rotateSpeed = 0.3f;

    /**
     * Implicitly calls super().
     */
    public TestState2() {
    }

    @Override
    public void setUp() {
        System.out.println("Setting up Test State 2");
    }

    @Override
    public void update(int delta) {
        GL11.glRotatef(rotateSpeed * delta, 0, 0, 1);
    }
    
    @Override
    public void input() {
        while (Keyboard.next()) {
            switch (Keyboard.getEventKey()) {
                case Keyboard.KEY_ADD:
                    rotateSpeed += 0.01f;
                    break;
                case Keyboard.KEY_SUBTRACT:
                    rotateSpeed -= 0.01f;
                    break;
                case Keyboard.KEY_SPACE:
                    if (Keyboard.getEventKeyState()) {
                        pop();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void draw() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);

        GL11.glColor4f(0, 1, 1, 1);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(0, 0, 0);
        GL11.glVertex3f(1, 0, 0);
        GL11.glVertex3f(1, 1, 0);
        GL11.glVertex3f(0, 1, 0);
        GL11.glEnd();

        GL11.glColor4f(1, 1, 0, 1);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(-0.5f, -0.5f, 0);
        GL11.glVertex3f(0, -0.5f, 0);
        GL11.glVertex3f(0, 0, 0);
        GL11.glVertex3f(-0.5f, 0, 0);
        GL11.glEnd();
    }

    @Override
    public void switchTo() {
        GL11.glClearColor(0, 1, 0, 0);
        System.out.println("Switching to Test State 2");
        Display.setTitle("Test State 2");
    }

    @Override
    public void switchFrom() {
        System.out.println("Switching from Test State 2");
    }

    @Override
    public void tearDown() {
        System.out.println("Tearing down Test State 2");
    }

}
