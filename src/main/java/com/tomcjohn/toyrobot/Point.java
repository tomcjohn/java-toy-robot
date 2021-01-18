package com.tomcjohn.toyrobot;

/**
 * A convenient representation of a point in space.
 */
public class Point {

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
