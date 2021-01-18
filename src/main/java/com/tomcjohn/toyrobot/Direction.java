package com.tomcjohn.toyrobot;

import java.util.function.Function;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * A representation of the compass points.
 */
public enum Direction {
    NORTH(pos -> new Point(pos.getX(), pos.getY() + 1)),
    SOUTH(pos -> new Point(pos.getX(), pos.getY() - 1)),
    EAST(pos -> new Point(pos.getX() + 1, pos.getY())),
    WEST(pos -> new Point(pos.getX() - 1, pos.getY()));

    private static final BiMap<Direction, Direction> COMPASS = HashBiMap.create();
    static {
        COMPASS.put(NORTH, EAST);
        COMPASS.put(EAST, SOUTH);
        COMPASS.put(SOUTH, WEST);
        COMPASS.put(WEST, NORTH);
    }

    private final Function<Point, Point> moveFunc;

    Direction(final Function<Point, Point> moveFunc) {
        this.moveFunc = moveFunc;
    }

    public Point move(final Point currentPos) {
        return moveFunc.apply(currentPos);
    }

    public Direction right(final Direction of) {
        return COMPASS.get(of);
    }

    public Direction left(final Direction of) {
        return COMPASS.inverse().get(of);
    }
}
