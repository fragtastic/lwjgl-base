package com.github.fragtastic.example;

import com.github.fragtastic.lwjgl.framework.GameState;
import com.github.fragtastic.lwjgl.framework.Util;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author mitch
 */
public class Game {

    int FRAMERATE = 120;
    static boolean gameRunning = true;

    public Game() {

        this.initGL();

        new TestState();

        while (gameRunning) {
            GameState.tick(Util.getDelta());

            Display.update();
            Display.sync(FRAMERATE);

            if (Display.isCloseRequested() || GameState.stateStack.isEmpty()) {
                gameRunning = false;
            }
        }

        Display.destroy();
        System.exit(0);
    }

    private void initGL() {
        int targetWidth = 640;
        int targetHeight = 480;
        try {
            DisplayMode displayMode = new DisplayMode(targetWidth, targetHeight);

            Display.setDisplayMode(displayMode);
            Display.setTitle("jRPG");
            Display.setFullscreen(false);
            Display.create();
        } catch (LWJGLException e) {
            System.err.println(e);
            System.exit(0);
        }
        System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));
    }

    public static void main(String[] args) {
        Util.setNatives();
        Game g = new Game();
    }

}
