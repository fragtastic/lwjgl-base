package com.github.fragtastic.lwjgl.framework;

import java.util.Stack;

/**
 *
 * @author mitch
 */
public abstract class GameState {

    public static Stack<GameState> stateStack = new Stack();

    /**
     * Implicitly called during child class initialization. Calls
     * GameState.setUp().
     */
    public GameState() {
        this.setUp();
        push(this);
    }

    /**
     * Designated method for performing initialization of the child GameState.
     * Implicitly called during initialization of GameState, not to be called by
     * user.
     */
    public abstract void setUp();

    /**
     * Used in preparation for destruction of GameState object. Called when a
     * GameState is removed from the stateStack.
     */
    public abstract void tearDown();

    public abstract void update(int delta);

    public abstract void draw();

    public abstract void input();

    /**
     * Used for switching to the GameStates without intent to destroy.
     */
    public abstract void switchTo();

    /**
     * Used for switching from the GameStates without intent to destroy.
     */
    public abstract void switchFrom();

    /**
     * Performs GameState.update() and GameState.draw().
     *
     * @param delta number of milliseconds since last frame.
     */
    public static void tick(int delta) {
        stateStack.peek().update(delta);
        stateStack.peek().draw();
        stateStack.peek().input();
    }

    public static void push(GameState gs) {
        if (!stateStack.isEmpty()) {
            stateStack.peek().switchFrom();
        }
        stateStack.push(gs);
        gs.switchTo();
    }

    public static void pop() {
        stateStack.peek().switchFrom();
        stateStack.pop().tearDown();
        if (!stateStack.isEmpty()) {
            stateStack.peek().switchTo();
        }
    }
}
