package com.reagroup.toyrobot;

/**
 * A square implementation of a {@link Universe}, meaning (obviously) that all
 * four sides are the same length.
 * <p>
 * (0,0) is the default southwest corner and the northeast corner is calculated
 * to be (minX + sideLength-1, minY + sideLength-1).
 */
public class SquareUniverse implements Universe {

    private final int minX;
    private final int minY;
    private final int sideLength;

    public SquareUniverse(final int sideLength) {
        this(0, 0, sideLength);
    }

    public SquareUniverse(final int minX, final int minY, final int sideLength) {
        this.minX = minX;
        this.minY = minY;
        this.sideLength = sideLength;
    }

    @Override
    public boolean withinBounds(final Point point) {
        return (point.getX() >= minX) && (point.getX() < minX + sideLength) &&
                (point.getY() >= minY) && (point.getY() < minX + sideLength);
    }
}
