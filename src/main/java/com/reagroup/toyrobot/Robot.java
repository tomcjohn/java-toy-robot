package com.reagroup.toyrobot;

/**
 * A robot whose position can be controlled and reported on.
 */
public interface Robot {

    /**
     * Set the robot's position and orientation.
     */
    boolean place(final int x, final int y, final Direction newFacing);

    /**
     * Move the robot one unit in the direction it is facing.
     */
    Point move();

    /**
     * Rotate the robot 90 degrees clockwise.
     */
    void right();

    /**
     * Rotate the robot 90 degrees anticlockwise.
     */
    void left();

    /**
     * Report the robot's current position and orientation.
     */
    String report();
}
