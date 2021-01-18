package com.reagroup.toyrobot;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * An implementation of {@link Robot}.
 */
public class ToyRobot implements Robot {

    private final Universe universe;
    private Point pos;
    private Direction facing = null;

    public ToyRobot(final Universe universe) {
        this.universe = universe;
    }

    @Override
    public boolean place(final int x, final int y, final Direction newFacing) {
        final Point newPos = new Point(x, y);
        if (universe.withinBounds(newPos)) {
            reposition(newPos, newFacing);
            return true;
        }
        return false;
    }

    @Override
    public Point move() {
        if (placed()) {
            final Point newPos = facing.move(pos);
            if (universe.withinBounds(newPos)) {
                reposition(newPos, facing);
            }
        }
        return pos;
    }

    @Override
    public void right() {
        if (placed()) {
            facing = facing.right(facing);
        }
    }

    @Override
    public void left() {
        if (placed()) {
            facing = facing.left(facing);
        }
    }

    @Override
    public String report() {
        final String str;
        if (placed()) {
            str = pos.getX() + "," + pos.getY() + "," + facing.name();
            System.out.println(str);
        } else {
            str = "Not placed";
        }
        return str;
    }

    public boolean placed() {
        return facing != null;
    }

    private void reposition(final Point pos, final Direction facing) {
        this.pos = pos;
        this.facing = facing;
    }

    private void doCommand(final String cmd) {
        final String[] splitCmd = cmd.split(" ");
        switch (splitCmd[0]) {
            case "PLACE":
                final String[] placeArgs = splitCmd[1].split(",");
                place(Integer.valueOf(placeArgs[0]), Integer.valueOf(placeArgs[1]), Direction.valueOf(placeArgs[2]));
                break;
            case "LEFT":
                left();
                break;
            case "RIGHT":
                right();
                break;
            case "MOVE":
                move();
                break;
            case "REPORT":
                report();
                break;
            default:
                System.out.println("Unknown command, skipping: " + cmd);
                break;
        }
    }

    public static void main(final String[] args) throws Exception {
        final Universe universe = new SquareUniverse(5);
        final ToyRobot robot = new ToyRobot(universe);

        // TODO consider using args4j rather than hard coding input file name here
        final String inputFilename = "robot-test.in";
        try (final BufferedReader in = new BufferedReader(new FileReader(inputFilename))) {

            String line;
            while ((line = in.readLine()) != null) {
                robot.doCommand(line);
            }
        }
    }
}
