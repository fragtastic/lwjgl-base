package com.github.fragtastic.lwjgl.framework;

/**
 *
 * @author mitch
 */
public abstract class GameState {
    
    /**
     * Implicitly called during child class initialization.
     * Calls GameState.setUp().
     */
    public GameState() {
        this.setUp();
    }
    
    /**
     * Designated method for performing initialization of GameState.
     * Implicitly called during initialization of GameState, not to be called by user.
     */
    public abstract void setUp();
    
    public abstract void tearDown();
    
    public abstract void update();
    
    public abstract void draw();
    
    public abstract void switchTo();
    
    public abstract void switchFrom();
}
