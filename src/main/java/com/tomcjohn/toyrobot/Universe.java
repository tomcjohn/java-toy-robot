package com.tomcjohn.toyrobot;

/**
 * The definition of the space within which a {@link Robot} can validly move.
 */
public interface Universe {

    /**
     * Check the given point is within the bounds of the universe.
     * True if so, false otherwise.
     */
    boolean withinBounds(final Point point);
}
